package com.company.webapp;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TableTest {

    @Test
    public void gettingTableData() {

        System.setProperty("webdriver.chrome.driver", "resources/drivers/chrome/chromedriver");
        WebDriver driver = new ChromeDriver();

        driver.get("file:///Users/jhumbertoh/Downloads/projectg3-selenium-webdriver-main/webapp/table.html");

        WebElement outerTable = driver.findElement(By.tagName("table"));
        WebElement innerTable = outerTable.findElement(By.tagName("table"));

        /*List<WebElement> listWebElements = innerTable.findElements(By.tagName("td"));
        WebElement row = listWebElements.get(1);*/

        WebElement row = innerTable.findElements(By.tagName("td")).get(1);

        System.out.println("El texto obtenido es: " + row.getText());
        Assert.assertEquals("Table 2 Row 2", row.getText());
        driver.quit();
    }
}
