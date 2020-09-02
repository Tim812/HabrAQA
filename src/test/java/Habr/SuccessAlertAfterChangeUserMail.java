package Habr;


import Pages.*;
import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import resources.ConfPropeties;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;

public class SuccessAlertAfterChangeUserMail {
    public static WebDriver driver;
    public static MainPage mainPage;
    public static UserMenu userMenu;
    public static AutorisationPage autorisationPage;
    public static ProfileSettings profileSettings;
    public static AccountSettings accountSettings;

    @BeforeClass
    public void setup(){
        System.setProperty("webdriver.chrome.driver", ConfPropeties.getProperty("chromeDriver"));
        driver = new ChromeDriver();
        mainPage = new MainPage(driver);
        autorisationPage = new AutorisationPage(driver);
        userMenu = new UserMenu(driver);
        profileSettings = new ProfileSettings(driver);
        accountSettings = new AccountSettings(driver);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get(ConfPropeties.getProperty("mainPage"));
        assertEquals(driver.getTitle(),MainPage.getTitle());
    }
    @Test(priority = 1)
    @Description("Verify user logIn")
    public void logIn() throws InterruptedException {
        mainPage.findLogIn().click();
        autorisationPage.checkTitleOfPage();
        autorisationPage.inputDefaultEmail();
        Thread.sleep(500); //Тест временами падает, если между вводом почты и пароля нету паузы
        autorisationPage.inputDefaultPassword();
        autorisationPage.emailField.submit();

    }
    @Test(priority = 2)
    public void goToAccountSettings(){
        mainPage.findUserIcon().click();
        userMenu.findSettingsButtond().click();
        profileSettings.checkTitleOfPage();
        profileSettings.findAccountButton().click();
    }

    @Test(priority = 3)
    public void changeEmail() throws InterruptedException {
        //Переключение на новый таб
        ArrayList<String> newTab = new ArrayList<String>(driver.getWindowHandles());
        System.out.println(newTab);
        driver.switchTo().window(newTab.get(1));
        System.out.println(driver.getTitle());
        accountSettings.checkTitleOfPage();
        accountSettings.findChangeMailForm().click();
        accountSettings.changeUserEmail();
        accountSettings.findPasswordField().click();
        accountSettings.findPasswordField().sendKeys(ConfPropeties.getProperty("defaultPassword"));
        accountSettings.findSaveButton().click();
        accountSettings.findSuccessAlert();
        assertEquals(accountSettings.findSuccessAlert().getText(),accountSettings.getNoticeSuccessText());
    }

    @AfterClass
    public void quit(){
        driver.quit();
    }


}
