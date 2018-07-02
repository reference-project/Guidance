package com.slk.guidance.service;
import com.slk.guidance.mapper.WPH_mealmenu.WphMealmenuMapper;
import com.slk.guidance.model.WPH_mealmenu.G_weekmeal;
import com.slk.guidance.model.WPH_mealmenu.WphMealmenu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class MealmenuService {

	@Autowired
	private WphMealmenuMapper wphmealmenumapper;


	public List<G_weekmeal> selectWeekMealMenus(){
		return wphmealmenumapper.selectWeekMealMenus();
	}

	public List<G_weekmeal> selectDayMealMenus(Integer typeId){
		return wphmealmenumapper.selectDayMealMenus(typeId);
	}

	public  Integer selectFeedCountByTypeId(Integer typeId){
		return wphmealmenumapper.selectFeedCountByTypeId(typeId);
	}

	public List<WphMealmenu> selectMealByTypeId(Integer typeId){
		return wphmealmenumapper.selectMealByTypeId(typeId);
	}

	public String selectNameBytypeId(Integer typeId){
		return wphmealmenumapper.selectNameBytypeId(typeId);
	}

}