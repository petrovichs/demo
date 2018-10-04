package ru.sgorshkov.webapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"ru.sgorshkov.webapp.mapper",
        "ru.sgorshkov.webapp.controller",
        "ru.sgorshkov.webapp.service",
        "ru.sgorshkov.webapp.repo"})
public class Application {


    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}