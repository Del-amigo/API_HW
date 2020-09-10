import POJOs.Country;
import io.restassured.http.*;
import org.apache.commons.lang3.RandomStringUtils;
import org.testng.annotations.*;
import java.util.*;
import static io.restassured.RestAssured.*;
// import static org.hamcrest.Matchers.*;

public class BasqarRestAssured_04 {
    Country body = new Country();
    private Cookies cookies;
    private String id;
    private final String countryName = "Tajikistan01";

    @BeforeClass
    public void initialization() {
        baseURI = "https://test.basqar.techno.study";

        Map<String, String> credentials = new HashMap<>();
        credentials.put( "username", "daulet2030@gmail.com" );
        credentials.put( "password", "TechnoStudy123@" );

        cookies = given()
                .contentType( ContentType.JSON )
                .body( credentials )
                .when()
                .post( "/auth/login" )
                .then()
                .statusCode( 200 )
                .extract().response().detailedCookies();
    }

    @Test
    public void createCountryTest() {
        body.setName( countryName );
        body.setCode(RandomStringUtils.randomAlphabetic(4));

        id = given()
                .cookies(cookies)
                .body(body)
                .contentType(ContentType.JSON)
                .when()
                .post("/school-service/api/countries")
                .then()
                .statusCode(201)
                .extract().jsonPath().getString("id");

        System.out.println(id);
    }

    @Test(dependsOnMethods = "createCountryTest")
    public void createCountry_Negative_Test() {
        body.setName( countryName );

         given()
                .cookies(cookies)
                .body(body)
                .contentType(ContentType.JSON)
                .when()
                .post("/school-service/api/countries")
                .then()
                .statusCode(400);
    }

    @Test(dependsOnMethods = "createCountry_Negative_Test")
    public void editCountryTest() {
        body.setId(id);
        body.setName(countryName.substring( 0,10 )+"07");
        body.setShortName(RandomStringUtils.randomAlphabetic(2));

        given()
                .cookies(cookies)
                .contentType(ContentType.JSON)
                .body(body)
                .when()
                .put("/school-service/api/countries")
                .then()
                .statusCode(200);
    }

    @Test(dependsOnMethods = "editCountryTest")
    public void deleteCountryTest() {
        given()
                .cookies(cookies)
                .when()
                .delete("/school-service/api/countries/" + id)
                .then()
                .statusCode(200);
    }

    @Test(dependsOnMethods = "deleteCountryTest")
    public void deleteCountry_Negative_Test(){
        given()
                .cookies(cookies)
                .when()
                .delete("/school-service/api/countries/" + id)
                .then()
                .statusCode(404);
    }
}
