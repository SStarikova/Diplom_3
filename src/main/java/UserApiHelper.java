import io.qameta.allure.Step;
import io.restassured.response.Response;

import java.net.HttpURLConnection;

import static io.restassured.RestAssured.given;

public class UserApiHelper {

    private static final String BASE_URL = "https://stellarburgers.nomoreparties.site";
    private static final String CREATE_USER = "/api/auth/register";
    private static final String LOGIN_USER = "/api/auth/login";
    private static final String DELETE_USER = "/api/auth/user";

    @Step("Создание пользователя через API")
    public void createUser(String email, String password, String name) {
        given()
                .baseUri(BASE_URL)
                .header("Content-Type", "application/json")
                .body("{\"email\":\"" + email + "\",\"password\":\"" + password + "\",\"name\":\"" + name + "\"}")
                .when()
                .post(CREATE_USER)
                .then().statusCode(HttpURLConnection.HTTP_OK);
    }

    @Step("Удаление пользователя через API")
    public void deleteUser(String email, String password) {
        String token = getAccessToken(email, password);
        given()
                .baseUri(BASE_URL)
                .header("Authorization", token)
                .when()
                .delete(DELETE_USER)
                .then().statusCode(HttpURLConnection.HTTP_ACCEPTED);
    }

    @Step("Получение accessToken через API")
    private String getAccessToken(String email, String password) {
        Response response = given()
                .baseUri(BASE_URL)
                .header("Content-Type", "application/json")
                .body("{\"email\":\"" + email + "\",\"password\":\"" + password + "\"}")
                .when()
                .post(LOGIN_USER)
                .then().statusCode(HttpURLConnection.HTTP_OK)
                .extract().response();

        return response.path("accessToken");
    }
}