package com.herokuapp.pages;

import com.aventstack.extentreports.Status;
import com.herokuapp.customlisteners.CustomListeners;
import com.herokuapp.utility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class SecurePage extends Utility {
    @CacheLookup
    @FindBy(xpath = "//h2[text()=' Secure Area']")
    WebElement secureAreaText;

    //This method verify secure area text is displayed
    public String getSecureAreaText(){
        Reporter.log("Verify the text “Secure Area” is displayed" + secureAreaText.toString());
        String text = getTextFromElement(secureAreaText);
        CustomListeners.test.log(Status.PASS,"Verify the text “Secure Area”");
        return text;
    }
}
