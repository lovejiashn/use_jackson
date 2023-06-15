package com.jiashn.useJackson.domain;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author: jiangjs
 * @description:
 * @date: 2023/6/12 15:55
 **/
@Data
@AllArgsConstructor
public class JsonValueDomain {
    private String name;
    @JsonValue
    private String nickName;
}
