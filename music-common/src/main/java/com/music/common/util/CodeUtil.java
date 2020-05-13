package com.music.common.util;





import org.apache.commons.lang.RandomStringUtils;

import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CodeUtil {
    /**
     * 获取随机6位验证码
     * @return
     */
  public static String getCode(){
      String code = "";
      for (int i=1;i<=6;i++){
          code+=(int)(Math.random() * 9);
      }
      return code;
  }

    /**
     * 随机生成用户名
     */
    public static   String getStringRandom(int length) {

              String val = "";
              Random random = new Random();

        //参数length，表示生成几位随机数
        for(int i = 0; i < length; i++) {
                String charOrNum = random.nextInt(2) % 2 == 0 ? "char" : "num";
                      //输出字母还是数字
                      if( "char".equalsIgnoreCase(charOrNum) ) {
                               //输出是大写字母还是小写字母
                             int temp = random.nextInt(2) % 2 == 0 ? 65 : 97;
                              val += (char)(random.nextInt(26) + temp);
                      } else if( "num".equalsIgnoreCase(charOrNum) ) {
                          val += String.valueOf(random.nextInt(10));
                     }
               }
           return val;
          }

    /**
     * 手机号码格式校验
     * @param mobiles
     * @return
     */
    public static boolean isMobileNO(String mobiles){
        Pattern p = Pattern.compile("^((13[0-9])|(15[^4,\\D])|(18[0,5-9]))\\d{8}$");
        Matcher m = p.matcher(mobiles);
        System.out.println(m.matches()+"---");
        return m.matches();
    }

}
