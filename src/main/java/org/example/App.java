package org.example;

import org.example.dao.UserDOMapper;
import org.example.dataobject.UserDO;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
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
        UserDO userDo = userDOMapper.selectByPrimaryKey(1);
        if(userDo == null) {
            return "user not exist";
        } else {
            return userDo.getName();
        }
    }
    public static void main( String[] args )
    {
        SpringApplication.run(App.class, args);
    }
}