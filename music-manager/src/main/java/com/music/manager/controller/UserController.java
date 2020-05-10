package com.music.manager.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.music.common.result.BaseResult;
import com.music.manager.service.IMyMusicService;
import com.music.manager.service.IUserService;
import com.music.manager.service.impl.UserService;
import com.music.manager.vo.AdminQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * 
 * @author linliquan
 * @data 2018年12月23日 00:03:48
 */

@Controller
@RequestMapping("/user")
public class UserController {


	@Resource
	protected IUserService userService;

	@Resource
	protected IMyMusicService MyMusicService;

	@Autowired
	UserService userService2;

	String newName = null;

	/**
	 * 登入功能
	 * @param adminQuery
	 * @return
	 */
	@RequestMapping(value = "/loginPage", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ResponseBody
	public BaseResult loginCon(AdminQuery adminQuery,HttpServletRequest request,HttpServletResponse response) {

		return  userService.login(adminQuery,request,response);
	}


	/**
	 * 更改密码 更改密码 更改密码
	 * @return
	 */
	@RequestMapping(value = "/resetUserPassword", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ResponseBody
	public BaseResult resetUserPassword(AdminQuery adminQuery) {




		return null;
		/*
		Object data = null;
		String statusMsg = "";
		Integer statusCode = 200;
		int uId = 0;

		// 取参数的方法，对应登录表单中的用户名
		String user_name = request.getParameter("user_name");
		String newUser_password = request.getParameter("newUser_password");
		try {
			uId = (int) this.userService2.resetPassword(user_name, newUser_password);
			System.out.println("修改密码返回的id:" + uId);
		} catch (Exception e) {

		}

		return webResponse.getWebResponse(statusCode, statusMsg, data);*/

	}

}
