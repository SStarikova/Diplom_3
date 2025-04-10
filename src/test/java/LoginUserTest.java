import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.concurrent.ThreadLocalRandom;

import static org.junit.Assert.assertTrue;

/* Вход
Проверь:
вход по кнопке «Войти в аккаунт» на главной,
вход через кнопку «Личный кабинет»,
вход через кнопку в форме регистрации,
вход через кнопку в форме восстановления пароля.*/
public class LoginUserTest extends BaseTest {

    private final UserApiHelper apiHelper = new UserApiHelper();
    private MainPage mainPage;
    private LoginPage loginPage;
    int random = ThreadLocalRandom.current().nextInt(100,100_000);
    private final String email = "sveta" + random + "@yandex.ru";
    private final String name = "Sveta";
    private final String password = "123456";
    @Before
    public void setUpPage() {
        apiHelper.createUser(email, password, name);
        mainPage = new MainPage(driver);
        loginPage = new LoginPage(driver);
    }

    @After
    public void deleteUser() {
        apiHelper.deleteUser(email, password);
    }

    @Test
    @DisplayName("Login from main page with button 'Войти в аккаунт'")
    @Description("Проверка входа через кнопку 'Войти в аккаунт' на главной странице")
    public void loginFromMainPageTest() {
        mainPage.open();
        mainPage.clickLoginButton();
        loginPage.login(email, password);
        assertTrue(mainPage.isOrderButtonVisible());
    }

    @Test
    @DisplayName("Login from main page with button 'Личный кабинет'")
    @Description("Проверка входа через кнопку 'Личный кабинет' на главной странице")
    public void loginFromPersonalAccountTest() {
        mainPage.open();
        mainPage.clickPersonalAccount();
        loginPage.login(email, password);
        assertTrue(mainPage.isOrderButtonVisible());
    }

    @Test
    @DisplayName("Login with link from registration form")
    @Description("Проверка входа по ссылке из формы регистрации")
    public void loginFromRegisterFormTest() {
        RegisterPage registerPage = new RegisterPage(driver);
        registerPage.open();
        registerPage.clickLoginLink();
        loginPage.login(email, password);
        assertTrue(mainPage.isOrderButtonVisible());
    }

    @Test
    @DisplayName("Login with link from forgot password form")
    @Description("Проверка входа по ссылке из формы восстановления пароля")
    public void loginFromForgotPasswordTest() {
        loginPage.openForgotPasswordPage();
        loginPage.clickLoginFromForgotPassword();
        loginPage.login(email, password);
        assertTrue(mainPage.isOrderButtonVisible());
    }
}