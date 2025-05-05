package org.dows.framework.enums;

import com.baomidou.mybatisplus.annotation.IEnum;

public enum U1Status implements IEnum<Long> {
    T1,T2;

    @Override
    public Long getValue() {
        return Long.valueOf(this.ordinal());
    }
}
