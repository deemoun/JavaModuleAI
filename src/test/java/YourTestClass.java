import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class YourTestClass {

    private WebDriver driver;

    @BeforeEach
    void setUp() {
        // Настройка WebDriver
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @Test
    void yourTest() {
        // Ваш тестовый код с использованием WebDriver
        driver.get("https://www.example.com");
        // Добавьте свой тестовый код здесь
    }

    @AfterEach
    void tearDown() {
        // Закрытие WebDriver после завершения теста
        if (driver != null) {
            driver.quit();
        }
    }
}
