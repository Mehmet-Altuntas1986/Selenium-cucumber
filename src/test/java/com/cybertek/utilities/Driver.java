package com.cybertek.utilities;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;

public class Driver {  //utilities paketinde   //Bu ONCEDEN OLUSTURMUS OLDUGumuz WebDriverFactory classindan daha fazla browser a ulasmamizi sagliyor

    private Driver() {}  //diger classlar da bu class in object i olusturulamaz , heryerde bu classda olusturdugumuz objecti kullanabiliriz (Singleton)

    private static WebDriver driver;  //null              --> local variable olsaydi initilization gerekli olurdu


    public static WebDriver get() { //is this get accepting any browser type? this is only get method
                                    //get in icine webdriverFactory deki gibi parameter koymadik ,cunku switch ile secmesini istedik duruma gore
        if (driver == null) {
            String browser = ConfigurationReader.get("browser");   //burdaki get methodu , configurationreader class inin icinde , static oldugu icin class ismi ile cagirilabilir
            switch (browser) {
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    break;
                case "chrome-headless":
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver(new ChromeOptions().setHeadless(true));
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    break;
                case "firefox-headless":
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver(new FirefoxOptions().setHeadless(true));
                    break;
                case "ie": //internet explorer
                    if (!System.getProperty("os.name").toLowerCase().contains("windows"))  //if not contains windows, throws exception
                        throw new WebDriverException("Your OS doesn't support Internet Explorer");
                    WebDriverManager.iedriver().setup();
                    driver = new InternetExplorerDriver();
                    break;

                case "edge":
                    if (!System.getProperty("os.name").toLowerCase().contains("windows"))
                        throw new WebDriverException("Your OS doesn't support Edge");
                    WebDriverManager.edgedriver().setup();
                    driver = new EdgeDriver();
                    break;

                case "safari":
                    if (!System.getProperty("os.name").toLowerCase().contains("mac"))
                        throw new WebDriverException("Your OS doesn't support Safari");
                    WebDriverManager.getInstance(SafariDriver.class).setup();
                    driver = new SafariDriver();
                    break;
            }



        }

        return driver;
    }

    public static void closeDriver() { //closeDriver is making my driver null boylece jvm yeniden if statementinin icine gider bir sonraki test case de Driver.get deyince
                                       //bu kismi kullanmasaydik hep ayni driver i kullanmis olurduk
        if (driver != null) {
            driver.quit();
            driver = null; //assignment
        }
    }
}

//ConfigurationReader is in uitlities package

//Driver bir singleton design patter a ornek - cunku bu class ile diger classlar object olusturamazlar. Ve Bu class
// ta olusturulmus olan object heryerde kullanilabilir. yani tek object heryerde islevsel