package org.dows.framework;

import lombok.extern.slf4j.Slf4j;
import org.dows.framework.snapshot.ExperimentInitializer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@Slf4j
@SpringBootTest(classes = CrudApplcation.class)
public class SnapshotTest {
    @Autowired
    private ExperimentInitializer experimentInitializer;

    @Test
    public void testExpSnapshot() {
        experimentInitializer.initExp("init");
        log.info("");
    }

}
