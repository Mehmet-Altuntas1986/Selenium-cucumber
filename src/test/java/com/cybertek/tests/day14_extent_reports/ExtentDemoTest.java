package com.cybertek.tests.day14_extent_reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.cybertek.utilities.ConfigurationReader;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ExtentDemoTest {

    //this class is used for starting and building reports
    ExtentReports report;
    //this class is used to create HTML report file
    ExtentHtmlReporter htmlReporter;
    //this will  define a test, enables adding logs, authors, test steps
    ExtentTest extentLogger;

    @BeforeMethod
    public void setup(){
        //initialize the class
        report = new ExtentReports();  //object

        //create a report path-->where i find my project ready //dynamic way use and make it work in all computers
        String projectPath = System.getProperty("user.dir");   ///Users/mehmetaltuntas/Library/Java/JavaVirtualMachines/openjdk-16.0.2/Contents/Home/bin/java/Users/mehmetaltuntas/Library/Java/JavaVirtualMachines/openjdk-16.0.2/Contents/Home/bin/java
        String path = projectPath + "/test-output/report.html"; //bir file olusturduk -folder name is test-output , in a real project , we will not have static file name , farkli farkli isimler olacak
                                                     //sol tarafa bak intellj de test output adinda bir dosya ve icindede report.html dosyasi var
                                                     //report.html in uzerinde saga tikla-->reveal in finder--> open it with any browser that you want-->and see the report
        //initialize the html reporter with the report path
        htmlReporter = new ExtentHtmlReporter(path);

        //attach the html report to report object
        report.attachReporter(htmlReporter);

        //title in report
        htmlReporter.config().setReportName("Vytrack Smoke Test");

        //set environment information  (key and value ile calisiyor)
        report.setSystemInfo("Environment","QA");  //Enviroment internet ortami
        report.setSystemInfo("Browser", ConfigurationReader.get("browser")); //it gives me dynamicly browser type
        report.setSystemInfo("OS",System.getProperty("os.name"));

    }

    @Test
    public void test1(){
        //give name to current test
        extentLogger= report.createTest("TC123 Login as Driver Test");  //write test name here

        //test steps
        extentLogger.info("Open Chrome Browser");

        extentLogger.info("Go to this URL");

        extentLogger.info("Enter driver username password");

        extentLogger.info("Click Login");

        extentLogger.info("Verify logged in");

        //pass()--> marks the test case as passed
        extentLogger.pass("TC123 is passed");

    }


    @AfterMethod
    public void teardown(){
        //this is when the report is actually created
        report.flush();

    }

}

//we can use this in the future projects

//bugun olusturdugumuz bu yapinin belirli kisimlarini testBase e yapistirdik


//synchronized is	A non-access modifier, which specifies that methods can only be accessed by one thread at a time