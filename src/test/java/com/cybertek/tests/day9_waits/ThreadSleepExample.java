package com.cybertek.tests.day9_waits;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ThreadSleepExample {


    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        driver = WebDriverFactory.getDriver("chrome");
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }

    @Test
    public void test1() throws InterruptedException {
        driver.get("http://practice.cybertekschool.com/dynamic_loading/3");

        Thread.sleep(6000);   //kullanilmasaydi hata verirdi

        driver.findElement(By.id("username")).sendKeys("MikeSmith");

    }
}

//regression suite te butun test caselerimizin oldugunu dusun, hepsini birden calistirinca yaklasik 1 saat gececek
//thread lerin zamanini iyi ayarlamamiz lazim, eger gerekli degilse kullanmamaliyiz.

/*COMPARISON OF 3 WAITS
1-Thread.sleep
   call every time you need
   wait for whole duration,not dynamic(static)
    not selenium wait -javaya ait

2-IMPLICITLY WAIT
      call it once,(set of driver)
      waits while trying to findElement
      wait until element found or time runs out(dynamic)
      applies for all findElement methods
3-EXPLICITLY WAIT
     call every time you need it
     wait until condition is met or time runs out(dynamic)
     waits for different conditions(interactible,visible,invisible,text,clicible etc)
  */