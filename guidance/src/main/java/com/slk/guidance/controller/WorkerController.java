package com.slk.guidance.controller;

import com.slk.guidance.service.G_workerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/worker")
public class WorkerController {

    @Autowired
    private G_workerServiceImpl service;

    @RequestMapping("selectWorkerByWardId/{wardid}")
    public Map selectWorkerByWardId(@PathVariable Integer wardid){
        Map<String,Object> map=new HashMap<String,Object>();
        map.put("flag",true);
        map.put("workerList",service.selectWorkerByWardId(wardid));
        return map;
    }
}
