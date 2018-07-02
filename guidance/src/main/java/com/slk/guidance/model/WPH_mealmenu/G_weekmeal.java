package com.slk.guidance.model.WPH_mealmenu;

import lombok.Data;

import java.util.List;

@Data
public class G_weekmeal {

    /* 星期 */
    private String weekname;

    /* 早午晚 餐 */
    private String mealtimename;

    /* 菜单名称 */
    private String menuname;

    /* 菜单名称 */
    private Integer type;

    /* 图片 */
    private String imgs;

    /* 描述 */
    private String depict;

    private Double money;

    private List<G_weekmeal> meal;
}
