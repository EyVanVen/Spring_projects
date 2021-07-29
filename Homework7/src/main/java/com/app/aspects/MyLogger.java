package com.app.aspects;

import com.app.authorize.Authorization;
import org.aspectj.lang.JoinPoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.ApplicationContext;

import static java.lang.System.out;

public class MyLogger {

    private ApplicationContext applicationContext;

    public void beforeMethodInvocation(JoinPoint joinPoint) {
        Authorization authorization = applicationContext.getBean("userAuthorized", Authorization.class);
        out.println("======================================================================");
        out.println("Authorized : " + authorization.getAuthorized());
        out.println("Log : before method " + joinPoint.getSignature().toShortString() + ".");
        out.println("----------------------------------------------------------------------");
    }

    public void afterMethodInvocation(JoinPoint joinPoint) {
        out.println("======================================================================");
        out.println("Log : " + joinPoint.getSignature().getName() + " method was invoked!");
        out.println("----------------------------------------------------------------------");
    }

    @Cacheable("listCache")
    public void afterThrowing(Exception ex) {
        out.println("*********** Log : error ***********");
        out.println("Exception : " + ex.getMessage());
        out.println("***********************************");
    }


    @Autowired
    public void setApplicationContext(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }
}
