import PageObjectModel.*;
import org.apache.poi.ss.formula.functions.T;
import org.junit.Before;
import org.junit.Test;

import java.util.concurrent.TimeUnit;

public class Case extends BaseTest{
HomePage homePage;
TabMenu tabMenu;
CareersPage careersPage;
CareersQualityAssurancePage careersQualityAssurancePage;
QualityAssuranceJobsPage qualityAssuranceJobsPage;
LeverApplicationPage leverApplicationPage;

    @Before
    public void background(){
        homePage=new HomePage();
        tabMenu=new TabMenu();
        careersPage=new CareersPage();
        careersQualityAssurancePage=new CareersQualityAssurancePage();
        qualityAssuranceJobsPage=new QualityAssuranceJobsPage();
        leverApplicationPage=new LeverApplicationPage();

    }

    @Test
    public void case001(){
        homePage.acceptNotificationAndCookies();
        homePage.checkIfImOnHomePage("https://useinsider.com/");
        tabMenu.navigateToCarrersPage();
        careersPage.checkAllTeams();
        careersPage.checkLocationBar();
        careersPage.checkLifeAtInsider();
        driver.get("https://useinsider.com/careers/quality-assurance/,");
        careersQualityAssurancePage.clickOnSeeAllQaJobsButton();
        qualityAssuranceJobsPage.checkIfImOnQAJobsPage();
        qualityAssuranceJobsPage.selectIstanbulAndCheck("Istanbul, Turkey");
        qualityAssuranceJobsPage.checkPositions();
        leverApplicationPage.checkElements();
    }




}
