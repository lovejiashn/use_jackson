package com.jiashn.useJackson.domain.identity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

/**
 * @author: jiangjs
 * @description:
 * @date: 2023/6/14 10:39
 **/
@Data
@Accessors(chain = true)
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property = "id")
public class IdentityParent {
    private Integer id;
    private String name;
    private List<IdentityChild> children;
}
