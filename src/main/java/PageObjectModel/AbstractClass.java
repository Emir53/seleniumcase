package PageObjectModel;

import Utilities.Driver;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



import static org.junit.Assert.*;



import java.time.Duration;
import java.util.List;
import java.util.Set;

public abstract class AbstractClass {
    private WebDriver driver = Driver.getDriver();

    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    Actions act = new Actions(driver);
    JavascriptExecutor jse = (JavascriptExecutor) driver;

    public void clickFunction(WebElement clickElement) {

        wait.until(ExpectedConditions.elementToBeClickable(clickElement));
        clickElement.click();
    }

    public void hoverOnElement(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
        act.moveToElement(element).perform();
    }


    public void sendKeysFunction(WebElement sendKeysElement, String value) {
        wait.until(ExpectedConditions.visibilityOf(sendKeysElement));
        sendKeysElement.sendKeys(value);
    }


    public void assertUrl(String text) {
        String currentUrl = driver.getCurrentUrl();
        assertEquals(text, currentUrl);

    }

    public void pressEnter() {
        act.sendKeys(Keys.ENTER).perform();
    }


    public void scrollDownUntillSeeTheElement(WebElement element) {
        sleepNseconds(2);

        jse.executeScript("arguments[0].scrollIntoView()", element);
    }


    public String getText(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
        return element.getText();
    }

    public boolean checkIfElementExist(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
        return element.isDisplayed();
    }

    public void selectElementFromDropdown(WebElement dropdown, String value) {
        wait.until(ExpectedConditions.visibilityOf(dropdown));
        Select slc = new Select(dropdown);
        System.out.println(slc.getOptions());
        System.out.println(slc.getAllSelectedOptions());
        slc.selectByVisibleText(value);
    }

    public String dropDownSizeValue(WebElement dropdown) {
        Select slc = new Select(dropdown);
        return slc.getFirstSelectedOption().getText();

    }

    public void waitForListElement(List<WebElement> elements) {
        wait.until(ExpectedConditions.visibilityOfAllElements(elements));
    }

    public void sleepNseconds(int i) {
        try {
            Thread.sleep(i * 1000);
        } catch (InterruptedException e) {

            e.printStackTrace();
        }
    }

    private void scrollTo(int x, int y) {
        String script = String.format("window.scrollTo(%d, %d);", x, y);
        jse.executeScript(script, true);
    }

    public void scrollToElementToBeVisible(WebElement element) {
        if (element != null) {
            scrollTo(element.getLocation().getX(), element.getLocation().getY() - 200);
        }
    }

    public void switchWindow(WebElement element) {
        String currentWindow = driver.getWindowHandle();
        clickFunction(element);
        Set<String> windows = driver.getWindowHandles();
        for (String windowList : windows) {
            if (!windowList.equals(currentWindow)) {
                // Yeni pencereye geç
                driver.switchTo().window(windowList);
            }
        }
    }
}