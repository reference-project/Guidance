package com.slk.guidance.service;

import com.slk.guidance.mapper.G_worker.GWorkerMapper;
import com.slk.guidance.model.G_worker.GWorker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class G_workerServiceImpl {
    @Autowired
    private GWorkerMapper mapper;
    public List<GWorker> selectWorkerByWardId(Integer wardid){
        return mapper.selectWorkerByWardId(wardid);
    }
}
