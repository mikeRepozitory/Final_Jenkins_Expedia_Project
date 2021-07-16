package com.expedia.interview.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class SelectFromDropDown {

    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        WebElement element = null;
        Select select = new Select(element);
        select.selectByVisibleText("USA");
    }
}
