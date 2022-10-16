package com.cybertek.tests.day9_popups_tabs_frames;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Set;

public class MultipleWindows {


    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver( "chrome" );
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep( 2000 );
        driver.quit();
    }

    @Test
    public void SwitchWindowsTest() {      //windowhandels: pencere kollari

        driver.get( "http://practice.cybertekschool.com/windows" );

        //get title
        System.out.println( "Title before new window:" + driver.getTitle() );  //Windows  --> acilan pencerenin ismi

        driver.findElement( By.linkText( "Click Here" ) ).click(); //click here linkine tikladik ve yeni bir window (tab) acildi ismi New Window du

        System.out.println( "Title after new window:" + driver.getTitle() );  //Windows  => cunku hala selenium ayni window a bakiyordu click ten sonra

        //  System.out.println("driver.getWindowHandle() = " + driver.getWindowHandle()); //i can get my current windowhandle with this method
        //CDwindow-1F41C848409968BC8C27DCE078653A3A

/*When the site opens, we need to handle the main window by driver.getWindowHandle(). This will handle the
current window that uniquely identifies it within this driver instance. Its return type is String.
 */
        String currentWindowHandle = driver.getWindowHandle();
/*To handle all opened windows by web driver, we can use “Driver.getWindowHandles()” and then we can switch window from
one window to another in a web application. Its return type is Iterator<String>.
 */
        Set<String> windowHandles = driver.getWindowHandles(); //this method will get all the windows open at that time handle , this set removes duplicate values,
        // only takes unique values and it doesnt care index , order ,siralama yapmaz 1.button, 2. button diye
        // getwindowshandles methodunda index kullanilamaz
// if i have two windows , how i will switch to other one?
        for (String handle : windowHandles) {

            if (!handle.equals( currentWindowHandle )) {
                driver.switchTo().window( handle );
            }
        }

        System.out.println( "Title after switch new window:" + driver.getTitle() );

    }

    @Test
    public void moreThan2Window() {  //web sitesinin ust kisminda  acilan windows (Tabs) --pencereler
        driver.get( "http://practice.cybertekschool.com/windows" );

        driver.findElement( By.linkText( "Click Here" ) ).click(); //if there is a link , it is easy to use linkText locater

        System.out.println( "Before Switch:" + driver.getTitle() );

        Set<String> windowHandles = driver.getWindowHandles();

//Whenever your windows title equels to title that you are looking for, loop stops
        //loop through each window
        for (String handle : windowHandles) {
            //one by one change it
            driver.switchTo().window( handle );

            //whenever your title equals to your expected window title
            if (driver.getTitle().equals( "New Window" )) {
                //stop on that window
                break;
            }

        }

        System.out.println( "After Switch: " + driver.getTitle() );

    }


}

//java scriptten gelen popup ve alert leri inspect yapamiyoruz , buyuzden locater kullanamiyoruz ,
// buyuzden biz Alert diye bir class imiz var, switch yapip onu kullaniyoruz.