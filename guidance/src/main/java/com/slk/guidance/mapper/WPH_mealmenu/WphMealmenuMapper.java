package com.slk.guidance.mapper.WPH_mealmenu;

import com.slk.guidance.model.WPH_mealmenu.G_weekmeal;
import com.slk.guidance.model.WPH_mealmenu.WphMealmenu;
import com.slk.guidance.framework.MyMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface WphMealmenuMapper extends MyMapper<WphMealmenu> {

    public List<G_weekmeal> selectWeekMealMenus();

    public List<G_weekmeal> selectDayMealMenus(Integer typeFid);

    public List<WphMealmenu> selectMealByTypeId(Integer typeFid);

    public Integer selectFeedCountByTypeId(Integer typeid);

    public String selectNameBytypeId(Integer typeId);



}