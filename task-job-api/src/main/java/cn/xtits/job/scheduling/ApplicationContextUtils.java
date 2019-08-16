package cn.xtits.job.scheduling;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Configuration;

/**
 * @version 1.0
 * @author: Bo
 * @fileName: ApplicationContextUtils
 * @createDate: 2019-08-16 11:20.
 * @description:
 */
@Configuration
public class ApplicationContextUtils implements ApplicationContextAware {

    private static ApplicationContext APPLICATION_CONTEXT;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        APPLICATION_CONTEXT = applicationContext;
    }

    public static ApplicationContext getApplicationContext() {
        return APPLICATION_CONTEXT;
    }

    public static <T> T getBean(Class<T> cla) {
        return APPLICATION_CONTEXT.getBean(cla);
    }
}
