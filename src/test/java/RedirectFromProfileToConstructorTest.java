import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import pageobject.LoginPage;
import static com.codeborne.selenide.Selenide.open;

public class RedirectFromProfileToConstructorTest extends BaseTest {

    @Test
    @DisplayName("Переход из личного кабинета по клику на «Конструктор»")
    public void redirectConstructorButtonTest() {
        open(LoginPage.URL_LOGIN, LoginPage.class)
                .loginUser(user)
                .clickProfileButtonAfterAuth()
                .clickConstructorButton()
                .isBurgerConstructorHeaderExist();
    }

    @Test
    @DisplayName("Переход из личного кабинета по клику на логотип Stellar Burgers")
    public void redirectLogoButtonTest() {
        open(LoginPage.URL_LOGIN, LoginPage.class)
                .loginUser(user)
                .clickProfileButtonAfterAuth()
                .clickLogoButton()
                .isBurgerConstructorHeaderExist();
    }
}
