package com.jiashn.useJackson.domain.filter;

import com.fasterxml.jackson.annotation.JsonFilter;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author: jiangjs
 * @description:
 * @date: 2023/6/14 17:23
 **/
@Data
@JsonFilter("jsonFilter")
@AllArgsConstructor
public class UseJsonFilter {
    private String name;
    private String nickname;
}
