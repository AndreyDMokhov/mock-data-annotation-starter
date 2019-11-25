package com.naya.mockdata.annotation.configuration;

import com.github.javafaker.Faker;
import com.naya.mockdata.annotation.User;
import com.naya.mockdata.annotation.annotation.injectrandom.InjectRandomAnnotationBeanPostProcessor;
import com.naya.mockdata.annotation.annotation.injectrandom.Type;
import com.naya.mockdata.annotation.annotation.injectrandom.handlers.EmailMockRandomDataHandlerImpl;
import com.naya.mockdata.annotation.annotation.injectrandom.handlers.MockRandomDataHandler;
import com.naya.mockdata.annotation.annotation.injectrandom.handlers.NameMockRandomDataHandlerImpl;
import com.naya.mockdata.annotation.annotation.injectrandom.handlers.PhoneNumberMockRandomDataHandlerImpl;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.toMap;

@Configuration
@ConditionalOnClass(Faker.class)
public class Config {

    @Bean
    public Faker faker() {
        return Faker.instance();
    }

    @Bean
    public Map<Type, MockRandomDataHandler> initMap(List<MockRandomDataHandler> handlersList) {
        return handlersList.stream().collect(toMap(MockRandomDataHandler::getType, v -> v));
    }
    @Bean
    public EmailMockRandomDataHandlerImpl emailMockRandomDataHandler() {
        return new EmailMockRandomDataHandlerImpl(faker());
    }

    @Bean
    public NameMockRandomDataHandlerImpl nameMockRandomDataHandler() {
        return new NameMockRandomDataHandlerImpl(faker());
    }

    @Bean
    public PhoneNumberMockRandomDataHandlerImpl phoneNumberMockRandomDataHandler() {
        return new PhoneNumberMockRandomDataHandlerImpl(faker());
    }

    @Bean
    public InjectRandomAnnotationBeanPostProcessor injectRandomAnnotationBeanPostProcessor() {
        return new InjectRandomAnnotationBeanPostProcessor();
    }
    @Bean
    public User user() {
        return new User();
    }





}
