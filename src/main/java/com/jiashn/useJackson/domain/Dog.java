package com.jiashn.useJackson.domain;

import com.fasterxml.jackson.annotation.JsonTypeName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * @author: jiangjs
 * @description:
 * @date: 2023/6/13 14:16
 **/
@EqualsAndHashCode(callSuper = true)
@Data
@JsonTypeName(value = "dog")
@Accessors(chain = true)
public class Dog extends Animal{
    public double barkVolume;
}
