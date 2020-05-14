package com.music.manager.controller;


import com.music.common.result.BaseResult;
import com.music.manager.service.ISingerService;
import com.music.manager.vo.SingerQuery;
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

    /**
     * 获取华语男女歌手
     * @param sex
     * @param pageNum
     * @param pageSize
     * @return
     */
    @RequestMapping("getSexSingerList")
    @ResponseBody
    public BaseResult getSexSingerList(String sex,Integer pageNum, Integer pageSize){
        return  iSingerService.getSexSingerList(sex,pageNum,pageSize);
    }

    @RequestMapping("getTypeSingerList")
    @ResponseBody
    public BaseResult getTypeSingerList(SingerQuery singerQuery){
        return iSingerService.getTypeSingerList(singerQuery);
    }

    @RequestMapping("getGroupSingerList")
    @ResponseBody
    public BaseResult getGroupSingerList(SingerQuery singerQuery){
        return iSingerService.getGroupSingerList(singerQuery);
    }
}
