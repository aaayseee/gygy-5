package com.turkcell.spring_starter.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;



@RestController
@RequestMapping("/api/product") //localhost:8080/api/product -> ProductController
//Bu class bir RestController'dır, içini uygulama başadığında tara 
//http function tanımlarını al

public class ProductController {
    //kullanıcı ne zaman /api/product alanına istek atarsa -> cevap bu fonksiyonda dönen cevap olsun
    //api/product -> sayHi(), matchle
    //HTTP METHOD -> GET, POST, PUT, DELETE,PATCH...
    @GetMapping("")
    public String sayHi(){
        return "Hello";
    }

    @GetMapping("Hello")
    public String sayHi2(){
        return "Hello2";
    }
}
