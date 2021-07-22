package com.expedia.base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;
import java.util.NoSuchElementException;

import static com.expedia.base.Hook.*;
import static java.util.concurrent.TimeUnit.SECONDS;

public class CustomWait {


    public void waitFor(int second) {
        try {
            Thread.sleep(1000 * second);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    public void fluentWait() {
        Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(60)) // this defines the total amount of time to wait for
                .pollingEvery(Duration.ofSeconds(2)) // this defines the polling frequency
                .ignoring(NoSuchElementException.class);

/*
        FluentWait fluentWait1 = new FluentWait(driver);
        fluentWait1.withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(NoSuchElementException.class);

*/

    }

}
