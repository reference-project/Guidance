package com.slk.guidance.controller;

import com.slk.guidance.service.G_PositionImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/phone/position")
public class H5Position {
    @Autowired
    private G_PositionImpl serviceImpl;
    @RequestMapping("/selectPositionAll")
    public Map selectPositionAll(){
        Map<String,Object> map=new HashMap<String,Object>();
        map.put("positionList",serviceImpl.selectPositionAll());
        map.put("flag",true);
        return map;
    }
}
