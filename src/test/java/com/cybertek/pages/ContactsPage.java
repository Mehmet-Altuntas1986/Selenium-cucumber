package com.cybertek.pages;

import com.cybertek.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ContactsPage extends BasePage{

    //since we are extending BasePage we do not need explicit constructor for this class

//    @FindBy(xpath = "//td[contains(text(),'mbrackstone9@example.com')][@data-column-label='Email']")
//    public WebElement email;

    public WebElement getContactEmail(String email){
        //dynamik bir Email locater olusturduk
        String xpath ="//td[contains(text(),'"+email+"')][@data-column-label='Email']";
        return Driver.get().findElement(By.xpath(xpath));  //get methodu browser i dynamic olarak secmeyi sagliyor (command+b)
    }
}
//        String xpath ="//td[contains(text(),'"+email+"')][@data-column-label='Email']"; bunu yukarida email kismini dynamic hale getirdi, email degisse bile sikinti olmaz
//bunun icin ustteki method olusturuldu


//Driver.get()  SINGLETEON design pattern   KULLANIYOR
//SINGLETEON KULLANMASAYDIK --> public WebElement getContactEmail(Webdriver driverString email){ buna benzer bir sekilde olusturulurdu
 // return driver.findElement(By.xpath(xpath));

//all browserutils methods larinda singleton pattern i kullandik , hepsi ayni objecte point olur , if we remove singleton pattern

/*****getContactEmail () methodunda parametre olarak WebDriver driver kullanmadik cunku Driver.get()
 singleton design pattern olusturmustuk, eger olusturumus olmasaydik parametre olara eklememiz gerekirdi.
 BrowserUtils classindada singleton design pattern i kullanmassak , WebDriver driver i eklememiz lazim methodlarda
 ******/

/**
 BasePage i vytrack icin olusturduk , baska bir websitesinde kullanamayiz ama benzer bir yapi olusturabiliriz
 BasePage te common locater ve methodlari vytr ack icin koyduk
 */

/**
 * TestBase kopyalayip  her projede kullanabiliriz.Belki ufak degisiklikler yapabiliriz
 *
 */
