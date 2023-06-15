package com.jiashn.useJackson.domain.identity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author: jiangjs
 * @description:
 * @date: 2023/6/14 10:40
 **/
@Data
@Accessors(chain = true)
public class IdentityChild {
    private int id;
    private String childName;
    private IdentityParent identityParent;
}
