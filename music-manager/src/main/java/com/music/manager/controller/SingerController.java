package com.music.manager.controller;


import com.music.common.result.BaseResult;
import com.music.manager.service.ISingerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/singer")
public class SingerController {
    @Autowired
    private ISingerService iSingerService;
    /**
     * 进入页面首先查询歌手List
     * */
    @RequestMapping("getSingerList")
    @ResponseBody
    public BaseResult getSingerList(Integer pageNum, Integer pageSize){
        return  iSingerService.getSingerList(pageNum,pageSize);
    }
    @RequestMapping("getSexSingerList")
    @ResponseBody
    public BaseResult getSexSingerList(String sex,Integer pageNum, Integer pageSize){
        return  iSingerService.getSexSingerList(sex,pageNum,pageSize);
    }
}
