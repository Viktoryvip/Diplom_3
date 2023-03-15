import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import pageobject.*;
import static com.codeborne.selenide.Selenide.open;

public class LoginTest extends BaseTest {

    @Test
    @DisplayName("вход по кнопке «Войти в аккаунт» на главной")
    public void authButtonMainPageAuthTest() {
        open(MainPage.URL_MAIN, MainPage.class)
                .clickLoginButton()
                .setEmail(user.getEmail())
                .setPassword(user.getPassword())
                .clickLoginPageAuthButton()
                .isCreateOrderButtonAppear();
    }

    @Test
    @DisplayName("вход через кнопку «Личный кабинет»")
    public void authButtonProfileAuthTest() {
        open(MainPage.URL_MAIN, MainPage.class)
                .clickProfileButtonBeforeAuth()
                .setEmail(user.getEmail())
                .setPassword(user.getPassword())
                .clickLoginPageAuthButton()
                .isCreateOrderButtonAppear();
    }

    @Test
    @DisplayName("вход через кнопку в форме регистрации")
    public void authButtonRegistrationAuthTest() {
        open(RegisterPage.URL_REGISTER, RegisterPage.class)
                .clickRegistrationPageAuthButton()
                .setEmail(user.getEmail())
                .setPassword(user.getPassword())
                .clickLoginPageAuthButton()
                .isCreateOrderButtonAppear();
    }

    @Test
    @DisplayName("вход через кнопку в форме восстановления пароля")
    public void authButtonRecoveryPassTest() {
        open(RecoveryPassPage.URL_FORGOT_PASSWORD, RecoveryPassPage.class)
                .clickRecoveryPasswordButton()
                .setEmail(user.getEmail())
                .setPassword(user.getPassword())
                .clickLoginPageAuthButton()
                .isCreateOrderButtonAppear();
    }
}
