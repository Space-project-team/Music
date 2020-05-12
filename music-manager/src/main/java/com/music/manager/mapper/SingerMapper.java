package com.music.manager.mapper;


import com.music.manager.pojo.Singer;
import com.music.manager.pojo.SingerExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SingerMapper {
    long countByExample(SingerExample example);

    int deleteByExample(SingerExample example);

    int deleteByPrimaryKey(String singerid);

    int insert(Singer record);

    int insertSelective(Singer record);

    List<Singer> selectByExample(SingerExample example);

    Singer selectByPrimaryKey(String singerid);

    int updateByExampleSelective(@Param("record") Singer record, @Param("example") SingerExample example);

    int updateByExample(@Param("record") Singer record, @Param("example") SingerExample example);

    int updateByPrimaryKeySelective(Singer record);

    int updateByPrimaryKey(Singer record);
}