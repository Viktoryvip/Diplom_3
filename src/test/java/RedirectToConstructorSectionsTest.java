import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import pageobject.*;
import static com.codeborne.selenide.Selenide.open;

public class RedirectToConstructorSectionsTest extends BaseTest {

    @Test
    @DisplayName("переход к разделу «Булки»")
    public void moveBunsSectionButtonTest() {
        open(MainPage.URL_MAIN, MainPage.class)
                .clickSaucesButton()
                .clickBunsButton()
                .isBunsHeaderIsDisplayed();
    }

    @Test
    @DisplayName("переход к разделу «Соусы»")
    public void moveSaucesSectionButtonTest() {
        open(MainPage.URL_MAIN, MainPage.class)
                .clickSaucesButton()
                .isSaucesHeaderDisplayed();
    }

    @Test
    @DisplayName("переход к разделу «Начинки»")
    public void moveFillingsSectionButtonTest() {
        open(MainPage.URL_MAIN, MainPage.class)
                .clickFillingsButton()
                .isSaucesHeaderDisplayed();
    }

    @Test
    @DisplayName("Скролл раздела «Булки» в конструторе")
    public void moveBunsSectionScrollTest() {
        open(MainPage.URL_MAIN, MainPage.class)
                .scrollToBunsHeader()
                .isBunsHeaderIsDisplayed();
    }

    @Test
    @DisplayName("Скролл раздела «Соусы» в конструторе")
    public void moveSaucesSectionScrollTest() {
        open(MainPage.URL_MAIN, MainPage.class)
                .scrollToSaucesHeader()
                .isSaucesHeaderDisplayed();
    }

    @Test
    @DisplayName("Скролл раздела «Начинки» в конструторе")
    public void moveFillingsSectionScrollest() {
        open(MainPage.URL_MAIN, MainPage.class)
                .scrollToFillingsHeader()
                .isFillingsHeaderDisplayed();
    }
}
