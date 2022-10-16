package com.cybertek.tests.day12_properties_driver_tests;

import com.cybertek.utilities.Driver;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class SingletonTest {   //Singleton deyince su aklima gelecek--> ayni objecti heryerde kullaniyorum ve bu object sadece bir class ta olusturulabilir ornegin Driver class

    //@Test
    public void test1(){  //s1 ve s2 ayni objecte point olmus
        String s1 = Singleton.getInstance();
        String s2 = Singleton.getInstance();

        System.out.println("s1 = " + s1);
        System.out.println("s2 = " + s2);
    }


    @Test
    public void test2() throws InterruptedException { //bu 1.yol , test 3 te 2.yol gosteriliyor ,oylede yapabiliriz
        WebDriver driver = Driver.get();    //Driver class i singleton a bir ornek, heryerde sadece bu object ile islem yapabiliyoruz
        Thread.sleep(2000);
        driver.get("https://www.google.com");

    }

    @Test
    public void test3(){
       // WebDriver driver = Driver.get();  //onceden =WebDriverFactory.getDriver(browserType:"chrome"); diyorduk, simdi browseri dynamic hale getirdik ayni seyi Driver.get();
                                            // ile yaptik ve direkt browser olarak configuration.properties teki browser i secti
                                            //ve son olarak WebDriver driver in object e assign etmemizede da gerek yok , bu kismida yazmayacagiz , yerine Driver.get yeterli , bu kisim is returning to object

       // driver.get("https://www.amazon.com");


        Driver.get().get("https://www.amazon.com");  //Birinci get method Driver class ina ait bizi browser a goturuyor , 2, get method da bizi url ye bagliyor , 2. get method selenyuma ait , bu sekildede yapabiliriz
                                                     //ama birincisi daha anlasilabilir okunur, 2. si de daha kolay
    }

}

//WebDriverFactory yerine daha gelismis olanini Driver clasini (in utilities package) singleton olarak kullanacagiz
//Driver.get() methodu ile driver i elde ederiz, sonra driver.get("url")