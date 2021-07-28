package com.app.aspects;

import com.app.authorize.Authorization;
import com.app.authorize.NotAuthorizedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

public class SecurityAspect {
    private ApplicationContext applicationContext;

    public void checkAuthorize(){
        Authorization authorization = applicationContext.getBean("userAuthorized", Authorization.class);
        if (!authorization.getAuthorized()) {
            throw new NotAuthorizedException("User is not authorized!");
        }
    }

    @Autowired
    public void setApplicationContext(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }
}
