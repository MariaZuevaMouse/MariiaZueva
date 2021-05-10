package com.marizueva.laboratory.hw5.context;

import java.util.HashMap;
import java.util.Map;

public final class TestContext {

    private static TestContext instance;

    public static final String WEB_DRIVER = "driver";
    public static String ALL_LOGS_FROM_DIFFERENT_ELEMENT_PAGE = "different element logs";

    private final Map<String, Object> context = new HashMap<>();

    private TestContext() {
    }

    public void setTestObject(String key, Object object) {
        context.put(key, object);
    }

    public <T> T getTestObject(String key)  {
        return (T) context.get(key);
    }

    public static TestContext getInstance() {
        if (instance == null) {
            instance = new TestContext();
        }
        return instance;
    }

    public void clearContext() {
        context.clear();
    }
}
