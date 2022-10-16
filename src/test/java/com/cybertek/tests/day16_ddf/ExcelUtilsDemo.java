package com.cybertek.tests.day16_ddf;

import com.cybertek.utilities.ExcelUtil;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class ExcelUtilsDemo {


    @Test
    public void readExcelFile()  {

        //Create an object from ExcelUtil
        //it accepts two argument
        //Argument 1: location of the excel file(path)  --right click on excel file-->copy path root
        //Argument 2: sheet that wew want to open(sheetName)

        ExcelUtil qa3short = new ExcelUtil("src/test/resources/Vytracktestdata.xlsx","QA3-short"); //exelin icini ac--alttaki sheetlerden birinin ismi QA3-short

        //how many rows in the sheet
        System.out.println("qa3short.rowCount() = " + qa3short.rowCount());


        //how many columns in the sheet
        System.out.println("qa3short.columnCount() = " + qa3short.columnCount());


        //get all column names
        System.out.println("qa3short.getColumnsNames() = " + qa3short.getColumnsNames());



        //get all data in list of maps   ---each row represents one map
        List<Map<String, String>> dataList = qa3short.getDataList();  //qa3short.getDataList() yaz ve option+sag enter click 2 times //map lerde key and value var
                                                                      //1st string is key-column name , 2nd string is the value in row

        for (Map<String, String> onerow : dataList) { // iter +enter//string1 is value (name of the column) string 2 is value , each raw represents one map
            System.out.println(onerow);

        }

        //get Nona (a name in excel) as a value
        System.out.println("dataList.get(2) = " + dataList.get(2).get("firstname")); //index 0 dan basliyor-->yani bu 3.row--> 3.map  //2.get methodu map te bilgi icin kullaniyoruz
                                                   //first get is list method , second get is map method
        //get Harber
        System.out.println("dataList.get(8) = " + dataList.get(8).get("lastname"));  //excel-ilk row u saymadigi icin index 8=9 uncu rowda harber

        //get all data in 2d array
        String [][] dataArray = qa3short.getDataArray();

        //print 2d array
        System.out.println( Arrays.deepToString(dataArray));

    }
}


// soltarafta src nin altindaki main ile isimiz yok, developerslar kullaniyor onu
// excel file yuklemek istersek javanin okuna tikla ,hemen altinda ki resources u kullan sol tarafta
// masaustundeki vytrack exel dosyasin da copy --> resources a git -->right click-->paste dedik ve
// eklendi resources dosyasina intelij de --> dikkat main dosyasinin altindaki resources a copyalama
// how do you handle,read nad write excel files in intellij --> i use apache poi dependincies sonra i have my excelUtil class that
// i have ready methods to read excel files in different format  > we can say we created with our team or i created
// bu class surekli hata veriyordu, Vytracktestdata .xlsx  de a harfi ile x aarasinda bir bosluk vardi, boslugu silince hata duzeldi.