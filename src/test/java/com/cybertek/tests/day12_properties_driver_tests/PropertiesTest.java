package com.cybertek.tests.day12_properties_driver_tests;

import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class PropertiesTest {

    @Test
    public void test1(){

        String browserType = ConfigurationReader.get("browser");

        System.out.println("browserType = " + browserType);
        System.out.println("Browser: "+ConfigurationReader.get("browser"));

        String url = ConfigurationReader.get("url");

        System.out.println("url = " + url);


    }

    @Test
    public void OpenBrowserWithConf(){//configuration browserdaki url ve browser calisiyor, baglanti isini configurationReader class i yapiyor

        WebDriver driver = WebDriverFactory.getDriver(ConfigurationReader.get("browser"));//onceki derslerde parantez icine chrome yaziyorduk ,
                                              // simdi configuration.properties de koydugumuz browser ile calisabilir
                                              //browser degisikligi yapma isini configuration.properties kisminda yapacagiz

        driver.get(ConfigurationReader.get("url"));  //configuration.properties de bulunan url , degisklik yapinca  onfiguration.properties de yapiyoruz

        String username = ConfigurationReader.get("driver_username");  //configuration.properties de bulunan key value ,box in icine gider
        String password = ConfigurationReader.get("driver_password");

        driver.findElement(By.id("prependedInput")).sendKeys(username);
        driver.findElement(By.id("prependedInput2")).sendKeys(password+ Keys.TAB);  //ornegin web sayfasinda bir boxin icindesin,
                                                                                                // tab a tiklayinca alttaki box in icine geciyor

    }


}
//sirasiyla once PropertiesTest, Singleton,SingletonTest sonra Utilities package inda Driver i copy paste yapin  dedi