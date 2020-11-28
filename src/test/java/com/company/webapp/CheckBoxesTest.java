package com.company.webapp;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CheckBoxesTest {

    @Test
    public void selectingCheckbox(){

        System.setProperty("webdriver.chrome.driver", "resources/drivers/chrome/chromedriver");
        WebDriver driver = new ChromeDriver();

        driver.get("file:///Users/jhumbertoh/Downloads/projectg3-selenium-webdriver-main/webapp/checkboxes.html");

        WebElement checkbox = driver.findElement(By.id("lettuceCheckbox"));
        checkbox.click();
        checkbox.click();
        checkbox.click();

        Assert.assertTrue("El checkbox no esta seleccionado", checkbox.isSelected());

        driver.quit();
    }

}
