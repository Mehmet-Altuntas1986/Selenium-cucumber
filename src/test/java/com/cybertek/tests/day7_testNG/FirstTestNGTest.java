package com.cybertek.tests.day7_testNG;

import org.testng.annotations.Test;

public class FirstTestNGTest {
    //BUNU YAZDIKTAN SONRA LINE 3 IMPORTED
    @Test
    public void test1() {

        //this method is not a regular java method , it is testNg test method  -->main method yerine bunu kullaniyoruz
        System.out.println( "my first test case" );
    }

    @Test
    public void test2() { //this is like we 2 main methods in the same class , and for each we have run button
        System.out.println( "my first test case" );
    }


//we can create many tests in this way

/*mvnrepository websitesinde testng yadim ve version 7.1.0 i alip pom.xml de dependincies larin arasina copyaladim , sonra bu package i actim
        <!--  https://mvnrepository.com/artifact/org.testng/testng/7.1.0 -->
    <dependency>
        <groupId>org.testng</groupId>
        <artifactId>testng</artifactId>
        <version>7.1.0</version>
        <scope>test</scope>
    </dependency> */

}

//TestNg is ?  https://keytorc.com/blog/testng-nedir-nasil-kullanilir/

/*we have test annotations in order to execute out test cases, no main method
    it is a unit testing tool
it has lots of feaTURES ,we will use couple of them
We will build framework with the unit testing tool (TestNg) ,integreted with selenium and other dependencies*/
