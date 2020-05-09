/** 
* 
* @author linliquan
* @data 2018年12月23日 00:03:48  
*/

package com.music.manager.service;


import com.music.common.result.IServiceOperations;
import com.music.manager.domain.MusicLink;

public interface IMusicLinkService extends IServiceOperations<MusicLink, MusicLink> {

	// 将榜单音乐收藏插入到我的音乐表中
	public void insertSongRearch(int song_id, int userId);

	public String judgeSong(String songName, int userId);
}
