package com.music.manager.service;

import com.github.qcloudsms.httpclient.HTTPException;
import com.music.common.result.BaseResult;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public interface SendMessageService {
    /**
     * 发送短信
     * @param phoneNum
     */
    BaseResult sendMessage(String phoneNum, HttpServletRequest request) throws HTTPException, IOException;
}
