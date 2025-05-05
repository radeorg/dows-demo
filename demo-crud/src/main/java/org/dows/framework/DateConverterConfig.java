package org.dows.framework;

import cn.hutool.core.util.StrUtil;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.TimeZone;

/**
 * 自定义参数转换器，全局反序列化 GET请求、POST表单 提交的时间字符串
 */
@Configuration
public class DateConverterConfig {

    /**
     * yyyy-MM-dd 时间格式的正则表达式
     */
    private static final String DATE_REGEX = "[1-9]\\d{3}-(0[1-9]|1[0-2])-(0[1-9]|[1-2][0-9]|3[0-1])";

    /**
     * HH:mm:ss 时间格式的正则表达式
     */
    private static final String TIME_REGEX = "(20|21|22|23|[0-1]\\d):[0-5]\\d:[0-5]\\d";

    /**
     * yyyy-MM-dd HH:mm:ss 时间格式的正则表达式
     */
    private static final String DATE_TIME_REGEX = DATE_REGEX + "\s" + TIME_REGEX;

    /**
     * yyyy-MM-ddTHH:mm:ss 时间格式的正则表达式
     */
    private static final String DATE_T_TIME_REGEX = DATE_REGEX + "T" + TIME_REGEX;

    /**
     * yyyy-MM-ddTHH:mm:ss.SSS 时间格式的正则表达式
     */
    private static final String DATE_T_TIME_MS_REGEX = DATE_REGEX + "T" + TIME_REGEX + ".\\d{3}";

    /**
     * 13位时间戳正则表达式
     */
    private static final String TIME_STAMP_REGEX = "1\\d{12}";

    /**
     * yyyy-MM 时间格式的正则表达式
     */
    private static final String YEAR_MONTH_REGEX = "[1-9]\\d{3}-(0[1-9]|1[0-2])";

    /**
     * yyyy-MM 格式
     */
    private static final String YEAR_MONTH_PATTERN = "yyyy-MM";

    /**
     * DateTime格式化字符串
     */
    private static final String DEFAULT_DATETIME_PATTERN = "yyyy-MM-dd HH:mm:ss";

    /**
     * DateTime格式化字符串 ISO 格式
     */
    private static final String DEFAULT_DATETIME_ISO_PATTERN = "yyyy-MM-ddTHH:mm:ss";

    /**
     * DateTime格式化字符串 带毫秒值的 ISO 格式
     */
    private static final String DEFAULT_DATETIME_MS_ISO_PATTERN = "yyyy-MM-ddTHH:mm:ss.SSS";

    /**
     * Date格式化字符串
     */
    private static final String DEFAULT_DATE_FORMAT = "yyyy-MM-dd";

    /**
     * Time格式化字符串
     */
    private static final String DEFAULT_TIME_FORMAT = "HH:mm:ss";

    /**
     * 根据 pattern 构建 SimpleDateFormat
     * @param pattern
     * @return
     */
    private SimpleDateFormat getSimpleDateFormat(String pattern){
        SimpleDateFormat df =  new SimpleDateFormat(pattern);
        System.out.println(TimeZone.getDefault());
        df.setTimeZone(TimeZone.getTimeZone ("GMT"));
        return df;
    }

    /**
     * String -> Date 转换器
     * 用于转换 @RequestParam参数、@PathVariable参数、表单参数
     */
    @Bean
    public Converter<String, Date> dateConverter() {
        return new Converter<String, Date>() {
            @SuppressWarnings("NullableProblems")
            @Override
            public Date convert(String source) {
                if (StrUtil.isEmpty(source)) {
                    return null;
                }
                // 13位毫秒值 -> Date
                if (source.matches(TIME_STAMP_REGEX)) {
                    return new Date(Long.parseLong(source));
                }
                try {
                    // yyyy-MM-dd HH:mm:ss -> Date
                    if (source.matches(DATE_TIME_REGEX)) {
                        return getSimpleDateFormat(DEFAULT_DATETIME_PATTERN).parse(source);
                    }

                    // yyyy-MM-dd -> Date
                    if (source.matches(DATE_REGEX)) {
                        return getSimpleDateFormat(DEFAULT_DATE_FORMAT).parse(source);
                    }

                    // yyyy-MM -> Date
                    if (source.matches(YEAR_MONTH_REGEX)) {
                        return getSimpleDateFormat(YEAR_MONTH_PATTERN).parse(source);
                    }
                } catch (ParseException e) {
                    throw new RuntimeException(e);
                }
                return null;
            }
        };
    }


    /**
     * String -> LocalDateTime 转换器
     * 用于转换 @RequestParam参数、@PathVariable参数、表单参数
     */
    @Bean
    public Converter<String, LocalDateTime> localDateTimeConverter() {
        return new Converter<String, LocalDateTime>() {
            @SuppressWarnings("NullableProblems")
            @Override
            public LocalDateTime convert(String source) {
                if (StrUtil.isEmpty(source)) {
                    return null;
                }
                // 13位毫秒值 -> LocalDateTime
                if (source.matches(TIME_STAMP_REGEX)) {
                    Instant instant = Instant.ofEpochMilli(Long.parseLong(source));
                    ZoneId zone = ZoneId.systemDefault();
                    return LocalDateTime.ofInstant(instant, zone);
                }
                // yyyy-MM-dd HH:mm:ss -> LocalDateTime
                if (source.matches(DATE_TIME_REGEX)) {
                    return LocalDateTime.parse(source, DateTimeFormatter.ofPattern(DEFAULT_DATETIME_PATTERN));
                }

                // yyyy-MM-ddTHH:mm:ss -> LocalDateTime
                if (source.matches(DATE_T_TIME_REGEX)) {
                    return LocalDateTime.parse(source, DateTimeFormatter.ofPattern(DEFAULT_DATETIME_ISO_PATTERN));
                }

                // yyyy-MM-ddTHH:mm:ss.SSS -> LocalDateTime
                if (source.matches(DATE_T_TIME_MS_REGEX)) {
                    return LocalDateTime.parse(source, DateTimeFormatter.ofPattern(DEFAULT_DATETIME_MS_ISO_PATTERN));
                }

                return null;
            }
        };
    }

    /**
     * String -> LocalDate 转换器
     * 用于转换 @RequestParam参数、@PathVariable参数、表单参数
     */
    @Bean
    public Converter<String, LocalDate> localDateConverter() {
        return new Converter<String, LocalDate>() {
            @SuppressWarnings("NullableProblems")
            @Override
            public LocalDate convert(String source) {
                if (StrUtil.isEmpty(source)) {
                    return null;
                }
                // 13位毫秒值 -> LocalDate
                if (source.matches(TIME_STAMP_REGEX)) {
                    Instant instant = Instant.ofEpochMilli(Long.parseLong(source));
                    ZoneId zone = ZoneId.systemDefault();
                    return LocalDateTime.ofInstant(instant, zone).toLocalDate();
                }

                // yyyy-MM-dd -> LocalDate
                if (source.matches(DATE_REGEX)) {
                    return LocalDate.parse(source, DateTimeFormatter.ofPattern(DEFAULT_DATE_FORMAT));
                }

                return null;
            }
        };
    }

    /**
     * String -> LocalTime 转换器
     * 用于转换 @RequestParam参数、@PathVariable参数、表单参数
     */
    @Bean
    public Converter<String, LocalTime> localTimeConverter() {
        return new Converter<String, LocalTime>() {
            @SuppressWarnings("NullableProblems")
            @Override
            public LocalTime convert(String source) {
                if (StrUtil.isEmpty(source)) {
                    return null;
                }
                // HH:mm:ss -> LocalTime
                return LocalTime.parse(source, DateTimeFormatter.ofPattern(DEFAULT_TIME_FORMAT));
            }
        };
    }

}