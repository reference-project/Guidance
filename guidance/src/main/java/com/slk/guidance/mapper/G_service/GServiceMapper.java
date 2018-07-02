package com.slk.guidance.mapper.G_service;

import com.slk.guidance.framework.MyMapper;
import com.slk.guidance.model.G_service.GService;

import java.util.List;

public interface GServiceMapper extends MyMapper<GService> {
    public List<GService> selectServiceAll();
}
