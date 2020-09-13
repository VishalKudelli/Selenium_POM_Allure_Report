package com.commontestannotations;

import com.genericmethods.GenericMethods;
import com.testdata.ReadJsonFile;
import org.json.simple.parser.ParseException;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.io.IOException;
import java.lang.reflect.Method;

public class CommonTestAnnotations {
    @BeforeSuite
    public void beforeSuite() throws IOException, ParseException {
        System.out.println("Before Suite");
        ReadJsonFile readJsonFile=new ReadJsonFile();
        readJsonFile.loadJSONFile();
    }

    @AfterSuite
    public void afterSuite(){
        System.out.println("After Suite");
        GenericMethods genericMethods=new GenericMethods();
        genericMethods.closeApplication();
    }

    @BeforeMethod
    public void beforeMethod(Method m){
        GenericMethods.currentTestCase= m.getName();
    }

}
