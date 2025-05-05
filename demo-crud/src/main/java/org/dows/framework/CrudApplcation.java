package org.dows.framework;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"cn.hutool.extra.spring", "org.dows.framework.*"})
public class CrudApplcation {
    public static void main(String[] args) {
        SpringApplication.run(CrudApplcation.class, args);
    }

}
