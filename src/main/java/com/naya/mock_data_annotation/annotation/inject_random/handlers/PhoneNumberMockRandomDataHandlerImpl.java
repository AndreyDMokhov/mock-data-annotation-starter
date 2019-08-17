package com.naya.mock_data_annotation.annotation.inject_random.handlers;

import com.github.javafaker.Faker;
import com.naya.mock_data_annotation.annotation.inject_random.MockDataType;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Service;

@Service("PHONE_NUM")
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
