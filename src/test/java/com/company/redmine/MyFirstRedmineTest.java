package com.company.redmine;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class MyFirstRedmineTest {

    @Test
    public void myFirstTest(){

        //webdriver.chrome.driver

        //Para Windows
        //System.setProperty("webdriver.chrome.driver", "resources/drivers/chrome/chromedriver.exe");

        //Para Linux o MAC OS
        System.setProperty("webdriver.chrome.driver", "resources/drivers/chrome/chromedriver");

        WebDriver driver = new ChromeDriver();

        driver.get("http://db168820d6a9.ngrok.io");

        //Maximizar la ventana
        //driver.manage().window().maximize();

        //Pantalla completa
        //driver.manage().window().fullscreen();

        //Especificando una dimensión por ejemplo (iPhoneX)
        driver.manage().window().setSize(new Dimension(375,812));

        System.out.println("");
        driver.quit();

    }

    @Test
    public void loginRedmineTest(){

        System.setProperty("webdriver.chrome.driver", "resources/drivers/chrome/chromedriver");
        WebDriver driver = new ChromeDriver();

        driver.get("http://db168820d6a9.ngrok.io");


        WebElement linkLogin = driver.findElement(By.linkText("Iniciar sesión"));

        System.out.println("Interrupción..");

        linkLogin.click();

        System.out.println("Interrupción..");

        WebElement txtUsername = driver.findElement(By.id("username"));
        txtUsername.sendKeys("jhurtado");

        WebElement txtPassword = driver.findElement(By.name("password"));
        txtPassword.sendKeys("12345678");

        // XPath  Relativo = //*[@id="login-submit"]
        // XPath Absoluto = /html/body/div[2]/div[2]/div[1]/div[3]/div[2]/div[1]/form/input[6]

        WebElement btnLogin = driver.findElement(By.xpath("//*[@id='login-submit']"));
        btnLogin.click();

        WebElement divLogin = driver.findElement(By.id("loggedas"));

        String userExpected = "Logged in as jhurtado";
        String userActual = divLogin.getText();

        Assert.assertEquals("Error en login",userExpected,userActual);

        driver.quit();
    }
}
