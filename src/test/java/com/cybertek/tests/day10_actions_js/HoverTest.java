package com.cybertek.tests.day10_actions_js;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HoverTest {    //hover over: uzerinde gezinmek

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

    /**
     * hover over each image in the website
     * verify each name:user text is displayed
     */

    @Test
    public void oneImage() throws InterruptedException {
        driver.get("http://practice.cybertekschool.com/hovers");

        WebElement img1 = driver.findElement(By.tagName("img"));

        Actions actions = new Actions(driver);

        Thread.sleep(2000);
        actions.moveToElement(img1).perform();

        WebElement text1 = driver.findElement(By.xpath("//h5[.='name: user1']"));

        Assert.assertTrue(text1.isDisplayed(),"verify text 1 is displayed");

    }

    /**
     * hover over each image in the website
     * verify each name:user text is displayed
     */
    @Test
    public void test2() throws InterruptedException {
        driver.get("http://practice.cybertekschool.com/hovers");

        for (int i = 1; i <= 3; i++) {  // 3 u degistirip 4 veya daha fazla bir rakama yazarsak , error , no suchelementexception verir , cunku sadece 3 tane image var sayfada

            String xpathImg = "(//img)["+i+"]";     //driver.findElement(By.xpath("(//img)[1]") 1 koyunca 1.resim i , 2 koyunca 2. resimi 3. koyunca 3. resimi locate ediyor
                                                    //i nin onune +i+ seklinde koyunca onu int olarak algilayip concatenate ediyor

            WebElement img = driver.findElement(By.xpath(xpathImg));  //String xpathImg = "(//img)["+i+"]"; String manupulation yapildi burada , boylece sirayla 3 resimde hover over yapilir
            System.out.println(xpathImg);

            Actions actions = new Actions(driver);
            Thread.sleep(1000);
            actions.moveToElement(img).perform();   //perform() --> perform the action, complete the action
                                                    //moveToElement --> move your mouse to webelement(hover over)


             //image lerin altindaki yazilar (bu kisimda loop un icinde)
            String textXpath = "//h5[.='name: user"+i+"']";    //"//h5[.='name: user1']"; doesnt work for all images , therefore String manupulation was made
            WebElement text1 = driver.findElement(By.xpath(textXpath));
            System.out.println(textXpath);
            Assert.assertTrue(text1.isDisplayed(),"verify user "+i+" is displayed");  //"+i+"  bu kisimda dynamic hale geldi

        }












    }

}