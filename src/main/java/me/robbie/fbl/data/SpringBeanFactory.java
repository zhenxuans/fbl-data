package me.robbie.fbl.data;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public final class SpringBeanFactory implements ApplicationContextAware {

    private static ApplicationContext context;

    public SpringBeanFactory() {
    }



    public static ApplicationContext getApplicationContext() {
        return context;
    }



    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        context = applicationContext;
    }

}
