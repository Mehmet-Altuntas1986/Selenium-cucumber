package com.cybertek.tests.day7_testNG;

import org.testng.annotations.*;

public class BeforeAfterMethod {

        @BeforeClass //runs only once before everything in the class
        public void SetUpClass(){
                System.out.println("--before class");
                System.out.println("executed one time before the class");

        }




        @Test   // ---> @ -->annotation
        public void test1() {
                System.out.println("Webdriver, opening browser");

                System.out.println("first test case");

                System.out.println("closing browser ,quit");

        }
        @Ignore
        @Test       //-->   //@Test in onune  2 tane slash yada  @Test  annotation nin hemen ustunde @ignore bu annotation i
                   // eklersek --> test 2 de beforeaftermethod uygulanmaz, kisaca test etmiyoruz bu test case i
        public void test2(){
                System.out.println("second test case");

        }

        @Test
        public void test3(){
                System.out.println("third test case");

        }

        @BeforeMethod     //--->runs once before each method with @Test annotations
        public void setUp(){
                System.out.println("before method");
                System.out.println("Webdriver, opening browser");

        }

        @AfterMethod      //--->runs once after each method with @Test annotations
public void tearDown(){
                System.out.println("after method");
                System.out.println("closing browser ,quit");

        }
@AfterClass   //runs only once after everything in the class
        public void tearDownClass(){
        System.out.println("--after class");
        System.out.println("some reporting code here");
}



        }




        //biz ilkonce browser i acar en sonda test bitince onu kapatiriz

//bu sayfada ornegin smoke test yaptik , report yaparken boyle birsey kullanabiliriz