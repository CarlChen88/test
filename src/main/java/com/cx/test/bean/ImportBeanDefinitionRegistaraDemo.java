package com.cx.test.bean;

import com.cx.test.common.TestBean;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @author chenxiang
 * @vesion 1.0
 * @Description TODO
 * @createTime 2022-04-30 19:47:47
 */
public class ImportBeanDefinitionRegistaraDemo implements ImportBeanDefinitionRegistrar {
    @Override
    public void registerBeanDefinitions(AnnotationMetadata annotationMetadata, BeanDefinitionRegistry beanDefinitionRegistry) {
        BeanDefinition beanDefinition = new RootBeanDefinition(TestBean.class.getName());
        beanDefinitionRegistry.registerBeanDefinition(TestBean.class.getName(),beanDefinition);
    }
}
