package org.dows.saas;

import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.redisson.api.RBucket;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
public class RedissonApplication implements ApplicationRunner {

    public static void main(String[] args) {
        SpringApplication.run(RedissonApplication.class, args);
    }

    /**
     * 直接注入RedissonClient就可以直接使用.
     */
    @Resource
    private RedissonClient redissonClient;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        log.info("spring boot run");
        RBucket<Object> bucket = redissonClient.getBucket("zhang");
        bucket.set("liang");
        Object o = bucket.get();
        log.info("===={}", o);
        //创建锁
        RLock helloLock = redissonClient.getLock("hello");

        //加锁
        helloLock.lock();
        try {
            log.info("locked");
            Thread.sleep(1000 * 10);
        } finally {
            //释放锁
            helloLock.unlock();
            log.info("unlocked");
        }
        log.info("finished");
    }
}