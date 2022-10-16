package com.cybertek.pages;

import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {  //diyelimki ilerde id degisti name locater i oldu , loginpage e gelir parantez iclerinde ilgili locater degistirilir
                           //login page i BasePage e extends yapmadim cunku commen properties yok(ornegin Menu,subtitle ,diger moduller varmi login page de)

   public LoginPage(){  //constructor
        PageFactory.initElements( Driver.get(),this);  //pageFactory-is a class from selenium , initElements methodunu oradan kullaniyoruz

                                                            //Driver.get() methodu returns driver--> initElements Bize WebDriver driver=new ChromeDriver() gibi bisey elde etmemizi sagliyor
    }                                                      //ConTrol B ILE INCELE


    //driver.findElement(By.id("prependedInput")); BOYLE YAZMAK YERINE ayni islemi simdi find annotation lari ile yapacagiz
    @FindAll({                                //@FindBy, @FindBys bunlarida kullanabilirdik
           @FindBy(id = "prependedInput"),
           @FindBy(name ="_username")
    })
    public WebElement usernameInput;     //WebLocater's name is usernameInput  burada  //websitesini acinca box larin
                                        // icinde username ,password ,login gibi seyler var, bu yuzden bu isimleri verdik

    @FindBy(id = "prependedInput2")   //selenium annotation
    public WebElement passwordInput;

    //driver.findElement(By.id("_submit")); we are converting to page object model locater ,
                                 // ayni sey i asagida yaptik findby annotation ile

    @FindBy(id = "_submit")        //butun locater isimleri parantez icinde mevcut id, name , ot others can be used
    public WebElement loginBtn;

  //  @FindBy(css=".btn.btn_primary") //6 buttons  -- bu kismi bir soruya cevap olmasi icin yazdi ve sildi
  //    public List<WebElement> buttons;

    public void login(String username,String password){  //burda olusturdugu methodu day 13 te kullandi
        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password);
        loginBtn.click();
    }

    public void loginAsStoreManager(){

        String username = ConfigurationReader.get("storemanager_username");
        String password = ConfigurationReader.get("storemanager_password");

        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password);
        loginBtn.click();
    }

    public void loginAsDriver(){
                          //configutation reader reads configuration.properties
        String username = ConfigurationReader.get("driver_username");  //configuration.properties ile baglantiyi kurdu
        String password = ConfigurationReader.get("driver_password");

        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password);
        loginBtn.click();
    }

}

//locater lari koydugumuz class ve ayni zamanda bazi methodlarida buraya koyuyoruz
//bir websitesinde farkli module lere tiklayinca hala sayfade degismeyen birtakim kisimlar goruruz url degismesine ragmen (login haric)
//we have common actions and locaters

/*
/*
Page Object Model and Page Factory:
1. Define and create a package for all the page objects from the application for logical grouping. For example,
 com.vytrack.pages is created to define all the page classes.

2. Create a new Java class file. Give the name of the page we will be testing from the application to this class.For
example, we will be creating a page class for the VYTrack application, so the class name could be LoginPage for login page.

     What is PageFactory?
The PageFactory Class in Selenium is an extension to the Page Object design pattern. It is used to initialize the
 elements of the Page Object or instantiate the Page Objects itself.
***It is used to initialize elements of a Page class without having to use ‘FindElement’ or ‘FindElements’

        public LoginPage(){  //constructor

        PageFactory.initElements(Driver.get(),this);   //bu birnevi driver.findElements ILE ayni gorevi yapiyor
*Add a constructor to the LoginPage class, which will call the PageFactory.
*The initElements() method to initialize the elements in the class.
In other words, map the elements to the variables in the LoginPage class
*The initElements() method takes the driver object created in the test and initializes the elements
declared in the LoginPage class. We can then directly call the methods on these elements, as follows:

The FindBy annotations:
Using the FindBy annotation,we can locate the elements within the PageFactory class, as on the picture.
We declared a public member for the login button element and used the @FindBy annotation, specifying the id as
a locator for finding this element on the page

The FindAll annotations When required WebElement objects needs to match at least one of the given criteria use
@FindAll annotation

The FindBys annotations:
When the required WebElement objects needs to match all of the given criteria use
@FindBys annotation

The CacheLookUp attribute:
One downside to using the @FindBy annotation is
that every time we call a method on the
WebElement object, the driver will go and find it on
the current page again. This is useful in
applications where elements are dynamically
loaded, or AJAX-heavy applications.
However, in applications where we know that the
element is always going to be there and
stay the same without any change, it would be
handy if we could cache the element once we
find it. In order to do this, we use the
@CacheLookUp annotation along with the @FindBy
annotation.
This tells the PageFactory.initElements() method to
cache the element once it’s located. Tests work
faster with cached elements when these elements
are used repeatedly.
@FindBy(id = "prependedInput")
@CacheLookup
public WebElement uaserNameInput;
@FindBy(id = "prependedInput2")
@CacheLookup
public WebElement passwordInput;
@FindBy(id = "_submit")
@CacheLooku

Advantages of Page Object Model:
!17
www.cybertekschool.com
© 2019 CyberTEK LLC. All Rights Reserved.
• According to Page Object Model, we should keep our tests and element locators
separately, this will keep code clean and easy to understand and maintain.
• The Page Object approach makes test automation framework programmer friendly, more
durable and comprehensive.
• Another important advantage is our Page Object Repository is Independent of
Automation Tests. Keeping separate repository for page objects helps us to use this
repository for different purposes with different frameworks like, we are able to integrate
this repository with other tools like JUnit as well as with TestNG/Cucumber/etc.
• Test cases become short and optimized as we are able to reuse page object methods in
the POM classes.
• Any change in UI can easily be implemented, updated and maintained into the Page
Objects and Classes


Basic Framework Structure
Pages
LoginPage
Tests
LoginTests
utilities
TestBase
Driver
BrowserUtils
pom.xml
configuration.properties


POM is best applicable for the applications which contain multiple pages.
Each of which have fields which can be uniquely referenced with respect to the page.
 */



/*
Object Initialization in Java
The process of assigning a value of the variable is called initialization of state of an object. In other words,
initialization is the process of storing data into an object.
 */

/*
InitElement() – is used to initialize the WebElements declared, using driver instance from the main class.
In other words, WebElements are created using the driver instance. Only after the WebElements are initialized,
 they can be used in the methods to perform actions.
 */