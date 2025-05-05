package org.dows.framework.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import org.dows.framework.crud.api.annotation.Orm;
import org.dows.framework.crud.mybatis.MyBatisPlusDao;

@Data
@TableName("user")
@Orm(MyBatisPlusDao.class)
public class User {
    @TableId(type = IdType.AUTO)
    private Long id;
    private String name;
    private String type;
    private Long clazzId;

}
