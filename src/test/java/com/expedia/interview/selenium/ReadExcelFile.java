package com.expedia.interview.selenium;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ReadExcelFile {

    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream("//path");
        Workbook workbook = WorkbookFactory.create(fis);
        Sheet sheet = workbook.getSheet("sheet name");
        int totalNumOFRow = sheet.getTopRow();
        int totalNumOfColoms = sheet.getFirstRowNum();

    }
}
