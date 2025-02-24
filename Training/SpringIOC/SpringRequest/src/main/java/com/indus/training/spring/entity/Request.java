package com.indus.training.spring.entity;

import java.util.HashMap;
import java.util.Map;

public class Request {
    private Map<String, String> formData;

    public Request() {
        this.formData = new HashMap<>();
    }

    public void addFormData(String key, String value) {
        formData.put(key, value);
    }

    public String getFormData(String key) {
        return formData.get(key);
    }

    public Map<String, String> getAllFormData() {
        return formData;
    }
}
