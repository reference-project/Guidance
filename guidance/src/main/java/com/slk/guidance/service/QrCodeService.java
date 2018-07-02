package com.slk.guidance.service;

import com.slk.guidance.framework.util.ZXingUtil;
import com.slk.guidance.mapper.G_qrcode.GQrcodeMapper;
import com.slk.guidance.model.G_qrcode.GQrcode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class QrCodeService {

    @Autowired
    GQrcodeMapper qrcodeMapper;



    /**
     * 获取所有二维码
     * Create by song on 2018-03-29 16:52:19
     */
    public List<GQrcode> getQrCodeListAll(){
        return qrcodeMapper.getQrCodeListAll();
    }


    /**
     * 添加或修改二维码根据fid
     * fid=null 添加
     * fid!-null修改
     * Create by song on 2018-03-29 16:53:30
     */
    public Integer setQrCode(GQrcode qrcode){
        Integer count = 0;
        //如果id=null，需先进行插入操作
        if (null == qrcode.getId()) count = qrcodeMapper.insertUseGeneratedKeys(qrcode);
        //参数采用加密处理机制，无参时注释
        //加密后的参数
        //String RID = JSSecretUtil.compileStr(qrcode.getRegion_id().toString());
        //String TID = JSSecretUtil.compileStr(qrcode.getguidancetype_id().toString());
        //String QID = JSSecretUtil.compileStr(qrcode.getId().toString());
        //+"?r="+RID+"&t="+TID+"&q="+QID
        qrcode.setUrl(ZXingUtil.generateZXing(qrcode.getPath()));
        count = qrcodeMapper.updateByPrimaryKeySelective(qrcode);
        return count;
    }


    /**
     * 获取二维码根据id
     * Create by song on 2018-03-29 16:54:54
     */
    public GQrcode getQrCodeById(Integer id){
        return qrcodeMapper.selectByPrimaryKey(id);
    }

    /**
     * 删除二维码根据id
     * Create by song on 2018-03-29 16:55:59
     */
    public Integer deleteQrCodeById(Integer id){
        return qrcodeMapper.deleteByPrimaryKey(id);
    }

}
