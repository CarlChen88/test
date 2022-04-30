package com.cx.test.bean;

import com.cx.test.common.TestBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author chenxiang
 * @vesion 1.0
 * @Description @Configuration+@Bean的方式
 * @createTime 2022-04-30 19:40:40
 */
//@Configuration
public class ConfigurationDemo {

    //@Bean
    public TestBean testBean(){
        return new TestBean();
    }
}
