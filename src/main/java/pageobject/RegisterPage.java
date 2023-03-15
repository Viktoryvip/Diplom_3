package pageobject;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import static com.codeborne.selenide.Selenide.page;

public class RegisterPage {
    public final static String URL_REGISTER = "https://stellarburgers.nomoreparties.site/register";

    @FindBy(how = How.XPATH, using = "//label[text()='Имя']/following-sibling::input")
    private SelenideElement nameField;

    @FindBy(how = How.XPATH, using = "//*[text()='Email']/following-sibling::input")
    private SelenideElement emailField;

    @FindBy(how = How.XPATH, using = "//*[text()='Пароль']/following-sibling::input")
    private SelenideElement passwordField;

    @FindBy(how = How.XPATH, using = "//button[text()='Зарегистрироваться']")
    private SelenideElement confirmRegistrationButton;

    @FindBy(how = How.XPATH, using = "//a[text()='Войти']")
    private SelenideElement registrationPageAuthButton;

    @FindBy(how = How.XPATH, using = "//p[text()='Некорректный пароль']")
    private SelenideElement errorPasswordMessage;

    @Step("Вввод имени")
    public RegisterPage setName(String name) {
        nameField.setValue(name);
        return this;
    }

    @Step("Ввод email нового пользователя")
    public RegisterPage setEmail(String email) {
        emailField.setValue(email);
        return this;
    }

    @Step("Ввод пароля")
    public RegisterPage setPassword(String password) {
        passwordField.setValue(password);
        return this;
    }

    @Step("Клик на кнопку регистрации")
    public LoginPage clickButtonRegistration() {
        confirmRegistrationButton.click();
        return page(LoginPage.class);
    }

    @Step("Клик на кнопку и переход на страницу регистрации")
    public LoginPage clickConfirmRegistrationButton() {
        confirmRegistrationButton.click();
        return page(LoginPage.class);
    }

    @Step("Клик на кнопку входа")
    public LoginPage clickRegistrationPageAuthButton() {
        registrationPageAuthButton.click();
        return page(LoginPage.class);
    }
}
