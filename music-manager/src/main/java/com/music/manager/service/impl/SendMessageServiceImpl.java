package com.music.manager.service.impl;

import com.github.qcloudsms.SmsSingleSender;
import com.github.qcloudsms.SmsSingleSenderResult;
import com.github.qcloudsms.httpclient.HTTPException;
import com.music.common.result.BaseResult;
import com.music.common.util.CodeUtil;
import com.music.common.util.RandomUtil;

import com.music.manager.service.SendMessageService;
import org.json.JSONException;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

@Service
public class SendMessageServiceImpl implements SendMessageService {

    /**
     *
     * 发送短信
     * @param phoneNum
     * @return
     * @throws HTTPException
     * @throws IOException
     */
    @Override
    public BaseResult sendMessage(String phoneNum, HttpServletRequest request) throws HTTPException, IOException {
        if(!CodeUtil.isMobileNO(phoneNum)){
            BaseResult result = new BaseResult();
            result.setCode(404);
            result.setMessage("手机号码格式不正确!");
            return result;
        }
        int appid = 1400365043;
        String appkey = "92ab2a9508b1cc96935a0d4acbc6b6c2";
        String[] phoneNumbers = {phoneNum}; //手机号可以添很多。
        int templateId = 598600;
        String smsSign = "小小伯乐无君愁";
        try {
            //第一个参数传递{1}位置想要的内容，第二个传递{2}的内容，以此类推。具体看步骤5
            String code = CodeUtil.getCode();
            String[] params = {code,"5"};
            SmsSingleSender ssender = new SmsSingleSender(appid, appkey);
            SmsSingleSenderResult result = ssender.sendWithParam("86", phoneNumbers[0],
                    templateId, params, smsSign, "", "");
            if(result.errMsg.equals("OK")){
                //将code值存储
                HttpSession session = request.getSession();
                session.setAttribute("code",code);
                //TimerTask实现5分钟后从session中删除checkCode
                final Timer timer=new Timer();
                timer.schedule(new TimerTask() {
                    @Override
                    public void run() {
                        session.removeAttribute("code");
                        System.out.println("code");
                        timer.cancel();
                    }
                },5*60*1000);
                return BaseResult.success();
            }
        } catch (HTTPException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return BaseResult.error();
    }




}
