package com.cybertek.tests.day4_ID_locater;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class classNameTest {
    public static void main(String[] args) {


        WebDriver driver= WebDriverFactory.getDriver( "chrome" );
        driver.get( "http://practice.cybertekschool.com/sign_up" );  //bu sitedeki home button nini inspect yap ---< bize class locater ini gosterecek

    //class locator da birden fazla sayida olabilir, 1. olani sec bu durumda

        WebElement homeLink =driver.findElement( By.className("nav-link") );
        homeLink.click();

        driver.get(  "http://practice.cybertekschool.com/multiple_buttons" ); // inspect yapinca--->   <h3 class="h3">Multiple buttons</h3>
                                                                            // h3 tag ve class tag ikiside bu multiple buttons i gosteriyor
//print multiple buttons header
        System.out.println( driver.findElement( By.className( "h3" ) ).getText()); //Multiple buttons //getText ve getAttribute kullanilabiliyor
     //[[ChromeDriver: chrome on MAC (98b5c98cce352f3107dc1d2612662b33)] -> class name: h3] yukarida gettext i kullanmazsak bunu consolda goruruz--reference

    }
}

//if there is a space in the value of a class , we dont  use it--inspect e bak. ornegin <button class="btn btn_primary".......
// btn ile diger btn arasinda bosluk var cunku bosluk olunca ayri yazilanlar farkli siniflardan geliyor
/*Usage of class is unique, means we use class in order to locate more than one element

tag 'a' represent a link-->    <a class="nav-link" href="/">Home</a>      home button inini linki

link ile cok ugrasacagiz , isimizi kolaylastiran 2 locator var linkText and partialLinkTest

 */