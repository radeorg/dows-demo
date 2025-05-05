//package org.dows.saas;
//
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.core.convert.converter.Converter;
//import org.springframework.stereotype.Component;
//
//import java.text.DateFormat;
//import java.text.SimpleDateFormat;
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.List;
//import java.util.regex.Pattern;
//
//@Slf4j
//@Component
//public class StringToDateConverter implements Converter<String, Date> {
//    private static final List<Entry> formatList = new ArrayList<>();
//
//    static {
//        formatList.add(new Entry("yyyy-MM-dd", "^\\d{4}-\\d{1,2}-\\d{1,2}$"));
//        formatList.add(new Entry("yyyy-MM-dd HH:mm", "^\\d{4}-\\d{1,2}-\\d{1,2} {1}\\d{1,2}:\\d{1,2}$"));
//        formatList.add(new Entry("yyyy-MM-dd HH:mm:ss", "^\\d{4}-\\d{1,2}-\\d{1,2} {1}\\d{1,2}:\\d{1,2}:\\d{1,2}$"));
//    }
//
//
//    @Override
//    public Date convert(String source) {
//        String value = source.trim();
//        if ("".equals(value)) {
//            return null;
//        }
//        if (source.matches(formatList.get(0).value)) {
//            return parseDate(source, formatList.get(0).key);
//        } else if (source.matches(formatList.get(1).value)) {
//            return parseDate(source, formatList.get(1).key);
//        } else if (source.matches(formatList.get(2).value)) {
//            return parseDate(source, formatList.get(2).key);
//        } else if (isTimestamp(source)) {//long 时间戳转换
//            return parseDate(source, null);
//        } else {
//            throw new IllegalArgumentException("Invalid boolean value '" + source + "'");
//        }
//    }
//
//    /**
//     * 格式化日期
//     *
//     * @param dateStr String 字符型日期
//     * @param format  String 格式
//     * @return Date 日期
//     */
//    public Date parseDate(String dateStr, String format) {
//        Date date = null;
//        //long 时间戳转换
//        if (isTimestamp(dateStr)) {
//            long time = Long.parseLong(dateStr);
//            return new Date(time);
//        }
//        try {
//            DateFormat dateFormat = new SimpleDateFormat(format);
//            date = dateFormat.parse(dateStr);
//        } catch (Exception e) {
//            log.error("时间转换错误：{}", e.getMessage());
//        }
//        return date;
//    }
//
//    public static boolean isNumeric(String str) {
//        Pattern pattern = Pattern.compile("^[-\\+]?[\\d]*$");
//        return pattern.matcher(str).matches();
//    }
//
//    public static boolean isTimestamp(String str) {
//        return str != null && str.length() == 13 && isNumeric(str);
//    }
//
//    static class Entry {
//        String key;
//        String value;
//
//        public Entry(String key, String value) {
//            this.key = key;
//            this.value = value;
//        }
//    }
//}