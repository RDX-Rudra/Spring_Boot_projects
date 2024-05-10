package com.example.demo;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class MyController {

    
    public String requestMethodName(@RequestParam String param) {
        return new String();
    }
    @RequestMapping("m")
    public static String myMethode(){
        return "<h1>coading is best</h1>";
    }
    @PostMapping("process-form")
    public static String getdata(@RequestParam int num1,@RequestParam int num2){
        int num = num1 + num2;
        return "result = "+ num;
    }
}
