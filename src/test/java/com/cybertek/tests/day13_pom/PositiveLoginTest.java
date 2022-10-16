package com.cybertek.tests.day13_pom;

import com.cybertek.pages.LoginPage;
import com.cybertek.tests.TestBase;
import com.cybertek.utilities.ConfigurationReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PositiveLoginTest extends TestBase {

//driver_username and driver_passwords are coming from configuration.properties
    //
    @Test
    public void loginAsDriver(){

        LoginPage loginPage = new LoginPage();

     /*   bu methodu LoginPage clasinda olusturmustum
     public void loginAsDriver(){
            //configutation reader reads configuration.properties
            String username = ConfigurationReader.get("driver_username");  //configuration.properties ile baglantiyi kurdu
            String password = ConfigurationReader.get("driver_password");

            usernameInput.sendKeys(username);     //WebElement name is usernameInput   , FindBy ile locater i bulunmus ve WebDriver usernameInput; ile declare edilmis
            passwordInput.sendKeys(password);     //Burdada ayni
            loginBtn.click();
        } WebElement lere keys atacagiz

      */
        loginPage.loginAsDriver();    //Login as driver methodunu olusturdum , yukarida ki islevi kisa bir yolla
                                     // yapmis oldum. isleri kisaltmak icin methodlar olusturmka lazim

        Assert.assertEquals(driver.getCurrentUrl(),"https://qa1.vytrack.com/");


    }

    @Test
    public void loginAsStoreManager(){

        LoginPage loginPage = new LoginPage();  //LoginPage class inin icini kisayol ile goremke icin command+b ye tikla

        String username = ConfigurationReader.get("storemanager_username"); //key parantezin icinde-->configutation.properties
        String password = ConfigurationReader.get("storemanager_password");
        loginPage.login(username,password);

        Assert.assertEquals(driver.getCurrentUrl(),"https://qa1.vytrack.com/");


    }

    @Test
    public void loginAsStoreManager2(){  //Loginpage te method olusturuldu bunun icin --ismi  loginAsStoreManager();

        LoginPage loginPage = new LoginPage();

        loginPage.loginAsStoreManager();

        Assert.assertEquals(driver.getCurrentUrl(),"https://qa1.vytrack.com/");


    }



}