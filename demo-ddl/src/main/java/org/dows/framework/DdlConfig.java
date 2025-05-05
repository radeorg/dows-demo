package org.dows.framework;

import lombok.RequiredArgsConstructor;
import org.dows.framework.ddl.api.ddl.Create;
import org.dows.framework.ddl.api.ddl.Snapshot;
import org.dows.framework.ddl.store.DdlBuildrRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@RequiredArgsConstructor
@Configuration
public class DdlConfig {

    private final DdlBuildrRepository ddlBuildrRepository;

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

}
