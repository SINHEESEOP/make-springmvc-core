package com.study.myspringmvc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan
public class MySpringMvcApplication {

    public static void main(String[] args) {
        SpringApplication.run(MySpringMvcApplication.class, args);
    }

}
