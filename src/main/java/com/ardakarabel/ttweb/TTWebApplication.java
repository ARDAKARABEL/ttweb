package com.ardakarabel.ttweb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class TTWebApplication extends SpringBootServletInitializer{

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(TTWebApplication.class);
    }

    //Starts Tomcat + Spring Boot Frameworks
    public static void main(String[] args) {
        SpringApplication.run(TTWebApplication.class,args);
    }
}