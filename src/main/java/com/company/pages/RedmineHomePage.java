package com.company.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RedmineHomePage extends RedmineLandingPage{

    private By menuMyPage = By.xpath("//a[@href='/my/page']");
    private By menuMyProjects = By.xpath("//a[@href='/projects']");
    private By menuMyAdmin = By.xpath("//a[@href='/admin']");
    private By menuHelp = By.xpath("//a[@href='https://www.redmine.org/guide']");


    private By lblUserLogged = By.id("loggedas");

    public RedmineHomePage(WebDriver driver){
        super(driver);
    }

    public String getUserLogged(){
        //String userLogged = driver.findElement(lblUserLogged).getText();
        return  driver.findElement(lblUserLogged).getText();
    }

    public RedmineProjectsPage clickOnLink(String option) {


        switch (option.toLowerCase()) {

            case "my page":
                driver.findElement(menuMyPage).click();
                break;
            case "projects":
                driver.findElement(menuMyProjects).click();
                break;
            case "administration":
                driver.findElement(menuMyAdmin).click();
                break;
            case "help":
                driver.findElement(menuHelp).click();
                break;
            default:
                throw new IllegalStateException("The option: " + option.toLowerCase() + "is not present");
        }

        return new RedmineProjectsPage(driver);
    }
}