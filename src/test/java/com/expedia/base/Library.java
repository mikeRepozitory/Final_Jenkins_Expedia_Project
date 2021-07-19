package com.expedia.base;

import java.util.Set;

import static com.expedia.base.Hook.*;

public class Library {

    CustomWait waitFor = new CustomWait();

    public void switchTab(int timeToWaitInSeconds) {
        String current_tab = driver.getWindowHandle();
        Set<String> tabs = driver.getWindowHandles();
        for (String tab : tabs) {
            if (!tab.equals(current_tab)) {
                driver.switchTo().window(tab);
            }
            waitFor.waitFor(timeToWaitInSeconds);
        }
    }

    public void switchBackHandle() { // get window ID
        String current_tab = driver.getWindowHandle();
        Set<String> tabs = driver.getWindowHandles();
        for (String tab : tabs) {
            if (!tab.equals(current_tab)) {
                driver.switchTo().window(tab);
            }
        }
    }
}
