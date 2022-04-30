package com.cx.test;

import com.cx.test.bean.EnableImportSelector;
import com.cx.test.common.TestBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Import;

/**
 * @author chenxiang
 * @vesion 1.0
 * @Description 启动类
 * @createTime 2022-04-30 18:53:53
 */
@SpringBootApplication
//@Import(TestBean.class)
@EnableImportSelector
public class Application {
    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(Application.class, args);
        TestBean bean = run.getBean(TestBean.class);
        bean.printMessage("======================");
    }
}
