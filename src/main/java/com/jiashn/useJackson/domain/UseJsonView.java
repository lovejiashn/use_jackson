package com.jiashn.useJackson.domain;

import com.fasterxml.jackson.annotation.JsonView;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author: jiangjs
 * @description:
 * @date: 2023/6/14 10:15
 **/
@Data
@AllArgsConstructor
public class UseJsonView {
    @JsonView(Views.Public.class)
    private String name;
    @JsonView(Views.Public.class)
    private String nickName;
    @JsonView(Views.Internal.class)
    private String gender;
}
