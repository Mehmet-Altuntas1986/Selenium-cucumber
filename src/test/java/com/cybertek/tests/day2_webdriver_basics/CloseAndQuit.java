package com.cybertek.tests.day2_webdriver_basics;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CloseAndQuit {

    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();  //opening an empty browser   //ChromeDriver is a class comes from selenium, with it driver object is created

        driver.get("http://practice.cybertekschool.com"); //navigate to this website

        Thread.sleep(2000);  //write only number   //weblink opens , 2 sn waits , then will be closed




        driver.close();   //close current tab(window ) //burda browser i kapattik   //yeniden bir empty browser imiz oldu.

        driver = new ChromeDriver();  //giving new browser tab  //bunu koymazsak birsonraki line da websitesine ulasamaz

        driver.get("http://practice.cybertekschool.com/open_new_tab");

        Thread.sleep(5000);

        driver.quit();   //closes all tabs(windows)  //quit dedigimizde web sitesini yeniden actigimizda onceden web sitesinde yaptigimiz aramalar
                                            //karsimiza cikmiyor, sanki o web sitesini ilk defa aciyormus gibi oluruz

        //BREAK UNTIL 2:15 (long break)


    }
}

//console u okuyabilmek onemli
//consolda onemli bir kelime var ona odaklan --->Exception   birde en sona gidip blue renkte olan yazilara tiklayip
// ornegin en sonda mavi renkteki yazi (CloseAndQuit.java:22 ) bu su manada line 22 de bir hata var