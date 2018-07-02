package com.slk.guidance.controller;

import com.slk.guidance.service.G_SServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/phone/service")
public class H5ServiceController {
    @Autowired
    private G_SServiceImpl impl;

    @RequestMapping("/selectServiceById/{id}")
    public Map selectServiceById(@PathVariable Integer id){
        Map<String,Object> map=new HashMap<String,Object>();
        map.put("gService",impl.selectServiceById(id));
        return map;
    }
}
