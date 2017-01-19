package com.lazy.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.SpringVersion;

@SpringBootApplication
public class AppMain {

    public static void main(String[] args) {

        SpringApplication.run(AppMain.class, args);
        System.out.println("Home:"+System.getProperty("user.home"));
        System.out.println("JDK Versoin:"+System.getProperty("java.version"));
        System.out.println("OS:"+System.getProperty("os.name"));
        System.out.println("SpringVersion:"+SpringVersion.getVersion());
        
    }

}
	