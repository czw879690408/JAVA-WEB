package com.czw.music.aspect;


        import org.aspectj.lang.JoinPoint;
        import org.aspectj.lang.annotation.*;
        import org.springframework.stereotype.Component;

@Component
@Aspect
public class MyAspect {


    @Pointcut("execution(* com.czw.music.dao..*.*(..))")
    public void anOldTranfer(){ }

    @Before("anOldTranfer()")
    public void adviceB(JoinPoint joinPoint){
        System.out.println("------------------");
        System.out.println(joinPoint.getThis().getClass());
        System.out.println("DAO调用");
    }

    @After("anOldTranfer()")
    public void adviceA(){
        System.out.println("------------------");
    }

    @AfterReturning("anOldTranfer()")
    public void aVoidA(){
        System.out.println("调用成功");
    }


    @AfterThrowing("anOldTranfer()")
    public void aVoidB(){
        System.out.println("调用失败");
    }
}
