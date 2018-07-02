package com.slk.guidance.service;

import com.slk.guidance.mapper.G_nursinglevel.GNursinglevelMapper;
import com.slk.guidance.model.G_nursinglevel.GNursinglevel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class G_nursinglevelServiceImpl {
    @Autowired
    private GNursinglevelMapper mapper;

    public List<GNursinglevel> selectNursingLevelAll(){
        return mapper.selectNursingLevelAll();
    }

    public List<GNursinglevel> selectNursingLevelByWardId(Integer wardid){
        return mapper.selectNursingLevelByWardId(wardid);
    }

    public boolean updateNursingLevel(GNursinglevel nursingLevel){
        boolean flag=false;
        if(mapper.updateNursingLevel(nursingLevel)>0){
            flag=true;
        }
        return flag;
    }

    public boolean insertNursingLevel(GNursinglevel nursingLevel){
        boolean flag=false;
        if(mapper.insertNursingLevel(nursingLevel)>0){
            flag=true;
        }
        return flag;
    }

    public boolean deleteNursingLevel(Integer id){
        boolean flag=false;
        if(mapper.deleteNursingLevel(id)>0){
            flag=true;
        }
        return flag;
    }
}