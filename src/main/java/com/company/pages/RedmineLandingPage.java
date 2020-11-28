package com.company.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RedmineLandingPage {

    protected WebDriver driver;

    private By linkLogin = By.cssSelector("a.login");


    public RedmineLandingPage(WebDriver driver){
        this.driver = driver;
    }

    public void clickLinkLogin(){

        driver.findElement(linkLogin).click();
    }

}
