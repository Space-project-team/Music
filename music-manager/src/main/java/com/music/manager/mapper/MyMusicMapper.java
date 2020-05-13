package com.music.manager.mapper;


import com.music.manager.pojo.MyMusic;
import com.music.manager.pojo.MyMusicExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MyMusicMapper {
    long countByExample(MyMusicExample example);

    int deleteByExample(MyMusicExample example);

    int deleteByPrimaryKey(Integer myId);

    int insert(MyMusic record);

    int insertSelective(MyMusic record);

    List<MyMusic> selectByExample(MyMusicExample example);

    MyMusic selectByPrimaryKey(Integer myId);

    int updateByExampleSelective(@Param("record") MyMusic record, @Param("example") MyMusicExample example);

    int updateByExample(@Param("record") MyMusic record, @Param("example") MyMusicExample example);

    int updateByPrimaryKeySelective(MyMusic record);

    int updateByPrimaryKey(MyMusic record);

    Integer selectByUserName(String userName);

    int deleteByMidAndUid(Integer mid, Integer uid);
}