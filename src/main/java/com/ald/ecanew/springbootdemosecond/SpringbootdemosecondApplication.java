package com.ald.ecanew.springbootdemosecond;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource(value = "classpath:jdbc.properties")
public class SpringbootdemosecondApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootdemosecondApplication.class, args);
    }

}
