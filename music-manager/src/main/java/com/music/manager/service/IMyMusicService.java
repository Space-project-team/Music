/** 
* 
* @author linliquan
* @data 2018年12月23日 00:03:48  
*/

package com.music.manager.service;

import com.music.common.result.IServiceOperations;
import com.music.manager.domain.MyMusic;

import java.util.List;



public interface IMyMusicService extends IServiceOperations<MyMusic, MyMusic> {

	public String getUserById(String user_name, String user_password);

	// 从数据库中获取音乐到我的音乐列表中
	public List<MyMusic> getMyMusicList(int userId);

	// 删除音乐
	public int deleteMyMusic(int song_id, int user_id);
}
