import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestMethodOrder;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)

public class BaseTest {
    protected static WebDriver driver;
    BasePage BaseTest;


    @BeforeAll
    public void setUp(){
    System.setProperty("webdriver.chrome.driver","drivers\\chromedriver.exe");
    driver = new ChromeDriver();
    driver.get("https://www.beymen.com/");
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    BaseTest = new BasePage(driver);
    }



/*
    @AfterAll
    public void tearDown(){
        driver.quit();

    }*/

}
