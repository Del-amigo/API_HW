import POJOs.BankAccounts;
import io.restassured.http.*;
import org.apache.commons.lang3.RandomStringUtils;
import org.testng.annotations.*;
import java.util.*;
import static io.restassured.RestAssured.*;

public class BasqarRestAssured_01 {
    private Cookies cookies;
    private String id;

    @BeforeClass
    public void init() {
        baseURI = "https://test.basqar.techno.study";

        Map<String, String> credentials = new HashMap<>();
        credentials.put( "username", "daulet2030@gmail.com" );
        credentials.put( "password", "TechnoStudy123@" );

        cookies = given()
                .contentType( ContentType.JSON )
                .body( credentials )
//                .body("{\"username\":\"daulet2030@gmail.com\",\"password\":\"TechnoStudy123@\",\"rememberMe\":false}")
                .when()
                .post( "/auth/login" )
                .then()
                .statusCode( 200 )
                .extract().response().detailedCookies();
    }

    @Test
    public void Creation() {
        BankAccounts accounts = new BankAccounts();
        String randomName = randomText( 5 );
        accounts.setName( randomName );
        accounts.setIban( randomText( 4 ) );
        accounts.setCurrency( "USD" );
        accounts.setIntegrationCode( randomText( 3 ) );
        accounts.setSchoolId( "5c5aa8551ad17423a4f6ef1d" );

        id = given()
                .cookies( cookies )
                .body( accounts )
                .contentType( ContentType.JSON )
                .when()
                .post( "/school-service/api/bank-accounts" )
                .then()
                .statusCode( 201 )
                .extract().jsonPath().getString( "id" );

        System.out.println( randomName );
    }

    @Test(dependsOnMethods = "Creation" )
    public void Deleting(){
        given()
                .cookies( cookies )
                .when()
                .delete("/school-service/api/bank-accounts/"+id)
                .then()
                .statusCode(200);
    }

    private String randomText(int num) {
        return RandomStringUtils.randomAlphabetic( num );
    }
}
