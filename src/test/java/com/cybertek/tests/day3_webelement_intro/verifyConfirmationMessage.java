package com.cybertek.tests.day3_webelement_intro;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class verifyConfirmationMessage {

    public static void main(String[] args) {
    /*
    Verify confirmation message
        open chrome browser
        go to http://practice.cybertekschool.com/forgot_password Links to an external site.
        enter any email
        verify that email is displayed in the input box
        click on Retrieve password
        verify that confirmation message says 'Your e-mail's been sent!'
     */

        //open chrome browser
        WebDriver driver = WebDriverFactory.getDriver("cHromE");  //toLowerCase methodu var WebDriverFactory
                                                                       // class inin icindeki getDriver methodunun icinde

        //go to http://practice.cybertekschool.com/forgot_password
        driver.get("http://practice.cybertekschool.com/forgot_password");

        //enter any email
        WebElement emailInputBox = driver.findElement(By.name("email"));  //id veya name i inspectordan bul   //esitligin sag tarafini yaz+option+enter a tikla esitligin sol tarafini otomatik
                                                                         // olusturur, sonra ismi duzenleyebilirsin

        String expectedEmail = "mike@smith.com";

        //sendKeys()--> send keyboard action to the webelement
        emailInputBox.sendKeys(expectedEmail);  //parantezin icine buda yazilabilir , sikinti olmaz   //sendKeys methodu ile bu email inputboxin icine gider ve sanki biz oraya yazmis gibi olur


        //somehow we should get text (herhangi bir yazi ) from web elements
        //two main ways to get txt from web elements
        //1.getText()--> it will work %99 and it will return string  -->input box in ici icin  2.yolu kullanacagiz
        //2.getAttribute("value") --> second way of getting text especially input boxes

        String actualEmail = emailInputBox.getAttribute("value");
        System.out.println("actualEmail = " + actualEmail);

        //verify that email is displayed in the input box
        if(expectedEmail.equals(actualEmail)){
            System.out.println("PASS");
        }else{
            System.out.println("FAIL");
        }

        //click on retrieve password
        WebElement retrievePasswordButton = driver.findElement(By.id("form_submit"));
        retrievePasswordButton.click();

        //verify that confirmation message says 'Your e-mail's been sent!'
        WebElement actualConfirmationMessage = driver.findElement(By.name("confirmation_message"));

        System.out.println(actualConfirmationMessage.getText()); //getText i eklemezsem  -->[[ChromeDriver: chrome on MAC (888819fe11bc4e67b2747452ca47b537)] -> name: confirmation_message] --reference i gorurum consolda

        //save expected message
        String expectedMessage = "Your e-mail's been sent!";
        //save actual message to variable
        String actualMessage = actualConfirmationMessage.getText();

        if(expectedMessage.equals(actualMessage)){
            System.out.println("PASS");
        }else{
            System.out.println("FAIL");
            System.out.println("expectedMessage = " + expectedMessage);
            System.out.println("actualMessage = " + actualMessage);
        }

        //close browser
        driver.quit();


        //consol da exception i bul , hata varsa o gosterecektir --->blue line hatayi gosterecektir , blue line nin uzerine tikla
    }
}
