package actitime.testScripts;

import actitime.GenericLib.BaseClass;

import org.openqa.selenium.By;

import org.testng.annotations.Test;

import java.io.IOException;


public class TypeOfWorkAlert extends BaseClass {

    @Test
    public void alertHandeling() throws IOException {
        driver.findElement(By.className("popup_menu_button_settings")).click();
        driver.findElement(By.linkText("Types of Work")).click();
        driver.findElement(By.className("i")).click();
        driver.findElement(By.id("name")).sendKeys(du.getDataFromExcelFile("type of work", 1, 1));
        driver.findElement(By.xpath("//td[@id='ButtonPane']/input[contains(@value,'Cancel')]")).click();
        System.out.println(cu.getMessageFromAlert(driver));
        cu.actionOnAlert(driver, "cancel");
    }
}
