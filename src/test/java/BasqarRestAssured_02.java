import POJOs.Locations;
import POJOs.School;
import io.restassured.http.*;
import org.apache.commons.lang3.RandomStringUtils;
import org.testng.annotations.*;
import java.util.*;
import static io.restassured.RestAssured.*;

public class BasqarRestAssured_02 {
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
                .when()
                .post( "/auth/login" )
                .then()
                .statusCode( 200 )
                .extract().response().detailedCookies();
    }

    @Test
    public void CreatingNewLocation() {
        Locations locations = new Locations();
        School school = new School();
        String randomLocationName = randomText( 8 );
        locations.setName(randomLocationName);
        locations.setShortName( randomText( 4 ) );
        locations.setType( "CLASS" );
        locations.setCapacity( 4 );
        school.setId( "5c5aa8551ad17423a4f6ef1d" );
        school.setBBBServerEnabled( false );
        locations.setSchool( school );

        id = given()
                .cookies( cookies )
 //               .log().body()
                .body( locations )
                .contentType( ContentType.JSON )
                .when()
                .post( "/school-service/api/location" )
                .then()
                .statusCode( 201 )
                .extract().jsonPath().getString( "id" );

        System.out.println(randomLocationName);
        System.out.println( id );
    }

    @Test(dependsOnMethods = "CreatingNewLocation")
    public void DeletingLocation(){
        given()
                .cookies( cookies )
                .when()
                .delete("/school-service/api/location/"+id)
                .then()
                .statusCode( 200 );
    }

    private String randomText(int num) {
        return RandomStringUtils.randomAlphabetic( num );
    }
}
