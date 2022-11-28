package com.demoqa.tests.pages.components;


import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class ResultsTableComponent {

private final static String Title_Text = "Thanks for submitting the form";


        public ResultsTableComponent checkVisible ()
        {
            $(".modal-dialog").should(appear);
            $("#example-modal-sizes-title-lg").shouldHave(text(Title_Text));
            return this;
        }


    public ResultsTableComponent checkResult (String key, String value)
    {
        $(".table-responsive table").$(byText(key)).parent().shouldHave(text(value));
        return this;
    }
    }