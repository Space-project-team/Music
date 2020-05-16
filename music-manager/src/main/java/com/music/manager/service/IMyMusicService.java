/** 
* 
* @author linliquan
* @data 2018年12月23日 00:03:48  
*/

package com.music.manager.service;


import com.music.common.result.BaseResult;

import javax.servlet.http.HttpServletRequest;

public interface IMyMusicService {
    /**
     * 用户歌曲信息列表-分页
     */
    BaseResult getMyMusicList(String userName, Integer pageNum, Integer pageSize);

    /**
     * 根据用户id和歌曲id 删除
     */
    int deleteMyMusic(Integer mid,String userName);

    /**
     * 获取用户歌曲总数
     * @param uid
     * @return
     */
    Integer getCount(Integer uid);


}
