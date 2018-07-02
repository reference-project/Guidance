package com.slk.guidance.mapper.G_user;

import com.slk.guidance.framework.MyMapper;
import com.slk.guidance.model.G_user.GUser;

import java.util.List;

public interface GUserMapper extends MyMapper<GUser> {

    public List<GUser> selectUserAll();

    public GUser selectUserById(Integer id);

    public int deleteUserById(Integer id);

    public int updateUser(GUser gUser);

    public int insertUser(GUser gUser);

    public GUser selectUser(GUser gUser);
}