import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    private final WebDriver driver;

    // Локаторы
    private final By loginHeader = By.xpath("//h2[contains(text(),'Вход')]");
    private final By email = By.xpath("//label[text()='Email']/following-sibling::input");
    private final By password = By.xpath("//input[@type='password']");
    private final By loginButton = By.xpath("//button[text()='Войти']");
    private final By registerLink = By.linkText("Зарегистрироваться");
    private final By forgotPasswordLink = By.linkText("Восстановить пароль");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Геттер заголовка 'Вход'")
    public By getLoginHeader() {
        return loginHeader;
    }

    @Step("Ввод email")
    public void enterEmail(String email) {
        driver.findElement(this.email).sendKeys(email);
    }

    @Step("Ввод пароля")
    public void enterPassword(String password) {
        driver.findElement(this.password).sendKeys(password);
    }

    @Step("Нажать кнопку 'Войти'")
    public void clickLoginButton() {
        driver.findElement(loginButton).click();
    }

    @Step("Перейти по ссылке 'Зарегистрироваться'")
    public void clickRegisterLink() {
        driver.findElement(registerLink).click();
    }

    @Step("Перейти по ссылке 'Восстановить пароль'")
    public void clickForgotPasswordLink() {
        driver.findElement(forgotPasswordLink).click();
    }
    @Step("Открыть страницу восстановления пароля")
    public void openForgotPasswordPage() {
        driver.get("https://stellarburgers.nomoreparties.site/forgot-password");
    }

    @Step("Нажать по ссылке 'Войти' на странице восстановления пароля")
    public void clickLoginFromForgotPassword() {
        driver.findElement(By.linkText("Войти")).click();
    }

    @Step("Авторизация пользователя")
    public void login(String email, String password) {
        enterEmail(email);
        enterPassword(password);
        clickLoginButton();
    }
}