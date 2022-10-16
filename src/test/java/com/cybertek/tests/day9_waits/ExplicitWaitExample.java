package com.cybertek.tests.day9_waits;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ExplicitWaitExample {


    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver( "chrome" );

    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep( 2000 );
        driver.quit();
    }

    @Test
    public void test1() throws InterruptedException {
        driver.get( "http://practice.cybertekschool.com/dynamic_loading/1" );
//click start Button then inputbox( enter username box) appears
        driver.findElement( By.xpath( "//button[contains(text(),'Start')]" ) ).click();

        WebElement usernameInput = driver.findElement( By.id( "username" ) );

        //HOW TO WAIT EXPLICITLY ?      //line 38-45 arasini yazmadan once run ettigimizde -->element not interactable  -->consolda belirdi
        //cunku birkac saniyeligine 5-6 sn hicbirsey belirmedi ,acmaya calisti, it was not visible on the screen
        //buyuzden explicitwait kullanildi

        //create Explicit wait object
        WebDriverWait wait = new WebDriverWait( driver, 10 ); //buraya 3 sn koysaydik error verirdi, cunku yaklasik 5 sn icinde visible , gorunur oluyor

        wait.until( ExpectedConditions.visibilityOf( usernameInput ) ); //visible olana kadar bekliyor , websitesinde ornegin  (parametreye element i koyuyoruz)
        // biryeri acacagiz ama 5 sn icinde aciliyor, biz sonra gorebiliyoruz
        //visibiltyOf methodunu kullandik cunku start buttonuna basmadan once inputbox i goremiyorduk, tiklamadan yaklasik 5 sn sonra gorunur oldu
        //ExpectedConditions is a class ve visibilityOf is a method of this class


        usernameInput.sendKeys( "MikeSmith" );

    }

    @Test
    public void test2() {
        driver.get( "http://practice.cybertekschool.com/dynamic_controls" );

        //click enable button
        driver.findElement( By.xpath( "//*[.='Enable']" ) ).click();   // nokta text() ile ayni    "//*[this()='Enable']"

        //finding inputbox
        WebElement inputBox = driver.findElement( By.cssSelector( "#input-example>input" ) );  // > isaretle css de child tag a gecti

        WebDriverWait wait = new WebDriverWait( driver, 10 );  //buraya bekleme suresini az koydugumuzdan test fails
                                                                       //consolda: TimeoutException: Expected condition failed: waiting for element to be clickable:


        wait.until( ExpectedConditions.elementToBeClickable( inputBox ) );  //burda elementtobeclickable methodunu kullnamamizin sebebi
                                                                          // enable buttonuna tiklamadan hemen ustundeki bosluk kutusuna tiklamak mumkun degildi.


        inputBox.sendKeys( "MikeSmith" );

    }

/*Explicitly wait
Sometimes we might locate the element but we cannot interact with it within certain time.
we have to wait until it is visible, clicikble, enabled,has certains text or dissapear.
when we have to wait for these cases, we will use explicit wait.
2 step to use explicit wait, first craete the object pass parameters
WebDriverWait wait = new WebDriverWait(driver,10);
WebDriverWait --> clas used to explicit waits
it takes 2 parameters driver, time in seconds
use object to wait until specific conditions for webelement or case.
wait.until(ExpectedConditions.elementToBeClickable(inputBox));
ExpectedConditions-->contains conditions for wait that we can wait using WebDriverWait
Depending on what condition we are using, we can pass webelement,bylocator or text to ExpectedConditions.
Explicit wait waits for the condition to complete, once the condition is met, it will stop waiting(dynamic).
if the condition is not met and the time runs out we got TimeoutException
  */

/*
Implicit, Explicit and Fluent Wait are the different waits used in Selenium. Usage of these waits are totally based on
the elements which are loaded at different intervals of time. It is always not recommended to use Thread.Sleep() while
Testing our application or building our framework.

Difference Between Implicit Wait Vs Explicit Wait
Following is the main difference between implicit wait and explicit wait in Selenium:

Implicit Wait	                                                           Explicit Wait
*Implicit Wait time is applied to all the elements in the script    * Explicit Wait time is applied only to those elements which are intended by us
*In Implicit Wait, we need not specify “ExpectedConditions”         * In Explicit Wait, we need to specify “ExpectedConditions” on the element to be located
  on the element to be located
*It is recommended to use when the elements are located with        * It is recommended to use when the elements are taking long time
the time frame specified in Selenium implicit wait                  to load and also for verifying the property of the element like(visibilityOfElementLocated,
                                                                    elementToBeClickable,elementToBeSelected)


 */
}