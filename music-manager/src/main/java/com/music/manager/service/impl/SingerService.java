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
import com.music.manager.vo.SingerQuery;
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

    private Integer pageNum = null;
    private Integer pageSize = null;


    /**
     * 获取所以歌手,按照粉丝排行
     * @param pageNum
     * @param pageSize
     * @return
     */
    @Override
    public BaseResult getSingerList(Integer pageNum, Integer pageSize) {
        if(pageNum<=0||pageNum==null){
            pageNum=1;
        }
        if (pageSize<=0||pageSize==null){
            pageSize=50;
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
        //分页参数设置
        setPage(pageNum,pageSize);
        //开启分页
        PageHelper.startPage(pageNum,pageSize);
        //创建对象
        SingerExample singerExample =new SingerExample();
        singerExample.setOrderByClause("fans desc");
        singerExample.createCriteria().andSexEqualTo(sex);
        List<Singer> singerList = singerMapper.selectByExample(singerExample);
        if(!CollectionUtils.isEmpty(singerList)){
            PageInfo<Singer> pageInfo=new PageInfo<>(singerList);
            //将查询的数据放入Redis
            //返回结果
            return BaseResult.success(pageInfo);
        }
        return BaseResult.error();
    }

    @Override
    public BaseResult getTypeSingerList(SingerQuery singerQuery) {
        //分页参数设置
        setPage(singerQuery.getPageNum(),singerQuery.getPageSize());
        //开启分页
        PageHelper.startPage(pageNum,pageSize);
        //创建对象
        SingerExample singerExample =new SingerExample();
        //设置参数
        singerExample.setOrderByClause("fans desc");
        SingerExample.Criteria criteria = singerExample.createCriteria();
        criteria.andSexEqualTo(singerQuery.getSex());
        criteria.andTypeEqualTo(singerQuery.getTypeName());
        //查询
        List<Singer> singers = singerMapper.selectByExample(singerExample);
        if(!CollectionUtils.isEmpty(singers)){
            //不为空,返回数据
            return BaseResult.success(new PageInfo<>(singers));
        }
        //为空,返回失败信息
        return BaseResult.error();
    }

    /**
     * 风格组合歌手查询
     * @param singerQuery
     * @return
     */
    @Override
    public BaseResult getGroupSingerList(SingerQuery singerQuery) {
        //分页参数设置
        setPage(singerQuery.getPageNum(),singerQuery.getPageSize());
        //开启分页
        PageHelper.startPage(pageNum,pageSize);
        //创建对象
        SingerExample singerExample =new SingerExample();
        //设置参数
        singerExample.setOrderByClause("fans desc");
        SingerExample.Criteria criteria = singerExample.createCriteria();
        criteria.andGroupsEqualTo(singerQuery.getGroup());
        criteria.andTypeEqualTo(singerQuery.getTypeName());
        //查询
        List<Singer> singers = singerMapper.selectByExample(singerExample);
        if(!CollectionUtils.isEmpty(singers)){
            //不为空,返回数据
            return BaseResult.success(new PageInfo<>(singers));
        }
        //为空,返回失败信息
        return BaseResult.error();
    }

    /**
     * 设置分页参数
     * @param pageNums
     * @param pageSizes
     */
    public void setPage(Integer pageNums,Integer pageSizes){
        pageNum = pageNums;
        pageSize = pageSizes;
        //分页参数判断
        if(StringUtils.isEmpty(pageNum)||StringUtils.isEmpty(pageSize)){
            pageNum = 1;
            pageSize = 30;
        }
    }
}
