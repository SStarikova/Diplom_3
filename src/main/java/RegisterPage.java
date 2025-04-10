import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterPage {

    private final WebDriver driver;

    // Локаторы
    private final By name = By.xpath("//input[@name='name']");
    private final By email = By.xpath("//label[text()='Email']/following-sibling::input");
    private final By password = By.xpath("//input[@type='password']");
    private final By registerButton = By.xpath("//button[text()='Зарегистрироваться']");
    private final By loginLink = By.linkText("Войти");

    public RegisterPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Ввод имени")
    public void enterName(String name) {
        driver.findElement(this.name).sendKeys(name);
    }

    @Step("Ввод email")
    public void enterEmail(String email) {
        driver.findElement(this.email).sendKeys(email);
    }

    @Step("Ввод пароля")
    public void enterPassword(String password) {
        driver.findElement(this.password).sendKeys(password);
    }

    @Step("Нажать кнопку 'Зарегистрироваться'")
    public void clickRegisterButton() {
        driver.findElement(registerButton).click();
    }

    @Step("Перейти по ссылке 'Войти'")
    public void clickLoginLink() {
        driver.findElement(loginLink).click();
    }

    @Step("Заполнить и отправить форму регистрации")
    public void register(String nameValue, String emailValue, String passwordValue) {
        enterName(nameValue);
        enterEmail(emailValue);
        enterPassword(passwordValue);
        clickRegisterButton();
    }
    @Step("Открыть страницу регистрации")
    public void open() {
        driver.get("https://stellarburgers.nomoreparties.site/register");
    }
}