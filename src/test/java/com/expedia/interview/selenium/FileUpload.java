package com.expedia.interview.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class FileUpload {

    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        WebElement element = driver.findElement(By.xpath(""));
        element.sendKeys("path of file");

    }
}
