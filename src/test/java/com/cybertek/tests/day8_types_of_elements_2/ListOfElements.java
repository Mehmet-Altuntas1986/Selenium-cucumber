package com.cybertek.tests.day8_types_of_elements_2;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class ListOfElements {

    WebDriver driver;  //asagidaki methodlarin da bu driver i kullanabilmesi icin methodlarin disinda buraya koyuldu

    @BeforeMethod
    public void setUp(){
        driver = WebDriverFactory.getDriver("chrome");
    }

    @AfterMethod  ////if test fails, it will also close the browser, that is why it is important
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }

    @Test
    public void test1(){
        driver.get("http://practice.cybertekschool.com/multiple_buttons");

        //save our web elements inside the list
        List<WebElement> buttons = driver.findElements(By.tagName("button"));  //findElements methodu--> array
                                                                               //findElement methodu--->String

        System.out.println("buttons.size() = " + buttons.size());  //kac tane button oldugunu bize verir
        //verify button size
        Assert.assertEquals(buttons.size(),6,"verify buttons size");

        //iter + enter to get  'for each loop' with shortcut
        for (WebElement button : buttons) {
            System.out.println("button.isDisplayed() = " + button.isDisplayed());  //yani ekranda goruluyor
            Assert.assertTrue(button.isDisplayed(),"verify buttons are displayed");
        }

        //click second button (without locating)
        buttons.get(1).click();  //get(1) is pointing 2nd button

    }

    @Test
    public void test2(){
        driver.get("http://practice.cybertekschool.com/multiple_buttons");  //test lerin icinde sadece driver.get ile
                                                                            // bircok test olusturabiliriz


        //regular findElement method will throw NSE if locator does not exist
        //driver.findElement(By.tagName("buttonaiysdgausda"));

        //passing locator which does not exist, it will not throw NoSuchElementException

        //ALT+enter or OPTION+Enter then one more enter for the shortcut
        List<WebElement> buttons = driver.findElements(By.tagName("buttonaiysdgausda"));

        System.out.println("buttons.size() = " + buttons.size());  //0  CUNKU  YUKARIDAKI LINE DAKI TAGNAME ILE HERHANGIBIRSEY BULAMAZ
                                                //BURDAN NE ANLIYORUZ YANLIS TAG ILE DE MESAJ OLARAK VERIFY YAPABILIYORUZ (NO ECCEPTION -ERROR BELIRDI)



    }

//findElements() method does not throw NoSuchElementException, if you locator is wrong it will return you empty list.


}