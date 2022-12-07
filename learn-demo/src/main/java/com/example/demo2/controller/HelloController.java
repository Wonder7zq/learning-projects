package com.example.demo2.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Wonder7zq
 * @date 2019/10/10 - 15:25
 */
@RestController
public class HelloController {

//    @GetMapping("/hello/{name}")
    /*public String hello(@PathVariable("name") String name){
        System.out.println("获取到得name是:"+name);
        return "hello "+name;
    }*/

    @GetMapping("/hello")
    public String hello(@RequestParam("name") String name){
        System.out.println("获取到得name是:"+name);
        return "hello "+name;
    }

}
