/** 
* 
* @author linliquan 
* @data 2018年12月23日 00:03:48  
*/

package com.music.manager.service.impl;

import javax.annotation.Resource;

import com.music.common.result.AbstractService;
import com.music.common.result.IOperations;
import com.music.manager.domain.Test;
import com.music.manager.mapper.ITestMapper;
import com.music.manager.service.ITestService;
import org.springframework.stereotype.Service;

@Service("testService")
public class TestService extends AbstractService<Test, Test> implements ITestService {

	public TestService() {
		this.setTableName("test");
	}

	@Resource   
	private ITestMapper testMapper;

	@Override
	protected IOperations<Test, Test> getMapper() {
		return testMapper;
	}

	@Override
	public void setTableName(String tableName) {
		this.tableName = tableName;
		;
	}

}
