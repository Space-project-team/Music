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
     * @return
     */
    @Override
    public BaseResult getSingerList(SingerQuery singerQuery) {
        //实时更新
        redisTemplate.delete(singerListRedisKey);
        //分页参数设置
        setPage(singerQuery.getPageNum(),singerQuery.getPageSize());
        //开启分页
        PageHelper.startPage(pageNum,pageSize);
        //先从redis查询是否有数据
        ValueOperations<String,Object> stringObjectValueOperations=redisTemplate.opsForValue();
        String singerListJson = (String) stringObjectValueOperations.get(singerListRedisKey);
        //如果有值，直接转成list返回，没有就去数据库查询
        if(!StringUtils.isEmpty(singerListJson)){
            PageInfo pageInfo = JsonUtil.jsonStr2Object(singerListJson, PageInfo.class);
            //设置歌手总数
            return BaseResult.success(pageInfo);
        }
        //创建对象
        SingerExample singerExample =new SingerExample();
        singerExample.setOrderByClause("fans desc");
        List<Singer> singerList = singerMapper.selectByExample(singerExample);
        //如果查询结果不为空，放入分页对象返回
        if(!CollectionUtils.isEmpty(singerList)){
            PageInfo<Singer> pageInfo=new PageInfo<>(singerList);
            //设置歌手总数
            pageInfo.setTotal(getSingerCount());
            //将查询的数据放入Redis
            stringObjectValueOperations.set(singerListRedisKey, JsonUtil.object2JsonStr(pageInfo));
            //返回结果
            return BaseResult.success(pageInfo);
        }else{
            PageInfo<MyMusic> myMusicPageInfo = new PageInfo<>(new ArrayList<>());
            //设置歌手总数
            myMusicPageInfo.setTotal(getSingerCount());
            //如果没有查到数据，将null放入redis，并设置失效时间1分钟
            stringObjectValueOperations.set(singerListRedisKey,myMusicPageInfo,60, TimeUnit.SECONDS);

        }
        return BaseResult.error();
    }

    /**
     * 根据性别查询歌手
     * @param singerQuery
     * @return
     */
    @Override
    public BaseResult getSexSingerList(SingerQuery singerQuery) {
        //分页参数设置
        setPage(singerQuery.getPageNum(),singerQuery.getPageSize());
        //开启分页
        PageHelper.startPage(pageNum,pageSize);
        //创建对象
        SingerExample singerExample =new SingerExample();
        singerExample.setOrderByClause("fans desc");
        singerExample.createCriteria().andSexEqualTo(singerQuery.getSex());
        List<Singer> singerList = singerMapper.selectByExample(singerExample);
        if(!CollectionUtils.isEmpty(singerList)){
            PageInfo<Singer> pageInfo=new PageInfo<>(singerList);
            //获取总数,用于分页
            pageInfo.setTotal(singerList.size());
            //将查询的数据放入Redis
            //返回结果
            return BaseResult.success(pageInfo);
        }
        return BaseResult.error();
    }


    /**
     * 根据类型查询歌手
     * @param singerQuery
     * @return
     */
    @Override
    public BaseResult getTypeSingerList(SingerQuery singerQuery) {
        if(emptySinger(singerQuery)){
            //如果为true,参数为空
            return BaseResult.error();
        }
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
            PageInfo<Singer> singerPageInfo = new PageInfo<>(singers);
            //获取总数,用于分页
            singerPageInfo.setTotal(singers.size());
            return BaseResult.success(singerPageInfo);
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
        if(StringUtils.isEmpty(singerQuery.getTypeName())||StringUtils.isEmpty(singerQuery.getGroup())){
            //如果为true,参数为空
            return BaseResult.error();
        }
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
            PageInfo<Singer> singerPageInfo = new PageInfo<>(singers);
            singerPageInfo.setTotal(singers.size());
            return BaseResult.success(singerPageInfo);
        }
        //为空,返回失败信息
        return BaseResult.error();
    }

    /**
     *  获取所以歌手总数
     * @return
     */
    @Override
    public Integer getSingerCount() {
        List<Singer> singers = singerMapper.selectByExample(new SingerExample());
        return singers.size();
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
            pageSize = 10;
        }
    }


    /**
     * 非空判断工具
     * @param singerQuery
     * @return
     */
    public Boolean emptySinger(SingerQuery singerQuery){
        if(StringUtils.isEmpty(singerQuery.getGroup())){
            return true;
        }
        if(StringUtils.isEmpty(singerQuery.getSex())){
            return true;
        }
        if(StringUtils.isEmpty(singerQuery.getTypeName())){
            return true;
        }
        return false;
    }
}
