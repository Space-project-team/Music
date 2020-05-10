package com.music.manager.controller;

import javax.annotation.Resource;

import com.music.manager.service.IMusicLinkService;
import com.music.manager.service.impl.MusicLinkServicelmpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


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

	@Resource
	protected MusicLinkServicelmpl musicLinkService2;
	
	String str = null;


}
