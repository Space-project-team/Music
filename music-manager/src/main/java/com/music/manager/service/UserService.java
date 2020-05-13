/** 
* 
* @author linliquan
* @data 2018年12月23日 00:03:48  
*/

package com.music.manager.service;


import com.music.common.result.BaseResult;
import com.music.manager.vo.AdminQuery;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public interface UserService {

	//用户登入
    BaseResult login(AdminQuery adminQuery, HttpServletRequest request, HttpServletResponse response);

    //用户注册
    BaseResult addUser(AdminQuery adminQuery, HttpServletRequest request, HttpServletResponse response);

    //修改密码
    BaseResult EditUser(String newPassword, HttpServletRequest request, HttpServletResponse response);

    //用户注销
    BaseResult layOut(HttpServletRequest request, HttpServletResponse response);

    //手机注册
    BaseResult SendSmsRegister(AdminQuery adminQuery,HttpServletRequest request);
}
