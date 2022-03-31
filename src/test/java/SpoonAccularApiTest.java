import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import net.javacrumbs.jsonunit.JsonAssert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;
import java.net.URL;
import java.util.Locale;


import static net.javacrumbs.jsonunit.core.Option.IGNORING_ARRAY_ORDER;
import static org.hamcrest.Matchers.*;


public class SpoonAccularApiTest extends BaseTest {

    private static final String API_KEY = "e256311898d64a67868915573dda48ef";
    private static final String BASE_URL = "https://api.spoonacular.com";

    @BeforeAll
    static void beforeAll() {

        RestAssured.baseURI = BASE_URL;

        RestAssured.requestSpecification = new RequestSpecBuilder()
                .addQueryParam("apiKey", API_KEY)
                .build();

        RestAssured.responseSpecification = new ResponseSpecBuilder()
                .expectResponseTime(lessThan(3000L))
                .expectStatusCode(200)
                .build();
    }

    @Test

    void testGetComplexSearchBurger() throws IOException {

        String actually = RestAssured.given()
                .queryParam("query", "burger")
                .queryParam("cuisine", "european")
                .log()
                .uri()
                .expect()
                .log()
                .body()
                .when()
                .get("recipes/complexSearch")
                .body()
                .asPrettyString();

        String expected = getResourceAsString("expected.json");

        JsonAssert.assertJsonEquals(
                expected,
                actually,
                JsonAssert.when(IGNORING_ARRAY_ORDER)
        );

    }
    @Test
    void testGetComplexSearchPojo() throws IOException {

        RecipesSearchResponse actually = RestAssured.given()
                .queryParam("query", "burger")
                .queryParam("cuisine", "italian")
                .log()
                .uri()
                .expect()
                .log()
                .body()
                .when()
                .get("recipes/complexSearch")
                .body()
                .as(RecipesSearchResponse.class);

        System.out.println(actually);

        for (RecipesSearchResponseItem item : actually.getResults()) {
            Assertions.assertNotNull(item.getId());
            Assertions.assertTrue(item.getTitle().toLowerCase(Locale.ROOT).contains("burger"));
            Image image = ImageIO.read(new URL(item.getImage()));
            Assertions.assertNotNull(image);
        }

    }


    @Test
    void testAddToShoppingListPojo(){
                RestAssured.given()
                .queryParam("username", "Falafel Burger")
                .queryParam("id", "642539")
                .log()
                .uri()
                .expect()
                .log()
                .body()
                .when()
                .post("https://api.spoonacular.com/mealplanner/shopping-list/items")
                .body()
                .as(RecipesSearchResponse.class);


    }


    @Test
    void testGetShoppingListPojo(){
                RestAssured.given()
                .queryParam("username", "dsky")
                .queryParam("hash", "e256311898d64a67868915573dda48ef")
                .log()
                .uri()
                .expect()
                .log()
                .body()
                .when()
                .get("https://api.spoonacular.com/mealplanner/{username}/shopping-list")
                .body()
                .as(RecipesSearchResponse.class);



    }
    @Test
    void testDeleteFromShoppingListPojo(){
                RestAssured.given()
                .queryParam("username", "Falafel Burger")
                .queryParam("id", "642539")
                .log()
                .uri()
                .expect()
                .log()
                .body()
                .when()
                .delete("https://api.spoonacular.com/mealplanner/{username}/shopping-list/items/{id}")
                .body()
                .as(RecipesSearchResponse.class);

    }
}