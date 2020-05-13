package com.music.manager.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.music.common.result.BaseResult;
import com.music.common.util.JsonUtil;
import com.music.manager.mapper.SingerMapper;
import com.music.manager.pojo.MyMusic;
import com.music.manager.pojo.Singer;
import com.music.manager.pojo.SingerExample;
import com.music.manager.service.ISingerService;
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

@Service("singerService")
public class SingerService implements ISingerService {
    @Resource
    private SingerMapper singerMapper;
    @Autowired
    private RedisTemplate<String,Object> redisTemplate;
    @Value("${singer.list.key}")
    private String singerListRedisKey;
    @Override
    public BaseResult getSingerList(Integer pageNum, Integer pageSize) {
        if(pageNum<=0||pageNum==null){
            pageNum=1;
        }
        if (pageSize<=0||pageSize==null){
            pageSize=42;
        }
        //开启分页
        PageHelper.startPage(pageNum,pageSize);
        //先从redis查询是否有数据
        ValueOperations<String,Object> stringObjectValueOperations=redisTemplate.opsForValue();
        String singerListJson = (String) stringObjectValueOperations.get(singerListRedisKey);
        //如果有值，直接转成list返回，没有就去数据库查询
        if(!StringUtils.isEmpty(singerListJson)){
            PageInfo pageInfo = JsonUtil.jsonStr2Object(singerListJson, PageInfo.class);
            return BaseResult.success(pageInfo);
        }
        //创建对象
        SingerExample singerExample =new SingerExample();
        singerExample.setOrderByClause("fans desc");
        List<Singer> singerList = singerMapper.selectByExample(singerExample);
//如果查询结果不为空，放入分页对象返回
        if(!CollectionUtils.isEmpty(singerList)){
            PageInfo<Singer> pageInfo=new PageInfo<>(singerList);
            //将查询的数据放入Redis
            stringObjectValueOperations.set(singerListRedisKey, JsonUtil.object2JsonStr(pageInfo));
            //返回结果
            return BaseResult.success(pageInfo);
        }else{

            //如果没有查到数据，将null放入redis，并设置失效时间1分钟
            stringObjectValueOperations.set(singerListRedisKey,new PageInfo<>(new ArrayList<MyMusic>()),60, TimeUnit.SECONDS);

        }
        return BaseResult.error();
    }

    @Override
    public BaseResult getSexSingerList(String sex, Integer pageNum, Integer pageSize) {
        return null;
    }
}
