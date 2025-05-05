package org.dows.saas;

import lombok.extern.slf4j.Slf4j;
import org.dows.saas.model.DateModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Slf4j
@RestController
public class AppRest {


    @GetMapping("/get")
    public String get() {
        log.info("get()");
        return "hello lait";
    }


    @GetMapping("/date")
    public DateModel dateModel() {
        log.info("dateModel()");
        DateModel dateModel = new DateModel();

        dateModel.setDate(new Date());
        dateModel.setLocalDate(LocalDate.now());
        dateModel.setLocalDateTime(LocalDateTime.now());
        return dateModel;

    }
}
