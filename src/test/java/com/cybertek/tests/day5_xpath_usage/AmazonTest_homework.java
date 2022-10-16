package com.cybertek.tests.day5_xpath_usage;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AmazonTest_homework {
    /*task_homework
      1- go to amozon.com
      2-search for selenium
      3- click search button
      4- verify 1-48 of 304 results for "selenium"
       */
    public static void main(String[] args) {


        WebDriver driver= WebDriverFactory.getDriver( "chrome" );  //ConfigurationReader.get("browser") bunu parantezin icinde yazarsam (day12 dersi)
                                                                               //browser degisikligi sorun olusturmaz--configuration properties ile baglanti kurulur
                                                                               //configuration properties in icinde browser in ismini degistiriz ve otomatik test case de degisir
        driver.get( "https://www.amazon.com/" );

        WebElement  searchBox= driver.findElement( By.xpath("//input[@id='twotabsearchtextbox']"));
searchBox.sendKeys( "Selenium" );
//Click search button
driver.findElement( By.xpath( "//input[@value='Go']" ) ).click();

WebElement result=driver.findElement( By.xpath( "//span[contains(text(),'results for')]" ) );  //1-48 of 187 results for "SELENIUM"
                                                         // NORMALDE BUNA BENZER BIR TEXT AMA BEN DEGISMEYEN KISMI KULLANDIM CUNKU ILERDE RAKAMLAR DEGISEBILIR
String resultText=result.getText(); //secilen elementin web sitesindeki ismini veriyor

        System.out.println( "resultText = " + resultText );

    String expectedResult= "1-47 of over 3,000 results for";
    if (expectedResult.equals( resultText )){
        System.out.println("pass");
    }else{
        System.out.println("fail");
        System.out.println( "expectedResult = " + expectedResult );
        System.out.println( "resultText = " + resultText );
    }
    driver.quit();


    }
}