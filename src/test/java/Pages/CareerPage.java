package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class CareerPage extends MainPage{
    public CareerPage(WebDriver driver){
        super(driver);
    }
    private String titleCareerPage = "Работа в IT-индустрии — Хабр Карьера";
    //Дропдаун, показывающий список остальных сервисов Хабра
    //Код для шапки неодинаковый для страниц, поэтому приходится дублировать
    @FindBy(xpath = "//*[contains(@class,'panel__projects-dropdown')]")
    private WebElement dropdownCareer;
    //Кнопкf перехода на хабр
    @FindBy(xpath ="//a[contains(@href,'https://habr.com')]")
    private WebElement habrLink;
    public void checkTitleOfPage(){ Assert.assertEquals(driver.getTitle(),titleCareerPage); }
    public WebElement findDropdownCareer(){ return dropdownCareer; }
    public WebElement findHabrLink(){return habrLink;}

}
