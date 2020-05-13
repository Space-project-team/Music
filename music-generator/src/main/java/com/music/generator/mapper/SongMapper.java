package com.music.generator.mapper;

import com.music.generator.pojo.Song;
import com.music.generator.pojo.SongExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SongMapper {
    long countByExample(SongExample example);

    int deleteByExample(SongExample example);

    int deleteByPrimaryKey(String songid);

    int insert(Song record);

    int insertSelective(Song record);

    List<Song> selectByExample(SongExample example);

    Song selectByPrimaryKey(String songid);

    int updateByExampleSelective(@Param("record") Song record, @Param("example") SongExample example);

    int updateByExample(@Param("record") Song record, @Param("example") SongExample example);

    int updateByPrimaryKeySelective(Song record);

    int updateByPrimaryKey(Song record);
}