import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
        driver.get("https://demoqa.com/automation-practice-form");
        driver.findElement(By.id("firstName")).sendKeys("Dmitry");
        driver.findElement(By.id("lastName")).sendKeys("Y");
        driver.findElement(By.id("userNumber")).sendKeys("343434343434");

        // Click a radio button using driver
        WebElement element = driver.findElement(By.id("gender-radio-1"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
        WebElement element2 = driver.findElement(By.id("submit"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element2);
    }

    @AfterEach
    void tearDown() {
        // Закрытие WebDriver после завершения теста
        if (driver != null) {
            driver.quit();
        }
    }
}
