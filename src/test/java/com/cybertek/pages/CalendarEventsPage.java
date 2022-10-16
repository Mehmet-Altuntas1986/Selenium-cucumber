package com.cybertek.pages;

import com.cybertek.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CalendarEventsPage extends BasePage {

    public CalendarEventsPage() {
        PageFactory.initElements(Driver.get(), this);   //PageFactory-->seleniuma ait bir class
    }

    @FindBy(css = "[title='Create Calendar event']")
    public WebElement createCalendarEvent;

}


//calender event is in activities module of vytRACK WEBSITE

//cclanedereventspage   ve createcalenderevenetspage --> Calender Events bir locater var , tiklayinca birsuru sekme var , bu yuzden  createcalenderevenetspage olusturuldu