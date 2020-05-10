/** 
* 
* @author linliquan
* @data 2018年12月23日 00:03:48  
*/

package com.music.manager.service.impl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.music.common.result.BaseResult;
import com.music.manager.mapper.UserMapper;
import com.music.manager.pojo.User;
import com.music.manager.pojo.UserExample;
import com.music.manager.service.UserService;
import com.music.manager.vo.AdminQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

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
			result.setCode(500);
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
			if(adminQuery.getUser_password().equals(user.getUserPassword())){
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
