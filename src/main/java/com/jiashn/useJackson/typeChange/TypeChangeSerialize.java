package com.jiashn.useJackson.typeChange;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.ser.ContextualSerializer;
import lombok.AllArgsConstructor;

import java.io.IOException;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author: jiangjs
 * @description:
 * @date: 2023/6/15 16:21
 **/
@AllArgsConstructor
public class TypeChangeSerialize extends JsonSerializer<Object> implements ContextualSerializer {

    private final String[] annotationValues;

    @Override
    public void serialize(Object value, JsonGenerator gen, SerializerProvider provider) throws IOException {
        String[] types = this.annotationValues;
        Map<String, String> typeMap = new ConcurrentHashMap<>();
        if (Objects.nonNull(types) && types.length > 0) {
            for (String type : types) {
                String[] s = type.split("_");
                typeMap.put(s[0],s[1]);
            }
        }
        gen.writeString(typeMap.get(String.valueOf(value)));
    }

    @Override
    public JsonSerializer<?> createContextual(SerializerProvider provider, BeanProperty property) throws JsonMappingException {
        if (Objects.isNull(property)){
            return provider.findNullValueSerializer(null);
        }
        //校验当前bean是否为String
        if (Objects.equals(property.getType().getRawClass(),String.class) ||
                Objects.equals(property.getType().getRawClass(),Integer.class)){
            TypeChange typeChange = property.getAnnotation(TypeChange.class);
            if (Objects.isNull(typeChange)){
                typeChange = property.getContextAnnotation(TypeChange.class);
            }
            if (Objects.nonNull(typeChange)){
                return new TypeChangeSerialize(typeChange.replace());
            }
        }
        return provider.findValueSerializer(property.getType(), property);
    }
}
