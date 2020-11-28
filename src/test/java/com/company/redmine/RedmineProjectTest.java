package com.company.redmine;

import com.company.base.BaseTest;
import com.company.pages.RedmineHomePage;
import com.company.pages.RedmineLoginPage;
import org.junit.Test;

public class RedmineProjectTest extends BaseTest {

    @Test
    public void testCreateProjectRedmine(){

        RedmineLoginPage redmineLoginPage = redmineLandingPage.clickLinkLogin();
        RedmineHomePage redmineHomePage = redmineLoginPage.login("user", "bitnami1");

        redmineHomePage.clickOnLink("MY PAGE");

        System.out.println("Test.....");

    }

}
