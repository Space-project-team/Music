package com.music.manager.mapper;


import com.music.manager.pojo.Language;
import com.music.manager.pojo.LanguageExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface LanguageMapper {
    long countByExample(LanguageExample example);

    int deleteByExample(LanguageExample example);

    int deleteByPrimaryKey(String languageid);

    int insert(Language record);

    int insertSelective(Language record);

    List<Language> selectByExample(LanguageExample example);

    Language selectByPrimaryKey(String languageid);

    int updateByExampleSelective(@Param("record") Language record, @Param("example") LanguageExample example);

    int updateByExample(@Param("record") Language record, @Param("example") LanguageExample example);

    int updateByPrimaryKeySelective(Language record);

    int updateByPrimaryKey(Language record);
}