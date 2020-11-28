package com.company.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RedmineHomePage extends RedmineLandingPage{

    private By lblUserLogged = By.id("loggedas");

    public RedmineHomePage(WebDriver driver){
        super(driver);
    }

    public String getUserLogged(){
        //String userLogged = driver.findElement(lblUserLogged).getText();
        return  driver.findElement(lblUserLogged).getText();
    }
}
