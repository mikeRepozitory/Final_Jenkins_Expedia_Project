package com.expedia.interview.selenium;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Alerts {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        Alert alert = driver.switchTo().alert();
        alert.dismiss();
        alert.accept();
        alert.getText();
        alert.sendKeys("dadwadw");
    }
}
