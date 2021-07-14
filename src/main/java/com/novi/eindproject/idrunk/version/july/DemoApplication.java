package com.novi.eindproject.idrunk.version.july;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @SpringBootApplication
    public static class DemoFileUpload {

        public void main(String[] args) {
            SpringApplication.run(DemoFileUpload.class, args);
        }

    }
}
