package com.cybertek.tests.day2_webdriver_basics;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.WebDriver;

public class CallWebDriverFactory {  //WebDriverFactory adinda onceden bir class acmistik, onu cagiracagiz (utilities package in icinden)

    public static void main(String[] args) {

        WebDriver driver= WebDriverFactory.getDriver( "firefox" );  //google da koyabiliriz  //WebDriverFactory.getDriver bize driver i veriyor
        driver.get("http://www.google.com");
        String title=driver.getTitle();
        System.out.println( "title = " + title );  //soutv + enter  short cut

    }
}
