package com.imodupsy.shawamacloud;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
public class ShawamaCloudApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShawamaCloudApplication.class, args);
        log.info("\n\n========================================= APPLICATION LAUNCHED!!! =========================================\n\n");
    }

}
