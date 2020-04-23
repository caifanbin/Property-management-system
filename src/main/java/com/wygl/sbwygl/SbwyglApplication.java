package com.wygl.sbwygl;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan(value = "com.wygl.sbwygl.mapper")
@SpringBootApplication
public class SbwyglApplication {

    public static void main(String[] args) {
        SpringApplication.run(SbwyglApplication.class, args);
    }

}
