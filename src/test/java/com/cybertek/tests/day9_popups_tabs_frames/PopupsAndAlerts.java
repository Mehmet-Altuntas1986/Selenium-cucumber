package com.cybertek.tests.day9_popups_tabs_frames;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PopupsAndAlerts {  //bazi pop up lar clickable and inspectable fakat bazilarinda bu mumkun degil , ne yapariz bu durumda?

    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        driver = WebDriverFactory.getDriver("chrome");
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        //driver.quit();
    }

    @Test

    public void test1(){  //chrome notification ile bu pop up lar farkli , karistirma
        driver.get("https://www.primefaces.org/showcase/ui/overlay/confirmDialog.xhtml");

        //click the Destroy the World button -->bu web sitesinde bu button artik belirmiyor, eskiden beliriyordu (kendim yapmaliyim)
        driver.findElement(By.xpath("//span[.='Confirm ']")).click();  //confirm button inina click et

        //Click NO button
        driver.findElement(By.xpath("//button[.='No']")).click();

    }

    @Test
    public void test2() throws InterruptedException {
        driver.get("http://practice.cybertekschool.com/javascript_alerts"); //click 'for js alert' buttonuna tiklaninca cikan pop up i inspect edemiyoruz

        //click Click For JS Alert Button
        driver.findElement(By.xpath("//button[1]")).click(); //bu java degil index 1 den baslar

        //switch to JS alert pop up
        Alert alert = driver.switchTo().alert();   //Alert seleniuma ait   //object olusturuldu
        Thread.sleep(2000);
        alert.accept();

        //click for JS confirm
        driver.findElement(By.xpath("//button[2]")).click();
        Thread.sleep(2000);
        alert.dismiss();  // cancel and ok buttons   --> pop up in uzerinde -->click to cancel demek

        //click for JS Prompt
        driver.findElement(By.xpath("//button[3]")).click();
        //send keys to JS Prompt
        alert.sendKeys("MikeSmith");
        //click OK
        alert.accept();
    }

}
//in interview if they ask how to handle pop ups --> answer--> I use Alert  class

//java scriptten gelen popup ve alert leri inspect yapamiyoruz , buyuzden locater kullanamiyoruz , buyuzden biz Alert
// diye bir class imiz var, switch yapip onu kullaniyoruz

/*    • Following syntax is used for locating elements containing exact text within an element
     //TagName[text()=‘exact text’]      OR       //TagName[.=‘exact text’]

 */