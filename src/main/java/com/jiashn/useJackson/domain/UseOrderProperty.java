package com.jiashn.useJackson.domain;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author: jiangjs
 * @description:
 * @date: 2023/6/12 14:40
 **/
@Data
@AllArgsConstructor
@JsonPropertyOrder({"name","nickName","id"})
public class UseOrderProperty {
    private int id;
    private String name;
    private String nickName;
}
