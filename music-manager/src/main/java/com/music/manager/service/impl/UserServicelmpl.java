/** 
* 
* @author linliquan
* @data 2018年12月23日 00:03:48  
*/

package com.music.manager.service.impl;

import com.github.pagehelper.PageInfo;
import com.music.common.result.BaseResult;
import com.music.common.util.CodeUtil;
import com.music.common.util.CookieUtil;
import com.music.common.util.Md5Util;
import com.music.common.util.RandomUtil;
import com.music.manager.mapper.UserMapper;
import com.music.manager.pojo.User;
import com.music.manager.pojo.UserExample;
import com.music.manager.service.UserService;
import com.music.manager.vo.AdminQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;


@Service
public class UserServicelmpl implements UserService {


	@Autowired
	private UserMapper userMapper;




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
			result.setCode(501);
			result.setMessage("密码不能为空!");
			return result;
		}
		//创建查询对象
		UserExample userExample = new UserExample();
		//添加参数
		userExample.createCriteria().andUserNameEqualTo(adminQuery.getUser_name());
		//执行
		List<User> users = userMapper.selectByExample(userExample);
		//3.判断返回用户值是否为空
		if(!CollectionUtils.isEmpty(users)){
			//3.1 不为空,在查询密码是否相同
			User user = users.get(0);
			adminQuery.setUser_password(Md5Util.getMD5String(adminQuery.getUser_password()));
			if(adminQuery.getUser_password().equals(user.getUserPassword())){
				//3.2两次密码相同,该用户存在并信息正确
				//将user信息存储到session中
				request.getSession().setAttribute("user",user);
				return BaseResult.success();
			}else{
				result = new BaseResult();
				result.setCode(503);
				result.setMessage("密码错误!");
				return result;
			}
		}
		result = new BaseResult();
		result.setCode(502);
		result.setMessage("该用户不存在,请先注册!");
		return result;
	}
	/**
	 * 用户注册
	 * */
	@Override
	public BaseResult addUser(AdminQuery adminQuery,HttpServletRequest request, HttpServletResponse response) {
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
			result.setCode(501);
			result.setMessage("密码不能为空!");
			return result;
		}
		//创建查询对象
		UserExample userExample = new UserExample();
		//添加参数
		userExample.createCriteria().andUserNameEqualTo(adminQuery.getUser_name());
		//执行
		List<User> users = userMapper.selectByExample(userExample);
		//3.判断返回用户值是否为空
		if(CollectionUtils.isEmpty(users)){
			//3.1 为空,则证明改用户名可用
			User user=new User();
			user.setUserName(adminQuery.getUser_name());
			user.setUserPassword(Md5Util.getMD5String(adminQuery.getUser_password()));
			Date date = new Date();
			user.setCreateTime(date);
			userMapper.insertSelective(user);
			//将user信息存储到session中
			request.getSession().setAttribute("user",user);
			return BaseResult.success();
		}
		result = new BaseResult();
		result.setCode(502);
		result.setMessage("该用户已存在,请重新输入!");
		return result;
	}

	@Override
	public BaseResult EditUser(String newPassword, HttpServletRequest request, HttpServletResponse response) {
		BaseResult result = null;
		User user=(User)request.getSession().getAttribute("user");
		if(user==null){
			result = new BaseResult();
			result.setCode(502);
			result.setMessage("请先登录!");
			return result;
		}
		//不需要验证旧密码登录
		//1.参数判断非空
		if(StringUtils.isEmpty(newPassword)){
			result = new BaseResult();
			result.setCode(501);
			result.setMessage("新密码不能为空!");
			return result;
		}
		user.setUserPassword(Md5Util.getMD5String(newPassword));
		int row=userMapper.updateByPrimaryKey(user);
        System.out.println(row);
		return BaseResult.success();
	}

	@Override
	public BaseResult layOut(HttpServletRequest request, HttpServletResponse response) {
		BaseResult result = null;
		User user=(User)request.getSession().getAttribute("user");
		if(user==null){
			result = new BaseResult();
			result.setCode(502);
			result.setMessage("请先登录!");
			return result;
		}
		//清除session
		request.getSession().removeAttribute("user");
		return BaseResult.success();
	}

	/**
	 * 手机短信注册用户
	 * @param adminQuery
	 * @param request
	 * @return
	 */
	@Override
	public BaseResult SendSmsRegister(AdminQuery adminQuery,HttpServletRequest request) {
		//1.参数判断非空
		BaseResult result = null;
		if(StringUtils.isEmpty(adminQuery.getUser_name())){
			result = new BaseResult();
			result.setCode(500);
			result.setMessage("用户名不能为空!");
			return result;
		}
		if(StringUtils.isEmpty(adminQuery.getUser_password())){
			result = new BaseResult();
			result.setCode(501);
			result.setMessage("密码不能为空!");
			return result;
		}
		if(StringUtils.isEmpty(adminQuery.getCode())){
			result = new BaseResult();
			result.setCode(501);
			result.setMessage("验证码不能为空!");
			return result;
		}
		//从作用域中取code
		String code = (String) request.getSession().getAttribute("code");
		//判断用户填写的验证码是否与发送短信后的验证码一致
		if(code.equals(adminQuery.getCode())){
			//创建查询对象
			UserExample userExample = new UserExample();
			//添加参数
			userExample.createCriteria().andUserNameEqualTo(adminQuery.getUser_name());
			//执行
			List<User> users = userMapper.selectByExample(userExample);
			//3.判断返回用户值是否为空
			if(CollectionUtils.isEmpty(users)) {
				//3.1 为空,则证明改用户名可用
				User user = new User();
				user.setUserName(adminQuery.getUser_name());
				user.setUserPassword(Md5Util.getMD5String(adminQuery.getUser_password()));
				Date date = new Date();
				user.setCreateTime(date);
				int row = userMapper.insertSelective(user);
				if(row>0) {
					//将user信息存储到session中
					request.getSession().setAttribute("user", user);
					result = new BaseResult();
					result.setCode(200);
					result.setMessage("注册成功!");
					return result;
				}
				return BaseResult.error();
			}
			result = new BaseResult();
			result.setCode(502);
			result.setMessage("该用户已存在,请重新输入!");
			return result;
		}
		result = new BaseResult();
		result.setCode(502);
		result.setMessage("验证码错误!");
		return result;
	}


}
