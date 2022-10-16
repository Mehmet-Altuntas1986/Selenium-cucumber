package com.cybertek.tests.day4_ID_locater;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class nameLocaterTest {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver= WebDriverFactory.getDriver("chrome"  );  //bos bir chrome sayfasi acar

        //make browser full screen
        driver.manage().window().maximize();  //maximize yerine fullscreen i sectigimizde macte calismiyor, windows bilgisayarlarda calisiyor


        driver.get( "http://practice.cybertekschool.com/sign_up" );  //bu linki acar

        WebElement fullNameInput =driver.findElement( By.name("full_name") );  //inspect te name kismina bak

        Thread.sleep( 2000 ); //2 sn ye bekle --> ben koydum buraya
        fullNameInput.sendKeys( "Mike Smith" );  //full name isimli box un icine bu deger gidecek, bir nevi yazmis olacagim

 //TASK:put some email and click sign up button

      //proper way
        WebElement emailInput= driver.findElement( By.name( "email" ) );
        emailInput.sendKeys( "mike@smith.com" );

        //lazy way ---yukaridaki proper way ikiside ayni isi yapar
        driver.findElement( By.name( "email" ) ).sendKeys( "mike@smith.com" );




      // proper way
        WebElement signUpButton=driver.findElement( By.name("wooden_spoon") );
        signUpButton.click();
      //lazy way
        driver.findElement( By.name("wooden_spoon") ).click();



    }
}
//Bazen developerlar id yi unique yapmiyor yada , otomatik olarak kendini yenileyen id ler olabiliyor , bu durumda baska locater kullan, developerlari uyar
//id is all the time same but problem it can sometimes be changeable,dynamic , in this case we dont use it in test automation , instead we use name

//name is static, not changeable but it can be duplicate --> ornegin  http://practice.cybertekschool.com/radio_buttons
//url yi ac ve blue red yellow black in yanindaki yuvarlak buttonlari inspect yap --> name degerlerine bakinca ayni seyin yazili oldugunu goreceksin


//once id ye bak , eger o dynamic ise name locater ina bak ve onu kullan

//if we cannot find name or id , we look for tagName--> head ,body ,......vs