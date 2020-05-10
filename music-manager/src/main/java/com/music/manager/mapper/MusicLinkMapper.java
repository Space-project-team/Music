package com.music.manager.mapper;


import com.music.manager.pojo.MusicLink;
import com.music.manager.pojo.MusicLinkExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MusicLinkMapper {
    long countByExample(MusicLinkExample example);

    int deleteByExample(MusicLinkExample example);

    int deleteByPrimaryKey(Integer mlId);

    int insert(MusicLink record);

    int insertSelective(MusicLink record);

    List<MusicLink> selectByExample(MusicLinkExample example);

    MusicLink selectByPrimaryKey(Integer mlId);

    int updateByExampleSelective(@Param("record") MusicLink record, @Param("example") MusicLinkExample example);

    int updateByExample(@Param("record") MusicLink record, @Param("example") MusicLinkExample example);

    int updateByPrimaryKeySelective(MusicLink record);

    int updateByPrimaryKey(MusicLink record);
}