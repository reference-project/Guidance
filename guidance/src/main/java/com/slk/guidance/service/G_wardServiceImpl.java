package com.slk.guidance.service;

import com.slk.guidance.mapper.G_ward.GWardMapper;
import com.slk.guidance.model.G_ward.GWard;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class G_wardServiceImpl {
    @Autowired
    private GWardMapper mapper;
    public List<GWard> selectWardAll(){
       return mapper.selectWardAll();
    }
}
