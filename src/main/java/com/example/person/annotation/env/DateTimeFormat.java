package com.example.person.annotation.env;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface DateTimeFormat {

    public static final String SOURCE_DATE_DEFAULT_FORMAT = "yyyyMMdd";
    public static final String SOURCE_TIME_DEFAULT_FORMAT = "HHmmss";
    //public static final String TARGET_DEFAULT_FORMAT = "yyyy-MM-dd'T00:00:00.000Z'";
    public static final String TARGET_DEFAULT_FORMAT = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'";

    public String sourceDateField() default "";
    public String sourceTimeField() default "";
    public String sourceDateFormat() default SOURCE_DATE_DEFAULT_FORMAT;
    public String sourceTimeFormat() default SOURCE_TIME_DEFAULT_FORMAT;
    public String targetFormat() default TARGET_DEFAULT_FORMAT;
    public SourceDateType sourceDateTypeValue() default SourceDateType.INT;

    public enum SourceDateType{
        INT, CALENDAR, STRING;
    }

}

