package com.example.demo;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;

/**
 * Created by Andrei on 24.11.2017.
 */
@Configuration
@ComponentScan
public class ServletInitializer extends SpringBootServletInitializer {
    private static ArrayList<String> allowOrigins = new ArrayList<>();
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(DemoApplication.class);
    }
}