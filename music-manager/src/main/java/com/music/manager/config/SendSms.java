package com.music.manager.config;

import com.tencentcloudapi.common.Credential;
import com.tencentcloudapi.common.profile.ClientProfile;
import com.tencentcloudapi.common.profile.HttpProfile;
import com.tencentcloudapi.common.exception.TencentCloudSDKException;

import com.tencentcloudapi.sms.v20190711.SmsClient;

import com.tencentcloudapi.sms.v20190711.models.SendSmsRequest;
import com.tencentcloudapi.sms.v20190711.models.SendSmsResponse;

public class SendSms {
    public static void main(String [] args) {
        try{

            Credential cred = new Credential("AKIDuGMAhwQJH2o7RURkxtXty0nJY2E8M5Bz", "e1DUUEgrKJ4KK5ZtOcZFftpTpvkJDp9D");

            HttpProfile httpProfile = new HttpProfile();
            httpProfile.setEndpoint("sms.tencentcloudapi.com");

            ClientProfile clientProfile = new ClientProfile();
            clientProfile.setHttpProfile(httpProfile);

            SmsClient client = new SmsClient(cred, "", clientProfile);

            String params = "{\"PhoneNumberSet\":[\"+8615279179201\"],\"TemplateID\":\"598600\",\"Sign\":\"小小伯乐无君愁\",\"SmsSdkAppid\":\"283829\"}";
            SendSmsRequest req = SendSmsRequest.fromJsonString(params, SendSmsRequest.class);

            SendSmsResponse resp = client.SendSms(req);

            System.out.println(SendSmsRequest.toJsonString(resp));
        } catch (TencentCloudSDKException e) {
            System.out.println(e.toString());
        }

    }

}