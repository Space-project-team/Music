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
import com.music.manager.mapper.MyMusicMapper;
import com.music.manager.pojo.MyMusic;
import com.music.manager.pojo.MyMusicExample;
import com.music.manager.service.IMyMusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Service("myMusicService")
public class MyMusicService implements IMyMusicService {

    @Resource
    private MyMusicMapper myMusicMapper;

    @Autowired
    private RedisTemplate<String,Object> redisTemplate;
    @Value("${mymusic.list.key}")
    private String myMusicListRedisKey;


    /**
     * 搜索用户歌曲信息 -分页
     * @param userName
     * @param pageNum
     * @param pageSize
     * @return
     */
    @Override
    public BaseResult getMyMusicList(String userName, Integer pageNum, Integer pageSize) {
        //开启分页
        PageHelper.startPage(pageNum,pageSize);
        //判断用户是否存在
        if(StringUtils.isEmpty(userName)){
            return BaseResult.error();
        }
        //先从redis查询是否有数据
        ValueOperations<String,Object> stringObjectValueOperations=redisTemplate.opsForValue();
        String myMusicListJson = (String) stringObjectValueOperations.get(myMusicListRedisKey);
        //如果有值，直接转成list返回，没有就去数据库查询
        if(!StringUtils.isEmpty(myMusicListJson)){
            PageInfo pageInfo = JsonUtil.jsonStr2Object(myMusicListJson, PageInfo.class);
            return BaseResult.success(pageInfo);
        }
        //查询用户id
        Integer uid=myMusicMapper.selectByUserName(userName);
        if (StringUtils.isEmpty(uid)){
            return BaseResult.error();
        }
        //创建对象
        MyMusicExample example=new MyMusicExample();
        example.createCriteria().andUserIdEqualTo(uid);
        //根据用户id查询查询歌曲列表
        List<MyMusic> myList=myMusicMapper.selectByExample(example);
        //System.out.println(myList.toString());
        //如果查询结果不为空，放入分页对象返回
        if(!CollectionUtils.isEmpty(myList)){
            PageInfo<MyMusic> pageInfo=new PageInfo<>(myList);
            //将查询的数据放入Redis
            stringObjectValueOperations.set(myMusicListRedisKey, JsonUtil.object2JsonStr(pageInfo));
            //返回结果
            return BaseResult.success(pageInfo);
        }else{

            //如果没有查到数据，将null放入redis，并设置失效时间1分钟
            stringObjectValueOperations.set(myMusicListRedisKey,new PageInfo<>(new ArrayList<MyMusic>()),60, TimeUnit.SECONDS);

        }
        return BaseResult.error();
    }

    /**
     * 根据用户id 和歌曲id 删除
     * @param mid
     * @param userName
     * @return
     */
    @Override
    public int deleteMyMusic(Integer mid, String userName) {
        //判断是否为空
        if(StringUtils.isEmpty(mid)){
            return 0;
        }
        if(StringUtils.isEmpty(userName)){
            return 0;
        }
        //获取用户id
        Integer uid=myMusicMapper.selectByUserName(userName);
        if (StringUtils.isEmpty(uid)){
            return 0;
        }
        //创建对象
        MyMusicExample example=new MyMusicExample();
        //填入参数
        example.createCriteria().andMyIdEqualTo(mid);
        example.createCriteria().andUserIdEqualTo(uid);
        //查询
        int result=myMusicMapper.deleteByExample(example);
        //如果结果大于0,返回结果
        if(result>0){
            return 1;
        }
        return 0;
    }

}
