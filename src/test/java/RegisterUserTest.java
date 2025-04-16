import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.ThreadLocalRandom;

import static org.junit.Assert.assertTrue;

/* Регистрация
Проверь:
Успешную регистрацию.
Ошибку для некорректного пароля. Минимальный пароль — шесть символов.*/
public class RegisterUserTest extends BaseTest {

    private RegisterPage registerPage;
    private LoginPage loginPage;
    private final UserApiHelper apiHelper = new UserApiHelper();
    int random = ThreadLocalRandom.current().nextInt(100,100_000);
    private final String email = "sveta" + random + "@yandex.ru";
    private final String name = "Sveta";
    private final String password = "123456";
    private boolean userWasCreated = false;

    @Before
    public void setUpPage() {
        registerPage = new RegisterPage(driver);
        loginPage = new LoginPage(driver);
        registerPage.open();
    }

    @After
    public void deleteUser() {
        if (userWasCreated) {
            apiHelper.deleteUser(email, password);
        }
    }

    @Test
    @DisplayName("Successful user registration")
    @Description("Проверка успешной регистрации пользователя с валидными данными")
    public void userCanRegisterSuccessfullyTest() {
        registerPage.register(name, email, password);
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(loginPage.getLoginHeader()));

        userWasCreated = true;

        // проверяем наличие текста заголовка 'Вход'
        assertTrue(driver.findElement(loginPage.getLoginHeader()).isDisplayed());
    }

    @Test
    @DisplayName("Registration fails with short password")
    @Description("Проверка ошибки при регистрации с паролем короче 6 символов")
    public void userCannotRegisterWithShortPasswordTest() {
        registerPage.register(name, email, "12345");
        assertTrue(driver.getPageSource().contains("Некорректный пароль"));
    }
}