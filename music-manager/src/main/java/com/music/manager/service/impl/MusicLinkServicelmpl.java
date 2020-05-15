/**
*
* @author linliquan
* @data 2018年12月23日 00:03:48
*/

package com.music.manager.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.music.common.result.BaseResult;
import com.music.common.util.JsonUtil;
import com.music.manager.mapper.*;
import com.music.manager.pojo.*;
import com.music.manager.service.IMusicLinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;


@Service("musicLinkService")
public class MusicLinkServicelmpl implements IMusicLinkService {

    @Autowired
    private MusicLinkMapper musicLinkMapper;
    @Autowired
    private MyMusicMapper myMusicMapper;

    @Autowired
    private RedisTemplate<String, String> redisTemplate;
    @Autowired
    private SingerMapper singerMapper;
    @Autowired
    private SongMapper songMapper;
    @Autowired
    private LanguageMapper languageMapper;

    @Value(value = "${musicLink.list}")
    private String musicLinkList;

    @Value(value = "${TOPLink_50}")
    private String TOPLink;
    


    /**
     * 获取所有音乐
     *
     * @return
     */
    @Override
    public BaseResult getMusicList(Integer pageNum, Integer pageSize) {
        //实时更新数据
        redisTemplate.delete(musicLinkList);
            if (StringUtils.isEmpty(pageNum)) {
                pageNum = 1;
            }
            if (StringUtils.isEmpty(pageSize)) {
                pageSize = 10;
            }
            PageHelper.startPage(pageNum, pageSize);
            //获取redis对象
            ListOperations<String, String> valueOperations = redisTemplate.opsForList();
//        //查看redis中是否存在musiclink缓存
            String mlStr = valueOperations.index(musicLinkList, pageNum - 1);
            if (!StringUtils.isEmpty(mlStr)) {
//            //存在缓存,使用缓存记录
                PageInfo pageInfo = JsonUtil.jsonStr2Object(mlStr, PageInfo.class);
                return BaseResult.success(pageInfo);
            }
            //不存在缓存,从数据库中查询所有音乐,在放入缓存中
        List<Song> songs = songMapper.selectByExample(new SongExample());
            if (!CollectionUtils.isEmpty(songs)) {

                //将歌手id换成歌手名称
                for (Song song : songs) {
                    Singer singer = singerMapper.selectByPrimaryKey(song.getSingerid());
                    song.setSingerid(singer.getSingername());
                }
                //将集合存入分页工具
                PageInfo<Song> page = new PageInfo<>(songs);
                //获取musicLink总数
                page.setTotal(getSongLinkCount());
                //将list存入缓存中
                valueOperations.rightPush(musicLinkList, JsonUtil.object2JsonStr(page));
                return BaseResult.success(page);
            }
            return BaseResult.error();
    }

        /**
         * 歌曲搜索功能
         * @param songName
         * @return
         */
        @Override
        public BaseResult getMusicByMusicName (String songName){
            //创建查询对象
            SongExample songExample = new SongExample();
            //设置查询先后顺序
            songExample.setOrderByClause("votes desc");
            SongExample.Criteria criteria = songExample.createCriteria();
            //模糊查询
            if (!StringUtils.isEmpty(songName)) {
                criteria.andSongnameLike("%" + songName + "%");
            }
            //执行
            List<Song> songList = songMapper.selectByExample(songExample);
            if (CollectionUtils.isEmpty(songList)) {
                System.out.println("暂无该数据");
                return BaseResult.error();
            }
            //将歌手id换成歌手名称
            for (Song song : songList) {
                Singer singer = singerMapper.selectByPrimaryKey(song.getSingerid());
                song.setSingerid(singer.getSingername());
            }
            PageHelper.startPage(1, 30);
            PageInfo<Song> songPageInfo = new PageInfo<>(songList);
            songPageInfo.setTotal(getSongLinkCount());
            return BaseResult.success(songPageInfo);
        }

        /**
         * 收藏歌曲
         * @param user
         * @param songName
         * @return
         */
        @Override
        public BaseResult addMusicCollect (User user, String songName, Integer mid){
            //1.判断是否为空
            if (StringUtils.isEmpty(user) || StringUtils.isEmpty(songName) || StringUtils.isEmpty(mid)) {
                //为空,直接返回错误信息
                return BaseResult.error();
            }
            //2.创建查询对象
            MusicLinkExample musicLinkExample = new MusicLinkExample();
            //歌曲id
            musicLinkExample.createCriteria().andMlIdEqualTo(mid);
            //3.查询该mid是否为有效值
            if (CollectionUtils.isEmpty(musicLinkMapper.selectByExample(musicLinkExample))) {
                //为空,无效mid值
                return BaseResult.error();
            }
            //有值,有效mid
            //歌曲名
            musicLinkExample.createCriteria().andMlSongnameEqualTo(songName);
            //4.执行
            List<MusicLink> musicLinks = musicLinkMapper.selectByExample(musicLinkExample);
            //判断查询后的list是否为空
            if (!CollectionUtils.isEmpty(musicLinks)) {
                //不为空,将该歌曲添加进该用户的myMusic
                MusicLink music = musicLinks.get(0);
                MyMusic myMusic = new MyMusic();
                //设置参数
                myMusic.setMySongname(music.getMlSongname());
                myMusic.setMySinger(music.getMlSinger());
                myMusic.setMySonglink(music.getMlSonglink());
                myMusic.setMyLyriclink(String.valueOf(0));
                myMusic.setMyPhotolink(music.getMlPhotolink());
                myMusic.setUserId(user.getUserId());
                //执行
                int result = myMusicMapper.insertSelective(myMusic);
                if (result > 0) {
                    redisTemplate.delete("mymusic*");
                    return BaseResult.success();
                }
                return BaseResult.error();
            }
            return BaseResult.error();
        }

        /**
         * 获取TOP-50歌曲
         * @param pageNum
         * @param pageSize
         * @return
         */
        @Override
        public BaseResult getTOPLink (Integer pageNum, Integer pageSize){
            //实时更新数据
            redisTemplate.delete(TOPLink);
            if (StringUtils.isEmpty(pageNum) || StringUtils.isEmpty(pageSize)) {
                pageNum = 1;
                pageSize = 50;
            }
            //设置分页
            PageHelper.startPage(pageNum, pageSize);
            BaseResult result = null;
            //判断是否缓存中有数据
            ValueOperations<String, String> operations = redisTemplate.opsForValue();
            //获取缓存中的json字符串
            String str = operations.get(TOPLink);
            if (!StringUtils.isEmpty(str)) {
                //不为空
                PageInfo pageInfo = JsonUtil.jsonStr2Object(str, PageInfo.class);
                pageInfo.setTotal(getSongLinkCount());
                //放入返回对象
                return BaseResult.success(pageInfo);
            }
            //放入到缓存中
            //根据点击数来判断歌曲火热程度,在进行升序
            SongExample songExample = new SongExample();
            //根据人气值来排序
            songExample.setOrderByClause("votes desc");
            //获取到排序后的歌曲
            List<Song> songList = songMapper.selectByExample(songExample);
            if (!CollectionUtils.isEmpty(songList)) {
                //将查询到的数据存放到缓存中歌手id拿到歌手名
                for (Song song : songList) {
                    Singer singer = singerMapper.selectByPrimaryKey(song.getSingerid());
                    //将歌手的名字放入
                    song.setSingerid(singer.getSingername());
                }
                //将集合存入分页工具
                PageInfo<Song> page = new PageInfo<>(songList);
                operations.set(TOPLink, JsonUtil.object2JsonStr(page));
                page.setTotal(songList.size());
                //遍历所有的歌曲,在根据
                return BaseResult.success(page);
            }
            return BaseResult.error();
        }



    /**
     * 使用music模板
     * @param pageNum
     * @param pageSize
     * @param SongType
     * @return
     */
        @Override
        public BaseResult ModuleMusic (Integer pageNum, Integer pageSize, String SongType,String time){
            return ModuleSong(pageNum, pageSize, SongType,time);
        }

    /**
     * 获取歌曲总数
     * @return
     */
    @Override
    public Integer getSongLinkCount() {
        List<Song> songs = songMapper.selectByExample(new SongExample());
        return songs.size();
    }

    /**
         * 模板
         * @param pageNum
         * @param pageSize
         * @param SongType
         * @return
         */
        public BaseResult ModuleSong (Integer pageNum, Integer pageSize, String SongType,String time){
            if (StringUtils.isEmpty(pageNum) || StringUtils.isEmpty(pageSize)) {
                pageNum = 1;
                pageSize = 50;
            }
            //设置分页数
            PageHelper.startPage(pageNum, pageSize);
            //创建查询对象
            LanguageExample languageExample = new LanguageExample();
            languageExample.createCriteria().andLanguagenameEqualTo(SongType);
            List<Language> languages = languageMapper.selectByExample(languageExample);
            //判断非空
            if (!CollectionUtils.isEmpty(languages)) {
                //获取language对象
                Language language = languages.get(0);
                //创建查对象
                SongExample songExample = new SongExample();
                SongExample.Criteria criteria = songExample.createCriteria();
                //设置歌曲风格id
                criteria.andTypeidEqualTo(language.getLanguageid());
                //设置字段排序
                songExample.setOrderByClause("votes DESC");

                //添加创建时间查询条件
                DateFormat dateFormat1 = new SimpleDateFormat("yyyy-MM-dd");
                Date date = null;
                Calendar calendar=Calendar.getInstance();
                try {
                    date = dateFormat1.parse("2010-12-30");
                } catch (ParseException e) {
                    e.printStackTrace();
                }

                if("1".equals(time)){
                    //欧美经典排行榜
                    criteria.andCreateTimeLessThanOrEqualTo(date);
                }else if("2".equals(time)){
                    //欧美新歌排行榜
                    try {
                        //将大于当前系统时间减3个月
                        calendar.add(Calendar.MONTH, -3);
                        date = dateFormat1.parse(dateFormat1.format(calendar.getTime()));
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                    criteria.andCreateTimeGreaterThanOrEqualTo(date);
                }
                List<Song> songs = songMapper.selectByExample(songExample);
                //判断是否为空
                if (!CollectionUtils.isEmpty(songs)) {
                    //不空
                    for (Song song : songs) {
                        //根据歌手id拿取到歌手名，并设置到song中
                        Singer singer = singerMapper.selectByPrimaryKey(song.getSingerid());
                        //将歌手的名字放入
                        song.setSingerid(singer.getSingername());
                    }
                    PageInfo<Song> songPageInfo = new PageInfo<>(songs);
                    songPageInfo.setTotal(songs.size());
                    return BaseResult.success(songPageInfo);
                }
            }
            return BaseResult.error();
        }
    }
