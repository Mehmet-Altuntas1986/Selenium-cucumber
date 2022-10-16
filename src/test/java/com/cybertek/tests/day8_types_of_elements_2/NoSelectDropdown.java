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

public class NoSelectDropdown {

    WebDriver driver;  //ASAGIDAKI METHODLARIN DISINDA , SINIF ICERISINDE OLDUGUNDA METHODLAR BUNU KULLANABILIYOR

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
    public void test1(){  //SELECT A WEBSITE BOX INI INSPECT YAPINCA 'select' isminde bir tag goremedik , bu durumda ne yapacagiz ?

        driver.get("http://practice.cybertekschool.com/dropdown");  //BOX LARIN ICINDEKI OKA TIKLAYINCA ASAGI DOGRU SECENEKLER GOSTEREN KUTUCUKLAR(DROPDOWN)
  //EGER INSPECT TE  <select  HTML tag ini gorursek , bunu bircok formul ile kullanabiliriz

        WebElement dropdownElement = driver.findElement(By.id("dropdownMenuLink")); //inspect


        //click the dropdown to see available options
        dropdownElement.click();
        //get the options with findElements method and finding common locator between them
        List<WebElement> dropdownOptions = driver.findElements(By.className("dropdown-item"));

        //print size of options
        System.out.println("dropdownOptions.size() = " + dropdownOptions.size());
        Assert.assertEquals(dropdownOptions.size(),5,"verify size of options");

        //print them one by one
        for (WebElement option : dropdownOptions) {
            System.out.println(option.getText());
        }

        //click yahoo
        dropdownOptions.get(2).click();  //2 index numarasi javada 3.option temsil ediyor. //javada index 0 dan baslar

    }


}