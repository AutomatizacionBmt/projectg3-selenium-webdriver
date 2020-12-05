package com.company.pages;

import com.company.models.RedmineProject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RedmineProjectsPage extends RedmineLandingPage{

    private By btnNewProject = By.xpath("//a[text()='New project']");
    private By txtNombreProyecto = By.id("project_name");
    private By txtDescripcion = By.id("project_description");
    private By txtHomePage = By.id("project_homepage");
    private By chbPublicProject = By.id("project_is_public");
    private By btnCreate = By.name("commit");
    private By lblMessage = By.id("flash_notice");


    public RedmineProjectsPage(WebDriver driver){
        super(driver);
    }

    public void createProject(RedmineProject project){

        driver.findElement(btnNewProject).click();

        driver.findElement(txtNombreProyecto).sendKeys(project.getName());
        driver.findElement(txtDescripcion).sendKeys(project.getDescription());
        driver.findElement(txtHomePage).sendKeys(project.getHomePage());

        WebElement  checkboxProject = driver.findElement(chbPublicProject);
        if(project.getIsPublic()){
            if(!checkboxProject.isSelected())
                checkboxProject.click();
        }else{
            if (checkboxProject.isSelected())
                checkboxProject.click();
        }

        driver.findElement(btnCreate).click();
    }

    public String getUIMessage(){

        //Explicit Wait
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.presenceOfElementLocated(lblMessage));

        return driver.findElement(lblMessage).getText();
    }
}
