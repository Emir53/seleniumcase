package PageObjectModel;

import Utilities.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CareersQualityAssurancePage extends AbstractClass {

    WebDriver driver;
    public CareersQualityAssurancePage(){
        driver= Driver.getDriver();
        PageFactory.initElements(driver,this);

    }

    @FindBy(xpath = "//a[normalize-space()='See all QA jobs']")
    private WebElement seeAllQaJobs;

    public void clickOnSeeAllQaJobsButton(){
        clickFunction(seeAllQaJobs);
    }




}
