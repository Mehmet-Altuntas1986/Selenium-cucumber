package com.cybertek.tests.day16_ddf;

import com.cybertek.pages.DashboardPage;
import com.cybertek.pages.LoginPage;
import com.cybertek.tests.TestBase;
import com.cybertek.utilities.ExcelUtil;
import org.testng.Assert;
import org.testng.annotations.DataProvider;   //import lara bakinca ne nereden geliyor anlariz
import org.testng.annotations.Test;

public class DDFLoginTest extends TestBase {  //EACH TEST CASE OPENING SEPERATE BROWSER, BIRI HATA VERSE YINEDE DIGERLERI CALISIR  //Data

    @DataProvider  //testNg
    public Object [][] userData(){  //return type is object

        ExcelUtil qa3short = new ExcelUtil("src/test/resources/Vytracktestdata.xlsx","QA3-short");

        String [][] dataArray =qa3short.getDataArrayWithoutFirstRow();  //first row includes the titles , bundan dolayi dahil etmedik , we store other datalari

        return dataArray;
    }

    @Test(dataProvider = "userData")
    public void test1(String username,String password,String firstName,String lastName){  //a,b,c,d de desek calisirdi , onemli olan siralamalri --> birincisi isim , ikincisi SIFRE....
        extentLogger=report.createTest("Test "+firstName+" "+lastName); //DYNAMIC
        LoginPage loginPage = new LoginPage();

        loginPage.login(username,password);

        DashboardPage dashboardPage = new DashboardPage();  //dashboard module i icin configuration.propertiesde url yi degistirdim
        dashboardPage.waitUntilLoaderScreenDisappear();

        String actualFullName = dashboardPage.getUserName();
        String expectedFullName = firstName+" "+lastName;

        Assert.assertEquals(actualFullName,expectedFullName,"verify fullname");  //bu kismi cikarirsak , bu test case olmaktan cikar
        extentLogger.pass("PASSED");
    }


}

//manuel bir sekilde vytrack login kismina resources daki excellden username ve password lari gir ,
// ve log in ile acildigina ilk ve son ismin dogru cikmasi , diyelimki listede 300 kisi var ve hepsinin log in
// yapildigina ekranda ismi dogrumu degilmi kontrol etmek istiyoruz

//selenium is responsible for automating browser --> Assert kismi comes from testNg we use it to create tests,run tests,generate reports

//exelUtil day 16 da olusturuldu   ,resources file inin icinde Vytrackdata .xlsx fiel i var