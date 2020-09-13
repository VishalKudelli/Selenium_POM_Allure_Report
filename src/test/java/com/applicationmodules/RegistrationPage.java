package com.applicationmodules;

import com.fakerdata.FakerData;
import com.genericmethods.GenericMethods;
import com.objectrepository.RegistrationPage_OR;
import org.openqa.selenium.support.PageFactory;

public class RegistrationPage extends GenericMethods {

    private static RegistrationPage_OR registrationPage_or;
    private static RegistrationPage registrationPage;
    private FakerData fData=FakerData.getInstance();

    private RegistrationPage(){
        registrationPage_or= PageFactory.initElements(driver, RegistrationPage_OR.class);
        System.out.println("Object is created for Home Page its OR");
    }

    public static RegistrationPage getInstance(){
        if (registrationPage==null) registrationPage=new RegistrationPage();
        return registrationPage;
    }

    public void fillRegistrationPage() {
        String gender = getData("Gender");
        if (gender.trim().equalsIgnoreCase("Male")) {
            hoverAndClick("Registration Page", "Male", registrationPage_or.rdo_Male);
        }
        else {
            hoverAndClick("Registration Page", "Female", registrationPage_or.rdo_Female);
        }
        String firstName = fData.getFirstName(); //getData("FirstName");
        clickAndSendData("Registration Page","First Name",registrationPage_or.txt_FirstName,firstName);

        String lastName = fData.getLastName(); //getData("LastName");
        clickAndSendData("Registration Page","Last Name",registrationPage_or.txt_LastName,lastName);

        //Select DOB
        selectDropDownByVisibleText(registrationPage_or.dd_Day,"3");
        selectDropDownByVisibleText(registrationPage_or.dd_Month,"August");
        selectDropDownByVisibleText(registrationPage_or.dd_Year,"1994");

//        clickAndSendData("Registration Page","Email",registrationPage_or.txt_Email,getData("Email"));
//        clickAndSendData("Registration Page","Company",registrationPage_or.txt_Company,getData("Company"));
//        clickAndSendData("Registration Page","Password",registrationPage_or.txt_Pwd,getData("Password"));
//        clickAndSendData("Registration Page","Confirm Password",registrationPage_or.txt_CnfPwd,getData("CnfPassword"));

        clickAndSendData("Registration Page","Email",registrationPage_or.txt_Email,fData.getEmail());
        clickAndSendData("Registration Page","Company",registrationPage_or.txt_Company,fData.getCompany());
        clickAndSendData("Registration Page","Password",registrationPage_or.txt_Pwd,fData.getPassword());
        clickAndSendData("Registration Page","Confirm Password",registrationPage_or.txt_CnfPwd,fData.getCnfPassword());
        getScreenshot();
    }

}
