package com.jiashn.useJackson.domain;

import com.fasterxml.jackson.annotation.JsonUnwrapped;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author: jiangjs
 * @description:
 * @date: 2023/6/14 10:07
 **/
@Data
@AllArgsConstructor
public class UseJsonUnwrapped {

    private String name;
    @JsonUnwrapped
    private Other other;

    @Data
    @AllArgsConstructor
    public static class Other{
        private String nickName;
        private String gender;
    }
}
