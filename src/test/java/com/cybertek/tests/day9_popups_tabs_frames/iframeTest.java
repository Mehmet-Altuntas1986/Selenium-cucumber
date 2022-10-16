package com.cybertek.tests.day9_popups_tabs_frames;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class iframeTest {  //iframe divides the webpage ,yani birden fazla html body var bu durumda. we can have different html ,source codes,text codes
                           //iframe varsa -->we should switch to the html we are trying to locate a webelement
                           //selenium can point only one html at the same time

    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        driver = WebDriverFactory.getDriver("chrome");
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }

    @Test
    public void test1() throws InterruptedException {
        driver.get("http://practice.cybertekschool.com/iframe");

        //How to switch frames
        //1.Switch using by name or ID attribute of iframe        =>o frame icinde bulunan bir elementin -->name or id String ini parametre olarak sadece kabul ediyor birde index numaaralarini int olarak
//gitmek istedigin frame icinde bir elementin id veya name ini sec
        driver.switchTo().frame("");  //diyelimki burda small html e gittik  //burda id kullanildi switch icin   --mce_0_ifr

        //clear before sendkeys
        driver.findElement(By.cssSelector("#tinymce")).clear();  //manauel olarak type yaptigimiz kisimda yazilar varsa , clear method siler onlari
                                                                 //your content goes here yazisi silindi
        Thread.sleep(1000);
        driver.findElement(By.cssSelector("#tinymce")).sendKeys("MikeSmith");

        //goes back to first frame(main html)   //buyuk html e donus yapiyoruz
        //goes back to first frame, useful when we have switched multiple frames
        driver.switchTo().defaultContent();   //1-first-->bu sekilde buyuk html e donus yapabiliriz yada index kullaniriz

        //2.Switching with INDEX
        driver.switchTo().frame(0);   //ana html bir tane iframe i oldugunda yani ana html in icinde  bir tane kucuk html  varsa , kucuk html(iframe) in index i   0 olur
        Thread.sleep(1000);

        //clear before sendkeys
        driver.findElement(By.cssSelector("#tinymce")).clear();
        Thread.sleep(1000);
        driver.findElement(By.cssSelector("#tinymce")).sendKeys("MikeSmith WITH INDEX");

        //second way to switch parent -->ana html
        driver.switchTo().frame( 0 );

        //3.USING WEBELEMENT
        //locating iframe with any valid locator
        WebElement iframeElement = driver.findElement(By.tagName("iframe"));

        driver.switchTo().frame(iframeElement);

        Thread.sleep(1000);
        driver.findElement(By.cssSelector("#tinymce")).sendKeys("MikeSmith WITH WEBELEMENT");

        //html
        //top
        //left
        //middle
        //firstframe
        //secondframe
        //right
        //bottom
        /*
        We can switch one at a time, cannot switch to grandchild directly.
·       We cannot switch to siblings.
·       We can only switch from parent to child, or from child to parent.
         */


    }

    @Test
    public void test2(){
        driver.get("http://practice.cybertekschool.com/nested_frames");

        //switching to frame top
        driver.switchTo().frame("frame-top");
        //top has 3 frame under ,--->left , middle and right
        //switch to frame middle
        driver.switchTo().frame("frame-middle");

        System.out.println(driver.findElement(By.id("content")).getText());

               //goes back to top frame        //once top frame e gidiyoruz sonra digerlerine ulasim mumkun oluyor
        //kardes frame lereden birbirine gecilemiyor //you can only switch from parent to child
        driver.switchTo().parentFrame();

        //switching right with index
        driver.switchTo().frame(2);

        System.out.println(driver.findElement(By.tagName("body")).getText());

        //go to main html to switch bottom
        driver.switchTo().defaultContent();

        driver.switchTo().frame(1);

        System.out.println(driver.findElement(By.tagName("body")).getText());

/*  5 tane frame var (html)       --> 6 html    ==> boyle bircok html oldugunda boyle resmetmek isleri kolaylastirir

          HTML(Default Content)
              0 frame-top(parent frame)
     index        0   left
                  1   middle
                  2   right
              1 frame-bottom


           frame top dan frame bottom a gecilemez ,ANA HTML DEN GECIS SAGLANABILIR
           KARDESLER (SIBLINGS) ARASI GECIS YOK --> FRAME TOP TAN FRAME BOTTOM E GECILMEZ,,  HTML DEN FRAME BOTTOM YADA FRAME TOP A GECEBILIRSIN
*/

    }
  //https://www.guru99.com/handling-iframes-selenium.html   learn all from this website
}

/*
We can even identify total number of iframes by using below snippet.

Int size = driver.findElements(By.tagName("iframe")).size();

Basically, we can switch over the elements and handle frames in Selenium using 3 ways.

By Index
By Name or Id
By Web Element


***It is impossible to click iframe directly through XPath since it is an iframe. First we have to switch to the frame and then we can click using xpath.
first switch to iframe then find element or elements.


 */

