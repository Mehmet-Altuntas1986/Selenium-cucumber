package com.cybertek.tests.day4_ID_locater;


import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class IDlocaterTest {
    public static void main(String[] args) {


        WebDriver driver= WebDriverFactory.getDriver( "CHROME" );
        driver.get("http://practice.cybertekschool.com/multiple_buttons");

        //CLICK      DONT'T CLICK        BUTTON  (static, degisken yapiya sahip degil)
        WebElement DontClickButton =driver.findElement( By.id( "disappearing_button" ) );  //burdaki id dynamic, degisken yapiya sahip olabilir inspect te , refreh yapilinca anlasiliyor
        //id is a locator ,  can be dynamic, changable or static (sabit yapida)  how it affects my test case? refresh e websitesinde
        // birkac kere tikla. eger degisik degerler gosterirse onu test icin kullanamam, kullanmam guvenilir olmaz (refresh yap ve inspecte id degerlerine bak)
//button 3 dynamic, degisken-->practice.cybertekschool.com/multiple_buttons  bu url yi ac ve incele refresh ve inspect ile


        DontClickButton.click(); //tiklaninca bu button yok oldu



    }
}
