package com.cybertek.tests.day4_ID_locater;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class tagNameLocator

         {
             public static void main(String[] args) {

               //full name i yazdi , bir email ekledi sonra sign up buttonuna tikladi

                 WebDriver driver= WebDriverFactory.getDriver( "chrome" );
                 driver.manage().window().maximize();  //full screen yaptik

                 driver.get( " http://practice.cybertekschool.com/sign_up" );

                 WebElement fullNameInput= driver.findElement( By.tagName("input"  ) );
                 fullNameInput.sendKeys( "Mike Smith With TagName" );

                 WebElement emailInput =driver.findElement( By.name( "email" ) );
                 emailInput.sendKeys( "mike@smith.com" );

                 //lazy way
                 driver.findElement( By.tagName("button"  ) ).click();          //tagName is button burada

                 //close browser
                 driver.quit();



/*if we cannot find name or id , we look for tagName
#inspector part ini actigimizda ornegin input locater i na bakiyor ve ilk input u secmemiz lazim, nasil anlayacagiz.
                 #inspectorda commend +f e tikla cikan yerde input u arat, aratinca kacinci oldugunu gosteriyor

#selenium reads the source from top to bottom. if your locater matched with one webelement, selenium stops there.

                 //if there is no id or name, we can use tagname based on two conditions
                 1_ tag should be used only one time
                  2_there are multiple same tags but you want to point the first tag
               we cannot use index when we use tagName locater. if there are multiple usage of sametag, we cannot point the second one, first one we should choose
if id is dynamic and name isd multiple, we cannot use them, instead we use other locators

#selenium source codu yukaridan asagiya dogru okur, ilk input u bulduktan sonra durur, asagi kismdaki codelari okumaz, this is valid for all locaters

##bir web sitesini actin inspect ile , ornegin search buttonunu kullanmak istyorsun,  <input deyip arattin , 10 tane input cikti, eger birinci siradaki input ile
senin search buttonun eslesirse  input kullanilabilir locator olarak, aksi durumda baska birsey kullanmamiz gerekir. oklari hareket ettirince web sitesinde eslesmeleri goruruz
              --amazon sitesinde dene ve gor


<a class="nav-link" href="/">home</a>
a is tagname
class is an atribute
nav-link is atribute value
home is a text

              #IF SELENIUM FINDS A LOCATOR, IT STOPS THERE , BU YUZDEN MULTIPLE OLAN LOCATERLARDA  1. INCI YI SECECEGIZ
                      */







             }
}
