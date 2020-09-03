package com.example.demo.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Arrays;

@Aspect
@Component
public class AspectLog {
    private int count=0;
    @AfterReturning("execution(* com.example.demo.controller.BookController.showBook(..))")
    public void beforeCallMethod(JoinPoint joinPoint) {
        count++;
        System.out.println("Số người đã vào trang: "+count);
        //System.out.println("Bắt đầu method: " + joinPoint.getSignature().getName());
    }


//    @AfterThrowing(value = "execution(* com.codegym.demoaop.Hello.*())", throwing = "e")
//    public void AfterThrowingCallMethod(JoinPoint joinPoint, Exception e) throws Throwable{
//        String className = joinPoint.getTarget().getClass().getSimpleName();
//        String method = joinPoint.getSignature().getName();
//        String args = Arrays.toString(joinPoint.getArgs());
//        System.out.println(String.format("[Hệ Thống] co loi xay ra: %s.%s%s: %s", className, method, args, e.getMessage()));
//    }




}
