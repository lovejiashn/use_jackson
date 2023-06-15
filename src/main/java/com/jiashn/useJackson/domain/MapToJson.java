package com.jiashn.useJackson.domain;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: jiangjs
 * @description: 使用@JsonAnyGetter将map序列化成json
 * @date: 2023/6/12 11:17
 **/
public class MapToJson {

    public MapToJson(){};

    public MapToJson(String name){
        this.name = name;
    };

    private String name;
    private final Map<String,Object> properties = new HashMap<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @JsonAnyGetter
    public Map<String,Object> getProperties(){
        return properties;
    }

    @JsonAnySetter
    public void setProperties(String key,Object value){
        this.properties.put(key,value);
    }
}
