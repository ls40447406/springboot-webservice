package com.lishuo.springboot.controller;


import com.lishuo.springboot.base.Result;
import com.lishuo.springboot.exception.ServiceException;
import com.lishuo.springboot.pojo.UserEntity;
import com.lishuo.springboot.service.UserService;
import com.lishuo.springboot.utils.Results;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;


@RestController
public class TestController {

    @Autowired
    private UserService userService;

    //@Autowired
    //private StringRedisTemplate redisTemplate;

    @Autowired
    private RedisTemplate<Object,Object> redisTemplate;


    private static  final Logger logger = LoggerFactory.getLogger(TestController.class);

    @RequestMapping(value = "/test/getUser", method = RequestMethod.POST, headers = "Accept=application/json")
    public void getPeopleDataById() {

    }

    @RequestMapping(value = "/test/save",method = RequestMethod.POST, headers = "Accept=application/json")
    public void save(@RequestBody UserEntity user){
        try {
            redisTemplate.opsForValue().set("abc",user);
            redisTemplate.opsForList().rightPush("cbd",user);
            UserEntity abc = (UserEntity)redisTemplate.opsForValue().get("abc");
            System.out.print(abc.toString());
        } catch (Exception e) {
            throw new ServiceException("system_error","服务异常");
        }
    }

    @RequestMapping(value = "/test/update",method = RequestMethod.POST, headers = "Accept=application/json")
    public Result update(@RequestBody UserEntity user){
        user = userService.update(user);
        return Results.successWithStatus(200,"更新成功");
    }


}
