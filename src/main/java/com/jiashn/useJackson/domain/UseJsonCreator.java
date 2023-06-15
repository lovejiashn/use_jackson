package com.jiashn.useJackson.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * @author: jiangjs
 * @description:
 * @date: 2023/6/13 9:17
 **/
@Data
public class UseJsonCreator {

    private String name;
    private String nickName;

    @JsonCreator
    public UseJsonCreator(@JsonProperty("name") String name,
                          @JsonProperty("nName") String nickName){
        this.name = name;
        this.nickName = nickName;
    }
}
