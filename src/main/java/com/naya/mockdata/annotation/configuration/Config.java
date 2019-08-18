package com.naya.mockdata.annotation.configuration;

import com.github.javafaker.Faker;
import com.naya.mockdata.annotation.annotation.injectrandom.InjectRandomAnnotationBeanPostProcessor;
import com.naya.mockdata.annotation.annotation.injectrandom.MockDataType;
import com.naya.mockdata.annotation.annotation.injectrandom.handlers.MockRandomDataHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.toMap;

@Configuration
@ComponentScan({"com.naya"})
@ConditionalOnClass(Faker.class)
public class Config {

    @Bean
    @ConditionalOnMissingBean
    public Faker faker() {
        return Faker.instance();
    }

    @Bean
    public Map<MockDataType, MockRandomDataHandler> initMap(@Autowired List<MockRandomDataHandler> handlersList) {
        return handlersList.stream().collect(toMap(MockRandomDataHandler::getType, v -> v));
    }

    @Bean
    @ConditionalOnMissingBean
    public InjectRandomAnnotationBeanPostProcessor injectRandomAnnotationBeanPostProcessor(Map<MockDataType, MockRandomDataHandler> handlers) {
        return new InjectRandomAnnotationBeanPostProcessor(handlers);
    }




}
