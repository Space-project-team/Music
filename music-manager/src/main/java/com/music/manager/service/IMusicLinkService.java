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
    BaseResult getMusicByMusicName(String songName,Integer pageNum,Integer pageSize);
    //收藏歌曲
    BaseResult addMusicCollect(String songName,String song_id,Integer user_id);
    //获取top前50歌曲
    BaseResult getTOPLink(Integer pageNum, Integer pageSize);
    //模板
    BaseResult  ModuleMusic(Integer pageNum, Integer pageSize,String SongType,String time);
    //获取song总数
    Integer getSongLinkCount();

}
