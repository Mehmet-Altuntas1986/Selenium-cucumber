package com.cybertek.tests.day12_properties_driver_tests;

import com.cybertek.tests.TestBase;
import com.cybertek.utilities.ConfigurationReader;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

public class LoginTest extends TestBase {  //sadece extends testBase yazdim baglanti icin//Login test parantezinin icine PropertiesTest classindan line 27_43 arasini kopyaladim , sonra biraz degisiklik yaptim

    //comment li kisim normalde testbase sinifi olmasa gerekli ama herbir test case icin yazmak isleri zorlastirir. bu nedenle
    // testbase adinda bir class acip before and after method kismini oraya yapistirirsam ve classlar arasinda
    // ki baglantiyida inheritance ile extend edip saglarsam isler kolaylasir

/*    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        driver = Driver.get();   // bu kismi sildim ve dynamic bir yapi olusturdum -- gerek yok --WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        Driver.closeDriver();   //driver.quit(); artik bunu kullanmiyorum ////closeDriver is making my driver null boylece jvm yeniden if statementinin icine gider -Driverclass ta
    }
*/

    @Test
    public void OpenBrowserWithConf(){//configuration browserdaki url ve browser calisiyor, baglanti isini configurationReader class i yapiyor ,WebDriver driver
                                     // kismini sildim ve day 11 den before and after methodunu alip yapistirdim


  //asagidaki driver hata vermemesi icin ,erisim saglananabilmesi icin TestBase de protected i EKLEDIM (WebDriver driver in onunde)
        driver.get(ConfigurationReader.get("url"));  //configuration.properties de bulunan url , degisklik yapinca  onfiguration.properties de yapiyoruz

        String username = ConfigurationReader.get("driver_username");  //configuration.properties de bulunan key value ,box in icine gider
        String password = ConfigurationReader.get("driver_password");

        driver.findElement( By.id("prependedInput")).sendKeys(username);
        driver.findElement(By.id("prependedInput2")).sendKeys(password+ Keys.TAB);  //ornegin web sayfasinda bir boxin icindesin ve username i yazdin ,
        // (enter tusu)tab a tiklayinca alttaki box in icine geciyor

    }

}

//pages websitesine ozel , baska bir websitesinde is gormez, ona gore duzenlemeliyiz , baska bir web sitesi icin degisiklikler yapmaliyiz, yeniden duzenlemeliyiz
//utilities herturlu websitesinde isimize yarar , kullanabiliriz degisiklik yapmadan
//BasePage de websitesine ozel ,general structure lari tabikide kullanabiliriz , baska bir websitesi icin duzenlenmesi gerekir