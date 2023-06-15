package com.jiashn.useJackson.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonIgnoreType;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author: jiangjs
 * @description:
 * @date: 2023/6/13 9:59
 **/
@Data
@JsonIgnoreProperties("name")
@AllArgsConstructor
public class UseJsonIgnoreProperties {
    private String name;
    private String nickName;
    @JsonIgnore
    private String gender;
    private IgnoreClass aClass;

    @Data
    @JsonIgnoreType
    @AllArgsConstructor
    public static class IgnoreClass{
        private String loginName;
        private String passWord;
    }
}
