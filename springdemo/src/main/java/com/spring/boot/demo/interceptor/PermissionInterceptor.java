package com.spring.boot.demo.interceptor;

import com.spring.boot.demo.entity.LoginUser;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author : Hens
 * @date : 2019/9/19 20:20
 */
@Component
public class PermissionInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        LoginUser user = (LoginUser) request.getSession().getAttribute("user");
        System.out.println("这是拦截器");
        System.out.println(user);
        if(user == null){
            return false;
        }
        return true;
    }
}
