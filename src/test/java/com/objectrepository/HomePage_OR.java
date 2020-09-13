package com.objectrepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage_OR {

    @FindBy(xpath = "//a[text()=\"Register\"]")public WebElement link_Register;
    @FindBy(xpath = "//a[text()=\"Log in\"]")public WebElement link_Login;
}
