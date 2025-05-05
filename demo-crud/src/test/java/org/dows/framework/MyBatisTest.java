package org.dows.framework;

import cn.hutool.extra.spring.SpringUtil;
import cn.hutool.json.JSONUtil;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import lombok.extern.slf4j.Slf4j;
import org.dows.framework.crud.engine.$;
import org.dows.framework.crud.mybatis.MyBatisPlusDaoFactory;
import org.dows.framework.entity.U1;
import org.dows.framework.entity.U2;
import org.dows.framework.enums.U1Status;
import org.dows.framework.vo.U1Vo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;

import java.util.List;

@SpringBootTest(classes = CrudApplcation.class)
@ContextConfiguration
@Slf4j
@Rollback(value = false)
public class MyBatisTest {

    @BeforeEach
    public void before() {
        new MyBatisPlusDaoFactory(SpringUtil.getBeansOfType(BaseMapper.class).values());

    }

    @Test
    public void list() {
        List<U1Vo> list = $.query(U1.class)
                .eq(U1::getStatus, U1Status.T1)
                .loadRef(U1::getU2Id, U2.class, U2::getId)
                .map(U1Vo.class).list();
        System.out.println(JSONUtil.toJsonStr(list));
    }
}
