package actitime.testScripts;

import actitime.GenericLib.BaseClass;
import actitime.GenericLib.CommonUtility;
import actitime.GenericLib.DataUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.Test;

import java.io.IOException;
import java.time.Duration;

public class CustomerCreation extends BaseClass {
    @Test
    public void createCustomer() throws IOException {
        String customerName = du.getDataFromExcelFile("customer page", 0, 1);
        int rNum = cu.getRandomNumber();
        customerName += rNum;
        driver.findElement(By.id("container_tasks")).click();
        driver.findElement(By.cssSelector(".title.ellipsis")).click();
        driver.findElement(By.cssSelector(".item.createNewCustomer")).click();
        driver.findElement(By.className("newNameField")).sendKeys(customerName);
        driver.findElement(By.xpath("//div/textarea[@placeholder='Enter Customer Description']")).sendKeys("Testing");
        driver.findElement(By.xpath("//div[text()='Create Customer']")).click();
        By locator=By.className("titleEditButtonContainer");
        cu.expilicitWait(driver,10,locator,customerName);
        String cusName = driver.findElement(By.className("titleEditButtonContainer")).getText();
        Reporter.log(cusName,true);
    }
}


