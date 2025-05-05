package org.dows.demo.sam.api;

import org.dows.demo.sam.biz.SamBiz;
import org.dows.framework.api.Response;
import org.dows.framework.crud.api.annotation.BizImplements;

public interface SamApi {

     Response getSam(String sam);
}
