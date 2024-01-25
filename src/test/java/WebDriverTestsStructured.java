import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebDriverTestsStructured {

    private WebDriver driver;

    @BeforeEach
    void setUp() {
        // Настройка WebDriver
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @Test
    void yourTest() {
        // Navigate to the page
        driver.get("https://demoqa.com/automation-practice-form");

        // Fill out the form
        //fillOutForm("Dmitry", "Y", "343434343434");
        fillOutForm(FakeData.generateFirstName(), FakeData.generateLastName(), FakeData.generatePhoneNumber());

        // Click the submit button
        clickButton("submit");
    }

    private void fillOutForm(String firstName, String lastName, String userNumber) {
        driver.findElement(By.id("firstName")).sendKeys(firstName);
        driver.findElement(By.id("lastName")).sendKeys(lastName);
        driver.findElement(By.id("userNumber")).sendKeys(userNumber);
    }

    private void clickButton(String id) {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        WebElement element = driver.findElement(By.id(id));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
    }

    // Write a Unit Test here that checks if the page title is correct
    @Test
    public void testPageTitle() {
        driver.get("https://demoqa.com/automation-practice-form");
        assertEquals("Automation Practice Form", driver.getTitle());
    }

    @AfterEach
    void tearDown() {
        // Закрытие WebDriver после завершения теста
        if (driver != null) {
            driver.quit();
        }
    }
}