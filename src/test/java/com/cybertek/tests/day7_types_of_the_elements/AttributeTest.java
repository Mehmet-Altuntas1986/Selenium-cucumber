package com.cybertek.tests.day7_types_of_the_elements;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AttributeTest {
    @Test
    public void test1(){
        WebDriver driver= WebDriverFactory.getDriver( "CHROME" );
        driver.manage().window().maximize();

        driver.get( "http://practice.cybertekschool.com/radio_buttons" );
        WebElement blueRadioBtn=driver.findElement( By.id("blue") );

        blueRadioBtn.getAttribute( "value" ); //getAttribute method is not only limited with the value , you can retrieve all the attribute value
                                                   //blue radiobutton i inspect yap
         //get the value of type attribute
       System.out.println( blueRadioBtn.getAttribute( "type" ) );  //  radio

        //get the value of name attribute

       System.out.println( blueRadioBtn.getAttribute( "name" ) ); //color        <input type="radio" id="blue" name="color" checked="">


        //get the value of checked attribute   -->true or false , this attribute has no value
        System.out.println( blueRadioBtn.getAttribute("checked") ); //true  //console da true yada false yazar

        //trying to get attribute that doesnt exist
        //when we use non exist attribute it will return null to us
       System.out.println( blueRadioBtn.getAttribute( "href" ) ); //null   --- it return false or something else in console -->null

         System.out.println( blueRadioBtn.getAttribute( "outerHTML" ) );//outerHTML IS NOT AN ATTRIBUTE
                                                                            //CONSOLDA <input type="radio" id="blue" name="color" checked=""> YAZI BELIRIR



                                                                                           //<input type="radio" id="blue" name="color" checked="">
         System.out.println("innerHtml is:"+blueRadioBtn.getAttribute( "innerHTML" ) ); //innerHtml is:      bu sekilde belirdi , TEXT OLMADIGI ICIN





        // <button class="btn btn-primary" onclick="button1()">Button 1</button>
        driver.get( "http://practice.cybertekschool.com/multiple_buttons" );
        WebElement button2=driver.findElement( By.name( "button2" ) );


       System.out.println( button2.getAttribute( "outerHTML" ) ); //boyle bir isim gormuyoruz html de , ama button 2 yi inspect ettigimizde cikan row belirir konsolda
                                                     //  CONSOLDA--->   <button class="btn btn-primary" onclick="button2()" name="button2">Button 2</button>

        String outerHTML=button2.getAttribute( "outerHTML" );

        Assert.assertTrue( outerHTML.contains( "button2" ));



        System.out.println( "innerHTML :" + button2.getAttribute( "innerHTML" ) );  //Button 2
        driver.quit();

        /*wHEN WE Need to get text of the webelement
            1.getText();
            2.getarribute("value");
            2.getarribute("innerHTML");
            2.getaTribute("outerHTML");   */

//GET ATTRIBUTE RETURN TO String

    }

}
// innerHTML ILE INSPECTE RENKLENDIRILMIS ELEMENT TAG LARI ARASINDAKI TEXT LI KISMI ALGILIYOR    (ATTRIBUTE DEGERLERINI DEGIL)
//outerHTML ISE ELEMNTI TEMSIL EDEN RENKLI INSPECT KISMINI TAMAMEN ICINE ALIYOR
/*
innerHTML is a property of every element. It tells you what is between the starting and ending tags of the element,
 and it also let you sets the content of the element. property describes an aspect of an object. It is something an object has as opposed to something an object does.
 */