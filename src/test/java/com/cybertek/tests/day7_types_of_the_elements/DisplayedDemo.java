package com.cybertek.tests.day7_types_of_the_elements;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DisplayedDemo {
    //Start button una click etmeden once bu kisim gozukmuyordu, tikladiktan sonra username ve password girmek icin 2 box belirdi.
@Test
public void test1() throws InterruptedException {
    WebDriver driver= WebDriverFactory.getDriver( "CHROME" );
    driver.get( "http://practice.cybertekschool.com/dynamic_loading/1" );
    WebElement usernameInput=driver.findElement( By.id("username") );

    System.out.println( "usernameInput.isDisplayed() = " + usernameInput.isDisplayed() );
    //task
    // 1-verify username inputbox is not displayed on the screen
    //2-click start button
    // 3-verify username displayed on the screen


    // 1-verify username inputbox is not displayed on the screen

    Assert.assertFalse( usernameInput.isDisplayed(),"verify inputbox is not displayed" );

    //2-click start button
    driver.findElement (By.cssSelector( "#start>button" )).click();
    Thread.sleep( 6000 );  //START BUTTONINA TIKLA VE SAY YAKLASIK KAC SANIYE ICINDE ACILIYOR , BUNU KOYMAYINCA HATA VERIYOR

    // 3-verify username displayed on the screen
    Assert.assertTrue( usernameInput.isDisplayed(),"verify username inputbox is displayed " );
    Thread.sleep( 6000 );
}
}

//display metdonu neden kullaniyoruz? ornegin  username i inspectte goruyoruz ama websitesinde gozukmuyor, gorebilmemeiz icin
//start button una tiklamamiz lazim , bu durumda gorunur olmasi icin displayed methoduna basvuruyoruz