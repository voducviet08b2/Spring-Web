package com.codegym.democreatespringboot;

import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class Logger {
    public void error() {
        System.out.println("[CMS] ERROR!");
    }

    @AfterThrowing(pointcut = "execution(public * com.codegym.democreatespringboot.service.CustomerService.findAll(..))")
    public void log() {

    }
}
