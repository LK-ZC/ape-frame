package com.jingdianjichi.tool.converter.base;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.ContextualSerializer;
import com.jingdianjichi.tool.converter.anno.CustomConverter;

import java.io.IOException;
import java.util.Objects;

/**
 * 默认数据转换器
 *
 * @author loser
 * @date 2023/07/22 10:40
 */
public class DefaultConverter<T, D> extends JsonSerializer<T> implements ContextualSerializer {

    /**
     * 转换器
     */
    private BaseConverter<T, D> converter;

    @Override
    public void serialize(T value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
        gen.writeObject(converter.doConvert(value));
    }

    /**
     * 设置转换器
     */
    @Override
    public JsonSerializer<?> createContextual(SerializerProvider prov, BeanProperty property) throws JsonMappingException {

        CustomConverter annotation = property.getAnnotation(CustomConverter.class);
        if (Objects.nonNull(annotation)) {
            Class<? extends BaseConverter> w = annotation.value();
            try {
                this.converter = w.newInstance();
                this.converter.property = property;
            } catch (Exception ignore) {
            }
            return this;
        }
        return prov.findValueSerializer(property.getType(), property);

    }

}
