package com.slk.guidance.model.WPH_mealmenu;

import lombok.Data;
import java.util.Date;
import javax.persistence.Id;

@Data
public class WphMealmenu{
    @Id
    private Integer fid;

    /* 餐品种类 */
    private Integer wph_mealtype_fid;

    /* 名称 */
    private String name;

    /* 菜品状态(0-默认上架 1-下架) */
    private Integer status;

    /* 菜品种类(0-默认 1-炒菜 2-面食 3粥类) */
    private Integer type;

    /* 图片 */
    private String imgs;

    /* 金额 */
    private Double money;

    /* 描述 */
    private String depict;

    /* 计量 */
    private Integer meterage;

    /* 创建时间 */
    private Date createdate;

    /*  */
    private String uuid;

    /* 菜品最大数量限制 */
    private Integer maxnum;

    /* 当前已订购份数 */
    private Integer nownum;

}