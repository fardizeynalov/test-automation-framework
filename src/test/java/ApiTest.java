import org.testng.annotations.Test;

public class ApiTest {
    actions.ApiTest at = new actions.ApiTest();
    @Test
    public void getPic(){
        at.getApiResponse("http://web2.anl.az:81/read/img.php?bibid=439264&pno=47");
    }
}
