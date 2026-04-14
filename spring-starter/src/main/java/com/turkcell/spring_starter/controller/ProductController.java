package com.turkcell.spring_starter.controller;

import org.springframework.web.bind.annotation.RestController;

import com.turkcell.spring_starter.model.Product;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/api/product") //localhost:8080/api/product -> ProductController
//Bu class bir RestController'dır, içini uygulama başadığında tara 
//http function tanımlarını al

public class ProductController {
    //kullanıcı ne zaman /api/product alanına istek atarsa -> cevap bu fonksiyonda dönen cevap olsun
    //api/product -> sayHi(), matchle
    //HTTP METHOD -> GET, POST, PUT, DELETE,PATCH...
    @GetMapping("") //controllerın uzantısı + getin uzantısı -> /api/product
    public String sayHi(String name, int age){ //localhost:8080/api/product?name=John&age=30
        return "Hi " + name + ", you are " + age + " years old.";
    }

    @GetMapping("hello/{name}/{age}")//localhost:8080/api/product/hello/John/30
    public String sayHelloPathVariable(@PathVariable String name, @PathVariable int age){
        return "Hello " + name + ", you are " + age + " years old.";
    }


    @PostMapping
    public Product add(@RequestBody Product product){ //JSON -> Java
        //veritabanına kaydetme işlemi yapılır
        return product; //kaydedilen ürün geri döner
    }
}
