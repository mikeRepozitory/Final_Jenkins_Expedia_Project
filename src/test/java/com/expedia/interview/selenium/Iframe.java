package com.expedia.interview.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Iframe {

    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        WebElement element = null;

        driver.switchTo().frame(element);
        driver.switchTo().frame(1);
    }
}
