package com.naya.mockdata.annotation.annotation.injectrandom.handlers;

import com.github.javafaker.Faker;

import com.naya.mockdata.annotation.annotation.injectrandom.MockDataType;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Service;


@AllArgsConstructor
@Data
public class PhoneNumberMockRandomDataHandlerImpl implements MockRandomDataHandler {

    private Faker faker;

    @Override
    public String data() {

        return faker.phoneNumber().cellPhone();
    }

    @Override
    public MockDataType getType() {
        return MockDataType.PHONE_NUMBER;
    }
}
