package data;

import org.testng.annotations.DataProvider;

import java.util.HashMap;
import java.util.Map;

public class TestData {
    public String getTestData(String key){
        Map<String, String> testData = new HashMap<>();
        testData.put("mail", "add yours");
        testData.put("password", "add yours");
        testData.put("age", "22");
        testData.put("bookName", "Rezonans Kanunu");
        testData.put("username", "Fardi Zeynalov");

        return testData.getOrDefault(key, "Test data not found for given key: " + key);
    }

    @DataProvider(name = "addresses")
    public Object[][] getDataProvider(){

        return new Object[][] {
                {"inshaatchilar pr 55"}
        };

    }

}
