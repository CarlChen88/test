package com.cx.test.common;

import lombok.Builder;
import lombok.Data;

/**
 * @author chenxiang
 * @vesion 1.0
 * @Description TODO
 * @createTime 2022-04-09 08:34:34
 */
@Data
@Builder
public class Student {
    private String code;
    private String name;
    private String sex;
    private Integer grade;
}
