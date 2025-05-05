package org.dows.demo.sam;

import org.dows.framework.crud.config.EnableBizMapping;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableBizMapping(bizPackages = {"org.dows.demo.sam.biz"})
public class SamApplication {

    public static void main(String[] args) {
        SpringApplication.run(SamApplication.class,args);
    }
}
