package com.jiashn.useJackson.desensitized;

import com.fasterxml.jackson.annotation.JacksonAnnotationsInside;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author: jiangjs
 * @description: 使用jackson进行数据脱敏
 * @date: 2023/6/1 15:50
 **/
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@JacksonAnnotationsInside
@JsonSerialize(using = JacksonDataDesensitized.class)
public @interface JsonSensitive {
    DesensitizedStrategy strategy();
}
