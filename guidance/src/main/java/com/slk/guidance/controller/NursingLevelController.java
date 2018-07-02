package com.slk.guidance.controller;

import com.slk.guidance.model.G_nursinglevel.GNursinglevel;
import com.slk.guidance.service.G_nursinglevelServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/nursingLevel")
public class NursingLevelController {

    @Autowired
    private G_nursinglevelServiceImpl service;

    @RequestMapping("/selectNursingLevelAll")
    public Map selectNursingLevelAll(){
        Map<String,Object> map=new HashMap<String,Object>();
        map.put("nursingLevelList",service.selectNursingLevelAll());
        map.put("flag",true);
        return map;
    }
    @RequestMapping("/selectNursingLevelByWardId/{wardid}")
    public Map selectNursingLevelByWardId(@PathVariable Integer wardid){
        Map<String,Object> map=new HashMap<String,Object>();
        map.put("nursingLevelList",service.selectNursingLevelByWardId(wardid));
        map.put("flag",true);
        return map;
    }


    @RequestMapping("/ModifyToNursingLevel")
    public Map ModifyToNursingLevel(GNursinglevel nursingLevel){
        boolean flag=false;
        Map<String,Object> map=new HashMap<String,Object>();
        if(nursingLevel.getId()!=null&&!"".equals(nursingLevel.getId())){
            flag=service.updateNursingLevel(nursingLevel);
        }else{
            flag=service.insertNursingLevel(nursingLevel);
        }
        map.put("flag",flag);
        return map;
    }


    @RequestMapping("/deleteNursingLevel/{nursingLevelId}")
    public Map deleteNursingLevel(@PathVariable Integer nursingLevelId){
        Map<String,Object> map=new HashMap<String,Object>();
        map.put("flag",service.deleteNursingLevel(nursingLevelId));
        return map;
    }
}
