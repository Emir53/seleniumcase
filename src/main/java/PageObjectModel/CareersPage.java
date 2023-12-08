package PageObjectModel;

import Utilities.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CareersPage  extends AbstractClass{
    WebDriver driver;
    public CareersPage(){
        driver= Driver.getDriver();
        PageFactory.initElements(driver,this);

    }
    @FindBy(xpath = "//a[contains(text(),'See all teams')]")
    private WebElement seeAllTeamsButton;

    @FindBy(css = "#location-slider")
    private WebElement locationBar;

    @FindBy(css = "div.elementor-main-swiper.swiper-container")
    private WebElement lifeAtInsider;



    public void checkAllTeams(){
        scrollDownUntillSeeTheElement(seeAllTeamsButton);
        checkIfElementExist(seeAllTeamsButton);
    }
    public void checkLocationBar(){
        scrollDownUntillSeeTheElement(locationBar);
        checkIfElementExist(locationBar);
    }

    public void checkLifeAtInsider(){
        scrollDownUntillSeeTheElement(lifeAtInsider);
        checkIfElementExist(lifeAtInsider);
    }





}
