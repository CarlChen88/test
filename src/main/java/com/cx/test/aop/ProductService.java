package com.cx.test.aop;

import org.springframework.stereotype.Service;

/**
 * @author chenxiang
 * @vesion 1.0
 * @Description TODO
 * @createTime 2022-05-01 09:55:55
 */
@Service
public class ProductService {

    @LogShow
    public String insert(){
        System.out.println("insert====================");
        return "success";
    }

    @LogShow
    public void update(){
        System.out.println("update====================");
    }
}
