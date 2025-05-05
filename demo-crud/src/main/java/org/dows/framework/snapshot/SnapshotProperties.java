package org.dows.framework.snapshot;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;

/**
 * dows:
 * hep:
 * snapshot:
 * experiment:
 * method: init
 * clazz: 初始化类
 * tables:
 * - ddddd
 * - ccccc
 * - fffff
 * - ggggg
 */
@ConfigurationProperties("dows.hep.snapshot.experiment")
@Data
public class SnapshotProperties {
    private String method;
    private Class<?> clazz;
    private List<Class<?>> tables;
}
