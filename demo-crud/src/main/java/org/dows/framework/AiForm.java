package org.dows.framework;

import lombok.Data;

import java.util.Map;

@Data
public class AiForm {

    private String aiFormId;
    private String api;
    private String method;
    private String css;
    private Map<String, AiField> fields;
}
