package com.cybertek.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriverFactory {
/*Task
Write a static method that takes string parameter name:browserType
Based on the value of parameter
it will set up the browser and
the method will return chromedriver or firefoxdriver object.
name of the method:getDriver
 */
    //resources file inini icinde exel file i var -->uzantisi xlsx
    //Method static --> yani class a ait--  class ismi .dot ile ulasabiliriz bu methoda
    //WebDriver is a interface

   // static WebDriver driver=null;    bu sekilde yapsaydik static oldugu icin class in icindeki methodlarda da kullanilabilir, ama methodun icine koyduk

    public static WebDriver getDriver(String browserType){ //WebDriver is a kind of object , there is  no void
        WebDriver driver=null; //Local variables must be initialized before use, as they don't have a default value and
                               // the compiler won't let us use an uninitialized value.

 switch (browserType.toLowerCase()){
     case "chrome":
         WebDriverManager.chromedriver().setup(); //set browser
         driver=new ChromeDriver();
         break;
     case "firefox":
         WebDriverManager.firefoxdriver().setup();
         driver=new FirefoxDriver();
         break;


 }
        return driver;
    }

}


//The variable used in a switch statement can only be integers, convertable integers (byte, short, char), Strings and enums.