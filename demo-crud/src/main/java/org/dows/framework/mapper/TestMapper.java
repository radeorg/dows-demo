package org.dows.framework.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.dows.framework.entity.TestEntity;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * @author jx
 * @date 2023/5/17 19:22
 */
@Mapper
public interface TestMapper {

    void saveStudent1(TestEntity testEntity);

    void saveStudent2(TestEntity testEntity);

    void saveStudent3(TestEntity testEntity);

    List<TestEntity> getStudentByPrimaryIds(@PathVariable("ids") List<Long> ids);

    void getStudentByDistributedIds(@PathVariable("ids") List<Long> ids);

//    void getStudentByDistributedIdAndPrimary(String testId,String sequence);

    List<TestEntity> getStudent1Limit10000();

    List<TestEntity> getStudent2Limit10000();

    List<TestEntity> getStudent3Limit10000();
}
