package com.jiashn.useJackson.domain;

import com.fasterxml.jackson.annotation.JacksonInject;
import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.Data;

/**
 * @author: jiangjs
 * @description:
 * @date: 2023/6/13 9:50
 **/
@Data
public class UseJsonAlias {
    private String name;
    @JsonAlias({"nName","pName"})
    private String nickName;
}
