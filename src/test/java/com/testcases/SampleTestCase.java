package com.testcases;

import com.applicationmodules.HomePage;
import com.applicationmodules.RegistrationPage;
import com.commontestannotations.CommonTestAnnotations;
import com.genericmethods.GenericMethods;
import io.qameta.allure.*;
import org.testng.annotations.Test;

public class SampleTestCase extends CommonTestAnnotations {
    @Test(groups = "Smoke Test")
    @Description("Register New User")
    @Severity(SeverityLevel.CRITICAL)
    @Epic("Registration")
    @Feature("Update")
    @Story("User Story 12344654")
    public void TC_01(){

        GenericMethods genericMethods=new GenericMethods();
        genericMethods.launchBrowser("opera","https://demo.nopcommerce.com/");

        HomePage homePage=HomePage.getInstance();
        homePage.navigateToRegistrationPage();

        RegistrationPage registrationPage=RegistrationPage.getInstance();
        registrationPage.fillRegistrationPage();

    }
}
