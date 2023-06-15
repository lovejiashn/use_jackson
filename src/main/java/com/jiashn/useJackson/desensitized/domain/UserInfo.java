package com.jiashn.useJackson.desensitized.domain;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.jiashn.useJackson.desensitized.DesensitizedStrategy;
import com.jiashn.useJackson.desensitized.JsonSensitive;
import com.jiashn.useJackson.typeChange.TypeChange;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * @author: jiangjs
 * @description:
 * @date: 2022/4/15 11:33
 **/
@Data
@Accessors(chain = true)
@EqualsAndHashCode
public class UserInfo implements Serializable{

    /**
     * 主键
     */
    private Integer id;

    /**
     * 用户名
     */
    private String userName;

    /**
     * 昵称
     */
    @JsonSensitive(strategy = DesensitizedStrategy.USER_NAME)
    private String nickName;

    /**
     * 手机号
     */
    @JsonSensitive(strategy = DesensitizedStrategy.PHONE)
    private String phone;

    /**
     * 身份证号
     */
    @JsonSensitive(strategy = DesensitizedStrategy.ID_CARD)
    private String idCard;

    /**
     * 创建时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss",timezone = "GTM+8")
    private Date createTime;

    @TypeChange(replace = {"1_男","2_女"})
    private Integer gender;

    private static final long serialVersionUID = 1L;
}