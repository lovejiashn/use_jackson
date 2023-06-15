package com.jiashn.useJackson.domain;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author: jiangjs
 * @description: @JsonTypeInfo实现多态
 * @date: 2023/6/13 14:12
 **/
@JsonTypeInfo(use = JsonTypeInfo.Id.NONE,include = JsonTypeInfo.As.WRAPPER_ARRAY,property="type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = Dog.class,name = "dog"),
        @JsonSubTypes.Type(value = Cat.class,name = "cat")
})
@Data
@Accessors(chain = true)
public class Animal {
    private String name;
    private String color;
}
