package com.cybertek.tests.day13_pom;

import com.cybertek.pages.CalendarEventsPage;
import com.cybertek.pages.CreateCalenderEventsPage;
import com.cybertek.pages.DashboardPage;
import com.cybertek.pages.LoginPage;
import com.cybertek.tests.TestBase;
import com.cybertek.utilities.BrowserUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RepeatOptionsTest extends TestBase {

    /*VERIFY RADIO BUTTONS
    Open Chrome browser
    Login as driver
    Go to Activities->Calendar Events
    Click on create calendar events
    Click on repeat
    Verify that repeat every days is checked  (choosen)
    verify that repeat weekday is not checked
    * */
                                                     //15 dk verdi cozmeleri icin  -bu tassklari ilerde tek basina yapmaya calis
    @Test
    public void test1(){

        LoginPage loginPage = new LoginPage();

        //Login as driver
        loginPage.loginAsDriver();   //LoginPage.navigateToModule diyemeyiz , cunku it is not extending to basepage

        DashboardPage dashboardPage = new DashboardPage();
        //Go to Activities->Calendar Events
        dashboardPage.navigateToModule("Activities","Calendar Events");

        CalendarEventsPage calendarEventsPage = new CalendarEventsPage();
        //Click on create calendar events
        //wait for loader mask
        calendarEventsPage.waitUntilLoaderScreenDisappear();
        BrowserUtils.waitForClickablility(calendarEventsPage.createCalendarEvent,5);  //50 sn de secsek dynamic oldugu icin zaman israfi olmaz.
        calendarEventsPage.createCalendarEvent.click();

        CreateCalenderEventsPage createCalendarEventsPage = new CreateCalenderEventsPage();
        // Click on repeat
        createCalendarEventsPage.repeat.click();

        //Verify that repeat every days is checked (choosen)
        Assert.assertTrue(createCalendarEventsPage.days.isSelected(),"Verify repeat days is selected");   //days is a WebElement
        //verify that repeat weekday is not checked
        Assert.assertFalse(createCalendarEventsPage.weekday.isSelected(),"Verify weekday is not selected");  //Weekday is a WebElement inCreateCalenderEventsPage class

    }

      /*
     VERIFY REPEAT OPTIONS
        Open Chrome browser
        Login as driver
        Go to Activities->Calendar Events
        Click on create calendar events button
        Click on repeat checkbox
        Verify that repeat options are Daily, Weekly, Monthly,Yearly(in this order)
     */

    @Test
    public void test2(){

        LoginPage loginPage = new LoginPage();

        //Login as driver
        loginPage.loginAsDriver();

        DashboardPage dashboardPage = new DashboardPage();
        //Go to Activities->Calendar Events
        dashboardPage.navigateToModule("Activities","Calendar Events");

        CalendarEventsPage calendarEventsPage = new CalendarEventsPage();
        //Click on create calendar events
        //wait for loader mask
        calendarEventsPage.waitUntilLoaderScreenDisappear();
        BrowserUtils.waitForClickablility(calendarEventsPage.createCalendarEvent,5);
        calendarEventsPage.createCalendarEvent.click();

        CreateCalenderEventsPage createCalendarEventsPage = new CreateCalenderEventsPage();
        // Click on repeat
        createCalendarEventsPage.repeat.click();

        Select repeatsDropdown = createCalendarEventsPage.repeatOptionsList();    //website da tikla--create claender events-->repeat---<repeats (is a dropdown)

        // Verify that repeat options are Daily, Weekly, Monthly,Yearly(in this order)
        List<String> expectedList = Arrays.asList("Daily","Weekly","Monthly","Yearly");  //SIRALAMA ARRAYLIST LERDE ONEMLI , SIRALAMAYI DEGISTIRIRSEN TEST FAILS

        List<String> actualList = new ArrayList<>();

        List<WebElement> actualOptions = repeatsDropdown.getOptions();
        for (WebElement option : actualOptions) {
            //get text of each element and add to actual List
            System.out.println(option.getText());
            actualList.add(option.getText());
        }
        System.out.println(actualList);
        //ready method for getting text of list of web elements
        List<String> actualList2 = BrowserUtils.getElementsText(actualOptions);
        //Verify that repeat options are Daily, Weekly, Monthly,Yearly(in this order)
        Assert.assertEquals(actualList,expectedList,"Verify Daily weekly monthly yearly");

    }
}

//pom yi kullanmamizin sebebi , writing the test case easily ,reusing the locaters ,methods