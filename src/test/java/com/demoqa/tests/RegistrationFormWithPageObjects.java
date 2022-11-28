package com.demoqa.tests;

import com.codeborne.selenide.Configuration;
import com.demoqa.tests.pages.RegistrationFormPage;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


public class RegistrationFormWithPageObjects {
    RegistrationFormPage registrationFormPage = new RegistrationFormPage();

    @BeforeAll
    static void setUp() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.holdBrowserOpen = true;
        Configuration.browserSize = "1920x1080";
    }

    @Test
    void fillFormTest() {
        registrationFormPage.openPage()
                .setFirstName("Egor")
                .setLastName("Egorov")
                .setEmail("Egor@egor.com")
                .setGender("Male")
                .setUserNumber("0123456789")
                .setBirthDate("30", "June", "1972")
                .setSubject("Maths")
                .setHobby("Sports")
                .setPicture("img/1.png")
                .setCurrentAddress("Current address test")
                .setCity("Uttar Pradesh", "Lucknow");

        registrationFormPage.checkResultsTableVisible().
                checkResult("Student Name", "Egor Egorov")
                .checkResult("Student Email", "Egor@egor.com")
                .checkResult("Gender", "Male")
                .checkResult("Mobile", "0123456789")
                .checkResult("Date of Birth", "30 June,1972")
                .checkResult("Subjects", "Maths")
                .checkResult("Hobbies", "Sports")
                .checkResult("Picture", "1.png")
                .checkResult("Address", "Current address test")
                .checkResult("State and City", "Uttar Pradesh Lucknow");


    }
}

