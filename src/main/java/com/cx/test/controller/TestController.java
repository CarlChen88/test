package com.cx.test.controller;

import com.cx.test.entity.ResultVO;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * @author chenxiang
 * @vesion 1.0
 * @Description TODO
 * @createTime 2022-09-25 08:59:59
 */
@RestController
@RequestMapping("/test")
public class TestController {


    @RequestMapping(value = "/testFeign",method = RequestMethod.GET)
    public ResultVO testFeign(@RequestParam("id") String id) throws Exception {
        //TimeUnit.SECONDS.sleep(3);
        if(true) throw new Exception();
        return ResultVO.success(id);
    }

}
