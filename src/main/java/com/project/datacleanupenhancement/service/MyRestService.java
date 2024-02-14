package com.project.datacleanupenhancement.service;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

@Service
public class MyRestService {

    public List<Map<String, Object>> cleanData(List<Map<String, Object>> inputData) {
        inputData.forEach(this::cleanTuple);
        return inputData;
    }

    public List<Map<String, Object>> enhanceData(List<Map<String, Object>> inputData) {
        inputData.forEach(this::enhanceTuple);
        return inputData;
    }

    private void enhanceTuple(Map<String, Object> tuple) {
        tuple.forEach((key, value) -> {
            if (value == null || value.toString().isEmpty()) {
                // Handle null or empty values separately
                handleNullValue(tuple, key);
            } else {
                // Handle non-null and non-empty values
                handleNonNullValue(tuple, key, value);
            }
        });
    }

    private void handleNullValue(Map<String, Object> tuple, String key) {
        // Set default values for null or empty values
        switch (key) {
            case "naam":
                tuple.put(key, "default");
                break;
            case "mark":
                tuple.put(key, 0);
                break;
            case "mail":
                tuple.put(key, "default@example.com");
                break;
            case "ph":
                tuple.put(key, "0000000000");
                break;
            case "dob":
                tuple.put(key, "YYYY-MM-DD");
                break;
            default:
                break;
        }
    }

    private void handleNonNullValue(Map<String, Object> tuple, String key, Object value) {
        // Regular expressions for validation
        String nameRegex = "^[a-zA-Z\\s-]+$";
        String marksRegex = "^(100|0?\\d{1,2})$";
        String emailRegex = "^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$";
        String dobRegex = "^\\d{4}/\\d{2}/\\d{2}$";
        String phoneRegex = "^[1-9]\\d{9}$";

        // Check the value type and match against regular expressions
        if (value instanceof String) {
            String strValue = (String) value;
            switch (key) {
                case "naam":
                    if (!Pattern.matches(nameRegex, strValue)) {
                        tuple.put(key, "default");
                    }
                    break;
                case "mark":
                    if (!Pattern.matches(marksRegex, strValue)) {
                        tuple.put(key, 0);
                    }
                    break;
                case "mail":
                    if (!Pattern.matches(emailRegex, strValue)) {
                        tuple.put(key, "default@example.com");
                    }
                    break;
                case "ph":
                    if (!Pattern.matches(phoneRegex, strValue)) {
                        tuple.put(key, "0000000000");
                    }
                    break;
                case "dob":
                    if (!Pattern.matches(dobRegex, strValue)) {
                        tuple.put(key, "YYYY-MM-DD");
                    }
                    break;
                default:
                    break;
            }
        }
    }

    private void cleanTuple(Map<String, Object> tuple) {
        tuple.values().removeIf(value -> value == null || value.toString().isEmpty());
    }
}
