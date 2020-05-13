package com.music.manager.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;


import com.music.common.result.BaseResult;
import com.music.common.result.MusicPageInfo;
import com.music.manager.pojo.MusicLink;
import com.music.manager.pojo.Song;
import com.music.manager.pojo.User;
import com.music.manager.service.IMusicLinkService;
import com.music.manager.service.impl.MusicLinkServicelmpl;
import com.music.manager.vo.MusicLinkQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * 
 * @author linliquan
 * @data 2018年12月23日 00:03:48
 */

@Controller 
@RequestMapping("musicLink")
public class MusicLinkController {


	@Autowired
	protected IMusicLinkService musicLinkService;


	/**
	 * 从数据库中获取歌曲数据，在榜单中显示
	 * @param
	 * @return
	 */
	@RequestMapping(value = "/getMusicLinkList",method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	@ResponseBody
	public BaseResult getMusicLink(Integer pageNum, Integer pageSize,HttpServletRequest request){
		BaseResult result = musicLinkService.getMusicList(pageNum, pageSize);
		request.getSession().setAttribute("MusicList",result.getPageInfo());
		return result;
	}

	// 歌曲搜索功能
	@RequestMapping(value = "/getSongRearch",method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ResponseBody
	public BaseResult getMusicByMusicName(String songName){
		return  musicLinkService.getMusicByMusicName(songName);
	}

	/**
	 * 歌曲收藏
	 * @return
	 */
	@RequestMapping(value = "/addMusicCollect",method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ResponseBody
	public BaseResult  addMusicCollect(HttpServletRequest request,String songName,Integer mid){
		User user = (User) request.getSession().getAttribute("user");
		return  musicLinkService.addMusicCollect(user,songName,mid);
	}


	/**
	 * TOP-50 排行榜
	 * @param pageNum
	 * @param pageSize
	 * @return
	 */
	@RequestMapping(value = "TOPLink",method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ResponseBody
	public BaseResult TOPLink(Integer pageNum,Integer pageSize){
		return musicLinkService.getTOPLink(pageNum,pageSize);
	}

	/**
	 * 获取网络歌曲排行榜
	 * @param pageNum
	 * @param pageSize
	 * @return
	 */
	@RequestMapping(value = "NetworkMusic",method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ResponseBody
	public BaseResult NetworkMusic(Integer pageNum,Integer pageSize){
		return musicLinkService.getNetworkMusic(pageNum,pageSize);
	}


}
