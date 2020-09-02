package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import static org.openqa.selenium.By.id;

public class MainPage extends BasePage{
    private static String titleOfMainPage = "Лучшие публикации за сутки / Хабр";
    public MainPage(WebDriver driver){
        super(driver);
    }
    //Кнопка "Войти"
    @FindBy(id = "login")
    private WebElement logIn;
    //Кнопка Регистрация
    @FindBy(xpath = "//*[contains(text(),'Регистрация')]")
    private WebElement registrationButton;
    //Иконка пользователя
    @FindBy(xpath = "//*[contains(@class, 'btn_navbar_user-dropdown')]")
    private WebElement userIcon;
    //Иконка смены языка
    @FindBy(xpath = "//*[contains(@class,'show_lang_settings')]")
    private WebElement languageButton;
    //Радиобаттон английский язык
    @FindBy(id = "hl_langs_en")
    private WebElement interface_en;

    //Выпадашка с другими сайтами хабра
    @FindBy(id = "dropdown-control")
    private WebElement dropdownControl;
    //QA
    @FindBy(xpath = "//a[contains(@href,'qna')]")
    private WebElement qaLink;
    //Карьера
    @FindBy(xpath = "//a[contains(@href,'career')]")
    private WebElement careerLink;
    //Фриланс
    @FindBy(xpath = "//a[contains(@href,'freelance')]")
    private WebElement freelanceLink;

    public WebElement dropdownControl(){
        return dropdownControl;
    }

    public WebElement findRegistrationButton(){
        return registrationButton;
    }
    public WebElement findDropdownControl(){return dropdownControl;}
    public WebElement findQaLink(){return qaLink;}
    public WebElement findCareerLink(){return careerLink;}
    public WebElement findFreelanceLink(){return freelanceLink;}
    public WebElement findUserIcon(){
        return userIcon;
    }
    public WebElement findLogIn(){
        return logIn;
    }
    public static String getTitle(){
        return titleOfMainPage;
    }
    public void checkTitleOfPage(){
        Assert.assertEquals(driver.getTitle(),titleOfMainPage);
    }

}
