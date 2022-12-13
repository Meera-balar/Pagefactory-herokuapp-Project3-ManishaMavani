package com.herokuapp.testsuite;

import com.herokuapp.customlisteners.CustomListeners;
import com.herokuapp.pages.LoginPage;
import com.herokuapp.pages.SecurePage;
import com.herokuapp.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
@Listeners(CustomListeners.class)
public class LoginPageTest extends BaseTest {

    LoginPage loginPage;
    SecurePage securePage;
    @BeforeMethod(alwaysRun = true)
    public void inIt(){
        loginPage = new LoginPage();
        securePage = new SecurePage();
    }


    @Test(groups = {"sanity","regression"})
    public void UserShouldLoginSuccessfullyWithValidCredentials(){
        loginPage.enterUserName("tomsmith");
        loginPage.enterPassword("SuperSecretPassword!");
        loginPage.clickOnLoginButton();
        String expectedText = "Secure Area";
        Assert.assertEquals(securePage.getSecureAreaText(),expectedText,"Secure Area text is not displayed");
    }
    @Test(groups = {"smoke","regression"})
    public void verifyTheUsernameErrorMessage(){
        loginPage.enterUserName("tomJohn");
        loginPage.enterPassword("SuperSecretPassword!");
        loginPage.clickOnLoginButton();
        Assert.assertTrue(loginPage.getUsernameErrorMessage().contains("Your username is invalid!"),"Username error message is not displayed");
    }
    @Test(groups = "regression")
    public void verifyThePasswordErrorMessage(){
        loginPage.enterUserName("tomsmith");
        loginPage.enterPassword("SuperSecretPassword");
        loginPage.clickOnLoginButton();
        Assert.assertTrue(loginPage.getPasswordErrorMessage().contains("Your password is invalid!"),"Password error message is not displayed");
    }
}
