package com.cybertek.tests.day10_file_upload;

import org.testng.annotations.Test;

public class FilePathExample {
 //bunu githup dan bir arkadasim alip bilgisayarinda kullanabilir ,hata vermez
    @Test
    public void test1() {
        // /Users/jamaldemir/IdeaProjects/fromgit/EU3TestNGSelenium/src/test/resources/textfile.txt

        // /Users/jamaldemir/IdeaProjects/fromgit/EU3TestNGSelenium src/test/resources/textfile.txt;      ==> yukardakinden bir slash eksik
        //System.out.println(System.getProperty("user.dir"));
        System.out.println( System.getProperty( "os.name" ) );
        String projectPath = System.getProperty( "user.dir" );  //gives you your project location folder --> cunku butun bilgisayarlarda calismasini istiyorum
        System.out.println( "projectPath = " + projectPath );

        String filePath = "src/test/resources/textfile.txt"; //click (under resources) textfile.txt --> copypath--> choose repository or content root ==>bu bir static path,
        // bende calsir ama baskasinin bilgisayarinda is gormez

        String fullPath = projectPath + "/" + filePath;
        System.out.println( fullPath );
    }

}

//https://www.youtube.com/watch?v=Uraakjx1TYM bu viodeoyu izle daha iyi anlamak icin
//in order continue ==>solda resorces-->copy path-->copy absolute path ===>/Users/mehmetaltuntas/Desktop/Eu3TestNGSelenium/src/test/resources/textfile.txt

//how can we get where my project located dynamicly?
