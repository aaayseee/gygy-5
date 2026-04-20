package com.turkcell.spring_starter.controller;

import org.springframework.web.bind.annotation.RestController;

import com.turkcell.spring_starter.dto.ProductCreatedResponse;
import com.turkcell.spring_starter.dto.ProductForCreateDto;
import com.turkcell.spring_starter.model.Product;

import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


//Altın kural: Veritabanı nesneleri request ve response nesneleri olarak kullanılmaz, ayrı sınıflar oluşturulur
@RestController
@RequestMapping("/api/product") //localhost:8080/api/product -> ProductController
//Bu class bir RestController'dır, içini uygulama başadığında tara 
//http function tanımlarını al

public class ProductController {
    //kullanıcı ne zaman /api/product alanına istek atarsa -> cevap bu fonksiyonda dönen cevap olsun
    //api/product -> sayHi(), matchle
    //HTTP METHOD -> GET, POST, PUT, DELETE,PATCH...
    /*@GetMapping("") //controllerın uzantısı + getin uzantısı -> /api/product
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
    }*/


    //In-memory product list to store products
    private List<Product> productList = new ArrayList<>(); //Ürünleri saklamak için bir liste

    @GetMapping()
    public List<Product> getAllProducts() {
        return productList; // Tüm ürünleri döndür
    }

    @GetMapping("{id}")
    public Product getProductById(@PathVariable int id) {
        return productList.stream()
                .filter(product -> product.getId() == id)
                .findFirst()
                .orElse(null); // ID'ye göre ürünü bul, yoksa null döndür
    }


    //Request-Response pattern
    //Her istek-cevap kendine has bir modele sahip olmak zorundadır
    //Birebir başka bir istek-cevap çiftiyle aynı içeriğe sahip olsa dahi!!
    @PostMapping
    public ProductCreatedResponse createProduct(@RequestBody ProductForCreateDto productDto) {
        //Veritabanına product nesnesini ekle...

        //Sen dışardan ProductForCreateDto alıyorsun
        //Ama veritabanı Product ile çalışıyor

        //Transfer => Manuel Mapping
        Product product = new Product();
        product.setName(productDto.getName());
        product.setPrice(productDto.getPrice());
        product.setId(new Random().nextInt(999));

        productList.add(product); //veritabanına ekleme işlemi

        //Domain Nesnesi -> Dto
        ProductCreatedResponse response = new ProductCreatedResponse();
        response.setId(product.getId());    
        response.setName(product.getName());
        response.setPrice(product.getPrice());
        return response;
    }

    @PutMapping
    public void updateProduct(@RequestBody Product product) {
       Product productToUpdate = productList.stream().filter(p -> p.getId() == product.getId()).findFirst().orElseThrow();

       productToUpdate.setName(product.getName());
       productToUpdate.setPrice(product.getPrice());
    }

    @DeleteMapping("{id}")
    public void deleteProduct(@PathVariable int id) {
        ///..
        productList.removeIf(product -> product.getId() == id); // ID'ye göre ürünü listeden kaldır
    }


}


//DTO => Data Transfer Object
//Entitiy ile X (Controller, Service, Repository) arasındaki veri transferini sağlamak için kullanılan sınıflar