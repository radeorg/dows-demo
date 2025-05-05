package org.dows.demo.sam.biz;

import cn.hutool.core.lang.func.Func1;
import org.dows.framework.api.Response;
import org.springframework.stereotype.Service;

import java.sql.Struct;

@Service
public class SamBiz {
    public Response getSam(String sam){
        return Response.ok("hello biz " + sam);
    }


}
