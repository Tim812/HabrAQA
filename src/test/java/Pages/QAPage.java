package Pages;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class QAPage extends MainPage{
    public QAPage(WebDriver driver){
        super(driver);
    }
    private String titleQaPage = "Интересные вопросы — Хабр Q&A";
    public void checkTitleOfPage(){
        Assert.assertEquals(driver.getTitle(),titleQaPage);
    }
}
