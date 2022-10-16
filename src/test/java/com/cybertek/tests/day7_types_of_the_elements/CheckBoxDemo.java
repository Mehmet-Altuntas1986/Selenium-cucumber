package com.cybertek.tests.day7_types_of_the_elements;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckBoxDemo { //bazen check box in yanindaki yaziya tiklayinca otamatik tick isareti box in icerisinde belirir,
                            //bu durumda text,bu yazi locater olarak kullanilabilir. aksi durumda check box in icini inspect yapmalisin.
    @Test
    public void test1() throws InterruptedException {
        WebDriver driver= WebDriverFactory.getDriver( "chrome" );
        driver.get( "http://practice.cybertekschool.com/checkboxes" );

        WebElement checkbox1=driver.findElement( By.xpath(("//input[1]")) );  //html de index 1 den baslar
        WebElement checkbox2=driver.findElement( By.xpath(("//input[2]")) );  //command +d -->bir sonraki line a yapistirir

        //how to verify checkbox is selected or not?
        Assert.assertFalse( checkbox1.isSelected(),"verify checkbox 1 is not seleceted" );
        Assert.assertTrue( checkbox1.isSelected(),"verify checkbox 1 is  seleceted" );

        //how to check checkboxes?
        //just like a radio button we use click() method
        checkbox1.click();

        //verify after click

        Assert.assertTrue( checkbox1.isSelected(),"verify checkbox 1 is  selected" );
      // Assert.assertTrue( checkbox1.isSelected(),"verify checkbox 2 is  selected" );

        Thread.sleep( 2000 );
        driver.quit();

        /* Checkboxes
Checkboxes are type of input elements which can be selected or unselected.
When we have group of checkboxes selecting or unselecting one checkbox does NOT affect on the selection of the other one.
Just like a radio buttons we use isSelected() method to check checkboxes are selected or not.
to select or unselect the checkboxes we use click() method.
        */


    }
}
