package Utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Driver {
    private static WebDriver driver;

    public static WebDriver getDriver(){
        if(driver==null){
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--disable-notifications");
            driver=new ChromeDriver(options);

        }
        return driver;
    }

}
