package com.victorsalaun;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;

@EnableBinding(Source.class)
@EnableDiscoveryClient
@SpringBootApplication
public class HttpSourceApplicationStarter {

    public static void main(String[] args) {
        SpringApplication.run(HttpSourceApplicationStarter.class, args);
    }

}
