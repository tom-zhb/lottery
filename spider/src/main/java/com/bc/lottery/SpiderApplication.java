package com.bc.lottery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@EnableAsync
@EnableScheduling
@SpringBootApplication
@ComponentScan(basePackages = {"com.bc.lottery.*"})
public class SpiderApplication extends WebMvcConfigurerAdapter {
    /*@Bean
    public HandlerInterceptor getTokenInterceptor(){
        return new TokenInterceptor();
    }
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(getTokenInterceptor()).addPathPatterns("/online-scalper/*").excludePathPatterns("/job/**");

        registry.addInterceptor(getTokenInterceptor()).addPathPatterns("/online-scalper/*");
    }*/
    public static void main(String[] args) {
        SpringApplication.run(SpiderApplication.class, args);
    }
}
