package com.music.generator.mapper;

import com.music.generator.pojo.MyMusic;
import com.music.generator.pojo.MyMusicExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

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
}