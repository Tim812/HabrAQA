package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import resources.ConfPropeties;

public class AutorisationPage extends BasePage{
    private static String titleOfAutorisationPage = "Вход — Habr Account";
    public AutorisationPage(WebDriver driver){
        super(driver);
    }
    //Поле "Email"
    @FindBy(id = "email_field")
    public WebElement emailField ;
    //Поле "Пароль"
    @FindBy(id = "password_field")
    public WebElement passwordField ;
    //Заполнение полей почты и пароля
    public void inputDefaultEmail(){
        emailField.sendKeys(ConfPropeties.getProperty("defaultEmail"));
    }
    public void inputDefaultPassword(){
        passwordField.sendKeys(ConfPropeties.getProperty("defaultPassword"));
    }
    //Получить название страницы
    public static String getTitle(){
        return titleOfAutorisationPage;
    }
    public void checkTitleOfPage(){
        Assert.assertEquals(driver.getTitle(), AutorisationPage.getTitle());}

}
