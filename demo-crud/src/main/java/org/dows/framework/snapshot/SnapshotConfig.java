package org.dows.framework.snapshot;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.dows.framework.ddl.api.ddl.Create;
import org.dows.framework.ddl.api.ddl.Snapshot;
import org.dows.framework.ddl.store.DdlBuildrRepository;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.aop.support.NameMatchMethodPointcut;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@RequiredArgsConstructor
@EnableConfigurationProperties({SnapshotProperties.class})
@Configuration
public class SnapshotConfig {

    private final SnapshotProperties snapshotProperties;

    private final DdlBuildrRepository ddlBuildrRepository;


    /**
     * todo 去数据库库读取，并缓存
     */
    @PostConstruct
    public void initConfig() {
        //snapshotProperties
    }


    @Bean(name = "mysqlCreate")
    public Create builderMysqlAlter() {
        Create create = ddlBuildrRepository.mysql().builderCreate();
        return create;
    }

    @Bean(name = "mysqlSnapshot")
    public Snapshot builderMysqlSnapshot() {
        Snapshot snapshot = ddlBuildrRepository.mysql().buildSnapshot();
        return snapshot;
    }

    @Bean("snapshotPointcut")
    NameMatchMethodPointcut nameMatchMethodPointcut() {
        NameMatchMethodPointcut nameMatchMethodPointcut = new NameMatchMethodPointcut();
        nameMatchMethodPointcut.addMethodName(snapshotProperties.getMethod());
        nameMatchMethodPointcut.setClassFilter(clazz -> {
            Class clz = snapshotProperties.getClazz();
            if (clz.equals(clazz)) {
                return true;
            }
            return false;
        });
        return nameMatchMethodPointcut;
    }


    @Bean("snapshotAroundMethod")
    SnapshotAroundMethod aroundMethod() {
        SnapshotAroundMethod snapshotAroundMethod = new SnapshotAroundMethod(snapshotProperties,builderMysqlSnapshot(),null);
        return snapshotAroundMethod;
    }

    @Bean("snapshotPointcutAdvisor")
    DefaultPointcutAdvisor defaultPointcutAdvisor() {
        DefaultPointcutAdvisor defaultPointcutAdvisor = new DefaultPointcutAdvisor();
        defaultPointcutAdvisor.setAdvice(aroundMethod());
        defaultPointcutAdvisor.setPointcut(nameMatchMethodPointcut());
        return defaultPointcutAdvisor;
    }

}
