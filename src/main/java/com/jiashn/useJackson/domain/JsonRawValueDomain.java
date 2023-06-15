package com.jiashn.useJackson.domain;

import com.fasterxml.jackson.annotation.JsonRawValue;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author: jiangjs
 * @description: 使用@JsonRawValue
 * @date: 2023/6/12 14:55
 **/
@Data
@AllArgsConstructor
public class JsonRawValueDomain {
    private String name;
    @JsonRawValue
    private String json;
}
