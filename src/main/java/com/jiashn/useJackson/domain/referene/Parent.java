package com.jiashn.useJackson.domain.referene;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

/**
 * @author: jiangjs
 * @description:
 * @date: 2023/6/14 10:39
 **/
@Data
@AllArgsConstructor
public class Parent {

    private Integer id;
    private String name;

   @JsonManagedReference
    Child children;
}
