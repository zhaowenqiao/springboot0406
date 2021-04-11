package com.zwq.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static jdk.nashorn.internal.runtime.regexp.joni.Config.log;

@RestController
@RequestMapping("hello")
public class MyController {

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    @GetMapping("test")
    public String test(){
        System.out.println("213212222222");
        redisTemplate.opsForValue().set("food","food11");
        String food = (String)redisTemplate.opsForValue().get("food");
        System.out.println(food);
//        System.out.println("hellot  World");
//
//        System.out.println("你好");
//        System.out.println("你好branch");
//
//		System.out.println("你好master修改");
//        System.out.println("你好branch update再一次");
        return "hello world!!!";

    }
}
