package com.naya.mock_data_annotation.annotation;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class MockDataAnnotationApplicationTests {

    private ApplicationContext context;


    @Before
    public void init() {
        context = new AnnotationConfigApplicationContext("com.naya.mock_data_annotation");
    }

    @Test
    public void injectRandomAnnotationPositive() {
        User user = context.getBean(User.class);

        Assert.assertNotNull(user.getEmail());
        Assert.assertNotNull(user.getName());
        Assert.assertNotNull(user.getPhoneNumber());

        System.out.println(user);


    }


}
