package org.dows.framework.snapshot;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.dows.framework.ddl.api.ddl.Snapshot;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import static cn.hutool.crypto.SecureUtil.md5;

@Slf4j
@RequiredArgsConstructor
public class SnapshotAroundMethod implements MethodInterceptor {

    private final SnapshotProperties snapshotProperties;

    private final Snapshot mysqlSnapshot;

    // todo 注入一个通用查询
    private final JdbcTemplate jdbcTemplate;

    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        log.info("around method before,method  name:{},method  arguments:{}",
                methodInvocation.getMethod().getName(), Arrays.toString(methodInvocation.getArguments()));
        try {
            // 获取数据
            SnapshotResult result = (SnapshotResult) methodInvocation.proceed();
            Class<?> declaringClass = methodInvocation.getMethod().getDeclaringClass();
            String methodName = methodInvocation.getMethod().getName();

            // todo 处理snapshot
            List<Class<?>> tables = snapshotProperties.getTables();

            Map<Class<?>, String> mapMd5 = result.getMapMd5Where();
            for (Class<?> table : tables) {
                //todo 快照
                String where = mapMd5.get(table);
                String newMd5 = "newmd5";
                try {
                    // todo 原sql查询数据，并计算md5
                    List list = Collections.singletonList(jdbcTemplate.query(where, (ResultSetExtractor<Object>) null));
                    newMd5 = md5(list.toString());
                } catch (Exception e) {

                }

                // todo 查询缓存是否有该md5，有则不需创建，无则快照一下
                String oldMd5 = "oldmd5";
                if (!newMd5.equals(oldMd5)) {
                    // todo 查询后数据的md5没有变化不需要快照
                    String sql = mysqlSnapshot.snapshotTable(table, table.getSimpleName() + "_" + newMd5, where);
                    // todo 执行该sql
                    log.info("快照数据：{}", sql);
                    System.out.println("快照数据 sql = "+ sql);
                }
            }
            log.info("around method : after ");
            return result;
        } catch (IllegalArgumentException e) {
            log.info("around method : throw  an  exception ");
            throw e;
        }
    }
}