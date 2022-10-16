package com.cybertek.tests.day3_webelement_intro;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class verifyURLnotChanged {

    public static void main(String[] args) {
        /*Verify URL not changed
           -open chrome browser
           -go to http://practice.cybertekschool.com/forgot_password Links to an external site.
           -click on Retrieve password button
           -verify that url did not change

         */

         //1-open chrome browser
        WebDriver driver= WebDriverFactory.getDriver( "chrome" );  //bos olan bir chrome sayfasi acar

       // 2-go to http://practice.cybertekschool.com/forgot_password Links to an external site.

        driver.get("http://practice.cybertekschool.com/forgot_password");

        //save expected url before clicking button
        String expectedUrl=driver.getCurrentUrl();  //4.adimda kullanacagim , burassi butona tiklamadan onceki url i verir, expected url ismi farkli da olabilir, biz koyduk

       //3 -click on Retrieve password
                                      //WebElement --> Interface that represent elements on the webpage
                                     //findElement --> method used to find element on a page
                                     //driver represents browser
        WebElement retrievePasswordButton=driver.findElement( By.id("form_submit") ); //web sitesinde inspect yapti form submit i (button) bulup yapistirdi
        retrievePasswordButton.click();


        //save actula url after clicking button

        String actualUrl=driver.getCurrentUrl();

        //4--verify that url did not change    (nasil anlarim-->before i click the button and after i click the button --> url ne , aynimi
      if(expectedUrl.equals( actualUrl )) {
          System.out.println( "pass" );
      }else{
              System.out.println("fail");




              //5-close your browser (gecmis aktivitelerimizi de gostermez bir sonraki acisimizda cunku quit i kullaniyoruz)
          driver.quit();
      }
    }
}

//2.adimdan sonra acilan web sitesinde, sola tikla -->inspect te tikla---> en ust en soldaki oka tikla ve
// sol tarafta web elementlerinin uzerinde mouse ile gezin boylece sag tarafte ne ile yapilmis gormus olacaksin
//eger id i gorursek bu bizi button ni bulmamizi saglar, bazen id omayabilir bu durumda nasil button i bulacagiz sonraki derslerde ogrenecegiz

//everything we see in a web are web elements
//3.adimda ogretmen retrievePasswordButton nin object (cunku String) oldugunu soyledi, baska isimde verebilirddik , new demedik
//3.adimda driver -->browser i temsil ediyor, button lari selenyum ile kullanirken browserda bulunduklari icin driver ile islem yapacagiz