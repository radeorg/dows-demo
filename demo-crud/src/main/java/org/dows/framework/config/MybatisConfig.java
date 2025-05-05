package org.dows.framework.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("org.dows.framework.mapper")
public class MybatisConfig {
}
