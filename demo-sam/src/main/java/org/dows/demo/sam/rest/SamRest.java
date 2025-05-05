package org.dows.demo.sam.rest;

import org.dows.demo.sam.api.SamApi;
import org.dows.demo.sam.biz.SamBiz;
import org.dows.framework.api.Response;
import org.dows.framework.crud.api.annotation.BizImplements;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@BizImplements(SamBiz.class)
public interface SamRest extends SamApi {


    @GetMapping()
    default Response getSam(String sam){
        return Response.ok("hello " + sam);
    }

}
