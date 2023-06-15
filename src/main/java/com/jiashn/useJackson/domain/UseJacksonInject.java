package com.jiashn.useJackson.domain;

import com.fasterxml.jackson.annotation.JacksonInject;
import lombok.Data;

/**
 * @author: jiangjs
 * @description:
 * @date: 2023/6/13 9:32
 **/
@Data
public class UseJacksonInject {

    @JacksonInject
    private String name;

    private String nickName;
}
