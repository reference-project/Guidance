package com.slk.guidance.framework;


import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class InterceptorCommon extends HandlerInterceptorAdapter {
    @Override
    public boolean preHandle(HttpServletRequest request ,HttpServletResponse response, Object object) throws Exception {
        Object obj = request.getSession().getAttribute("userid");
        String requestUrl = request.getRequestURL().toString();
        boolean flag=false;
        if(requestUrl.contains("login")||requestUrl.contains("phone")||requestUrl.contains("mealmenu")){
            flag=true;
        }else{
            if (obj != null) {
                flag= true;
            }
        }
        if(!flag){
            response.setStatus(222);
        }
        return flag;
    }
}
