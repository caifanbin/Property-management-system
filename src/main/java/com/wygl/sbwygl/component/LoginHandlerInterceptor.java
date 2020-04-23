package com.wygl.sbwygl.component;


import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 登录检查
 */
public class LoginHandlerInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Object loginUser = request.getSession().getAttribute("loginUser");
        if(loginUser==null){
            request.setAttribute("message","您还没有登录！");
            request.getRequestDispatcher("/").forward(request,response);
            return false;
        }
        return true;
    }
}
