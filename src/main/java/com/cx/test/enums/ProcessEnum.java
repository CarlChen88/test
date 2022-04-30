package com.cx.test.enums;

/**
 * @author chenxiang
 * @vesion 1.0
 * @Description TODO
 * @createTime 2022-04-09 09:25:25
 */
public enum ProcessEnum {

    INSTANCE;

    public String getsss(String ss){
        if("1".equals(ss)) return "sssss";
        if("2".equals(ss)) return "aaaaaa";
        return "ssfs";
    }

}
