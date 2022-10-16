package com.cybertek.tests.day11_webtables;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class WebTablesExample { //class seviyesindeki ok a tiklarsak butun test case ler run olur sirayla


    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get("http://practice.cybertekschool.com/tables");
    }

//    @AfterMethod
//    public void tearDown() throws InterruptedException {
//        Thread.sleep(2000);
//        driver.quit();
//    }

    @Test
    public void printTable(){
        WebElement table = driver.findElement(By.xpath("//table[@id='table1']"));  //WebElement is an intereface in java .util package

        System.out.println(table.getText());  //table 1 de everything in the string appears in the console ( last name ........edit delete e kadarki kisma bak

        Assert.assertTrue(table.getText().contains("jdoe@hotmail.com"));  //getText ile consolda beliren uzun stringde jdoe@hotmail.com olup olmadigini kontrol et
    }

    @Test
    public void getAllHeaders(){
        //how many columns we have ?  //6  inspecte th sayisi kadar header var (column sayisi header sayisi kadar)
        List<WebElement> headers = driver.findElements(By.xpath("//table[@id='table1']//th"));
        System.out.println("headers.size() = " + headers.size());

        for (WebElement header : headers) {

            System.out.println(header.getText());  //header larin isimlerini console da yazdirir
        }

    }

    @Test
    public void printTableSize(){
        //how many columns we have ?                                                             //locater xpath de bir tagtan uzaktaki bir taga geciste // kullan
        List<WebElement> headers = driver.findElements(By.xpath("//table[@id='table1']//th"));  //kac tane th oldugunu verir (her bir th bir column daki header lari gosteriyor)
        System.out.println("headers.size() = " + headers.size()); //6 columns with headers

        //number of rows
        List<WebElement> allRowsWithHeader = driver.findElements(By.xpath("//table[@id='table1']//tr"));
        System.out.println(allRowsWithHeader.size());

        //number of rows without header(we prefer this)
        List<WebElement> allRowsWithoutHeader = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr"));
        System.out.println(allRowsWithoutHeader.size());
    }

    @Test
    public void getRow(){
        //print the second row (yatay siralar) information -
        WebElement row2 = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr[2]"));  //inspecte tr lar row lari veriyor

        //System.out.println(row2.getText());  //Bach Frank fbach@yahoo.com $51.00  --->consolda bak row 2 nin text inin yazdirdi

        //get all rows dynamically
        //1.find number of rows
        List<WebElement> numRows = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr"));
        //2.iterate one by one
        for (int i = 1; i <= numRows.size(); i++) {
            WebElement row = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr["+i+"]"));
            System.out.println(i+"-"+row.getText());
        }

        //***loop shortcuts iter and itar +entera tikla

        }


    @Test
    public void getAllCellInOneRow(){ //Bach Frank fbach@yahoo.com $51.00 herbiri ayri ayri
        List<WebElement> allCellsInOneRow = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr[3]/td"));  //3 uncu row da yan yana siralari (cells) td gosteriyor

        for (WebElement element : allCellsInOneRow) {
            System.out.println(element.getText());
        }
    }


    @Test
    public void getASingleCellByIndex(){
        WebElement singleCell = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr[3]/td[5]"));
        System.out.println("singleCell.getText() = " + singleCell.getText());
    }

    @Test
    public void printAllCellsByIndex(){

        int rowNumber = getNumberOfRows();  // getNumberOfRows() methodu olmadigi icin  bu class in icinde bu isimde bir method olusturduk ve icini doldurduk -line en sondakiler
        int colNumber = getNumberOfColumns(); //bu methoduda bu class in icinde olusturduk

        System.out.println("colNumber = " + colNumber);
        System.out.println("rowNumber = " + rowNumber);

        //iterate through each row on the table
        for (int i = 1; i <= rowNumber; i++) {

            //iterate through each cell in the row
            for (int j = 1; j <= colNumber; j++) { //nested
                                                                  //yazdirirken first raw 2 . column , ...... bunun gibi isimlendirdigini dusun
                String cellXpath = "//table[@id='table1']/tbody/tr["+i+"]/td["+j+"]"; //hem raw lari hem de column lari
                System.out.println(cellXpath);

                WebElement cell = driver.findElement(By.xpath(cellXpath));
                System.out.println(cell.getText());  //24 cell in icerigi console da print oldu

            }

        }

    }

    //in the real life ornegin --<you are looking for the email of the john
    // --->table daki row  verilerin yerleri hergun degisebilir
    //dynamic way ile locate edersek , yer degisiklikleri testimize zarar vermez
    @Test
    public void getCellInRelationToAnotherCellInSameRow(){

        String firstName="Jason";  //ismin column i belli ama hangi raw da olacagi belli degil, her tiklamada degisiyorsa , asagida dynmaic bir yapi olustururuz
                                   //row lara testingte guvenme ve dynamic bir yol bul
        String xpath ="//table[@id='table1']//td[.='"+firstName+"']/../td[3]";   //    /.. parent a goturuyor inspect te  //td is column
        WebElement email = driver.findElement(By.xpath(xpath));
        System.out.println(email.getText());


    }


    private int getNumberOfColumns() {
        List<WebElement> headers = driver.findElements(By.xpath("//table[@id='table1']//th"));
        return  headers.size();
    }

    private int getNumberOfRows() {
        List<WebElement> allRowsWithoutHeader = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr"));
        return  allRowsWithoutHeader.size();
    }





}