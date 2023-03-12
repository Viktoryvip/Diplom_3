package user;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class BaseSite {

    public static final String BASE_URL = "https://stellarburgers.nomoreparties.site/api/";
    public static RequestSpecification getBaseSpecSettings() {
        return new RequestSpecBuilder()
                .setContentType(ContentType.JSON)
                .setBaseUri(BASE_URL)
                .build();
    }
}