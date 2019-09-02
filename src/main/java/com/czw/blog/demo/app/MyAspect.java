package com.czw.blog.demo.app;

import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.aspectj.lang.annotation.Aspect;


@Component
@Aspect
public class MyAspect {

    @Pointcut("execution(* com.czw.blog.demo.dao.CommentMapper.insert())")
    private void  addone(){};


}
