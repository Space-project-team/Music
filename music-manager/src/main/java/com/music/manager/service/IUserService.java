/** 
* 
* @author linliquan
* @data 2018年12月23日 00:03:48  
*/

package com.music.manager.service;


import com.music.common.result.BaseResult;
import com.music.common.result.IServiceOperations;
import com.music.manager.domain.User;
import com.music.manager.vo.AdminQuery;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface IUserService extends IServiceOperations<User, User> {

	// 判断用户名是否重复
	public String rearchUserName(String user_name);

	//用户登入
    BaseResult login(AdminQuery adminQuery, HttpServletRequest request, HttpServletResponse response);
}
