package com.cybertek.tests.day10_actions_js;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class ActionsTest {


    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        driver = WebDriverFactory.getDriver("chrome");

    }

   // @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }
  //bazi durumlarda maus ile resmin uzerine gelince yazilar beliriyor resmin altinda, bu yazilari inspect ediyoruz
    @Test
    public void hoverTest() throws InterruptedException {
        driver.get("http://practice.cybertekschool.com/hovers");

        WebElement img1 = driver.findElement(By.tagName("img"));
        //Actions --> class that contains all the user interactions
        //how to create actions object --> passing driver as a constructor
        Actions actions = new Actions(driver);   //parantezin icine driver koyulmasinin sebebi , object ve browser arasinda baglanti kurmak
        //perform() --> perform the action, complete the action
        //moveToElement --> move you mouse to webelement(hover over)
        Thread.sleep(2000);
        actions.moveToElement(img1).perform();

        WebElement viewLink = driver.findElement(By.linkText("View profile"));  //resmin uzerine gelince altinda bir tane link vardi

        Assert.assertTrue(viewLink.isDisplayed(),"verify view link is displayed");

    }

    @Test
    public void dragAndDrop() throws InterruptedException {
        driver.get("https://demos.telerik.com/kendo-ui/dragdrop/index"); //driver ile acinca bir cookies cikiyor ekranda
        driver.manage().window().maximize();


        Actions actions = new Actions(driver);


        //cookies olayini bu sekilde halledebiliriz
        List<WebElement> acceptAndClose = driver.findElements(By.xpath("//*[.='Accept and Close']"));
        List<WebElement> acceptCookies = driver.findElements(By.xpath("//*[.='Accept Cookies']"));
        Thread.sleep(1000);
        if(acceptAndClose.size()>0){
            acceptAndClose.get(0).click();  //get the first element and click it
        }else if(acceptCookies.size()>0){
            acceptCookies.get(0).click();          //bazen accept cookies tiklanmadan bir sonraki stepe gecilemez
        }

        WebElement source = driver.findElement(By.id("draggable"));
        WebElement target = driver.findElement(By.id("droptarget"));


        Thread.sleep(2000);
        actions.dragAndDrop(source,target).perform();
    }

    @Test
    public void dragAndDropChaining() throws InterruptedException {
        driver.get("https://demos.telerik.com/kendo-ui/dragdrop/index");
        driver.manage().window().maximize();

        Actions actions = new Actions(driver);
  //Web elementini bulunca listede bir element olacagini dusun , bulamazsa empty
        List<WebElement> acceptAndClose = driver.findElements(By.xpath("//*[.='Accept and Close']"));
        List<WebElement> acceptCookies = driver.findElements(By.xpath("//*[.='Accept Cookies']"));
        Thread.sleep(1000);
        if(acceptAndClose.size()>0){   //if the list is  empty , it will not be more than 0
            acceptAndClose.get(0).click();
        }else if(acceptCookies.size()>0){
            acceptCookies.get(0).click();
        }

        WebElement source = driver.findElement(By.id("draggable"));  //kucuk top un locater i
        WebElement target = driver.findElement(By.id("droptarget"));  //buyuk top resmi

        Thread.sleep(2000);
        //mouse u source a hareket ettir , sonra CLICK AND HOLD IT , SONRA target a surukle AND release it
        actions.moveToElement(source).clickAndHold().moveToElement(target).pause(2000).release().perform(); //moveto element


    }

}

//Cookies lerde alertlere benziyor ama cookies leri inspect edebiliyoruz , alertleri edemeyiz