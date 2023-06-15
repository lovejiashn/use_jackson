package com.jiashn.useJackson;

import com.jiashn.useJackson.desensitized.domain.UserInfo;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author: jiangjs
 * @description:
 * @date: 2023/6/15 11:24
 **/
@SpringBootTest
public class DesensitizedTest {
    private final static Logger log = LoggerFactory.getLogger(DesensitizedTest.class);

    @Test
    public void useDesensitized(){
        UserInfo userInfo = new UserInfo();
        userInfo.setId(1).setUserName("zhangsan").setNickName("张三")
                .setIdCard("450218199103458901")
                .setPhone("13456789012");
        log.info("自定义数据脱敏后数据：" + userInfo);
    }

}
