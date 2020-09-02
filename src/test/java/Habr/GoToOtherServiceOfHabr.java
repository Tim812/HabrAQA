package Habr;

import Pages.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import resources.ConfPropeties;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;

public class GoToOtherServiceOfHabr {
    public static WebDriver driver;
    public static MainPage mainPage;
    public static QAPage qaPage;
    public static CareerPage careerPage;
    public static FreelancePage freelancePage;

    @BeforeClass
    public void setup(){
        System.setProperty("webdriver.chrome.driver", ConfPropeties.getProperty("chromeDriver"));
        driver = new ChromeDriver();
        mainPage = new MainPage(driver);
        qaPage = new QAPage(driver);
        careerPage = new CareerPage(driver);
        freelancePage = new FreelancePage(driver);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(ConfPropeties.getProperty("mainPage"));
        assertEquals(driver.getTitle(),MainPage.getTitle());
    }

    @Test
    public void changeSite(){
        mainPage.findDropdownControl().click();
        mainPage.findQaLink().click();
        qaPage.checkTitleOfPage();
        driver.navigate().back();
        mainPage.findDropdownControl().click();
        mainPage.findFreelanceLink().click();
        freelancePage.checkTitleOfPage();
        driver.navigate().back();
        mainPage.findDropdownControl().click();
        mainPage.findCareerLink().click();
        careerPage.checkTitleOfPage();
        careerPage.findDropdownCareer().click();
        careerPage.findHabrLink().click();
        mainPage.checkTitleOfPage();
    }
    @AfterClass
    public void quit(){
        driver.quit();
    }

}
