package com.slk.guidance.mapper.G_worker;

import com.slk.guidance.framework.MyMapper;
import com.slk.guidance.model.G_user.GUser;
import com.slk.guidance.model.G_worker.GWorker;

import java.util.List;

public interface GWorkerMapper extends MyMapper<GUser> {

    public List<GWorker> selectWorkerByWardId(Integer wardid);

}