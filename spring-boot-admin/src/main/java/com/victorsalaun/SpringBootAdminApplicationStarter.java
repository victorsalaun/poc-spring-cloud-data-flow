package com.victorsalaun;

import de.codecentric.boot.admin.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableAdminServer
@SpringBootApplication
public class SpringBootAdminApplicationStarter {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootAdminApplicationStarter.class, args);
    }

}
