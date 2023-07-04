package actitime.GenericLib;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.io.IOException;
import java.time.Duration;

public class BaseClass {
   public DataUtility du = new DataUtility();
   public CommonUtility cu=new CommonUtility();
   public WebDriver driver;
   public static WebDriver listenerDriver;
    @BeforeClass
    public void launchBrowser(){
      driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }
    @BeforeMethod
    public void logIn() throws IOException {
        driver.get(du.getDataFromPropertiesFile("url"));
        driver.findElement(By.id("username")).sendKeys(du.getDataFromPropertiesFile("userName"));
        driver.findElement(By.name("pwd")).sendKeys(du.getDataFromPropertiesFile("password"));
        driver.findElement(By.id("loginButton")).click();
    }
    @AfterMethod
    public void logOut(){
        driver.findElement(By.id("logoutLink")).click();
    }
    @AfterClass
    public void tearDown(){
        driver.close();
    }
}
