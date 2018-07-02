package com.slk.guidance.controller;

import com.slk.guidance.service.G_wardServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/ward")
public class WardController {
    @Autowired
    private G_wardServiceImpl service;

    @RequestMapping("/selectWardAll")
    public Map selectWardAll(){
        Map<String,Object> map=new HashMap<String,Object>();
        map.put("flag",true);
        map.put("wardList",service.selectWardAll());
        return map;
    }
}
