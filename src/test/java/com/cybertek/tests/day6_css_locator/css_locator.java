package com.cybertek.tests.day6_css_locator;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class css_locator {
    public static void main(String[] args) {
        WebDriver driver= WebDriverFactory.getDriver( "CHROME" );
        driver.get( "http://practice.cybertekschool.com/multiple_buttons" );

        WebElement dontClick=driver.findElement( By.cssSelector("#disappearing_button") );    //TagName#idValue
                                                                                                //Symbol looking for ID

        System.out.println(dontClick.getText());
        driver.quit();
    }
}
