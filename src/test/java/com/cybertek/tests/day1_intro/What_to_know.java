package com.cybertek.tests.day1_intro;

public class What_to_know {
    String a ="java";

    //   https://www.tutorialandexample.com/web-driver-interface-class-diagram/
}
    /*WebDriver interface/class diagram:

The interface of WebDriver includes the following stages, which is as follows:

Search Context
Web driver
Remote web driver
Driver class
Web Driver interface
Search Context

 The first interface of the web driver class is search Context, which contains two abstract methods that are findElement() and findElements().

These two methods are abstract in search context interface.

  FindElement():

The findElement() is used to navigate <html>, and with the help of locator, it will find the source code of the web element.
It is used to identify the single element in UI.
It always returns the single web element even through multiple matching and single matching elements found.
It will throw the NoSuchElement exception if the element is not available in Html.
findElements():

It is used to identify multiple similar elements in UI.
It always returns a list of <web Element>.
Find elements return an empty list of web elements if elements not available in UI.
To identify a specific color, data, or accurate row data in dynamic web table, we use find Elements() method.
WebDriver:

A WebDriver is an interface that extends the search context interface, and multiple browser subclasses implement it.
WebDriver has many abstract methods like close(), quit(), get(), etc. and the web driver has also nested interface like navigation, window, timeouts, etc.
To perform some specific operations with the help of nested interfaces like back(), refresh(), forward(), etc.
And the entire WebDriver tool is converted as a jar file, which is uploaded by the selenium community.
To use a WebDriver tool, we should download the web driver jar from the selenium community and import the jar into eclipse before developing the test script.
Make sure that all the jars available inside the lib Folder and the jar along with the libraries, should import to eclipse.
Remote WebDriver :

It is a fully implemented class where all the abstract methods like get(), close(), quit(), and a nested interface like window, timeouts, navigations of web driver.
findElement() and findElements() methods of search context interface are implemented in remote WebDriver class.
It used to implement the JavaScriptExecutor and takeScreenshot interfaces.
Driver classes:

And finally, we have browser-specific driver classes available in the selenium WebDriver .

The driver classes include Firefox Driver, Chrome Driver, IE Driver, Safari Driver, etc.

WebElement Hierarchy
Webelement is an interface that extends SearchContext and TakeScreenShot interfaces.

These interfaces contains several controls like click(), sendKeys(), getText() etc. which can be used  after findElement() method.

Web Element Hierarchy
Search Context:
The SearchContext interface has been described in the class which includes findElement() and findElements() methods.

Web Element:

To perform any action on webelement like click(),isSelected(), getText() methods, we will use the overriding concept because all the abstract methods available in WebDriver are overridden.

Remote webelement:

The remote webelement class is a fully implemented class of web element interfaces. */

