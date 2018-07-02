package com.slk.guidance.model.G_qrcode;

import lombok.Data;

import javax.persistence.Id;
import java.util.Date;

@Data
public class GQrcode {
    @Id
    private Integer id;

    /*  */
    private String url;

    /* 备注 */
    private String remark;

    /* 访问路径 */
    private String path;

    /* 描述 */
    private String descr;

    /* 创建及更新时间 */
    private Date modify_date;

}