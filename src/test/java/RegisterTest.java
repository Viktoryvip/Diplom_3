import user.*;
import pageobject.*;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.Response;
import org.junit.After;
import org.junit.Test;
import static com.codeborne.selenide.Selenide.open;
import static org.junit.Assert.*;

public class RegisterTest {
    UserClient userClient;
    protected String name = UserGenerator.getRandomUser().getName();
    protected String email = UserGenerator.getRandomUser().getEmail();
    protected String password = UserGenerator.getRandomUser().getPassword();
    protected String incorrectPassword = "****";

    @Test
    @DisplayName("Создание нового пользователя с корректными данными")
    public void userRegisterValidDataTest() {
        open(MainPage.URL_MAIN, MainPage.class)
                .clickLoginButton()
                .clickRegistrationButtonLoginPage()
                .setName(name)
                .setEmail(email)
                .setPassword(password)
                .clickConfirmRegistrationButton()
                .loginRegisterUser(email, password);
        String currentUrl = WebDriverRunner.getWebDriver().getCurrentUrl();
        assertEquals( "https://stellarburgers.nomoreparties.site/login", currentUrl);
    }

    @Test
    @DisplayName("Создание пользователя с некорректным паролем")
    public void userRegisterNoValidDataTest() {
        boolean noValidDataRegister = open(MainPage.URL_MAIN, MainPage.class)
                .clickLoginButton()
                .clickRegistrationButtonLoginPage()
                .setName(name)
                .setEmail(email)
                .setPassword(incorrectPassword)
                .clickConfirmRegistrationButton()
                .errorPasswordMessageGetText()
                .clickEnterLinkButton()
                .loginRegisterUser(email, incorrectPassword)
                .isErrorMessageAppear();
        assertTrue(noValidDataRegister);
    }

    @After
    public void tearDown(){
        userClient = new UserClient();
        UserCredentials userCredentials = new UserCredentials(email, password);
        Response response = userClient.login(userCredentials);
        if (response.body().jsonPath().getString("accessToken") != null) {
            userClient.delete(response);
        }
        UserCredentials userNoValidCredentials = new UserCredentials(email, incorrectPassword);
        Response noValidResponse = userClient.login(userNoValidCredentials);
        if (noValidResponse.body().jsonPath().getString("accessToken") != null) {
            userClient.delete(noValidResponse);
        }
    }
}
