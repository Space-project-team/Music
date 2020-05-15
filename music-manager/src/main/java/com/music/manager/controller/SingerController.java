package com.music.manager.controller;


import com.music.common.result.BaseResult;
import com.music.manager.pojo.Singer;
import com.music.manager.service.ISingerService;
import com.music.manager.vo.SingerQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/singer")
public class SingerController {
    @Autowired
    private ISingerService iSingerService;


    /**
     * 进入页面首先查询歌手List
     * */
    @RequestMapping(value = "getSingerList",method = RequestMethod.POST)
    @ResponseBody
    public BaseResult getSingerList(SingerQuery singerQuery){
        return  iSingerService.getSingerList(singerQuery);
    }

    /**
     * 获取华语男女歌手
     * @param singerQuery
     * @return
     */
    @RequestMapping(value = "getSexSingerList",method = RequestMethod.POST)
    @ResponseBody
    public BaseResult getSexSingerList(SingerQuery singerQuery){
        return  iSingerService.getSexSingerList(singerQuery);
    }

    /**
     * 获取风格歌手
     * @param singerQuery
     * @return
     */
    @RequestMapping(value = "getTypeSingerList",method = RequestMethod.POST)
    @ResponseBody
    public BaseResult getTypeSingerList(SingerQuery singerQuery){
        return iSingerService.getTypeSingerList(singerQuery);
    }

    /**
     * 获取风格组合
     * @param singerQuery
     * @return
     */
    @RequestMapping(value = "getGroupSingerList",method = RequestMethod.POST)
    @ResponseBody
    public BaseResult getGroupSingerList(SingerQuery singerQuery){
        return iSingerService.getGroupSingerList(singerQuery);
    }
}
