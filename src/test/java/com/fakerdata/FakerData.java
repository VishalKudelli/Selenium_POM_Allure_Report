package com.fakerdata;

import com.github.javafaker.Faker;
import com.github.javafaker.service.FakeValuesService;
import com.github.javafaker.service.RandomService;

import java.util.Locale;

public class FakerData {
    private static FakerData fakerData;
    private Faker faker;
    private String password;

    private FakerData(){
        faker =new Faker();
    }
    public static FakerData getInstance(){
        if (fakerData==null) fakerData=new FakerData();
        return fakerData;
    }

    public String getFirstName(){
        return faker.name().firstName();
    }
    public String getLastName(){
        return faker.name().lastName();
    }
    public String getGender(){
        return faker.name().prefix();
    }
    public String getDay(){
        return faker.date().toString();
    }
    public String getMonth(){
        return faker.date().birthday().toString();
    }
    public String getYear(){
        return faker.date().birthday().toString();
    }
    public String getEmail(){
        FakeValuesService fakeValuesService = new FakeValuesService(
                new Locale("en-GB"), new RandomService());
        String email=fakeValuesService.bothify("????##@gmail.com");
        return email;
    }
    public String getCompany(){
        return faker.company().name();
    }
    public String getAddress1(){
        return faker.address().buildingNumber();
    }
    public String getAddress2(){
        return faker.address().streetAddress();
    }
    public String getCity(){
        return faker.address().city();
    }
    public String getZipCode(){
        return faker.address().zipCode();
    }
    public String getState(){
        return faker.address().state();
    }
    public String getCountry(){
        return faker.address().country();
    }
    public String getPhoneNum(){
        return faker.phoneNumber().cellPhone();
    }
    public String getPassword(){
        FakeValuesService fakeValuesService = new FakeValuesService(
                new Locale("en-GB"), new RandomService());
        password=fakeValuesService.bothify("????##????##");
        return password;
    }
    public String getCnfPassword(){
        return password;
    }

}
