package com.slk.guidance.model.G_nursinglevel;

import lombok.Data;

import javax.persistence.Id;
import java.util.Date;

@Data
public class GNursinglevel {
    @Id
    private Integer id;

    /* 病区id */
    private Integer wardid;

    /* 病区id */
    private String wardname;

    /* 护理等级 */
    private String nursingname;

    /* 工作 */
    private String workinfo;

    /* 服务意识 */
    private String serviceinfo;

    /* 价格 */
    private Double price;

    /*  */
    private Date createdate;

    /*  */
    private String createuser;

}