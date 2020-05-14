package com.music.manager.service;

import com.music.common.result.BaseResult;

public interface ISingerService {
    /**
     * 用户歌曲信息列表-分页
     */
    BaseResult getSingerList(Integer pageNum, Integer pageSize);

    /**
     * 男女歌手分页
     * */
    BaseResult getSexSingerList(String sex,Integer pageNum, Integer pageSize);

}
