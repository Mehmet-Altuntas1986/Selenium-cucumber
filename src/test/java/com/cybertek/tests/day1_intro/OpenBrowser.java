package com.cybertek.tests.day1_intro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class OpenBrowser {

    public static void main(String[] args) throws InterruptedException {
        //we have to enter this line every time we want to open chrome
        // hey webdrivermanager, can you make chrome ready for automation
                     // System.setProperty( "webdriver.driver.chrome" ,"chromedriver"); //windows bilgisayarlarda path kisminin sonu .exe koymalisin
        WebDriverManager.chromedriver().setup();   //WebDriverManager is an abstract class --icinde abstract methodlar var
             // this below could be used instead  WebDriverManager.chromedriver().setup();
        //System.setProperty( "Webdriver.chrome.driver","/Users/mehmetaltuntas/Desktop/projects/Eu3TestNGSelenium/chromedriver" );

        //webdriver represents the browser
        //we are creating driver for chrome browser
        //new chromeDriver()-->this part will open (empty) chrome browser
        WebDriver driver = new ChromeDriver();  //safari ,Firefox driver da diyebilirim , eger bilgisayarimizda yuklu ise calisirlar
        //WebDriver is the Interface (methods inside it has no body) ,ChromeDriver is a constructor with class name , here there is polymorphism

        //get method used for navigation to page
       driver.get("https://cybertekschool.com");
       // driver.get("https://github.com/bonigarcia/webdrivermanager");
        driver.getTitle();
        driver.getCurrentUrl();

    }
}

/*
#  WebDriverManager dependency is a library which allows to automate the management of the drivers (e.g. chromedriver, geckodriver, etc.)
  required by Selenium WebDriver.

Notice that simply adding WebDriverManager.chromedriver().setup(); WebDriverManager does magic for you:

It checks the version of the browser installed in your machine (e.g. Chrome, Firefox).
It matches the version of the driver (e.g. chromedriver, geckodriver). If unknown, it uses the latest version of the driver.
It downloads the driver if it is not present on the WebDriverManager cache (~/.cache/selenium by default).
It exports the proper WebDriver Java environment variables required by Selenium (not done when using WebDriverManager from the CLI or as a Server).
WebDriverManager resolves the drivers for the browsers Chrome, Firefox, Edge, Opera, PhantomJS, Internet Explorer, and Chromium.
 For that, it provides several drivers managers for these browsers. These drivers managers can be used as follows:

WebDriverManager.chromedriver().setup();
WebDriverManager.firefoxdriver().setup();
WebDriverManager.edgedriver().setup();
WebDriverManager.operadriver().setup();
WebDriverManager.phantomjs().setup();
WebDriverManager.iedriver().setup();
WebDriverManager.chromiumdriver().setup();

 What is Selenium?
Selenium refers to a suite of tools that are widely used in the testing community when it comes to cross-browser testing.
Selenium cannot automate desktop applications; it can only be used in browsers. It is considered to be one of the most
preferred tool suites for automation testing of web applications as it provides support for popular web browsers which
makes it very powerful.

It supports a number of browsers (Google Chrome 12+, Internet Explorer 7,8,9,10, Safari 5.1+, Opera 11.5, Firefox 3+) and
 operating systems (Windows, Mac, Linux/Unix).

Selenium also provides compatibility with different programming languages – C#, Java, JavaScript, Ruby, Python, PHP.
 Testers can choose which language to design test cases in, thus making Selenium highly favorable for its flexibility.

Note: It is not mandatory to write Selenium code in the same language as the application. For example,
if the application under test is written in PHP, then testers don’t have to write Selenium code in PHP. Thus, if a
website is written in C#, the Selenium code can be written in PHP too.

What is Selenium WebDriver?
Selenium WebDriver is a web framework that permits you to execute cross-browser tests.
This tool is used for automating web-based application testing to verify that it performs expectedly.

Selenium WebDriver allows you to choose a programming language to create test scripts.
 As discussed earlier, it is an advancement over Selenium RC to overcome a few limitations.
 Selenium WebDriver is not capable of handling window components, but this drawback can be overcome
 by using tools like Sikuli, Auto IT, etc.


 */

/*
  // System.setProperty( "webdriver.driver.chrome" ,"chromedriver"); //windows bilgisayarlarda path kisminin sonu .exe koymalisin
      or this one
     WebDriverManager.chromedriver().setup();
     burdaki third party chromedriver--> real browser i invoke etmemizi sagliyor

       ****  WebDriver driver = new ChromeDriver(); burada object ile invoke etmeye calsiyoruz browser i ama arkitektur yapidan dolayi bunu direkt yapamayiz
         once bir setup yada System.setProperty methodunu kullanmaliyiz

 */