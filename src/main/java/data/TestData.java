package data;

import java.util.HashMap;
import java.util.Map;

public class TestData {
    public static String getTestData(String key){
        Map<String, String> testData = new HashMap<>();
        testData.put("username", "FardiZeynal");
        testData.put("password", "SalamWorld");
        testData.put("age", "22");

        return testData.getOrDefault(key, "Test data not found for given key: " + key);
    }
}
