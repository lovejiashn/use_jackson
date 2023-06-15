package com.jiashn.useJackson.domain;

import com.fasterxml.jackson.annotation.JsonTypeName;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author: jiangjs
 * @description:
 * @date: 2023/6/13 14:14
 **/
@EqualsAndHashCode(callSuper = true)
@JsonTypeName(value = "cat")
@Data
public class Cat extends Animal{
    boolean likesCream;
    public int lives;
}
