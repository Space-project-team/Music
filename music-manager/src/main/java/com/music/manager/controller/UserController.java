package com.music.manager.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.github.qcloudsms.httpclient.HTTPException;
import com.music.common.result.BaseResult;
import com.music.manager.service.IMyMusicService;
import com.music.manager.service.SendMessageService;
import com.music.manager.service.UserService;
import com.music.manager.service.impl.UserServicelmpl;
import com.music.manager.vo.AdminQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;


/**
 * 
 * @author linliquan
 * @data 2018年12月23日 00:03:48
 */

@Controller
@RequestMapping("/user")
public class UserController {


	@Autowired
	protected UserService userService;

	@Resource
	protected IMyMusicService MyMusicService;

	@Autowired
	UserServicelmpl userService2;

	@Autowired
	private SendMessageService sendMessage;
	String newName = null;

	/**
	 * 登入功能
	 * @param adminQuery
	 * @return
	 */
	@RequestMapping(value = "/loginPage", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ResponseBody
	public BaseResult loginCon(AdminQuery adminQuery, HttpServletRequest request, HttpServletResponse response) {
		return  userService.login(adminQuery, request, response);
	}


	/**
	 * 更改密码 更改密码 更改密码
	 * @return
	 */
	@RequestMapping(value = "/resetUserPassword", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ResponseBody
	public BaseResult resetUserPassword(String newUser_password,HttpServletRequest request,HttpServletResponse response) {

		return userService.EditUser(newUser_password,request,response);
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
	/**
	 * 注册功能
	 *
	 * */
	@RequestMapping(value = "/addUser", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ResponseBody
	public BaseResult insert(AdminQuery adminQuery,HttpServletRequest request,HttpServletResponse response){
		return  userService.addUser(adminQuery,request,response);
	}
	/**
	 * 注销功能
	 * */
	@RequestMapping(value = "/layOut", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ResponseBody
	public BaseResult layOut(HttpServletRequest request,HttpServletResponse response){
		return  userService.layOut(request,response);
	}

	/**
	 * 手机注册功能
	 *
	 * */
	@RequestMapping(value = "/register", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ResponseBody
	public BaseResult register(AdminQuery adminQuery,HttpServletRequest request){
		return userService.SendSmsRegister(adminQuery, request);
	}

	/**
	 * 发送短信
	 */
	@RequestMapping(value = "/SendSsm", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ResponseBody
	public BaseResult SendSsm(String phone,HttpServletRequest request){
		BaseResult result = null;
		try {
			//发送短信
			result = sendMessage.sendMessage(phone, request);
		} catch (HTTPException e) {
			return BaseResult.error();
		} catch (IOException e) {
			return BaseResult.error();
		}
		return result;
	}
}
