package org.dows.framework;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@RestController
public class TestRest {



    @GetMapping("date")
    public DateModel dateModel(){
        DateModel dateModel = new DateModel();

        dateModel.setDate(new Date());
        dateModel.setLocalDate(LocalDate.now());
        dateModel.setLocalDateTime(LocalDateTime.now());
        return dateModel;

    }




}
