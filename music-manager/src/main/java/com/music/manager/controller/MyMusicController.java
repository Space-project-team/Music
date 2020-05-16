package com.music.manager.controller;

import com.music.common.result.BaseResult;
import com.music.manager.pojo.User;
import com.music.manager.service.IMyMusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;


/**
 * 
 * @author linliquan
 * @date 2018年12月23日 00:03:48
 */

@Controller
@RequestMapping("/myMusic")
public class MyMusicController {

    @Autowired
    private IMyMusicService iMyMusicService;
    /**
     * 根据用户id查询自己的歌曲信息--分页
     * @param userName
     * @return
     */
    @RequestMapping("getMyMusicList")
    @ResponseBody
    public BaseResult getMyMusicList(String userName, Integer pageNum, Integer pageSize, HttpServletRequest request){
        User user = (User) request.getSession().getAttribute("user");
        if(StringUtils.isEmpty(user)){
            request.setAttribute("MyMusicCount",iMyMusicService.getCount(user.getUserId()));
        }
        return iMyMusicService.getMyMusicList(userName,pageNum,pageSize);
    }


    /**
     * 根据用户id 和 歌曲删除
     * @param mid
     * @param userName
     * @return
     */
    @RequestMapping("deleteMyMusic")
    @ResponseBody
    public BaseResult deleteMyMusic(Integer mid,String userName){
        int result=iMyMusicService.deleteMyMusic(mid,userName);
        System.out.println(result);
        if(result>0){
            return BaseResult.success();
        }
        return BaseResult.error();
    }


}
