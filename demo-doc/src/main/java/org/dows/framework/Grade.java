package org.dows.framework;

import lombok.Data;
import org.dows.framework.doc.api.annotation.ExcelProperty;

@Data
public class Grade {

    @ExcelProperty(headName = "姓名", index = 1)
    private String name;

    @ExcelProperty(headName = "语文", index = 2)
    private Double chinese;

    @ExcelProperty(headName = "数学", index = 3)
    private Double math;

    @ExcelProperty(headName = "政治", index = 7)
    private Double politics;

    @ExcelProperty(headName = "历史", index = 8)
    private Double history;

    @ExcelProperty(headName = "地理", index = 9)
    private Double geography;

    @ExcelProperty(headName = "体育", index = 10)
    private Double sports;

    @ExcelProperty(headName = "音乐", index = 11)
    private Double music;

    @ExcelProperty(headName = "英语", index = 4)
    private Double english;

    @ExcelProperty(headName = "物理", index = 5)
    private Double physics;

    @ExcelProperty(headName = "化学", index = 6)
    private Double chemistry;
}
