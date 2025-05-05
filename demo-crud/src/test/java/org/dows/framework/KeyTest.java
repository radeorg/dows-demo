package org.dows.framework;

import org.dows.framework.entity.TestEntity;
import org.dows.framework.mapper.TestMapper;
import org.dows.sequence.snowflake.SnowflakeIdGenerator;
import org.dows.sequence.snowflake.config.SnowFlakeConfiguration;
import org.dows.sequence.snowflake.config.SnowFlakeProperties;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@SpringBootTest(classes = CrudApplcation.class)
public class KeyTest {
    @Autowired
    private TestMapper studentMapper;


    private static List<Long> ids = new ArrayList<>(1000);

    static {
        Random random = new Random();
        for (int i = 0; i <= 10000; i++) {
            final long l = random.nextLong();
            ids.add(l);
        }

    }

    @org.junit.jupiter.api.Test
    public void testAdd1() {
        Long startTime = System.currentTimeMillis();
        for (int i = 0; i < 500000; i++) {
            TestEntity stu = new TestEntity();
//            SnowFlakeProperties snowFlakeProperties = new SnowFlakeProperties();
//            SnowFlakeConfiguration snowFlakeConfiguration = SnowFlakeConfiguration.parse(snowFlakeProperties);
//            SnowflakeIdGenerator snowflakeIdGenerator = new SnowflakeIdGenerator(snowFlakeConfiguration);
//            stu.setTestId(snowflakeIdGenerator.nextIdStr());
            stu.setName("zhangsan" + i);
            stu.setDeleted(false);
            studentMapper.saveStudent1(stu);
        }
        Long endTime = System.currentTimeMillis();
        Long tempTime = (endTime - startTime);
        System.out.println("自增插入时间：" + tempTime);
    }

    @Test
    public void testAdd2() {
        Long startTime = System.currentTimeMillis();
        for (int i = 0; i < 500000; i++) {
            TestEntity stu = new TestEntity();
            SnowFlakeProperties snowFlakeProperties = new SnowFlakeProperties();
            SnowFlakeConfiguration snowFlakeConfiguration = SnowFlakeConfiguration.parse(snowFlakeProperties);
            SnowflakeIdGenerator snowflakeIdGenerator = new SnowflakeIdGenerator(snowFlakeConfiguration);
            stu.setTestId(snowflakeIdGenerator.nextIdStr());
            stu.setName("zhangsan" + i);
            stu.setDeleted(false);
            studentMapper.saveStudent2(stu);
        }
        Long endTime = System.currentTimeMillis();
        Long tempTime = (endTime - startTime);
        System.out.println("非自增插入时间：" + tempTime);
    }

    @Test
    public void testAdd3() {
        Long startTime = System.currentTimeMillis();
        for (int i = 0; i < 500000; i++) {
            TestEntity stu = new TestEntity();
            SnowFlakeProperties snowFlakeProperties = new SnowFlakeProperties();
            SnowFlakeConfiguration snowFlakeConfiguration = SnowFlakeConfiguration.parse(snowFlakeProperties);
            SnowflakeIdGenerator snowflakeIdGenerator = new SnowflakeIdGenerator(snowFlakeConfiguration);
            stu.setTestId(snowflakeIdGenerator.nextIdStr());
            stu.setName("zhangsan" + i);
            stu.setDeleted(false);
            studentMapper.saveStudent3(stu);
        }
        Long endTime = System.currentTimeMillis();
        Long tempTime = (endTime - startTime);
        System.out.println("联合插入时间：" + tempTime);
    }

    @Test
    public void testQuery1() {
        List<TestEntity> testList = studentMapper.getStudent1Limit10000();
        List<Long> idList = testList.stream().map(person -> person.getId()).collect(Collectors.toList());
        Long startTime = System.currentTimeMillis();
        studentMapper.getStudentByPrimaryIds(idList);
        Long endTime = System.currentTimeMillis();
        Long tempTime = (endTime - startTime);
        System.out.println("通过主键查询花费时间：" + tempTime);
    }

    @Test
    public void testQuery2() {
        List<TestEntity> testList = studentMapper.getStudent2Limit10000();
        List<Long> idList = testList.stream().map(person -> person.getId()).collect(Collectors.toList());
        Long startTime = System.currentTimeMillis();
        studentMapper.getStudentByDistributedIds(idList);
        Long endTime = System.currentTimeMillis();
        Long tempTime = (endTime - startTime);
        System.out.println("通过分布式键花费时间：" + tempTime);
    }

//    @org.junit.Test
//    public void testQuery3() {
//        Long startTime = System.currentTimeMillis();
//        studentMapper.getStudentByDistributedIdAndPrimary("335562783892574208","216019");
//        Long endTime = System.currentTimeMillis();
//        Long tempTime = (endTime - startTime);
//        System.out.println("通过联合主键花费时间："+ tempTime);
//    }
}
