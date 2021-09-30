package com.project.login;

import com.project.utilities.BasePage;
import com.project.utilities.Common;
import com.project.utilities.en;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage implements en{
    Common common = PageFactory.initElements(driver,Common.class);

    public LoginPage(){
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath ="//input[@value= 'Login']")
    @CacheLookup
    WebElement LoginButton;
}
