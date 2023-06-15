package com.jiashn.useJackson;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.InjectableValues;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import com.jiashn.useJackson.domain.*;

import com.jiashn.useJackson.domain.custom.CustomDataEnter;
import com.jiashn.useJackson.domain.filter.UseJsonFilter;
import com.jiashn.useJackson.domain.identity.IdentityChild;
import com.jiashn.useJackson.domain.identity.IdentityParent;
import com.jiashn.useJackson.domain.referene.Child;
import com.jiashn.useJackson.domain.referene.Parent;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.Collections;
import java.util.Date;

@SpringBootTest
class UseJacksonApplicationTests {
    private final static Logger log = LoggerFactory.getLogger(UseJacksonApplicationTests.class);

    @Test
    void contextLoads() {
    }

    @Test
    public void mapToJson() throws JsonProcessingException {
        MapToJson getJson = new MapToJson("张三");
        getJson.setProperties("key1","属性1");
        getJson.setProperties("key2",2);
        String jsonStr = new ObjectMapper().writeValueAsString(getJson);
        log.info("@JsonAnyGetter序列化Map转json："+jsonStr);

        String json = "{\"name\":\"张三\",\"s\":\"属性1\",\"p\":2}";
        MapToJson setJson = new ObjectMapper().readerFor(MapToJson.class).readValue(json);
        log.info("@JsonAnySetter反序列化Json转实体："+setJson.getProperties());
    }

    @Test
    public void jsonGetAndSet() throws JsonProcessingException {
        JsonGetAndSet getJson = new JsonGetAndSet("zhangsan","张三");
        String jsonStr = new ObjectMapper().writeValueAsString(getJson);
        log.info("@JsonGetter序列化实体转json："+jsonStr);

        String json = "{\"name\":\"zhangsan\",\"nName\":\"张三\"}";
        JsonGetAndSet setJson = new ObjectMapper().readerFor(JsonGetAndSet.class).readValue(json);
        log.info("@JsonSetter反序列化Json转实体："+setJson.getName() + "," + setJson.getNickName());
    }

    @Test
    public void usePropertyOrder() throws JsonProcessingException {
        OrderProperty property = new OrderProperty(1, "zhangsan", "张三");
        String json = new ObjectMapper().writeValueAsString(property);
        log.info("未使用@JsonPropertyOrder排序："+json);

        UseOrderProperty propertyOrder = new UseOrderProperty(1, "zhangsan", "张三");
        String useJson = new ObjectMapper().writeValueAsString(propertyOrder);
        log.info("使用@JsonPropertyOrder排序："+useJson);

    }

    @Test
    public void useJsonRawValue() throws JsonProcessingException {
        String json = "{\"name\":\"zhangsan\",\"nName\":\"张三\"}";
        UseJsonCreator uc = new ObjectMapper().readerFor(UseJsonCreator.class).readValue(json);
        log.info("使用@JsonCreator输出实体："+uc.getName() + uc.getNickName());
    }

    @Test
    public void useJsonValue() throws JsonProcessingException {
        JsonValueDomain valueDomain = new JsonValueDomain("zhangsan", "张三");
        String json = new ObjectMapper().writeValueAsString(valueDomain);
        log.info("未使用@JsonValue输出json："+json);
    }

    @Test
    public void useJsonRootName() throws JsonProcessingException {
        OrderProperty property = new OrderProperty(1, "zhangsan", "张三");
        String json = new ObjectMapper().enable(SerializationFeature.WRAP_ROOT_VALUE).writeValueAsString(property);
        log.info("使用@JsonRootName："+json);
    }

    @Test
    public void useJsonCreator() throws JsonProcessingException {
        OrderProperty property = new OrderProperty(1, "zhangsan", "张三");
        String json = new ObjectMapper().enable(SerializationFeature.WRAP_ROOT_VALUE).writeValueAsString(property);
        log.info("使用@JsonRootName："+json);
    }

    @Test
    public void useJacksonInject() throws JsonProcessingException {
        String json = "{\"nickName\":\"张三\"}";
        InjectableValues.Std inject = new InjectableValues.Std().addValue(String.class, "zhangsan");
        UseJacksonInject uji = new ObjectMapper().reader(inject).forType(UseJacksonInject.class).readValue(json);
        log.info("使用@JacksonInject赋值实体："+uji.getName() + uji.getNickName());
    }
    @Test
    public void useJsonAlias() throws JsonProcessingException {
        String json = "{\"nName\":\"张三\",\"name\":\"zhangsan\"}";
        UseJsonAlias uji = new ObjectMapper().readerFor(UseJsonAlias.class).readValue(json);
        log.info("使用@UseJsonAlias别名赋值实体："+uji.getName() + uji.getNickName());
    }

    @Test
    public void useJsonIgnoreProperties() throws JsonProcessingException {
        UseJsonIgnoreProperties.IgnoreClass clazz = new UseJsonIgnoreProperties.IgnoreClass("zs","123456");
        UseJsonIgnoreProperties ignoreProperties = new UseJsonIgnoreProperties("zhangsan", "张三","男",clazz);
        String json = new ObjectMapper().writeValueAsString(ignoreProperties);
        log.info("使用@JsonIgnoreProperties与@JsonIgnore忽略设置字段："+json);
    }

    @Test
    public void useJsonInclude() throws JsonProcessingException {
        UseJsonInclude include = new UseJsonInclude("zhangsan", null, "男");
        String json = new ObjectMapper().writeValueAsString(include);
        log.info("使用@JsonInclude与@JsonIncludeProperties序列化："+json);
    }

    @Test
    public void useJsonAutoDetect() throws JsonProcessingException {
        UseJsonAutoDetect autoDetect = new UseJsonAutoDetect("zhangsan", "张三","男",30);
        String json = new ObjectMapper().writeValueAsString(autoDetect);
        log.info("使用@JsonAutoDetect序列化："+json);
    }

    @Test
    public void useJsonTypeInfo() throws JsonProcessingException {
        Dog dog = new Dog();
        dog.setBarkVolume(10d).setColor("黄白").setName("橙橙");
        String json = new ObjectMapper().writeValueAsString(dog);
        log.info("使用@JsonTypeInfo多态："+json);

        String cat = "{\"type\":\"cat\",\"name\":\"橙橙\",\"color\":\"黄白\",\"lives\":1,\"likesCream\":true}";
        Animal animal = new ObjectMapper().readerFor(Animal.class).readValue(cat);
        log.info("使用@JsonTypeInfo多态："+animal.getName());
    }

    @Test
    public void useJsonProperty() throws JsonProcessingException {
        UseJsonProperty jsonProperty = new UseJsonProperty("zhangsan", "张三",new Date());
        String json = new ObjectMapper().writeValueAsString(jsonProperty);
        log.info("使用@JsonFormat指定属性：" + json);
    }
    @Test
    public void useJsonUnwrapped() throws JsonProcessingException {
        UseJsonUnwrapped.Other other = new UseJsonUnwrapped.Other("张三", "男");
        UseJsonUnwrapped unwrapped = new UseJsonUnwrapped("zhangsan", other);
        String json = new ObjectMapper().writeValueAsString(unwrapped);
        log.info("使用@JsonUnwrapped序列化json：" + json);
    }
    @Test
    public void useJsonView() throws JsonProcessingException {
        UseJsonView view = new UseJsonView("zhangsan","张三", "男");
        String json = new ObjectMapper().writerWithView(Views.Public.class).writeValueAsString(view);
        log.info("使用@JsonView序列化json：" + json);
    }

    @Test
    public void useReference() throws JsonProcessingException {
        Child child = new Child("孩子");
        Parent parent = new Parent(1, "父辈", child);
        String json = new ObjectMapper().writeValueAsString(parent);
        log.info("使用@JsonManagedReference, @JsonBackReference序列化json：" + json);
    }
    @Test
    public void useJsonIdentityInfo() throws JsonProcessingException {
        IdentityChild identityChild = new IdentityChild();
        identityChild.setId(2).setChildName("孩子");
        IdentityParent parent = new IdentityParent();
        parent.setName("父辈").setId(1).setChildren(Collections.singletonList(identityChild));
        identityChild.setIdentityParent(parent);
        String json = new ObjectMapper().writeValueAsString(parent);
        log.info("使用@JsonIdentityInfo序列化json：" + json);
    }

    @Test
    public void useJsonFilter() throws JsonProcessingException {
        UseJsonFilter filter = new UseJsonFilter("zhangsan","张三");
        SimpleFilterProvider provider = new SimpleFilterProvider()
                .addFilter("jsonFilter", SimpleBeanPropertyFilter.filterOutAllExcept("nickname"));
        String json = new ObjectMapper().writer(provider).writeValueAsString(filter);
        log.info("使用@JsonFilter序列化json：" + json);
    }
    @Test
    public void useJacksonAnnotationsInside() throws JsonProcessingException {
        CustomDataEnter dataEnter = new CustomDataEnter(1, "zhangsan", null, "123456");
        String json = new ObjectMapper().writeValueAsString(dataEnter);
        log.info("使用@JacksonAnnotationsInside实现自定义注解序列化json：" + json);
    }

}
