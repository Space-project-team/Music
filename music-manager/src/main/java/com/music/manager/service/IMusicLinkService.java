/** 
* 
* @author linliquan
* @data 2018年12月23日 00:03:48  
*/

package com.music.manager.service;


import com.music.common.result.BaseResult;
import com.music.common.result.MusicPageInfo;
import com.music.manager.pojo.MusicLink;
import com.music.manager.pojo.User;

public interface IMusicLinkService{
    //获取所有音乐
    BaseResult getMusicList(Integer pageNum,Integer pageSize);

    //歌曲搜索功能
    BaseResult getMusicByMusicName(String songName);
    //收藏歌曲
    BaseResult addMusicCollect(User user, String songName,Integer mid);
}
