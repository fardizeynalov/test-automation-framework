import org.testng.annotations.Test;

public class ApiTestCases {
    actions.ApiTest at = new actions.ApiTest();
    @Test
    public void verifyPostItem(){
        Object body = "{ \"name\": \"Apple MacBook Pro 16\", \"data\": { \"year\": 2019, \"price\": 1849.99, \"CPU model\": \"Intel Core i9\", \"Hard disk size\": \"1 TB\" } }";
        at.validateResponse(at.postApiRequest("https://api.restful-api.dev/objects",body),200);
    }

    @Test
    public void verifyGetItemByMultiId(){
        at.getApiResponse("https://api.restful-api.dev/objects?id=3&id=5&id=10");
        at.validateResponse(at.getApiResponse("https://api.restful-api.dev/objects?id=3&id=5&id=10"),200);
    }

    @Test
    public void getSingleItem(){
        at.validateResponse(at.getApiResponse("https://api.restful-api.dev/objects/7"),200);
    }

    @Test
    public void deleteItemAfterCreating(){
        Object body = "{ \"name\": \"Apple MacBook Pro 16\", \"data\": { \"year\": 2019, \"price\": 1849.99, \"CPU model\": \"Intel Core i9\", \"Hard disk size\": \"1 TB\" } }";
        at.validateResponse(at.postApiRequest("https://api.restful-api.dev/objects",body),200);
        at.validateResponse(at.deleteApiRequest("https://api.restful-api.dev/objects/ff80818192925da70192bff1dec36c71"),200); //add id from response of post request
    }

    @Test
    public void updateItem(){
        Object body = "{ \"name\": \"Apple MacBook Pro 16\", \"data\": { \"year\": 2019, \"price\": 2049.99, \"CPU model\": \"Intel Core i9\", \"Hard disk size\": \"1 TB\", \"color\": \"silver\" } }";
        at.validateResponse(at.putApiRequest("https://api.restful-api.dev/objects/7", body), 200);
    }
}
