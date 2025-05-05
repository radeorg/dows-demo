package org.dows.rade.oss;

import com.tangzc.mybatisflex.autotable.MybatisFlexAutoTableAutoConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(scanBasePackages = {"org.dows.rade.oss"},exclude = {DataSourceAutoConfiguration.class, MybatisFlexAutoTableAutoConfig.class})
//@Import(LocalOssConfiguration.class)
public class HraAdminApplication {

    public static void main(String[] args) {
        SpringApplication.run(HraAdminApplication.class, args);
    }
}
