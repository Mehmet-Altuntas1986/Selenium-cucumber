package com.cybertek.tests.day8_types_of_elements_2;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class SelectDropdownTest {

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
    public void test1(){
        driver.get("http://practice.cybertekschool.com/dropdown");
        //1.locate your dropdown just like any other webelement with unique locator
        WebElement dropdownElement = driver.findElement(By.id("state"));



        //2.create Select object by passing that element as a constructor //SELENIUM HAS A SPECIAL CLASS WHICH IS Select
        //Select yazinca otomatik cikiyor bu sinif, bu sinifla bir object olusturalim

        Select stateDropdown = new Select(dropdownElement);  //connection between the stateDropdown object and constructer --(dropdownElement)
                                       //   Webelementi parantez icine koymayinca hata veriyor



        //getOptions --> returns all the available options from the dropdown
        List<WebElement> options = stateDropdown.getOptions();
        //print size of the options
        System.out.println("options.size() = " + options.size());

        //print options one by one
        for (WebElement option : options) {
            System.out.println(option.getText());  //hepsini consolda yazdirdi donguyle
        }

    }


    @Test
    public void test2() throws InterruptedException {
        driver.get("http://practice.cybertekschool.com/dropdown");
        //1.locate your dropdown just like any other webelement with unique locator
        WebElement dropdownElement = driver.findElement(By.id("state"));

        //2.create Select object by passing that element as a constructor
        Select stateDropdown = new Select(dropdownElement);

        //verify that first selection is 'Select a state'
        String expectedOption = "Select a State";

        String actualOption = stateDropdown.getFirstSelectedOption().getText();

        Assert.assertEquals(actualOption,expectedOption,"verify first selection");

        //HOW TO SELECT OPTIONS FROM DROPDOWN ? THERE ARE 3 WAYS
        //1.SELECT USING VISIBLE TEXT METHODU ile
        Thread.sleep(2000);
        stateDropdown.selectByVisibleText("Virginia");  //box in icinde virginia option olarak gorunen kisma geldi
                                                       //it clicked the option for us


        expectedOption = "Virginia";
        actualOption = stateDropdown.getFirstSelectedOption().getText();
        Assert.assertEquals(actualOption,expectedOption,"verify first selection"); //if you compare two things

        //2.SELECT USING INDEX
        Thread.sleep(2000);
        stateDropdown.selectByIndex(51);//52 ci option //ilk option state degildi, amerikada 51 ayalet var //in javaside index start from 0

        expectedOption = "Wyoming";
        actualOption = stateDropdown.getFirstSelectedOption().getText();
        Assert.assertEquals(actualOption,expectedOption,"verify first selection");

        //3.SELECT BY VALUE
        Thread.sleep(2000);
        stateDropdown.selectByValue("TX");  //TX i INSPECT ILE BULDU  //secince ilk visible elemnt bu oluyor dropdown da

        expectedOption = "Texas";
        actualOption = stateDropdown.getFirstSelectedOption().getText();
        Assert.assertEquals(actualOption,expectedOption,"verify first selection");
    }

}