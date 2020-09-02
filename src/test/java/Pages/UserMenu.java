package Pages;

import Pages.MainPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import resources.ConfPropeties;

public class UserMenu extends MainPage {
    public UserMenu(WebDriver driver) {
        super(driver);
    }

    //Логин пользователя в выпадашке
    @FindBy(css = ".user-info__nickname")
    private WebElement userLogin;

    //Кнопка Выход
    @FindBy(xpath = "/html/body/div[1]/div[2]/div/div/div[2]/div/div/ul/li[7]/a")
    private WebElement logOutButton;

    //Кнопка Настройки
    @FindBy(xpath = "//ul[contains(@class,'n-dropdown-menu n-dropdown-menu_profile')]/li[6]")
    private WebElement settingsButton;

    public WebElement findLogOutButton() {
        return logOutButton;
    }
    public WebElement findSettingsButtond(){return settingsButton;};
    public WebElement getUserLogin() {
        return userLogin;
    }

    public void checkUserLogin() {
        Assert.assertEquals(getUserLogin().getText(), ConfPropeties.getProperty("defaultLogin"));
    }
}
