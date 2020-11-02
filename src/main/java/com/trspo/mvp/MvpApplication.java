package com.trspo.mvp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;


@SpringBootApplication()
public class MvpApplication {

    public static void main(String[] args) {
        SpringApplication.run(MvpApplication.class, args);
    }

}
