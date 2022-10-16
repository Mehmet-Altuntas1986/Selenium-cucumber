package com.cybertek.tests.day10_actions_js;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class JavaScriptExecuterDemo {

    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        driver = WebDriverFactory.getDriver("chrome");

    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        // driver.quit();
    }

    @Test
    public void clickWithJS(){   //CLICK WITH JAVA SCRIPT
        driver.get("http://practice.cybertekschool.com/");

        WebElement dropdownLink = driver.findElement(By.linkText("Dropdown"));
        JavascriptExecutor jse = (JavascriptExecutor) driver;

        jse.executeScript("arguments[0].click();", dropdownLink);//selenium da bazen click calismaz, bu durumda javascript ile click yapariz

    }
       //how to click an element in selenium WebDriver using JavaScript  --> google da yazip bakabiliriz
    @Test
    public void typeWithJS(){  //JS -> JAVASCRIPT
        driver.get("http://practice.cybertekschool.com/dynamic_controls");

        WebElement inputBox = driver.findElement(By.cssSelector("#input-example>input"));   //  #  represents id  and  > isareti ile child tab a gecis yapti

        JavascriptExecutor jse = (JavascriptExecutor) driver;   //burda casting driver to JavascriptExecutor , so that we can use cse

        String text = "Hello Disabled Input";  //locate ettigimiz Box in icindeki yazi

        jse.executeScript("arguments[0].setAttribute('value', '" + text +"')", inputBox);   //inputBox IS Weblement

    }

    @Test
    public void ScrollDownAndUp() throws InterruptedException {  //sayfayi asagiya getirme
        driver.get("http://practice.cybertekschool.com/infinite_scroll");
        driver.manage().window().maximize();

        JavascriptExecutor jse = (JavascriptExecutor) driver;   //JavascriptExecutor is an interface
//for dongusu ile web sitesinde sag taraftaki bar cubuk  asagiya dogru 10 kere gidecek ve sayfa asagiya dogru hareket edecek
        for (int i = 0; i < 10; i++) {
            Thread.sleep(1000);  //beklemeyi koyunca websayfasinin asagiya dogru hareketi iyi gozlemlenebildi
            jse.executeScript("window.scrollBy(0,250)"); //scroll down

        }

        for (int i = 0; i < 10; i++) {
            Thread.sleep(1000);
            jse.executeScript("window.scrollBy(0,-250)"); //scroll up

        }


    }

    @Test
    public void scrollToElement() throws InterruptedException {

        driver.get("https://www.amazon.com/");   //amazon sayfasina en alttaki english dil secenegini gormek istiyoruz, direk scroll down yapacak
        WebElement eng = driver.findElement(By.id("icp-touch-link-language"));
        Thread.sleep(2000);
        JavascriptExecutor jse = (JavascriptExecutor) driver;

        jse.executeScript("arguments[0].scrollIntoView(true);",eng);  //eng is english ,  scrollIntoView ile sayfaa asagi gidiop bize english buttonu nu gosteriyor


    }



}