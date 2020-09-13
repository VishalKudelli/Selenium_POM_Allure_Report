package com.applicationmodules;

import com.genericmethods.GenericMethods;
import com.objectrepository.HomePage_OR;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends GenericMethods {
    private static HomePage_OR homePage_or;
    private static HomePage homePage;

    private HomePage(){
        homePage_or= PageFactory.initElements(driver, HomePage_OR.class);
        System.out.println("Object is created for Home Page its OR");
    }

    public static HomePage getInstance(){
        if (homePage==null) homePage=new HomePage();
        return homePage;
    }

    public void navigateToRegistrationPage(){
        hoverAndClick("Home Page","Register",homePage_or.link_Register);
        getScreenshot();
    }
//    public void navigateToLoginPage(){
//        hoverAndClick("Home Page","Log In",homePage_or.link_Login);
//    }

}
