package PageObjectModel;

import Utilities.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LeverApplicationPage extends AbstractClass {
    WebDriver driver;

    public LeverApplicationPage(){
        driver= Driver.getDriver();
        PageFactory.initElements(driver,this);

    }
    @FindBy(xpath = "(//a[contains(@class,'postings-btn template-btn-submit')])[1]")
    private WebElement applyForThisJobButton;




    public void checkElements(){
        checkIfElementExist(applyForThisJobButton);
    }


}
