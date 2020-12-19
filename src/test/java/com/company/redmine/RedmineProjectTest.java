package com.company.redmine;

import com.company.base.BaseTest;
import com.company.models.RedmineProject;
import com.company.pages.RedmineHomePage;
import com.company.pages.RedmineLoginPage;
import com.company.pages.RedmineProjectsPage;
import com.company.utils.AppUtil;
import org.junit.Assert;
import org.junit.Test;

public class RedmineProjectTest extends BaseTest {

    @Test
    public void testCreateProjectRedmine() {

        RedmineLoginPage redmineLoginPage = redmineLandingPage.clickLinkLogin();
        RedmineHomePage redmineHomePage = redmineLoginPage.login("user", "bitnami1");
        RedmineProjectsPage redmineProjectsPage = (RedmineProjectsPage) redmineHomePage.clickOnLink("PROJECTS");

        String randomNumber = AppUtil.generateRandomNumber();

        RedmineProject project = new RedmineProject();
        project.setName("RedmineProject" + randomNumber);
        project.setDescription("Esta es una descripcion " + randomNumber);
        project.setHomePage("RedmineProject" + randomNumber);
        project.setIsPublic(true);


        redmineProjectsPage.createProject(project);

        Assert.assertEquals("El proyecto no se registró correctamente", "Successful creation.",
                redmineProjectsPage.getUIMessage());
    }

}
