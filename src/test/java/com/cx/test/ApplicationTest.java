package com.cx.test;

import com.cx.test.aop.ProductService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author chenxiang
 * @vesion 1.0
 * @Description TODO
 * @createTime 2022-05-01 11:07:07
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class ApplicationTest {
    @Autowired
    private ProductService productService;

    @Test
    public void test(){
        productService.insert();
    }
}
