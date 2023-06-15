package com.jiashn.useJackson.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonRootName;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author: jiangjs
 * @description:
 * @date: 2023/6/12 14:35
 **/
@Data
@AllArgsConstructor
@JsonRootName(value = "property")
public class OrderProperty {
    private int id;
    private String name;
    private String nickName;
}
