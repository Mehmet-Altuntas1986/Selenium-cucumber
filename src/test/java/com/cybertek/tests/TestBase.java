package com.cybertek.tests;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.cybertek.utilities.BrowserUtils;
import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class TestBase { //Test base i olusturmamizimn sebebi herbir test case de before and after methodu tekrar ve tekrar yazmamak , bu class i olusturdum
                      //We initiliaze everything in our testBase

    protected WebDriver driver;  //protected i ekleyince 2 class arasinda baglanti kurulabildi , logintest(day12) teki driver hata vermedi
    protected Actions actions;  //bu line ve before methodun icinde son line a ekleme yapildi
    protected WebDriverWait wait;   //explicit

    //this class is used for starting and building reports  --day14 --copy paste +protected yaptim
    protected ExtentReports report;
    //this class is used to create HTML report file
    protected ExtentHtmlReporter htmlReporter;
    //this will  define a test, enables adding logs, authors, test steps
    protected ExtentTest extentLogger;

    @BeforeTest
    public void SetUpTest(){  //day-14-copy paste here
        //initialize the class
        report = new ExtentReports();  //object

        //create a report path-->where i find my project ready //dynamic way use and make it work in all computers
        String projectPath = System.getProperty("user.dir");   ///Users/mehmetaltuntas/Library/Java/JavaVirtualMachines/openjdk-16.0.2/Contents/Home/bin/java/Users/mehmetaltuntas/Library/Java/JavaVirtualMachines/openjdk-16.0.2/Contents/Home/bin/java
        String path = projectPath + "/test-output/report.html"; //bir file olusturduk -folder name is test-output , in a real project , we will not have static file name , farkli farkli isimler olacak
        //sol tarafa bak intellj de test output adinda bir dosya ve icindede report.html dosyasi var
        //report.html in uzerinde saga tikla-->open in finder--> browser-->open it with any browser that you want-->and see the report

        //initialize the html reporter with the report path
        htmlReporter = new ExtentHtmlReporter(path);

        //attach the html report to report object
        report.attachReporter(htmlReporter);

        //title in report
        htmlReporter.config().setReportName("Vytrack Smoke Test");

        //set environment information  (key and value ile calisiyor)
        report.setSystemInfo("Environment","QA");
        report.setSystemInfo("Browser", ConfigurationReader.get("browser")); //it gives me dynamicly browser type
        report.setSystemInfo("OS",System.getProperty("os.name"));
    }



    @BeforeMethod      //runs once before each method with @Test annotations
    public void setUp(){
        driver = Driver.get();   // bu kismi sildim ve dynamic bir yapi olusturdum -- gerek yok --WebDriverFactory.getDriver("chrome"); //BROWSER CESIDINE BAGLAR
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        actions= new Actions( driver ); // assignment
        wait=new WebDriverWait(driver,10);
        driver.get( ConfigurationReader.get("url") );               //day 13 negativelogin test de gelip buraya bunu ekledik +import

    }

  /*  @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        Driver.closeDriver();   //driver.quit(); artik bunu kullanmiyorum ////closeDriver is making my driver null boylece jvm yeniden if statementinin icine gider -Driverclass ta
    }  day 14 de bu kodu update ediyoruz , gelistiriyoruz, asagidaki after methodu incele*/


               //ITestResult CLASS DESCRIBES THE RESULT OF A TEST IN TestNG
    @AfterMethod
    public void tearDown(ITestResult result) throws InterruptedException, IOException {  // ITestResult class is from  testng
        //if test fails        ---note herzaman screenshot almiyoruz bu durumda
        if (result.getStatus()==ITestResult.FAILURE){  //int , 2 int degeri- failure i gosteriyor ---nokta ya tiklayinca gorursun secenekleri

             //record the name of failed test case
            extentLogger.fail( result.getName() );                //test case in ismine result.getName ile ulasiyor

            //take the screenschot and return location of screenshot
            String screenShotPath= BrowserUtils.getScreenshot(result.getName()  );  //screenshot is ready , now i should attach it to reports

            //add your screenshot to your report
            extentLogger.addScreenCaptureFromPath( screenShotPath );

            //capture the exception and put inside the report
            extentLogger.fail( result.getThrowable() );
        }
        Thread.sleep( 2000 );
        Driver.closeDriver();
    }

    @AfterTest
    public void teardownTest(){   //day 14_ copy pasted
        //this is when the report is actually created
        report.flush();

    }


}


//TestBase is not utility or testcase , arasinda bisey , utility package inini icindede koymus olsaydim calisirdi
//amac butun class larda before ,after method ve diger gerekli olanlari tekrar ve tekrar yazmamak , decleration of variables da yazariz
//ihtiyac olunca bu sinifa extend ederek icerigini hazir kullanmis oluruz


//protected ile ayni package icindeki classlar arasinda ve farkli package deki subclass arasinda baglanti kurulur