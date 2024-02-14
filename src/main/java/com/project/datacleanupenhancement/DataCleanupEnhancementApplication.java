package com.project.datacleanupenhancement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class DataCleanupEnhancementApplication {

    public static void main(String[] args) {
        SpringApplication.run(DataCleanupEnhancementApplication.class, args);
    }

}
