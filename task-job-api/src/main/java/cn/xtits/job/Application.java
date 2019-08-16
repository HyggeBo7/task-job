package cn.xtits.job;

import cn.xtits.xtf.web.springmvc.ExceptionHandlerResolver;
import cn.xtits.xtf.web.springmvc.JsonMessageConverter;
import cn.xtits.xtf.web.springmvc.RequestContextInterceptor;
import cn.xtits.xtf.web.springmvc.RequestLogInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import javax.servlet.MultipartConfigElement;
import java.util.List;

@EnableScheduling
@SpringBootApplication
@Configuration
@EnableTransactionManagement
@MapperScan(basePackages = "cn.xtits.job.mapper")
public class Application extends WebMvcConfigurerAdapter {


    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    /**
     * 配置拦截器
     *
     * @param registry
     * @author lance
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new RequestContextInterceptor()).addPathPatterns("/**");
        registry.addInterceptor(new RequestLogInterceptor()).addPathPatterns("/**");

    }

    @Override
    public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
        configurer.favorPathExtension(false);
    }

    @Override
    public void configureHandlerExceptionResolvers(List<HandlerExceptionResolver> exceptionResolvers) {
        exceptionResolvers.add(new ExceptionHandlerResolver());
    }

    @Override
    public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
        converters.clear();
        converters.add(new JsonMessageConverter());
    }

    /**
     * 文件上传配置
     */
    @Bean
    public MultipartConfigElement multipartConfigElement() {
        MultipartConfigFactory factory = new MultipartConfigFactory();
        //单个文件最大 KB,MB
        factory.setMaxFileSize("10MB");
        /// 设置总上传数据总大小
        factory.setMaxRequestSize("100MB");
        return factory.createMultipartConfig();
    }

    /**
     * ThreadPoolTaskScheduler：线程池任务调度类，能够开启线程池进行任务调度。
     * ThreadPoolTaskScheduler.schedule()方法会创建一个定时计划ScheduledFuture，在这个方法需要添加两个参数，Runnable（线程接口类） 和CronTrigger（定时任务触发器）
     */
    @Bean
    public ThreadPoolTaskScheduler threadPoolTaskScheduler() {
        ThreadPoolTaskScheduler executor = new ThreadPoolTaskScheduler();
        executor.setThreadNamePrefix("TaskExecutor-");
        //定时任务执行线程池核心线程数 Runtime.getRuntime().availableProcessors() 可执行线程
        //executor.setPoolSize(Runtime.getRuntime().availableProcessors());
        executor.setPoolSize(20);
        //等待任务完成后关闭
        executor.setWaitForTasksToCompleteOnShutdown(true);
        //最多等待 60s
        executor.setAwaitTerminationSeconds(60);
        executor.setRemoveOnCancelPolicy(true);
        executor.initialize();
        return executor;
    }
}
