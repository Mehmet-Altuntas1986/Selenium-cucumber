package com.cybertek.tests.day10_file_upload;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FileUploadTest {

    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        driver = WebDriverFactory.getDriver("chrome");

    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        //driver.quit();
    }

    @Test
    public void test1(){
        driver.get("http://practice.cybertekschool.com/upload");
        //locating choose file button
        WebElement chooseFile = driver.findElement(By.name("file"));
        //sending file with sendKeys method
        chooseFile.sendKeys("/Users/mehmetaltuntas/Desktop/file.txt"); //hold option key + right click on file.text file and copy copypath to paste
                                                                                    //fakat burda soyle bir sorun var bu code un aynisi baska bilgisayarda calismaz ,


        //clicking upload button
        driver.findElement(By.id("file-submit")).click();

        //getting the file name from browser
        String actualFileName= driver.findElement(By.id("uploaded-files")).getText();
        //verify file name is file.txt
        Assert.assertEquals(actualFileName,"file.txt");

    }
          //masa ustunde file.txt adinda bir belge olusturduk,
          // bu belgeyi masaustunde saga tikla-->getinfi--->where kismindan kopyala /Users/mehmetaltuntas/Desktop sonra bir slash koy ve file ismini yaz
    @Test
    public void test2(){
        driver.get("http://practice.cybertekschool.com/upload");
        //locating choose file button
        WebElement chooseFile = driver.findElement(By.name("file"));

        //sending file with sendKeys method
        String projectPath = System.getProperty("user.dir");
        System.out.println(projectPath); //        /Users/mehmetaltuntas/Desktop/projects/Eu3TestNGSelenium

        String filePath = "src/test/resources/textfile.txt";    //textfile.txt proje dosyasinin icinde

        String fullPath = projectPath+"/"+filePath;          //bu path den maksat dosyanin  bilgisayarimda nerede bulundugu ile ilgili
        chooseFile.sendKeys(fullPath);
        //clicking upload button
        driver.findElement(By.id("file-submit")).click();

        //getting the file name from browser
        String actualFileName= driver.findElement(By.id("uploaded-files")).getText();
        //verify file name is file.txt
        Assert.assertEquals(actualFileName,"textfile.txt");

    }

}

//bu sayfada path dynamic sekilde yapildigindan, takimdaki diger kisiler code u alinca sorunsuz calisir

//chooseFile.sendKeys("/Users/mehmetaltuntas/Desktop/file.txt"); burda ki ismden dolayi baska bilgisayarlarda calismaz-->cozum filepath example class in da
//herhangi biri codu u copyalayinca , bu nasil cozulur?

//intellijy de en solda sirasiyla click -test--> new-->directory ---> resorces    sonra under the resorces, put the file name
//click resorces --> new -->file--> filename is textfile.txt diye yazdim ve icine some text here yazdim


//sol taraftaki resources kismina , masaustundende bir txt file i copy paste ile yapistirilabilir



//mesela birseyi internet sitesinde download ettim , linke tikladim ve indirdim selenium ile , sonra bunu verify  yapma islemini selenium ile yapamam