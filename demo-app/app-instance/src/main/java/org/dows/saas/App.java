package org.dows.saas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Hello world!
 */
@SpringBootApplication(scanBasePackages = {"cn.hutool.extra.spring", "org.dows.framework.*", "org.dows.saas"})
public class App {
    public static void main(String[] args) {
        System.setProperty("SERVICE_NAME", "appdemo");
        SpringApplication.run(App.class, args);
    }
}
