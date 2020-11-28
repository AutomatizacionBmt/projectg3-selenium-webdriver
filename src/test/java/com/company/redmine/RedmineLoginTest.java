package com.company.redmine;


import com.company.base.BaseTest;
import org.junit.Test;

public class RedmineLoginTest extends BaseTest {


    @Test
    public void testLoginRedmine(){

        redmineLandingPage.clickLinkLogin();

        System.out.println("Test....");

    }

}
