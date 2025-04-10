import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;
import java.time.Duration;

/*
* Открытие и закрытие браузера
* */
public class BaseTest {

    protected WebDriver driver;

    @Before
    public void setUp() {
        String browser = System.getProperty("browser", "chrome");

        WebDriverManager.chromedriver().setup();

        if (browser.equalsIgnoreCase("yandex")) {
            WebDriverManager.chromedriver()
                    .driverVersion("132.0.6834.159") // версия Яндекс браузера
                    .setup();
            // Путь к Яндекс браузеру
            String yandexPath = "C:\\Users\\Starikova\\AppData\\Local\\Yandex\\YandexBrowser\\Application\\browser.exe";

            ChromeOptions options = new ChromeOptions();
            options.setBinary(new File(yandexPath)); // подключаем Yandex
            driver = new ChromeDriver(options);

        } else {
            // По умолчанию Chrome
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        }

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}