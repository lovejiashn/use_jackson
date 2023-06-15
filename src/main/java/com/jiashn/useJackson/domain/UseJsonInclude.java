package com.jiashn.useJackson.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonIncludeProperties;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author: jiangjs
 * @description:
 * @date: 2023/6/13 10:31
 **/
@Data
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIncludeProperties({"nickName","name"})
public class UseJsonInclude {
    private String name;
    private String nickName;
    private String gender;
}
