package org.dows.framework.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import org.dows.framework.crud.api.annotation.Orm;
import org.dows.framework.crud.mybatis.MyBatisPlusDao;
import org.dows.framework.enums.U1Status;

/**
 * @author xuejike
 * @date 2020/12/29
 */
@Data
@TableName("u1")
@Orm({MyBatisPlusDao.class})
public class U1 {
    @TableId(type = IdType.AUTO)
    private Long id;
    private String name;
    private String type;
    private Long u2Id;

    private U1Status status;
}
