package org.dows.framework;

import lombok.Data;
import lombok.ToString;
import org.dows.framework.doc.api.annotation.PictureProperty;
import org.dows.framework.doc.api.annotation.WordProperty;
import org.dows.framework.doc.api.entity.word.ContextTypeEnum;

@Data
public class Thesis {

    @ToString.Exclude
    @WordProperty(key = "$[topic]", type = ContextTypeEnum.TEXT)
    private String topic;

    @WordProperty(key = "$[title1]", type = ContextTypeEnum.TEXT)
    private String title1;

    @WordProperty(key = "$[context1]", type = ContextTypeEnum.TEXT)
    private String context1;

    @WordProperty(key = "$[context2]", type = ContextTypeEnum.TEXT)
    private String context2;

    @WordProperty(key = "$[title2]", type = ContextTypeEnum.TEXT)
    private String title2;

    @WordProperty(key = "$[picture1]", type = ContextTypeEnum.PICTURE)
    @PictureProperty(width = 100, height = 100)
    private byte[] picture1;

    @WordProperty(key = "$[picture2]", type = ContextTypeEnum.PICTURE)
    @PictureProperty(width = 200, height = 200)
    private byte[] picture2;

    @WordProperty(key = "$[context3]", type = ContextTypeEnum.TEXT)
    private String context3;
}
