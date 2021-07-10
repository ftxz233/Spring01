package aop;

import org.springframework.stereotype.Component;

/**
 * @Author Rookie
 * @Date 2021/7/10
 */
@Component("target")
public class Target {
    public void targetMethod(){
        System.out.println("this is target method");
    }
}
