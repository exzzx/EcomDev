package org.example;

import org.example.dao.UserDOMapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Hello world!
 *
 */
@SpringBootApplication(scanBasePackages = {"org.example"})
@RestController
@MapperScan("org.example.dao")
public class App
{
    @Autowired
    private UserDOMapper userDOMapper;

    @GetMapping("/")
    public String accessHome(){
        return "Hello world!";
    }
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        SpringApplication.run(App.class, args);
    }
}