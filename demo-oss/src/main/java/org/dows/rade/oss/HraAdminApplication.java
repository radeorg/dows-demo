package org.dows.rade.oss;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"org.dows.rade.oss"})
//@Import(LocalOssConfiguration.class)
public class HraAdminApplication {

    public static void main(String[] args) {
        SpringApplication.run(HraAdminApplication.class, args);
    }
}
