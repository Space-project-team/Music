package com.music.manager.mapper;

import com.music.manager.pojo.Song;
import com.music.manager.pojo.SongExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
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