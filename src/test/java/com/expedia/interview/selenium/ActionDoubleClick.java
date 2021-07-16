package com.expedia.interview.selenium;

import io.cucumber.java.bs.A;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.Set;

public class ActionDoubleClick {

    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();

        Actions actions = new Actions(driver);
        WebElement element = null;

        actions.moveToElement(element).doubleClick().build().perform();
    }
}
