package com.slk.guidance.mapper.G_ward;

import com.slk.guidance.framework.MyMapper;
import com.slk.guidance.model.G_user.GUser;
import com.slk.guidance.model.G_ward.GWard;

import java.util.List;

public interface GWardMapper extends MyMapper<GUser> {

    public List<GWard> selectWardAll();

}