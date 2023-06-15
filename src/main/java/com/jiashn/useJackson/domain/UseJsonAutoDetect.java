package com.jiashn.useJackson.domain;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author: jiangjs
 * @description:
 * @date: 2023/6/13 11:12
 **/
@AllArgsConstructor
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.PROTECTED_AND_PUBLIC)
public class UseJsonAutoDetect {
    private final String name;
    private final String nickName;
    public String gender;
    protected Integer age;
}
