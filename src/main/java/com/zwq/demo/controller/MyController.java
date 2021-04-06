package com.zwq.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static jdk.nashorn.internal.runtime.regexp.joni.Config.log;

@RestController
@RequestMapping("hello")
public class MyController {

    @GetMapping("test")
    public String test(){
        System.out.println("213212222222");
        System.out.println("hellot  World");

        System.out.println("你好");
        System.out.println("你好branch");
		System.out.println("你好master修改");
        return "hello world!!!";

    }
}
