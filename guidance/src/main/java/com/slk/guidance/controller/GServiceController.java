package com.slk.guidance.controller;

import com.slk.guidance.model.G_service.GService;
import com.slk.guidance.model.G_service.GServiceCustom;
import com.slk.guidance.service.G_SServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/service")
public class GServiceController {
    @Autowired
    private G_SServiceImpl impl;

    @RequestMapping("/selectServiceAll")
    public Map selectServiceAll(){
        Map<String,Object> map=new HashMap<String,Object>();
        map.put("serviceList",impl.selectServiceAll());
        map.put("flag",true);
        return map;
    }

    @RequestMapping("/updateService")
    public Map updateService(GServiceCustom gServiceCustom){
        Map<String,Object> map=new HashMap<String,Object>();
        map.put("flag",impl.updateService(gServiceCustom));
        return map;
    }
}
