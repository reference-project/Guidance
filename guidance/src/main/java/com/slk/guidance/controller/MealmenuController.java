package com.slk.guidance.controller;

import com.slk.guidance.model.WPH_mealmenu.G_weekmeal;
import com.slk.guidance.model.WPH_mealmenu.WphMealmenu;
import com.slk.guidance.service.MealmenuService;
import com.sun.org.apache.xpath.internal.operations.Bool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/mealmenu")
public class MealmenuController {


    @Autowired
    private MealmenuService service;

    
    
    /**
     *
     * 获取一周餐品信息
     * Create by song-xl on 2018-05-08 04:36:17
     */
    @RequestMapping("/selectMealMenuList")
    public Map selectMealMenuList(){
        Boolean flag = true;
        Map<String,Object> map = new HashMap<String, Object>();
        List<G_weekmeal> mealMenus = service.selectWeekMealMenus();
        if (mealMenus.size()==0){
            flag = false;
            map.put("message","没有餐品信息");
        }else{
            map.put("mealMenus",mealMenus);
        }
        map.put("flag",flag);
        return map;
    }


    /**
     *
     * 获取今天，明天餐品信息根据类型
     * Create by song-xl on 2018-05-08 04:36:17
     */
    @RequestMapping("/selectMenusById/{typeId}")
    public Map selectMenusById(@PathVariable Integer typeId){
        Boolean flag = true;
        Map<String,Object> map = new HashMap<String, Object>();
        List<G_weekmeal> mealMenus = service.selectDayMealMenus(typeId);
        String name = service.selectNameBytypeId(typeId);
        if (mealMenus.size()==0){
            flag = false;
            map.put("message","没有餐品信息");
        }else{
            map.put("mealMenus",mealMenus);
            map.put("titleName",name);
        }
        map.put("flag",flag);
        return map;
    }
    

    /**
     *
     * 获取餐类数量，根据类型ID
     * Create by song-xl on 2018-05-26 03:28:42
     */
    @RequestMapping("/selectFeedCountByTypeId/{typeId}")
    public Map selectFeedCountByTypeId(@PathVariable Integer typeId){
        Boolean flag = false;
        Map<String,Object> map = new HashMap<String, Object>();
        Integer count = service.selectFeedCountByTypeId(typeId);
        if(count>0) flag=true;
        map.put("flag",flag);
        return map;
    }


    
    /**
     *
     * 获取餐类集合根据typeId
     * Create by song-xl on 2018-05-09 01:44:27
     */
    @RequestMapping("/selectMealByTypeId/{typeId}")
    public Map selectMealByTypeId(@PathVariable Integer typeId){
        Boolean flag = true;
        Map<String,Object> map = new HashMap<String, Object>();
        List<WphMealmenu> mealMenus = service.selectMealByTypeId(typeId);
        if(null==mealMenus){
            map.put("message","没有餐品信息");
        }else{
            map.put("mealMenus",mealMenus);
        }
        map.put("flag",flag);
        return map;

    }

}
