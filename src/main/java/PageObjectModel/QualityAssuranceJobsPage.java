package PageObjectModel;

import Utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.Random;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class QualityAssuranceJobsPage extends AbstractClass {
    WebDriver driver;
    Random random = new Random();

    public QualityAssuranceJobsPage(){
        driver= Driver.getDriver();
        PageFactory.initElements(driver,this);

    }
    @FindBy(css = "h3.mb-0")
    private WebElement browseOpenPositions;
    @FindBy(css = "select[data-select2-id='filter-by-location']")
    private WebElement selectLocation;

    @FindBy(css = "#select2-filter-by-location-container")
    private WebElement locationSelectCloser;
    @FindBy(xpath = "(//span[@role='presentation'])[1]")
    private WebElement closerArrow;

    @FindBy(css = "span[id='select2-filter-by-department-container'] span[title='Remove all items']")
    private WebElement departmentCloser;

    @FindBy(css="select[name='filter-by-department']")
    private WebElement selectDepartment2;
    @FindBy(css = "#select2-filter-by-department-container")
    private WebElement selectDepartment;


    @FindBy(xpath = "(//span[@class='select2-selection__rendered'])[1]")
    private WebElement selectDepertmentAfter;
    @FindBy(xpath = "(//span[@class='select2-selection__arrow'])[2]")
    private WebElement closerArrowDeparment;

    @FindBy(className = "position-list-item-wrapper")
    private List<WebElement> positions;

    @FindBy(css="div#jobs-list>div>div>a")
    private List<WebElement> viewRoleButtons;
    @FindBy(css = "#jobs-list > div")
    private WebElement position;




    public void checkIfImOnQAJobsPage(){
        String exp="https://useinsider.com/careers/open-positions/?department=qualityassurance";
        String current=driver.getCurrentUrl();
        Assert.assertEquals(exp,current);
    }

    public void selectIstanbulAndCheck(String value)  {
        sleepNseconds(5);
        Assert.assertEquals("Quality Assurance",selectDepartment.getAttribute("title"));
        clickFunction(locationSelectCloser);
        selectElementFromDropdown(selectLocation,value);
        clickFunction(closerArrow);
        sleepNseconds(10);
    }
    public void checkPositions(){
        int count = positions.size();
        int randomIndex= random.nextInt(count);
        WebElement element=positions.get(randomIndex);
        scrollToElementToBeVisible(element);
        waitForListElement(positions);
        for (WebElement position : positions) {
            String text = position.getText();
            String[] parts = text.split("\n");
            String positionOfJob = parts[0].trim();
            String departmentOfJob= parts[1].trim();
            String locationOfJob = parts[2].trim();
            Assert.assertTrue(positionOfJob.contains("Quality Assurance") ||positionOfJob.contains("QA"));
            Assert.assertTrue(departmentOfJob.contains("Quality Assurance"));
            Assert.assertTrue(locationOfJob.contains("Istanbul, Turkey"));

        }
        hoverOnElement(element);
        switchWindow(viewRoleButtons.get(randomIndex));

    }

}
