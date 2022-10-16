package com.cybertek.tests.day15_review;

import com.cybertek.pages.ContactInfoPage;
import com.cybertek.pages.ContactsPage;
import com.cybertek.pages.DashboardPage;
import com.cybertek.pages.LoginPage;
import com.cybertek.tests.TestBase;
import com.cybertek.utilities.ConfigurationReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class verifyContactInfoTest extends TestBase {  //ilk once manuel olarak test et , sonra basla
    /**
     * open the chrome
     * go to qa1.vytrack
     * login as a sales manager           --configuration.properties de salesmanager_username=salesmanager120    ---  salesmanager_password=UserUser123
     * navigate to customers ->contacts
     * click on email mbrackstone9@example.com
     * verify that full name is Mariam Brackstone
     * verify that email is mbrackstone9@example.com
     * verify that phone number is +18982323434
     */

    @Test
    public void contactDetailsTest(){

        extentLogger = report.createTest("Contact Info Verification");

        LoginPage loginPage = new LoginPage();

        String username = ConfigurationReader.get("salesmanager_username");
        String password = ConfigurationReader.get("salesmanager_password");

        extentLogger.info("username: "+username);
        extentLogger.info("password: "+password);

        extentLogger.info("Login as a Sales Manager");
        loginPage.login(username,password);

        extentLogger.info("Navigate to --> Customers > Contacts");
        //Dascboard page de baska bisey yapmayacagimiz icin DashboardPage dbpage=  new DashboardPage()  demedi, dediki sadece birkez kullanacagimiz icin bu lazy way i kullananbilirsin
        new DashboardPage().navigateToModule("Customers","Contacts");  //object olusumunda esitligin sag kismiyla nokta koyup islemi bitirme

        ContactsPage contactsPage = new ContactsPage();

        extentLogger.info("Click on mbrackstone9@example.com");
        contactsPage.waitUntilLoaderScreenDisappear();
        contactsPage.getContactEmail("mbrackstone9@example.com").click();

        ContactInfoPage contactInfoPage = new ContactInfoPage();

        String expectedFullName = "Mariam Brackstone";
        String actualFullName = contactInfoPage.fullName.getText();

        extentLogger.info("Verify full name is "+ expectedFullName);
        Assert.assertEquals(actualFullName,expectedFullName,"verify fullname");

        extentLogger.info("verify email is mbrackstone9@example.com");
        Assert.assertEquals(contactInfoPage.email.getText(),"mbrackstone9@example.com","Verify email");

        extentLogger.info("verify phone number is +18982323434");
        Assert.assertEquals(contactInfoPage.phone.getText(),"+18982323434","verify phone number");

        extentLogger.pass("PASSED");

    }


}

//pages da ContactsPage olusturuldu  birde emailin uzerine tiklaninca bize yeni bir websayfasi acti-->contactinfo diye bir class acctik
//email locater i dynamic ve unique olacak sekilde ayarlandi

//mariam bracstone ismini inspect edip locater kullanirkey text kullanmadi


//xml konusundan bahsetti 1.47 dk dan itibaren
//maven is using pom.xml

//we will learn how to simple text xml build for testng  --xml ile different packages and classes can run at the same time
//google-->testng -->documentation-->txt konusunu acti

//how we will create this  2.00 h ,   first intellij de solda butun herseyi icindeki file lar gorunmeyecek sekilde kapat , butun ok lar sag tarafi gostersin
//idea ,src,target,testoutput,configuration.properties ,pom  hepsini alt alt goreceksin  steps
//1-project namin uzerine gel-->right click--> new-->file--> isimver    --testng_runner.xml

////google-->testng -->documentation-->txt konusunu acti  -->textng.xml konubasligina git ve ilk bolgeyi kullaniyoruz

//tESTNG_runner.xml ile koymus oldugumuz testleri paketler ve icindeki butun test annotations lerle birlikte test edebiliriz .---> sol taraftaki file larin uzerine gel , sag tikla -->
//-->copy path--> copy reference  de sonra hazir yapiya tirnak isaretletri arasinda ekle  ornegin       <package name="com.cybertek.tests.day11_webtables">      </package>

//dk 2. somoke test icin dosyalarin icindeki classes seciliyor ve testng_runner a koyuluyor
//regression test icin paketlerin hepsi .*

//en sonda nasil sadece bir test case bir class in icinden secilir ve calistirilir diye gosterdi

// TestNg runner.xml e bak      <!-- note:Birden fazla package da testlerin ayni anda run olmasini istiyorsak buraya ekle -->

/*DDF --Data drive testing Framework : We have different Data for the same test case , think about you have an exel file
 it has 100 emails,phone numbers , names of users , can you verify each of them seperately?
 we are not touching test script ,only changig data and testing , this is called data driven testing


 */