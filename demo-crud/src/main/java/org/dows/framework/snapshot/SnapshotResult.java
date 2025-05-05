package org.dows.framework.snapshot;

import lombok.Getter;

import java.util.HashMap;
import java.util.Map;


public class SnapshotResult {
    @Getter
    private final Map<Class<?>, String> mapMd5Where = new HashMap<>();

    public SnapshotResult addSnapshot(Class<?> clazz, String md5) {
        mapMd5Where.put(clazz, md5);

        return this;
    }
}
