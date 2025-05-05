package org.dows.framework.snapshot;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.dows.framework.entity.EventEntity;
import org.dows.framework.entity.FoodRecommendEntity;
import org.springframework.stereotype.Service;

/**
 * 此处可以是任何biz service mapper等方法
 */
@RequiredArgsConstructor
@Service
@Slf4j
public class ExperimentInitializer {


    /**
     * 此处返回md5
     *
     * @param args
     * @return
     */
    public SnapshotResult initExp(String args) {

        // todo 其他业务
        //
        log.info(".....................aop..........................");
        //

        //todo 查询需要快照的表

        // md5
        //ExperimentSnapshot experimentSnapshot = new ExperimentSnapshot();

        // 完成业务后,确定快照数据的md5
        SnapshotResult snapshotResult = new SnapshotResult();
        snapshotResult.addSnapshot(EventEntity.class, "aaa=1 and bbb = 2")
                .addSnapshot(FoodRecommendEntity.class, "fff=1 and ddd = 2");
        return snapshotResult;
    }
}
