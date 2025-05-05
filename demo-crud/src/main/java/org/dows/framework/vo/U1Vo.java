package org.dows.framework.vo;

import lombok.Data;
import org.dows.framework.crud.api.annotation.RefValue;
import org.dows.framework.crud.api.annotation.SetRefValue;

@Data
public class U1Vo {
    private Long id;
    private String name;
    private String type;
    @SetRefValue("u2")
    private Long u2Id;
    @RefValue("#u2.name")
    private String u2Name;
}
