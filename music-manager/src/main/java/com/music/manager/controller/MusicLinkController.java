package com.music.manager.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import com.music.common.result.BaseResult;
import com.music.common.result.MusicPageInfo;
import com.music.manager.pojo.MusicLink;
import com.music.manager.pojo.User;
import com.music.manager.service.IMusicLinkService;
import com.music.manager.service.impl.MusicLinkServicelmpl;
import com.music.manager.vo.MusicLinkQuery;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * 
 * @author linliquan
 * @data 2018年12月23日 00:03:48
 */

@Controller 
@RequestMapping("/musicLink")
public class MusicLinkController {


	@Resource
	protected IMusicLinkService musicLinkService;


	/**
	 * 从数据库中获取歌曲数据，在榜单中显示
	 * @param
	 * @return
	 */
	@RequestMapping("getMusicLinkList")
	@ResponseBody
	public MusicPageInfo<MusicLink> getMusicLink(Integer pageNum,Integer pageSize){
		return musicLinkService.getMusicList(pageNum,pageSize);
	}

	// 歌曲搜索功能
	@RequestMapping("getSongRearch")
	@ResponseBody
	public BaseResult getMusicByMusicName(String songName){
		return  musicLinkService.getMusicByMusicName(songName);
	}

	/**
	 * 歌曲收藏
	 * @return
	 */
	@RequestMapping("addMusicCollect")
	@ResponseBody
	public BaseResult  addMusicCollect(HttpServletRequest request,String songName,Integer mid){
		User user = (User) request.getSession().getAttribute("user");
		return  musicLinkService.addMusicCollect(user,songName,mid);
	}
}
