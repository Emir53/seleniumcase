package PageObjectModel;

import Utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.junit.Assert.assertEquals;

public class HomePage extends AbstractClass{
    WebDriver driver;
    public HomePage(){
        driver= Driver.getDriver();
        PageFactory.initElements(driver,this);

    }

    @FindBy(css="div#announce")
    private WebElement homePageAnnounce;
    @FindBy(css = "span.ins-close-button")
    private WebElement notificationCloseButton;
    @FindBy(xpath = "//*[contains(text(),'Accept All')]")
    private WebElement acceptAllButton;


    public void acceptNotificationAndCookies(){
        clickFunction(acceptAllButton);
    }

    public void checkIfImOnHomePage(String expUrl){
        String currentUrl=driver.getCurrentUrl();
        Assert.assertEquals(expUrl,currentUrl);
        checkIfElementExist(homePageAnnounce);
    }



}
