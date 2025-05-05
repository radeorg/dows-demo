package org.dows.framework;

import jakarta.annotation.Resource;
import org.dows.rade.oss.HraAdminApplication;
import org.dows.rade.oss.local.OssService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.FileNotFoundException;

@SpringBootTest(classes = HraAdminApplication.class)
public class Test1 {
    @Resource
    private OssService ossService;

    @Test
    public void testSize() throws FileNotFoundException {
        ossService.uoload();
        ossService.download();
    }
}
