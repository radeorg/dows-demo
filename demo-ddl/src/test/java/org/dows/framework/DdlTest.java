package org.dows.framework;

import lombok.extern.slf4j.Slf4j;
import org.dows.framework.crud.entity.EventEntity;
import org.dows.framework.ddl.api.ddl.Create;
import org.dows.framework.ddl.api.ddl.Snapshot;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@Slf4j
@SpringBootTest(classes = {DdlApplication.class})
public class DdlTest {

    @Autowired
    private Create mysqlCreate;

    @Autowired
    private Snapshot mysqlSnapshot;

    @Test
    public void testCreate() {
        String s = mysqlCreate.creteTable(EventEntity.class);
        log.info("ddl:\n{}", s);
    }


    /**
     * String formTableName, String toTableName, List<String> columnList, String where
     */
    @Test
    public void testSnapshot() {
        String s = mysqlSnapshot.snapshotTable(EventEntity.class, "xxx_MD5", "xxx=1 and ddd=abcd");
        log.info("ddl:\n{}", s);
    }

}
