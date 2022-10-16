package com.cybertek.tests.day3_webelement_intro;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class verifyURLchanged {
    public static void main(String[] args) throws InterruptedException {
     /*   Verify URL changed
        open chrome browser
        go to http://practice.cybertekschool.com/forgot_password Links to an external site.
        enter any email
        click on Retrieve password
        verify that url changed to http://practice.cybertekschool.com/email_sent
      */

        // 1-  open chrome browser    //utilities package inin icinde WebDriverFactory adinda methodumuz var, o methodu incele

        WebDriver driver = WebDriverFactory.getDriver( "CHroMe");  //buyuk kucuk harf farketmiyor cunku
                                                                 // WebDriverFactory getDriver methodu hepsini kucuk harfe donusturuyor
        //2-        go to http://practice.cybertekschool.com/forgot_password Links to an external site.
        driver.get( "http://practice.cybertekschool.com/forgot_password" );

        //3-enter any email
        WebElement emailInputBox = driver.findElement( By.name( "email" ) );  //parantez icini inspect ile buldu ve yazdi.
        emailInputBox.sendKeys( "mike@smith.com" ); //farkli emailde koyulabilir. burda run yapinca bu email email yazdigimiz yerde belirdi


        //4_        click on Retrieve password button    //retriew :geri alma - buttonu
        WebElement retriewPasswordButton = driver.findElement( By.id( "form_submit" ) );
        retriewPasswordButton.click();
        // Thread.sleep( 3000 ); // 3 sn beklemesi icin buraya koyabilirim cunku internet zayif olunca bazen sonuc Fail cikabiliyor, bunu kullaninca bu sorunu cozebilirim
        //hata verirse Thread.sleep exception nin uzerine tikla


        //5-        verify that url changed to http://practice.cybertekschool.com/email_sent

        String expectedUrl = "http://practice.cybertekschool.com/email_sent";

        //saving actual url from browser after we enter any email and click retrieve password button
        String actualUrl = driver.getCurrentUrl();
        if (expectedUrl.equals( actualUrl )) {                                                  //actual url test sonucu ortaya cikan url
            System.out.println( "PASS" );    //"PASS".sout+enter tusuna bas-->kisa yol

        } else {
            System.out.println( "FAIL" );                           //fark varmi gorebilmek icin asagidakileri ekledim
            System.out.println( "expectedUrl = " + expectedUrl );   // expectedUrl+dot+soutv
            System.out.println( "actualUrl = " + actualUrl );
        }

        driver.quit(); //close browser


    }
}
