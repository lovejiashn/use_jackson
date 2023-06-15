package com.jiashn.useJackson.desensitized.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jiashn.useJackson.desensitized.domain.UserInfo;
import org.springframework.web.bind.annotation.*;

/**
 * @author: jiangjs
 * @description: 赋值
 * @date: 2023/6/15 11:31
 **/
@RestController
@RequestMapping("/desensitized")
public class DesensitizedController {

    @GetMapping("/getUserInfo.do")
    public UserInfo getUserInfo(){
        UserInfo userInfo = new UserInfo();
        userInfo.setId(1).setUserName("zhangsan").setNickName("张三")
                .setIdCard("450218199103458901")
                .setPhone("13456789012").setGender(1);
        return userInfo;
    }

    @PostMapping("/addUser.do")
    public UserInfo getUser(@RequestBody UserInfo userInfo) throws JsonProcessingException {
        return new ObjectMapper().readerFor(UserInfo.class).readValue(new ObjectMapper().writeValueAsString(userInfo));
    }
}
