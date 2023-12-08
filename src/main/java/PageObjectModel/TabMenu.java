package PageObjectModel;

import Utilities.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TabMenu extends AbstractClass{
    WebDriver driver;
    public TabMenu(){
        driver= Driver.getDriver();
        PageFactory.initElements(driver,this);

    }
    @FindBy(xpath="//a[contains(text(),'Company')]")
    private WebElement companyButton;
    @FindBy(xpath = "//a[contains(text(),'Careers')]")
    private WebElement careersButtonInCompanyButton;


    public void navigateToCarrersPage(){
        clickFunction(companyButton);
        clickFunction(careersButtonInCompanyButton);
    }






}
