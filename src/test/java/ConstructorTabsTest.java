import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/* Раздел «Конструктор»
Проверь, что работают переходы к разделам:
«Булки»,
«Соусы»,
«Начинки».*/
public class ConstructorTabsTest extends BaseTest {

    private MainPage mainPage;

    @Before
    public void setUpPage() {
        mainPage = new MainPage(driver);
        mainPage.open();
    }

    @Test
    @DisplayName("User can switch to 'Sauces' tab")
    @Description("Проверка, что при клике на 'Соусы' активируется соответствующая вкладка")
    public void userCanSwitchToSauceTabTest() {
        mainPage.clickSauceTab();
        assertEquals("Соусы", mainPage.getActiveTabText());
    }

    @Test
    @DisplayName("User can switch to 'Fillings' tab")
    @Description("Проверка, что при клике на 'Начинки' активируется соответствующая вкладка")
    public void userCanSwitchToFillingTabTest() {
        mainPage.clickFillingTab();
        assertEquals("Начинки", mainPage.getActiveTabText());
    }

    @Test
    @DisplayName("User can switch back to 'Buns' tab")
    @Description("Проверка, что при клике на 'Булки' активируется соответствующая вкладка")
    public void userCanSwitchToBunTabTest() {
        mainPage.clickFillingTab();
        mainPage.clickBunTab();
        assertEquals("Булки", mainPage.getActiveTabText());
    }
}