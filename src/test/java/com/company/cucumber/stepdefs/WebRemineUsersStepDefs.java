package com.company.cucumber.stepdefs;

import com.company.models.RedmineUser;
import com.company.pages.RedmineHomePage;
import com.company.pages.RedmineUserPage;
import com.company.utils.AppUtil;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Entonces;
import io.cucumber.java.es.Y;
import org.junit.Assert;

import java.util.Map;

public class WebRemineUsersStepDefs {

    BaseStepDefs baseStepDefs;
    RedmineHomePage redmineHomePage;
    RedmineUserPage redmineUserPage;

    RedmineUser redmineUser;

    public WebRemineUsersStepDefs(BaseStepDefs baseStepDefs) {
        this.baseStepDefs = baseStepDefs;
    }

    @Cuando("Yo registro un usuario")
    public void yoRegistroUnUsuario(Map<String, String> userData) {

        redmineHomePage = (RedmineHomePage) baseStepDefs.currentPage;
        redmineUserPage = (RedmineUserPage) redmineHomePage.clickOnLink("ADMINISTRATION");

        redmineUserPage.clickOnLinkUsers();
        redmineUserPage.clickOnLinkNewUsers();

        String number = AppUtil.generateRandomNumber();

        redmineUser = new RedmineUser();
        redmineUser.setUsername(userData.get("username") + number);
        redmineUser.setFirstname(userData.get("firstname") + number);
        redmineUser.setLastname(userData.get("lastname") + number);
        redmineUser.setEmail(redmineUser.getUsername() + userData.get("email"));
        redmineUser.setLanguage(userData.get("language"));
        redmineUser.setAdministrator(Boolean.parseBoolean(userData.get("administrator")));
        redmineUser.setPassword(userData.get("password"));

        redmineUserPage.createNewUser(redmineUser);

    }

    @Entonces("El usuario fue registrado satisfactoriamente")
    public void elUsuarioFueRegistradoSatisfactoriamente() {

        Assert.assertEquals("No se registró correctamente el usuario",
                "User " + redmineUser.getUsername() + " created.",
                redmineUserPage.getUIMessageCreateUser());

        System.out.println("Se registró correctamente el usuario: " + redmineUser.getUsername());

    }

    @Y("el usuario deberia visualizarce en la lista de usuarios")
    public void elUsuarioDeberiaVisualizarceEnLaListaDeUsuarios() {

        redmineUserPage.clickOnLinkUsers();
        Boolean userExist = redmineUserPage.userIsOnList(redmineUser.getUsername());
        System.out.println("¿Existe el usuario en la lista? -> " + userExist);

        Assert.assertTrue(userExist);
    }

    @Cuando("Yo elimino el usuario de la lista de usuarios")
    public void yoEliminoElUsuarioDeLaListaDeUsuarios() {

        redmineUserPage.clickOnLinkUsers();
        redmineUserPage.clickLinkDeleteUser(redmineUser.getUsername());
        redmineUserPage.removeUser();

    }

    @Entonces("el usuario no deberia visualizarce en la lista de usuarios")
    public void elUsuarioNoDeberiaVisualizarceEnLaListaDeUsuarios() {

        redmineUserPage.clickOnLinkUsers();
        Boolean userExist = redmineUserPage.userIsOnList(redmineUser.getUsername());
        System.out.println("¿Existe el usuario en la lista? -> " + userExist);

        Assert.assertFalse(userExist);
    }

    @Cuando("Yo no elimino el usuario de la lista de usuarios")
    public void yoNoEliminoElUsuarioDeLaListaDeUsuarios() {

        redmineUserPage.clickOnLinkUsers();
        redmineUserPage.clickLinkDeleteUser(redmineUser.getUsername());
        redmineUserPage.doNotRemoveUser();
    }
}
