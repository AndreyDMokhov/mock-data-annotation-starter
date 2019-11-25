package com.naya.mockdata.annotation;

import com.naya.mockdata.annotation.annotation.injectrandom.InjectRandom;

import com.naya.mockdata.annotation.annotation.injectrandom.MockDataType;
import lombok.Getter;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;


@Scope("prototype")
@Getter
public class User {

    @InjectRandom(type = MockDataType.NAME)
    private String name;
    @InjectRandom(type = MockDataType.PHONE_NUMBER)
    private String phoneNumber;
    @InjectRandom(type = MockDataType.EMAIL)
    private String email;

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
