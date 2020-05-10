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
}
