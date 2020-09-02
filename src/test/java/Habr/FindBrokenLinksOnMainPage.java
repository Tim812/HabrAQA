package Habr;

import Pages.MainPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import resources.ConfPropeties;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.assertEquals;

public class FindBrokenLinksOnMainPage {
    public static WebDriver driver;
    public static MainPage mainPage;
    HttpURLConnection huc = null;
    int respCode;
    List<WebElement> activesLinks = new ArrayList<WebElement>();
    @BeforeClass
    public void setup() {
        System.setProperty("webdriver.chrome.driver", ConfPropeties.getProperty("chromeDriver"));
        driver = new ChromeDriver();
        mainPage = new MainPage(driver);
        driver.manage().window().maximize();
        driver.get(ConfPropeties.getProperty("mainPage"));
        assertEquals(driver.getTitle(), MainPage.getTitle());
    }

    @Test(priority = 1)
    public void getLinks (){
        List<WebElement> AllList = driver.findElements(By.tagName("a"));
        for (WebElement webElement :AllList) {
            if (webElement.getAttribute("href") != null) {
                activesLinks.add(webElement);
            }
        }
    }
    @Test(priority = 2)
    public void VerifyLinks()  {
        for (WebElement activesLink : activesLinks) {
            String url = activesLink.getAttribute("href");
            try {
                huc = (HttpURLConnection) (new URL(url).openConnection());

                huc.setRequestMethod("HEAD");

                huc.connect();
                respCode = huc.getResponseCode();
                if (respCode >= 400) {
                    System.out.println(url + " is a broken link");
                }

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    @AfterClass
    public void quit(){
        driver.quit();
    }

}



