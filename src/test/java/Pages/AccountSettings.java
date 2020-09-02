package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import resources.ConfPropeties;

import static Habr.SuccessAlertAfterChangeUserMail.accountSettings;

public class AccountSettings extends ProfileSettings{
    public AccountSettings(WebDriver driver){
        super(driver);
    }
    private static String titleOfAccountSettings= "Настройки аккаунта — Habr Account";
    //Текст алерта после успешного изменения почты
    private static String noticeSuccessText = "Настройки сохранены. Перейдите по ссылке из письма для подтверждения введенного e-mail.";
    //Форма изменить email
    @FindBy(xpath = "/html/body/div/div[3]/div[2]/div[1]")
    private WebElement changeMailForm;
    //Поле текущая почта
    @FindBy(id = "current_email_field")
    private WebElement currentEmailField;
    //Поле новая почта
    @FindBy(id = "email_field")
    private WebElement newEmailfield;
    //Поле изменения пароля в "изменить email"
    @FindBy(id = "password_field")
    private WebElement passwordField;
    //Кнопка "Сохранить"
    @FindBy(xpath = "//*[contains(text(),'Сохранить')]")
    private WebElement saveButton;
    //Зеленый алерт после успешного изменения почты
    @FindBy(xpath = "//*[contains(text(),'Перейдите по ссылке из письма для подтверждения введенного e-mail.')]")
    private WebElement noticeSuccess;

    @FindBy(xpath = "//*[contains(text(),'Перейдите по ссылке из письма')]")
    private WebElement successAlert;

    public void checkTitleOfPage(){
        Assert.assertEquals(driver.getTitle(),titleOfAccountSettings);
    }
    public  WebElement findChangeMailForm(){
        return changeMailForm;
    }
    public WebElement findCurrentEmailField(){
        return currentEmailField;
    }
    public WebElement findNewEmailfield(){
        return newEmailfield;
    }
    public WebElement findPasswordField(){
        return passwordField;
    }
    public WebElement findSuccessAlert(){return successAlert;}
    public void changeUserEmail(){
        String currentEmail = accountSettings.findCurrentEmailField().getText();
        if (currentEmail.equals(ConfPropeties.getProperty("newEmail"))){
            accountSettings.findChangeMailForm().sendKeys(ConfPropeties.getProperty("newEmail"));
        }
        else{
            accountSettings.findNewEmailfield().sendKeys(ConfPropeties.getProperty("defaultEmail"));
        }
    }
    public WebElement findSaveButton(){
        return saveButton;
    }
    public WebElement getNoticeSuccess(){
        return noticeSuccess;
    }
    public String getNoticeSuccessText(){
        return noticeSuccessText;
    }




}
