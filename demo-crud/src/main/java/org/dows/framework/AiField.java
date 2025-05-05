package org.dows.framework;

import lombok.Data;

@Data
public class AiField {
    // 主键ID
    private String aiFieldId;
    // 序号
    private Integer sequence;
    // code
    private String code;
    // 标题
    private String title;
    // 必填项
    private Boolean required;
    // 是否隐藏
    private Boolean hidden;
    // 数据类型[integer,string,long,date...]
    private String dateType;
    // 输入类型[text,checkbox,select,radio......]
    private String inputType;
    // 绑定函数
    private String func;
    // 绑定数据
    private String data;
    //

}
