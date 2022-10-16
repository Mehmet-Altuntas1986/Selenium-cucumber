package com.cybertek.tests.day7_testNG;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestNGassertionsDemo {
    @Test
    public void test1(){
        System.out.println("open browser");

        System.out.println("first assertion");
        Assert.assertEquals( "title","Title" );  //in testNg, if assertion fails, rest of the method will not execute, it will be ignored/skipped


        System.out.println("second assertion");
        Assert.assertEquals( "url","url" );

        //CLOSE EGER FIRST ASSERTION DA ESLESME HATA VERDIYSE NASIL KAPATACAGIZ--> AFTERMETHOD U KULLANARAK --> CUNKU FAIL OLSA BILE HERHANGI BIR TESTTE BU METHOD RUN OLUR


    }
    @Test     //test runs independently than test 1
    public void test2(){
        Assert.assertEquals( "test2","test2" ,"buraya virgul ile mesaj yazabilirim " ); //assert is a class in testNG, It has methods used to do assertions like when we compare
    }


    @Test
    public void test3 () {

        String expectedTitle = "cyp";
        String actualTitle = "Cybertek";
        Assert.assertTrue( actualTitle.startsWith( expectedTitle ), "verify title starts with Cyb" );  // virgul koyunca mesaj yazabiliyoruz.
    }                                                        // yazdigimiz mesaji consolda error varsa gorebiliriz, aksi durumda gorunmez

    @Test
    public void test4(){
        //verify email contains @ sign
        String email = "mike@smith.com";
        Assert.assertTrue( email.contains("@"), "verify email contains @ " );


    }
    @Test
    public void test5(){
        Assert.assertFalse( 0>1 ,"veriy that 0 is not greater than 1" );
                               //false       --> assertFalse   0>1 false   yani  yanlis oldugunu onayladik -->donucta hata yok
                               //1>0 demis olsaydik  test would fail  --> consola bakabiliriz
    }

    @Test
    public void test6(){
        Assert.assertNotEquals( "one","two" );
    }




//whether your testcase fail or not , your before and after method will executed always. bu methodlarla quit and close yapabiliriz
    @BeforeMethod
    public void setUp(){
        System.out.println("open browser");
    }


    @AfterMethod
    public void tearDown(){
        System.out.println("close browser");
    }

}
