package com.cybertek.tests.day13_pom;

import com.cybertek.pages.LoginPage;
import com.cybertek.tests.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NegativeLoginTest extends TestBase {  //login test inin negativini buraya yapiyor , yanlis sifre girince bir yazi belirir ya onun inspect ini kullaniriz , yada url de ki degisiklige bakariz
                                                   //eger url degismediyse log in yapamamisiz demektir
    LoginPage loginPage = new LoginPage();
    @Test
    public void wrongPasswordTest(){

//        LoginPage loginPage = new LoginPage();      //Buraya yazmaya gerek yok ,line 10 da olusturulmus

        loginPage.usernameInput.sendKeys("user1");  //driver.findElement(By.id("PrependInput")).sendKeys("user1");
        loginPage.passwordInput.sendKeys("somepassword"); //driver.findElement(By.id("PrependInput2")).sendKeys("somepassword");
        loginPage.loginBtn.click();                                   //driver.findElement(By.id("_submit")).click();

        Assert.assertEquals(driver.getCurrentUrl(),"https://qa1.vytrack.com/user/login");

    }
                        //ogretmen dk 27 de configuration.properties deki degerleri degistirdi ve dediki ayni verileri girin
    @Test
    public void wrongUsernameTest(){

//        LoginPage loginPage = new LoginPage();

        loginPage.usernameInput.sendKeys("someusername");
        loginPage.passwordInput.sendKeys("UserUser123");
        loginPage.loginBtn.click();

        Assert.assertEquals(driver.getCurrentUrl(),"https://qa1.vytrack.com/user/login");

    }


}

/*
Page Object Model and Page Factory:
1. Define and create a package for all the page objects from the application for logical grouping. For example,
 com.vytrack.pages is created to define all the page classes.

2. Create a new Java class file. Give the name of the page we will be testing from the application to this class.For
example, we will be creating a page class for the VYTrack application, so the class name could be LoginPage for login page.

What is PageFactory?
The PageFactory Class in Selenium is an extension to the Page Object design pattern. It is used to initialize the
 elements of the Page Object or instantiate the Page Objects itself.
It is used to initialize elements of a Page class without having to use ‘FindElement’ or ‘FindElements’


 */