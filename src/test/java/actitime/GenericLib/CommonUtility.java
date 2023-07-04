package actitime.GenericLib;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.HdrDocumentImpl;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;
import java.util.Random;

public class CommonUtility {
    Alert alert=null;
    public int getRandomNumber(){
        Random r= new Random();
        return r.nextInt(10000);
    }
    public Alert switchToAlert(WebDriver driver){
         alert=driver.switchTo().alert();
        return alert;
    }
    public void actionOnAlert(WebDriver driver,String action){
       alert=switchToAlert(driver);
        if (action.equalsIgnoreCase("ok")){
            alert.accept();
        }else {
            alert.dismiss();
        }
    }
    public String getMessageFromAlert(WebDriver driver){
        switchToAlert(driver);
        return alert.getText();
    }
    public void writeMessageInAlert(WebDriver driver,String message){
        switchToAlert(driver);
        alert.sendKeys(message);
    }
    public void fetchingDataFromDDByText(WebElement element,String visibleText){
        Select select=new Select(element);
        select.selectByVisibleText(visibleText);
    }
    //selectByIndex,selectByValue,getOptions
    public void selectDataFromDDByIndex(WebElement element, int index){
        Select select=new Select(element);
        select.selectByIndex(index);
    }
    public void selectDataFromDDByValue(WebElement element,String value){
        Select select=new Select(element);
        select.selectByValue(value);
    }
    public List<WebElement> getAllOptionFromDD(WebElement element){
        Select select=new Select(element);
        return select.getOptions();
    }
    public void expilicitWait(WebDriver driver, int time, By locator, String text){
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(time));
        wait.until(ExpectedConditions.textToBePresentInElementLocated(locator,text));
    }
    public  void doubleClickByMouse(WebDriver driver,WebElement element){
        Actions action=new Actions(driver);
        action.doubleClick(element);
    }
    public void mouseHoverToElement(WebDriver driver,WebElement trgElement){
        Actions action=new Actions(driver);
        action.moveToElement(trgElement);
    }

}
