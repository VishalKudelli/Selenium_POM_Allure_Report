package com.objectrepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegistrationPage_OR {
    @FindBy(xpath = "//input[@id='gender-male']")public WebElement rdo_Male;
    @FindBy(xpath = "//input[@id='gender-female']")public WebElement rdo_Female;
    @FindBy(xpath = "//input[@id='FirstName']")public WebElement txt_FirstName;
    @FindBy(xpath = "//input[@id='LastName']")public WebElement txt_LastName;
    @FindBy(xpath = "//select[@name='DateOfBirthDay']")public WebElement dd_Day;
    @FindBy(xpath = "//select[@name='DateOfBirthMonth']")public WebElement dd_Month;
    @FindBy(xpath = "//select[@name='DateOfBirthYear']")public WebElement dd_Year;
    @FindBy(xpath = "//input[@name='Email']")public WebElement txt_Email;
    @FindBy(xpath = "//input[@name='Company']")public WebElement txt_Company;
    @FindBy(xpath = "//input[@name='Password']")public WebElement txt_Pwd;
    @FindBy(xpath = "//input[@name='ConfirmPassword']")public WebElement txt_CnfPwd;
}
