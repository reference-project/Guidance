package com.slk.guidance.controller;

import com.slk.guidance.model.G_user.GUser;
import com.slk.guidance.service.G_userServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class GUserController {
    @Autowired
    private G_userServiceImpl userService;

    /**
     * 用户登录
     * @return
     */
    @RequestMapping("/login")
    public Map login(GUser gUser, HttpSession session){
        boolean flag=false;
        Map<String,Object> map=new HashMap<String,Object>();
        GUser getUser=userService.login(gUser);
        if(getUser!=null){
            flag=true;
            //此处需要处理session
            session.setAttribute("userid",getUser.getId());
            session.setMaxInactiveInterval(60*60*24);
        }
        map.put("flag",flag);
        return map;
    }

    /**
     * 获取全部用户
     * @return
     */
    @RequestMapping("/selectUserAll")
    public Map selectUserAll(){
        Map<String,Object> map=new HashMap<String,Object>();
        map.put("flag",true);
        map.put("userList",userService.selectUserAll());
        return map;
    }

    /**
     * 新增用户
     * @return
     */
    @RequestMapping("/addUser")
    public Map addUser(GUser gUser){
        Map<String,Object> map=new HashMap<String,Object>();
        map.put("flag",userService.insertUser(gUser));
        return map;
    }

    /**
     * 修改用户
     * @return
     */
    @RequestMapping("/updateUser")
    public Map updateUser(GUser gUser,String oldPassword){
        Map<String,Object> map=new HashMap<String,Object>();
        map.put("flag",userService.updateUser(gUser,oldPassword));
        return map;
    }

    /**
     * 删除用户
     * @return
     */
    @RequestMapping("/deleteUserById/{id}")
    public Map updateUser(@PathVariable Integer id){
        Map<String,Object> map=new HashMap<String,Object>();
        map.put("flag",userService.deleteUserById(id));
        return map;
    }


    /**
     * 查询用户 by id
     * @return
     */
    @RequestMapping("/selectUserById")
    public Map selectUserById(Integer id){
        Map<String,Object> map=new HashMap<String,Object>();
        map.put("user",userService.selectUserById(id));
        map.put("flag",true);
        return map;
    }

    /**
     * 退出登录
     * @return
     */
    @RequestMapping("/outLogin")
    public Map outLogin(HttpSession session){
        session.setAttribute("userid", "");
        session.removeAttribute("userid");
        Map<String,Object> map=new HashMap<String,Object>();
        map.put("flag",true);
        return map;
    }
}
