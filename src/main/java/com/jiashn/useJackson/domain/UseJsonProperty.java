package com.jiashn.useJackson.domain;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

/**
 * @author: jiangjs
 * @description:
 * @date: 2023/6/13 15:06
 **/
@Data
@AllArgsConstructor
public class UseJsonProperty {
    @JsonProperty("loginName")
    private String name;
    private String nickName;
    @JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd kk:mm:ss",locale = "zh_CN")
    private Date date;
}
