package com.slk.guidance.controller;

import com.slk.guidance.service.G_nursinglevelServiceImpl;
import com.slk.guidance.service.G_wardServiceImpl;
import com.slk.guidance.service.G_workerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/phone/h5Nursing")
public class H5Controller {

    @Autowired
    private G_nursinglevelServiceImpl service;
    @Autowired
    private G_wardServiceImpl wardservice;

    @Autowired
    private G_workerServiceImpl workerservice;

    @RequestMapping("/selectNursingLevelByWardId/{wardid}")
    public Map selectNursingLevelByWardId(@PathVariable Integer wardid){
        Map<String,Object> map=new HashMap<String,Object>();
        map.put("nursingLevelList",service.selectNursingLevelByWardId(wardid));
        map.put("flag",true);
        return map;
    }

    @RequestMapping("/selectWardAll")
    public Map selectWardAll(){
        Map<String,Object> map=new HashMap<String,Object>();
        map.put("flag",true);
        map.put("wardList",wardservice.selectWardAll());
        return map;
    }

    @RequestMapping("selectWorkerByWardId/{wardid}")
    public Map selectWorkerByWardId(@PathVariable Integer wardid){
        Map<String,Object> map=new HashMap<String,Object>();
        map.put("flag",true);
        map.put("workerList",workerservice.selectWorkerByWardId(wardid));
        return map;
    }
}
