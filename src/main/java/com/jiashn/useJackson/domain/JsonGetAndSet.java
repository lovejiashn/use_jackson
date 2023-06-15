package com.jiashn.useJackson.domain;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;

/**
 * @author: jiangjs
 * @description: 使用@JsonGetter或@JsonSetter
 * @date: 2023/6/12 14:12
 **/
public class JsonGetAndSet {

    public JsonGetAndSet(String name,String nickName){
        this.name = name;
        this.nickName = nickName;
    }

    private String name;

    private String nickName;

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }


    @JsonGetter("nName")
    public String getNickName() {
        return nickName;
    }
    @JsonSetter("nName")
    public void setNickName(String nickName) {
        this.nickName = nickName;
    }
}
