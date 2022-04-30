package com.cx.test.bean;

import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * @author chenxiang
 * @vesion 1.0
 * @Description TODO
 * @createTime 2022-04-30 19:44:44
 */
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Target(ElementType.TYPE)
@Import({ImportBeanDefinitionRegistaraDemo.class})
public @interface EnableImportSelector {
}
