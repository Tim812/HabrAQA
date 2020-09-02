package Habr;

import Pages.AutorisationPage;
import Pages.MainPage;
import Pages.UserMenu;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import resources.ConfPropeties;

import java.util.concurrent.TimeUnit;

public class LogInAndLogOut {
    public static MainPage mainPage;
    public static AutorisationPage autorisationPage;
    public static WebDriver driver;
    public static UserMenu userMenu;


    @BeforeClass
    public void setup(){
        System.setProperty("webdriver.chrome.driver", ConfPropeties.getProperty("chromeDriver"));
        driver = new ChromeDriver();
        mainPage = new MainPage(driver);
        autorisationPage = new AutorisationPage(driver);
        userMenu = new UserMenu(driver);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(ConfPropeties.getProperty("mainPage"));
        Assert.assertEquals(driver.getTitle(),MainPage.getTitle());
    }

    @Test(priority = 1)
    public void logIn() throws InterruptedException {
        mainPage.findLogIn().click();
        autorisationPage.checkTitleOfPage();
        autorisationPage.inputDefaultEmail();
        Thread.sleep(500); //Тест временами падает, если между вводом почты и пароля нету паузы
        autorisationPage.inputDefaultPassword();
        autorisationPage.emailField.submit();
        mainPage.findUserIcon().click();
        userMenu.checkUserLogin();
    }
    @Test(priority = 2)
    public void logOut(){
        userMenu.findLogOutButton().click();
        mainPage.checkTitleOfPage();
        mainPage.findRegistrationButton();

    }
    @AfterClass
    public void quit(){
        driver.quit();
    }

}
