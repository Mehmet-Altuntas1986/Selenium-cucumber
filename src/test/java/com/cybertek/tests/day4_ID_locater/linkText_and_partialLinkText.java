package com.cybertek.tests.day4_ID_locater;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class linkText_and_partialLinkText {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver=WebDriverFactory.getDriver( "CHROME" );
        driver.get( "http://practice.cybertekschool.com/dynamic_loading" );

        WebElement link1=driver.findElement( By.linkText("Example 1: Element on page that is hidden and become visible after trigger"));
        link1.click();                                   //bukadar uzun yazi yerine unique olacak sekilde sadece Example 1 secip partialLinkText i de kullanabilirim


        driver.get( "http://practice.cybertekschool.com/dynamic_loading" );

        WebElement link4=driver.findElement( By.partialLinkText( "Example 4" ) );
        link4.click();



    }
}
