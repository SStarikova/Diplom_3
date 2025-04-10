import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage {

    private final WebDriver driver;

    private static final String URL = "https://stellarburgers.nomoreparties.site";

    // Локаторы
    private final By loginButton = By.xpath("//button[text()='Войти в аккаунт']");
    private final By personalAccountButton = By.xpath("//p[text()='Личный Кабинет']");
    private final By orderButton = By.xpath("//button[text()='Оформить заказ']");
    private final By bunTab = By.xpath("//span[text()='Булки']");
    private final By sauceTab = By.xpath("//span[text()='Соусы']");
    private final By fillingTab = By.xpath("//span[text()='Начинки']");
    private final By activeTab = By.xpath("//div[contains(@class,'tab_tab_type_current')]");

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Открыть главную страницу")
    public void open() {
        driver.get(URL);
    }

    @Step("Нажать кнопку 'Войти в аккаунт'")
    public void clickLoginButton() {
        driver.findElement(loginButton).click();
    }

    @Step("Нажать на 'Личный кабинет'")
    public void clickPersonalAccount() {
        driver.findElement(personalAccountButton).click();
    }

    @Step("Проверка: отображается кнопка 'Оформить заказ'")
    public boolean isOrderButtonVisible() {
        return driver.findElement(orderButton).isDisplayed();
    }

    @Step("Клик на вкладку 'Булки'")
    public void clickBunTab() {
        driver.findElement(bunTab).click();
    }

    @Step("Клик на вкладку 'Соусы'")
    public void clickSauceTab() {
        driver.findElement(sauceTab).click();
    }

    @Step("Клик на вкладку 'Начинки'")
    public void clickFillingTab() {
        driver.findElement(fillingTab).click();
    }

    @Step("Получить текст активной вкладки")
    public String getActiveTabText() {
        return driver.findElement(activeTab).getText();
    }
}