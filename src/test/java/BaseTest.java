import Utilities.Driver;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;

public class BaseTest {
    static WebDriver driver;
    @BeforeClass
    public static void beforeTest(){
        driver= Driver.getDriver();
        driver.manage().window().maximize();
        driver.get("https://useinsider.com/");
    }
    @AfterClass
    public static void afterTest(){
        Driver.closeDriver();
    }
}
