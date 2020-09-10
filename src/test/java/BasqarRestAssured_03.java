import POJOs.GradeLevels;
import io.restassured.http.*;
import org.testng.annotations.*;
import java.util.*;
import static io.restassured.RestAssured.*;

public class BasqarRestAssured_03 {
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
    public void CreatingNewGradeLevel() {
        GradeLevels levels = new GradeLevels();
        new Random().nextInt( 5 );
        levels.setName( "100th grade" );
        levels.setShortName( "100th" );
        levels.setOrder( new Random().nextInt( 10 ) );
        levels.setActive( true );

        id = given()
                .cookies( cookies )
                .body( levels )
                .contentType( ContentType.JSON )
                .when()
                .post( "/school-service/api/grade-levels" )
                .then()
                .statusCode( 201 )
                .extract().jsonPath().getString( "id" );

        //       System.out.println(id);
    }

    @Test(dependsOnMethods = "CreatingNewGradeLevel")
    public void UpdatingGradeLevel() {
        GradeLevels levels = new GradeLevels();
        levels.setId( id );
        levels.setName( "1009th grade" );
        levels.setShortName( "1009th" );

        given()
                .cookies( cookies )
                .contentType( ContentType.JSON )
                .body( levels )
                .when()
                .put( "/school-service/api/grade-levels" )
                .then()
                .statusCode( 200 );
    }

    @Test(dependsOnMethods = "CreatingNewGradeLevel", priority = 1)
    public void DeletingGradeLevel() {
        given()
                .cookies( cookies )
                .when()
                .delete( "/school-service/api/grade-levels/" + id )
                .then()
                .statusCode( 200 );
    }
}
