package com.company.webapp;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class RadioButtonsTest {


    @Test
    public void choosingRadioButton() {

        //Para Windows
        //System.setProperty("webdriver.chrome.driver", "resources/drivers/chrome/chromedriver");

        System.setProperty("webdriver.chrome.driver", "resources/drivers/chrome/chromedriver");
        WebDriver driver = new ChromeDriver();

        driver.get("file:///Users/jhumbertoh/Proyectos/Publicos/projectg3-selenium-webdriver/webapp/radibuttons.html");

        /*Para Windows
        driver.get("file:///D:/folder/radibuttons.html");
         */

        List<WebElement> radioButtons = driver.findElements(By.name("color"));
        System.out.println("Interrupción..");

        radioButtons.get(1).click();
        radioButtons.get(2).click();
        radioButtons.get(0).click();

        driver.quit();
    }

    @Test
    public void gettingRadioButtonValue() {

        System.setProperty("webdriver.chrome.driver", "resources/drivers/chrome/chromedriver");
        WebDriver driver = new ChromeDriver();

        driver.get("file:///Users/jhumbertoh/Proyectos/Publicos/projectg3-selenium-webdriver/webapp/radibuttons.html");

        List<WebElement> radioButtons = driver.findElements(By.name("color"));
        radioButtons.get(1).click();

        String colorActual = "";
        String colorExpected = "green";

        for (WebElement radioButton : radioButtons) {

            if (radioButton.isSelected()) {
                colorActual = radioButton.getAttribute("value");
                break;
            }
        }

        Assert.assertEquals("Color inválido", colorExpected, colorActual);

        driver.quit();
    }
}
