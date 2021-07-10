package aop;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @Author Rookie
 * @Date 2021/7/10
 */
@Component("myAspect")
@Aspect
public class MyAspect {
    @Before("pointcutRef()")
    public void before(){
        System.out.println("this is aspect before method");
    }
    @After("pointcutRef()")
    public void after(){
        System.out.println("this is aspect after method");
    }
    @Pointcut("execution(* aop.*.*(..))")
    public void pointcutRef(){}
}
