package com.cybertek.tests.day9_waits;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class ImplicitWaitExample {


    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); //qa enviroment ta eger islem 20 sn veya 30 sn den daha fazla suruyorsa cok yavas demektir
                                                                              //asagidaki herbir method dan once max 30 sn veriyor, bu cok buyuk bir rakam
        //asagida herbir findElement icin max 30 sn bekleyebilir, asagidaki methodlar run olurken tabikide 30 sn icinde run olmuyorlar , ama 30 sn icnde elementi bulmalilar
        //eger findElement 30 sn icinde bulamazsa , it will throw no suchelement exception
        //thread i kullandigimizda tahmini bir sn koyuyoruz, ama bunda zaman ne fazla nede az oluyor
        //30 sn icinde webelement i bulamazsa , it will throw nosuchElementexception


    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        //Thread.sleep(2000);
        driver.quit();
    }

    @Test
    public void test1() throws InterruptedException {
        driver.get("http://practice.cybertekschool.com/dynamic_loading/4");

        WebElement element = driver.findElement(By.cssSelector("#finish"));

        System.out.println(element.getText());

    }
}
/*HOW FIND ELEMENT METHODS WORK ?
we provide locator and try to find element to do same actions using findElement method
IF element FOUND,
it will return WebElement
IF element does NOT FOUND
a.it will check do we have implicitly wait set ?
-it will keep trying to find element up to time we set.
1.if it finds within the time, it will return the element.
2.if it cannot find up to time we set, it will throw NoSuchElementException
b.if there is no implicitly wait set, it will throw NoSuchElementException
This waits for elements to be found in HTML, It only works when we call findElement
method.
Implicitily wait only waits until the element located.
Implicitily wait is set once, then it isued by rest of the program. If we have many findElement methods, they will all use the same implicitlyWait.
As long as findElement method finds the webelement on the html, it does NOT care is it interactible,visible,clickible or not.
 it will reutrn the element. So implicilty wait will not solve our elementNotInteractible problmes.
IF ELEMENT IN THE HTML, findElement WILL NOT COMPLAIN.
*/