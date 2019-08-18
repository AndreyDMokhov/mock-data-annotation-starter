package com.naya.mockdata.annotation.annotation.injectrandom;

import com.naya.mockdata.annotation.annotation.injectrandom.handlers.MockRandomDataHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.Map;

@Component
@RequiredArgsConstructor
public class InjectRandomAnnotationBeanPostProcessor implements BeanPostProcessor {

    @Autowired
    private Map<MockDataType, MockRandomDataHandler> handlers;

    public InjectRandomAnnotationBeanPostProcessor(Map<MockDataType, MockRandomDataHandler> handlers) {
        this.handlers = handlers;
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        Field[] fields = bean.getClass().getDeclaredFields();
        for (Field field : fields) {
            InjectRandom annotation = field.getAnnotation(InjectRandom.class);
            if (annotation != null) {
                MockDataType type = annotation.type();
                MockRandomDataHandler mockRandomDataHandler = handlers.get(type);
                String value = mockRandomDataHandler.data();
                field.setAccessible(true);
                ReflectionUtils.setField(field, bean, value);
            }
        }
        return bean;
    }


    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }

    public void setHandlers(Map<MockDataType, MockRandomDataHandler> handlers) {
        this.handlers = handlers;
    }
}
