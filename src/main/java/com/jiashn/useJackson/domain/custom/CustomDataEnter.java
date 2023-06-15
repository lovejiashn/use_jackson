package com.jiashn.useJackson.domain.custom;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author: jiangjs
 * @description:
 * @date: 2023/6/15 10:11
 **/
@Data
@AllArgsConstructor
@DataOrderAndFilter
public class CustomDataEnter {
    private Integer id;
    private String name;
    private String nickName;
    private String password;
}
