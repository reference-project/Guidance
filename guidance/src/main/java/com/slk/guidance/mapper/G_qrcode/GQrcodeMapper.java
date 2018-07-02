package com.slk.guidance.mapper.G_qrcode;

import com.slk.guidance.framework.MyMapper;
import com.slk.guidance.model.G_qrcode.GQrcode;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface GQrcodeMapper extends MyMapper<GQrcode> {

    public List<GQrcode> getQrCodeListAll();

}