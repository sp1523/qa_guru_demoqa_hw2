package com.demoqa.tests.pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.demoqa.tests.pages.components.CalendarComponent;
import com.demoqa.tests.pages.components.CityComponent;
import com.demoqa.tests.pages.components.ResultsTableComponent;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class RegistrationFormPage {

    //Elements
    private ResultsTableComponent resultsTableComponent = new ResultsTableComponent();

    private final CalendarComponent calendarComponent = new CalendarComponent();

    private CityComponent cityComponent = new CityComponent();
    private final SelenideElement firstNameInput = $("#firstName");
    private final SelenideElement lastNameInput = $("#lastName");
    private final SelenideElement emailInput = $("#userEmail");
    private final SelenideElement genderInput = $("#genterWrapper");
    private final SelenideElement  numberInput =   $("#userNumber");

    private final SelenideElement subjectInput = $("#subjectsInput");

    private  final SelenideElement hobbyInput = $("#hobbiesWrapper");

    private  final SelenideElement pictureInput = $("#uploadPicture");

    private  final SelenideElement currentAddressInput = $("#currentAddress");

    private final static String Title_Text = "Student Registration Form";


    //Actions

    public RegistrationFormPage openPage() {
        open ( "/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text(Title_Text));
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");
        return this;

    }

    public  RegistrationFormPage  setFirstName(String value){
        firstNameInput.setValue(value);
        return this;
    }

    public  RegistrationFormPage  clearFirstName(String value){
        firstNameInput.clear();
        return this;
    }

    public  RegistrationFormPage  setLastName(String value){
        lastNameInput.setValue(value);
        return this;
    }

    public  RegistrationFormPage  setEmail(String value){
        emailInput.setValue(value);
        return this;
    }
    public  RegistrationFormPage  setGender(String value) {
        genderInput.$(byText(value)).click();
        return this;
    }

    public  RegistrationFormPage  setUserNumber(String value) {
        numberInput.setValue(value);
        return this;
    }

        public RegistrationFormPage setBirthDate (String day, String month, String year)
        {
            $("#dateOfBirthInput").click();
          calendarComponent.setDate(day, month, year);
            return this;
        }

    public RegistrationFormPage checkResultsTableVisible ()
    {
     resultsTableComponent.checkVisible();
        return this;
    }

    public RegistrationFormPage checkResult (String key, String value){
        resultsTableComponent.checkResult(key,value);
        return this;


    }
    public  RegistrationFormPage  setSubject(String value) {
        subjectInput.setValue(value).pressEnter();
        return this;
    }

    public  RegistrationFormPage  setHobby(String value) {
        hobbyInput.$(byText(value)).click();
        return this;
    }

    public  RegistrationFormPage  setPicture (String path) {
        pictureInput.uploadFromClasspath(path);

        return this;
    }
    public  RegistrationFormPage  setCurrentAddress (String value) {
        currentAddressInput.setValue(value);
        return this;
    }

    public RegistrationFormPage setCity (String state, String city)
    {

        cityComponent.setStateCity(state,city);
        return this;
    }

}