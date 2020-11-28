package com.company.pages;

import com.company.models.RedmineProject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RedmineProjectsPage extends RedmineLandingPage{

    //Identificar todos los elementos
    private By txtNombreProyecto = By.id("project_name");
    private By txtDescripcion = By.id("project_description");


    public RedmineProjectsPage(WebDriver driver){
        super(driver);
    }

    public void createProject(RedmineProject project){

        driver.findElement(txtNombreProyecto).sendKeys(project.getName());
        driver.findElement(txtDescripcion).sendKeys(project.getDescription());

    }



}
