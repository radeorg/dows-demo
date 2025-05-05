package org.dows.framework.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import org.dows.framework.crud.api.annotation.Orm;
import org.dows.framework.crud.mybatis.MyBatisPlusDao;

@Data
@TableName("u2")
@Orm(MyBatisPlusDao.class)
public class U2 {
    @TableId(type = IdType.AUTO)
    private Long id;
    private String name;
}
