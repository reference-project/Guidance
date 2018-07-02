package com.slk.guidance.service;

import com.slk.guidance.mapper.G_position.GPositionMapper;
import com.slk.guidance.model.G_position.GPosition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class G_PositionImpl {

    @Autowired
    private GPositionMapper mapper;
    public List<GPosition> selectPositionAll(){
        return mapper.selectAll();
    }
}
