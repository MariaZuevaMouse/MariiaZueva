package com.marizueva.laboratory.hw5.context;

import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.Map;

public final class TestContext {
    private static TestContext instance;

    private Map<String, Object> context = new HashMap<>();

    private TestContext() {
    }

    public void setTestObject(String key, Object object){
        context.put(key, object);
    }

    public <T> T getTestObject(String key) {
        return context;
    }

    public static TestContext getInstance(){
        if (instance == null) {
            instance = new TestContext();
        }
        return instance;
    }
}
