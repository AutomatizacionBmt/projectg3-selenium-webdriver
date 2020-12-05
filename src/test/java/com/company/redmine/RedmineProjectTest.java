package com.company.redmine;

import com.company.base.BaseTest;
import com.company.models.RedmineProject;
import com.company.pages.RedmineHomePage;
import com.company.pages.RedmineLoginPage;
import com.company.pages.RedmineProjectsPage;
import org.junit.Test;

public class RedmineProjectTest extends BaseTest {

    @Test
    public void testCreateProjectRedmine(){

        RedmineLoginPage redmineLoginPage = redmineLandingPage.clickLinkLogin();
        RedmineHomePage redmineHomePage = redmineLoginPage.login("user", "bitnami1");
        RedmineProjectsPage redmineProjectsPage = redmineHomePage.clickOnLink("PROJECTS");

        RedmineProject project = new RedmineProject();
        project.setName("Nombre del Proyecto");
        project.setDescription("Esta es una descripcion");



        redmineProjectsPage.createProject(project);


        //Assert que se agregó correctamente (Mensaje satisfactorio);

        System.out.println("Test.....");

    }

}
