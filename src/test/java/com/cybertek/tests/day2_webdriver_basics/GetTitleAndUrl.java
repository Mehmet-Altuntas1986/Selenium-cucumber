package com.cybertek.tests.day2_webdriver_basics;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GetTitleAndUrl {
    public static void main(String[] args) {
        //tASK OPEN CHROME AND NAVIGATE TO http://practice.cybertekschool.com

        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();

        driver.get( "http://practice.cybertekschool.com" ); //yada ayni islemi boyle yap driver.navigate().to("http://practice.cybertekscholl.com" ); --aralarinda bir fark yok


        //getting title with selenium   --usteki tab in icinde yazan baslik
        String title = driver.getTitle(); //driver.getTitle() yazdim , sonra option ve enter tusuna tikladim , short cut ile bunu olusturdu
        System.out.println( "title = " + title );   //  soutv deyip entera tikladim bu variable seklini bana olusturdu


        //getCurrentUrl---> get the url from browser
        String currentUrl = driver.getCurrentUrl();  //  driver.getCurrentUrl(); yaz + option+enter  ile olustur
        System.out.println( "currentUrl = " + currentUrl ); //soutv +enter tusuna bas



        //getPageSource   -- manuel olarak websitesinde saga tiklayinca-->view page source u tiklayincada ayni sey cikar
        String pageSource = driver.getPageSource();  //driver.getPageSource();+option+enter  //bu methodu cok cok nadir kullanacagiz  //consola bak- html in tamami belirdi
        System.out.println( "pageSource = " + pageSource ); //soutv+enter
    }
}






//inspector da title  is between the head tags in html  <title>