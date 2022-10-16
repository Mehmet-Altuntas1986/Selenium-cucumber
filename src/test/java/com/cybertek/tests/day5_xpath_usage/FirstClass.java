package com.cybertek.tests.day5_xpath_usage;

import com.github.javafaker.CreditCardType;
import com.github.javafaker.Faker;

public class FirstClass {
    public static void main(String[] args) {
        System.out.println("Hello World");   //sout  then enter ---> short cut

        Faker faker =new Faker();   //bu method dummy, fake data olusturmakta kullaniliyor

        System.out.println(faker.name().fullName());
        System.out.println(faker.harryPotter().character());
        System.out.println(faker.finance().creditCard(CreditCardType.FORBRUGSFORENINGEN));
    }
}

//POM.XML YI AC VE  LINE 19 A BAK, DEPENDY EKLEDIK O SITEYE DIDEREK BIR CODE ALDIK VE YAPISTIRDIK

