package parentTest;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.HomePage;
import pages.LoginPage;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class ParentTest {
    WebDriver webDriver;
   protected LoginPage loginPage;
   protected HomePage homePage;
    @Before
    public void setUp(){
        File file = new File("/home/user130/Auto//chromedriver");
        System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        loginPage = new LoginPage(webDriver);
        homePage = new HomePage(webDriver);
    }
    @After
    public void tearDown() {
        webDriver.quit();
    }

    public void checkExpetedResult(String message, boolean expectedResult, boolean actualResult){
        Assert.assertEquals(message, expectedResult, actualResult);

        }

   //     public void checkExpetedResult (String message, boolean actualResult){

 //       }


}
