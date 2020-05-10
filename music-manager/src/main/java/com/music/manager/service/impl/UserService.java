/** 
* 
* @author linliquan
* @data 2018年12月23日 00:03:48  
*/

package com.music.manager.service.impl;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.github.pagehelper.PageInfo;
import com.music.common.result.AbstractService;
import com.music.common.result.BaseResult;
import com.music.common.result.IOperations;
import com.music.common.util.CookieUtil;
import com.music.common.util.Md5Util;
import com.music.manager.domain.User;
import com.music.manager.mapper.IUserMapper;
import com.music.manager.service.IUserService;
import com.music.manager.vo.AdminQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;


@Service
public class UserService extends AbstractService<User, User> implements IUserService {

	public UserService() {
		this.setTableName("user");
	}

	@Autowired
	private IUserMapper userMapper;

	@Override
	protected IOperations<User, User> getMapper() {
		return userMapper;
	}

	@Override
	public void setTableName(String tableName) {
		this.tableName = tableName;
		;
	}

//	public User getUserByName(String user_name) {
//		User user = userMapper.getUserByName(user_name);
//		return user;
//	}

	public String login(String user_name, String user_password) {
		return userMapper.login(user_name, user_password);
	}

	public String getUserById(String user_name, String user_password) {
		return userMapper.getUserById(user_name, user_password);
	}

	public String registJudge(String user_name) {
		return userMapper.registJudge(user_name);
	}

	// 更改密码
	public Integer resetPassword(String user_name, String newUser_password) {
		return userMapper.resetPassword(user_name, newUser_password);
	}

	// 判断用户名是否重复
	@Override
	public String rearchUserName(String user_name) {
		return userMapper.rearchUserName(user_name);
	}



	/**
	 * 用户登入
	 * @param adminQuery
	 * @return
	 */
	@Override
	public BaseResult login(AdminQuery adminQuery, HttpServletRequest request, HttpServletResponse response) {
		BaseResult result = null;
		//1.参数判断非空
		if(StringUtils.isEmpty(adminQuery.getUser_name())){
			result = new BaseResult();
			result.setCode(500);
			result.setMessage("用户名不能为空!");
			return result;
		}
		if(StringUtils.isEmpty(adminQuery.getUser_password())){
			result = new BaseResult();
			result.setCode(500);
			result.setMessage("密码不能为空!");
			return result;
		}
		//2.如果用户名不为空,数据库查询该用户
		User user = userMapper.getUserByName(adminQuery.getUser_name());
		//3.判断返回用户值是否为空
		if(!StringUtils.isEmpty(user)){
			//3.1 不为空,在查询密码是否相同
			if(adminQuery.getUser_password().equals(user.user_password)){
				//3.2两次密码相同,该用户存在并信息正确
				//将user信息存储到session中
				request.getSession().setAttribute("user",user);
				return BaseResult.success();
			}
		}
		result = new BaseResult();
		result.setCode(500);
		result.setMessage("该用户不存在,请先注册!");
		return result;
	}
}
