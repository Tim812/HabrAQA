package Pages;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class FreelancePage extends MainPage{
    public FreelancePage(WebDriver driver){
        super(driver);
    }
    private String titleFreelancePage = "Хабр Фриланс";
    public void checkTitleOfPage(){
        Assert.assertEquals(driver.getTitle(),titleFreelancePage);
    }
}
