package com.jiashn.useJackson.typeChange;

import com.fasterxml.jackson.annotation.JacksonAnnotationsInside;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.util.JSONPObject;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author: jiangjs
 * @description:
 * @date: 2023/6/15 16:08
 **/
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@JacksonAnnotationsInside
@JsonSerialize(using = TypeChangeSerialize.class)
public @interface TypeChange {
     //值得替换 导出是{a_id,b_id} 导入反过来,所以只用写一个
     String[] replace() default {};
}
