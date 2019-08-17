package com.naya.mock_data_annotation.annotation.inject_random.handlers;


import com.github.javafaker.Faker;
import com.naya.mock_data_annotation.annotation.inject_random.MockDataType;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Service;

@Service("EMAIL")
@AllArgsConstructor
@Data
public class EmailMockRandomDataHandlerImpl implements MockRandomDataHandler {

    private Faker faker;

    @Override
    public String data() {
        return faker.internet().emailAddress();
    }

    @Override
    public MockDataType getType() {
        return MockDataType.EMAIL;
    }
}
