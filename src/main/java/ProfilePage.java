import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProfilePage {

    private final WebDriver driver;

    // Локаторы
    private final By logoutButton = By.xpath("//button[text()='Выход']");
    private final By constructorButton = By.xpath("//p[text()='Конструктор']");
    private final By logo = By.className("AppHeader_header__logo__2D0X2");

    public ProfilePage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Нажать кнопку 'Выйти'")
    public void clickLogoutButton() {
        driver.findElement(logoutButton).click();
    }

    @Step("Нажать кнопку 'Конструктор'")
    public void clickConstructorButton() {
        driver.findElement(constructorButton).click();
    }

    @Step("Нажать на логотип 'Stellar Burgers'")
    public void clickLogo() {
        driver.findElement(logo).click();
    }

    @Step("Проверить наличие кнопки 'Выход'")
    public boolean isLogoutButtonVisible() {
        return driver.findElement(logoutButton).isDisplayed();
    }
}