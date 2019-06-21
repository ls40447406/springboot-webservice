package com.lishuo.springboot.controller;


import com.lishuo.springboot.base.Result;
import com.lishuo.springboot.pojo.UserEntity;
import com.lishuo.springboot.service.UserService;
import com.lishuo.springboot.utils.Results;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class TestController {

    @Autowired
    private UserService userService;

    private static  final Logger logger = LoggerFactory.getLogger(TestController.class);

    @RequestMapping(value = "/test/getUser", method = RequestMethod.POST, headers = "Accept=application/json")
    public void getPeopleDataById() {

    }

    @RequestMapping(value = "/test/save",method = RequestMethod.POST, headers = "Accept=application/json")
    public Result save(@RequestBody UserEntity user){
        user = userService.insertSelective(user);
        return Results.successWithData(user);
    }

    @RequestMapping(value = "/test/update",method = RequestMethod.POST, headers = "Accept=application/json")
    public Result update(@RequestBody UserEntity user){
        user = userService.update(user);
        return Results.successWithStatus(200,"更新成功");
    }


}
