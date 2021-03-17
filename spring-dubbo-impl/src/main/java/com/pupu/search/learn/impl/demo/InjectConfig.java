package com.pupu.search.learn.impl.demo;

import com.pupu.search.learn.impl.demo.InjectBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InjectConfig {

    @Bean(name = "ddd")
    public InjectBean myBean1() {
        InjectBean injectBean = new InjectBean();
        injectBean.setId("1");
        return injectBean;
    }

    @Bean
    public InjectBean myBean2() {
        InjectBean injectBean = new InjectBean();
        injectBean.setId("2");
        return injectBean;
    }
}