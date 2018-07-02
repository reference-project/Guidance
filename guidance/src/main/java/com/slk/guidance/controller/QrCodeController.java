package com.slk.guidance.controller;

import com.slk.guidance.model.G_qrcode.GQrcode;
import com.slk.guidance.service.QrCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 二维码管理
 * Create by song on 2018-03-30 10:58:39
 */
@RestController
@RequestMapping("/qrCode")
public class QrCodeController {

    @Autowired
    private QrCodeService service;

    /**
     * 获取所有二维码
     * Create by song on 2018-03-29 16:52:19
     */
    @RequestMapping("/getQrCodeListAll")
    public Map getQrCodeListAll(){
        Boolean flag = true;
        Map<String,Object> map = new HashMap<>();
        List<GQrcode> qrList = service.getQrCodeListAll();
        if (0 == qrList.size()) {
            flag = false;
            map.put("message","获取不到信息！");
        }else{
            map.put("qrList",qrList);
        }
        map.put("flag",flag);
        return map;
    }



    /**
     * 添加或修改二维码根据fid
     * fid=null 添加
     * fid!-null修改
     * Create by song on 2018-03-29 16:53:30
     */
    @RequestMapping("/setQrCode")
    public Map setQrCode(GQrcode qrcode){
        Boolean flag = true;
        String message = "操作成功！";
        Map<String,Object> map = new HashMap<>();
        if (0==service.setQrCode(qrcode)) {
            flag = false;
            message = "操作失败！";
        }
        map.put("flag",flag);
        map.put("message",message);
        return map;
    }

    
    /**
     * 获取二维码根据id
     * Create by song on 2018-03-29 16:54:54
     */
    @RequestMapping("/getQrCodeById/{id}")
    public Map getQrCodeById(@PathVariable Integer id){
        Boolean flag = true;
        Map<String,Object> map = new HashMap<>();
        GQrcode qrcode = service.getQrCodeById(id);
        if (null == qrcode) {
            flag = false;
            map.put("message","获取信息失败！");
        }else{
            map.put("qrcode",qrcode);
        }
        map.put("flag",flag);
        return map;
    }

    
    /**
     * 删除二维码根据id
     * Create by song on 2018-03-29 16:55:59
     */
    @RequestMapping("/deleteQrCodeById/{id}")
    public Map deleteQrCodeById(@PathVariable Integer id){
        Boolean flag = true;
        String message = "操作成功！";
        Map<String,Object> map = new HashMap<>();
        if (0==service.deleteQrCodeById(id)) {
            flag = false;
            message = "操作失败！";
        }
        map.put("flag",flag);
        map.put("message",message);
        return map;
    }

}
