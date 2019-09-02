package com.czw.blog.demo.compnent;

import com.czw.blog.demo.model.User;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LgoinInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws IOException {
        User user = (User)request.getSession().getAttribute("user");
        if(user != null){
            return true;
        }
        else {
            //失败返回登陆页面
            response.sendRedirect("/");
            return false;
        }

    }
}
