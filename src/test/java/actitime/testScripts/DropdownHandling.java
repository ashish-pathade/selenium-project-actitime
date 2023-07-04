package actitime.testScripts;

import actitime.GenericLib.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class DropdownHandling extends BaseClass {
    @Test
    public void  dropdownHandling(){
        driver.findElement(By.className("popup_menu_button_settings")).click();
        driver.findElement(By.xpath("//div[text()='Manage system settings & configure actiTIME']")).click();
       WebElement dropdown= driver.findElement(By.id("firstHierarchyLevelCodeSelect"));
       cu.fetchingDataFromDDByText(dropdown,"Product Line");
      String msg= driver.findElement(By.id("FormModifiedTextCell")).getText();
        Reporter.log(msg,true);
    }
}
