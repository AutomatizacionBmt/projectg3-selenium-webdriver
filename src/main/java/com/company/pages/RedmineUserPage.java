package com.company.pages;

import com.company.models.RedmineUser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class RedmineUserPage extends RedmineLandingPage{

    private By linkUsers = By.xpath("//a[@href='/users']");
    private By linkNewUsers = By.xpath("//a[@href='/users/new']");

    private By txtUserName = By.xpath("//*[@id=\"user_login\"]");
    private By txtFirstName = By.xpath("//*[@id=\"user_firstname\"]");
    private By txtLastName = By.xpath("//*[@id=\"user_lastname\"]");
    private By txtEmail = By.xpath("//*[@id=\"user_mail\"]");
    private By cbxLanguage = By.xpath("//*[@id=\"user_language\"]");
    private By chbxAdministrator = By.xpath("//*[@id=\"user_admin\"]");
    private By txtPassword = By.xpath("//*[@id=\"user_password\"]");
    private By txtPasswordConfirmation = By.xpath("//*[@id=\"user_password_confirmation\"]");

    private By btnCreateUser = By.name("commit");
    private By lblUIMessage = By.xpath("//*[@id=\"flash_notice\"]");

    private By linkDelete = By.linkText("Delete");


    public RedmineUserPage(WebDriver driver) {
        super(driver);
    }

    public void createNewUser(RedmineUser user){

        driver.findElement(txtUserName).sendKeys(user.getUsername());
        driver.findElement(txtFirstName).sendKeys(user.getFirstname());
        driver.findElement(txtLastName).sendKeys(user.getLastname());
        driver.findElement(txtEmail).sendKeys(user.getEmail());

        WebElement webElementSelectLanguage = driver.findElement(cbxLanguage);

        Select selectLanguage = new Select(webElementSelectLanguage);
        selectLanguage.selectByVisibleText(user.getLanguage());

        WebElement  checkboxAdministrator = driver.findElement(chbxAdministrator);
        if(user.getAdministrator()){
            if(!checkboxAdministrator.isSelected())
                checkboxAdministrator.click();
        }else{
            if (checkboxAdministrator.isSelected())
                checkboxAdministrator.click();
        }

        driver.findElement(txtPassword).sendKeys(user.getPassword());
        driver.findElement(txtPasswordConfirmation).sendKeys(user.getPassword());
        driver.findElement(btnCreateUser).click();
    }

    public String getUIMessageCreateUser(){
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.presenceOfElementLocated(lblUIMessage));

        return driver.findElement(lblUIMessage).getText();
    }

    public void clickOnLinkUsers(){
        driver.findElement(linkUsers).click();
    }

    public void clickOnLinkNewUsers(){
        driver.findElement(linkNewUsers).click();
    }

    public Boolean userIsOnList(String userName){

        //WebElement table = driver.findElement(By.tagName("table"));
        //WebElement tbody = table.findElement(By.tagName("tbody"));
        //List<WebElement> usuarios = tbody.findElements(By.tagName("tr"));

        List<WebElement> userList =  driver.findElement(By.tagName("table"))
                .findElement(By.tagName("tbody"))
                .findElements(By.tagName("tr"));

        for (WebElement userRow : userList){
            //List<WebElement> listUserNames  = userRow.findElements(By.tagName("td"));
            //WebElement userNameRow = listUserNames.get(0);
            if(userName.equals(userRow.findElements(By.tagName("td")).get(0).getText()))
                return true;
        }

        return false;
    }

    public void clickLinkDeleteUser(String userName){

        List<WebElement> userList =  driver.findElement(By.tagName("table"))
                .findElement(By.tagName("tbody"))
                .findElements(By.tagName("tr"));

        for (WebElement userRow : userList){
            if(userName.equals(userRow.findElements(By.tagName("td")).get(0).getText())){
               userRow.findElements(By.tagName("td")).get(7).findElement(linkDelete).click();
               break;
            }
        }
    }

    public void removeUser(){
        driver.switchTo().alert().accept();
        //driver.switchTo().alert().getText();
        //driver.switchTo().alert().sendKeys("texto");
    }

    public void doNotRemoveUser(){
        driver.switchTo().alert().dismiss();
    }
}
