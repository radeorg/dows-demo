package org.dows.saas.model;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Data
public class DateModel {

    private Date date;

    private LocalDate localDate;

    private LocalDateTime localDateTime;



}
