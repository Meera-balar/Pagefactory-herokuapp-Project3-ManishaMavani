package com.herokuapp.pages;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.model.Report;
import com.herokuapp.customlisteners.CustomListeners;
import com.herokuapp.utility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class LoginPage extends Utility {
    @CacheLookup
    @FindBy(id = "username")
    WebElement userNameField;
    @CacheLookup
    @FindBy(id = "password")
    WebElement passwordField;

    @CacheLookup
    @FindBy(xpath = "//i[contains(text(),'Login')]")
    WebElement loginButton;

    @CacheLookup
    @FindBy(xpath = "//div[@id = 'flash']")
    WebElement userNameErrorMessage;

    @CacheLookup
    @FindBy(xpath = "//div[@class = 'flash error']")
    WebElement passwordErrorMessage;

    //This method enter username
    public void enterUserName(String username) {
        Reporter.log("Enter username " + username + " to username field " + userNameField.toString());
        sendTextToElement(userNameField, username);
        CustomListeners.test.log(Status.PASS, "Enter Username " + username);
    }

    //This method enter password
    public void enterPassword(String password) {
        Reporter.log("Enter password " + password + " to password field " + passwordField.toString());
        sendTextToElement(passwordField, password);
        CustomListeners.test.log(Status.PASS, "Enter Password " + password);
    }

    //This method click on login button
    public void clickOnLoginButton() {
        Reporter.log("Clicking on Login Button " + loginButton.toString());
        clickOnElement(loginButton);
        CustomListeners.test.log(Status.PASS, "Click on loginButton");
    }

    //This method verify error message for invalid username
    public String getUsernameErrorMessage() {
        Reporter.log("Verify the error message “Your username is invalid!” is displayed" + userNameErrorMessage.toString());
        String text = getTextFromElement(userNameErrorMessage);
        CustomListeners.test.log(Status.PASS, "Verify the error message “Your username is invalid!”");
        return text;
    }

    //This method verify error message for invalid password
    public String getPasswordErrorMessage() {
        Reporter.log("Verify the error message “Your password is invalid!” is displayed" + passwordErrorMessage.toString());
        String text = getTextFromElement(passwordErrorMessage);
        CustomListeners.test.log(Status.PASS, "Verify the error message “Your password is invalid!”");
        return text;
    }
}
