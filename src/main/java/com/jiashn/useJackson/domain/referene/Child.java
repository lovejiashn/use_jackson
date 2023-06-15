package com.jiashn.useJackson.domain.referene;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import java.util.List;

/**
 * @author: jiangjs
 * @description:
 * @date: 2023/6/14 10:40
 **/
@Data
public class Child {
    private String childName;

    @JsonBackReference
    List<Parent> parent;

    public Child(){}

    public Child(String childName){this.childName = childName;}
}
