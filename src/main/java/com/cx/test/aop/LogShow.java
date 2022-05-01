package com.cx.test.aop;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author chenxiang
 * @vesion 1.0
 * @Description TODO
 * @createTime 2022-05-01 09:56:56
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface LogShow {
}
