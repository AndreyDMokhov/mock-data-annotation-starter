package com.naya.mockdata.annotation.annotation.injectrandom;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum MockDataType implements Type {
    EMAIL,
    PHONE_NUMBER,
    NAME;

    @Override
    public Type getType() {
        return null;
    }
}
