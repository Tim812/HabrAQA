package Pages;

import org.testng.Assert;
import resources.ConfPropeties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProfileSettings extends BasePage{
    public ProfileSettings(WebDriver driver){
        super(driver);
    }
    private static String titleOfUserSettingPage = "Настройки профиля им. "+ ConfPropeties.getProperty("defaultLogin") + " / Хабр";
    @FindBy(xpath = "//*[contains(text(),'Аккаунт')]")
    private WebElement accountButton;

    public WebElement findAccountButton(){ return accountButton;}
    public void checkTitleOfPage(){
        Assert.assertEquals(driver.getTitle(),titleOfUserSettingPage);
    }
}
