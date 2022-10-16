package com.cybertek.tests.day7_types_of_the_elements;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RadioButtonTest {
    @Test
    public void test1() throws InterruptedException {
        WebDriver driver= WebDriverFactory.getDriver( "chrome" );
        driver.manage().window().maximize();

        driver.get( "http://practice.cybertekschool.com/radio_buttons");
        //locating radio buttons
        WebElement blueRadioBtn=driver.findElement( By.cssSelector("#blue") );
        WebElement redRadioBtn=driver.findElement(By.id("red"));


       //how ot check radio button is selected
        System.out.println( "blueRadioBtn.isDisplayed() = " + blueRadioBtn.isDisplayed() );
        System.out.println( "redRadioBtn.isSelected() = " + redRadioBtn.isSelected() );
                                                       //  redRadioBtn.isSelected().soutv -->click

//verify blue is selected
        //blue --> true
        //red  --> false
                               //blue button seciliyken bu islemi yaptik
        Assert.assertTrue(blueRadioBtn.isSelected(),"Verify that blue is selected"  );//isSelected returns true or false
        Assert.assertFalse(redRadioBtn.isSelected(),"verify that red is not selected" );

       // how to click redradio button?  //redradio button ununa click etmeseydim asagidakiler hata verirdi
        redRadioBtn.click();

       //if I click on the redButton in the website  , what happens?
        Assert.assertFalse(blueRadioBtn.isSelected(),"Verify that blue is not selected"  );  //blue will not be selected , then-->fails ,
                                                                                                    // compiler stops after error inside method
        Assert.assertTrue(redRadioBtn.isSelected(),"verify that red is not selected" );   //both of them fails , but this line is not visited by jvm
                              //false
        Thread.sleep( 3000 );
        driver.quit();




    }


}
