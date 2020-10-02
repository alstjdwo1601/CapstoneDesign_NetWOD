package com.example.netwod;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
        exData ff= new exData();
        ff.setValue("value");
        ff.setCategory("cate");
        System.out.println(ff.getCategory());
        System.out.println("머야");
        ExcelScrapper a= new ExcelScrapper();
        a.readExcel();
        System.out.println(a.list.get(0).getCategory());


    }
}