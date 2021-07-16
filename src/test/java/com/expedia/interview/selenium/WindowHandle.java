package com.expedia.interview.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Set;

public class WindowHandle {

    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        String parentWindow = driver.getWindowHandle();
        driver.findElement(By.xpath("")).click();

        Set<String> windowHandles = driver.getWindowHandles();

        for (String windowHandle : windowHandles) {
            if (windowHandle != parentWindow) {
                driver.switchTo().window(windowHandle);
            }
        }
    }
}
