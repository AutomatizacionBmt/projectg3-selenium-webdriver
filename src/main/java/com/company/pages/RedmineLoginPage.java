package com.company.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RedmineLoginPage extends RedmineLandingPage{

    private By txtUsername = By.id("username");
    private By txtPassword = By.name("password");
    private By btnLogin = By.xpath("//*[@id='login-submit']");

   public RedmineLoginPage(WebDriver driver){
       super(driver);
   }

   public void login(String userName, String password){
       driver.findElement(txtUsername).sendKeys(userName);
       driver.findElement(txtPassword).sendKeys(password);
       driver.findElement(btnLogin).click();
   }



}
