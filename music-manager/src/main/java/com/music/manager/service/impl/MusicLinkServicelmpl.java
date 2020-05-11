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
import com.music.manager.mapper.MusicLinkMapper;
import com.music.manager.mapper.MyMusicMapper;
import com.music.manager.pojo.*;
import com.music.manager.service.IMusicLinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.List;


@Service("musicLinkService")
public class MusicLinkServicelmpl implements IMusicLinkService {

    @Autowired
    private MusicLinkMapper musicLinkMapper;
    @Autowired
    private MyMusicMapper myMusicMapper;

    @Autowired
    private RedisTemplate<String,String> redisTemplate;

    @Value(value = "${musicLink.list}")
    private String musicLinkList;

    /**
     * 获取所有音乐
     * @return
     */
    @Override
    public BaseResult getMusicList(Integer pageNum,Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        //获取redis对象
        ValueOperations<String, String> valueOperations = redisTemplate.opsForValue();
        //查看redis中是否存在musiclink缓存
        String mlStr = valueOperations.get(musicLinkList);
        if(!StringUtils.isEmpty(mlStr)){
            //存在缓存,使用缓存记录
            PageInfo pageInfo = JsonUtil.jsonStr2Object(mlStr, PageInfo.class);
            return BaseResult.success(pageInfo);
        }
        //不存在缓存,从数据库中查询所有音乐,在放入缓存中
        List<MusicLink> musicLinks = musicLinkMapper.selectByExample(new MusicLinkExample());
        if(!CollectionUtils.isEmpty(musicLinks)){
            //将集合存入分页工具
            PageInfo<MusicLink> page = new PageInfo<>(musicLinks);
            //将list存入缓存中
            valueOperations.set(musicLinkList,JsonUtil.object2JsonStr(page));
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
    public BaseResult getMusicByMusicName(String songName) {
        //非空判断
        if(StringUtils.isEmpty(songName)){
            return BaseResult.error();
        }

        BaseResult result = null;
        //创建查询对象
        MusicLinkExample musicLinkExample = new MusicLinkExample();
        MusicLinkExample.Criteria criteria = musicLinkExample.createCriteria();
        //模糊查询
        if(null!=songName) {
            criteria.andMlSongnameLike("%"+songName+"%");
        }
        //执行
        List<MusicLink> musicLinks = musicLinkMapper.selectByExample(musicLinkExample);
        if (CollectionUtils.isEmpty(musicLinks)){
            result = new BaseResult();
            result.setCode(500);
            return result;
        }
        result = new BaseResult();
        result.setCode(200);
        PageHelper.startPage(1,30);
        result.setPageInfo(new PageInfo<>(musicLinks));
        return result;
    }

    /**
     * 收藏歌曲
     * @param user
     * @param songName
     * @return
     */
    @Override
    public BaseResult addMusicCollect(User user, String songName,Integer mid) {
        //1.判断是否为空
        if(StringUtils.isEmpty(user)||StringUtils.isEmpty(songName)||StringUtils.isEmpty(mid)){
            //为空,直接返回错误信息
            return BaseResult.error();
        }
        //2.创建查询对象
        MusicLinkExample musicLinkExample = new MusicLinkExample();
        //歌曲id
        musicLinkExample.createCriteria().andMlIdEqualTo(mid);
        //3.查询该mid是否为有效值
        if(CollectionUtils.isEmpty(musicLinkMapper.selectByExample(musicLinkExample))){
            //为空,无效mid值
            return BaseResult.error();
        }
        //有值,有效mid
        //歌曲名
        musicLinkExample.createCriteria().andMlSongnameEqualTo(songName);
        //4.执行
        List<MusicLink> musicLinks = musicLinkMapper.selectByExample(musicLinkExample);
        //判断查询后的list是否为空
        if(!CollectionUtils.isEmpty(musicLinks)){
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
            if(result>0){
                return BaseResult.success();
            }
            return BaseResult.error();
        }
        return BaseResult.error();
    }

}
