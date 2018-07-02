package com.slk.guidance.service;

import com.slk.guidance.framework.SecretUtil;
import com.slk.guidance.mapper.G_user.GUserMapper;
import com.slk.guidance.model.G_user.GUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class G_userServiceImpl{

    @Autowired
    private GUserMapper mapper;


    public List<GUser> selectUserAll() {
        return mapper.selectUserAll();
    }


    public GUser selectUserById(Integer id) {
        return mapper.selectUserById(id);
    }


    public boolean insertUser(GUser gUser) {
        boolean flag=false;
        gUser.setPassword(new SecretUtil().encrypt(gUser.getPassword()));
         if(mapper.insertUser(gUser)>0){
             flag=true;
         }
         return flag;
    }


    public boolean deleteUserById(Integer id) {
        boolean flag=false;
        if(mapper.deleteUserById(id)>0){
            flag=true;
        }
        return flag;
    }


    public boolean updateUser(GUser gUser,String pass) {
        boolean flag=false;
        String password=selectUserById(gUser.getId()).getPassword();
        if((new SecretUtil().encrypt(pass)).equals(password)){
            gUser.setPassword(new SecretUtil().encrypt(gUser.getPassword()));
            if(mapper.updateUser(gUser)>0){
                flag=true;
            }
        }
        return flag;
    }


    public GUser login(GUser gUser){
        gUser.setPassword(new SecretUtil().encrypt(gUser.getPassword()));
        GUser getUser=mapper.selectUser(gUser);
        return getUser;
    }

}
