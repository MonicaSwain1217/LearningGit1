package com.project.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Common<Exception> extends BasePage implements en{
    public void waitForTheVisibilityOfElement(WebElement element, long timeOutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitForElementToBeClickable(WebElement element, long timeOutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }


    public boolean isDisplayed(WebElement element) {

        if (element.isDisplayed()) {
            return true;
        } else {
            return false;
        }
    }


    public boolean isPresent(String xpath) {

        if (!driver.findElements(By.xpath(xpath)).isEmpty()) {
            return true;
        } else {
            return false;
        }
    }

    int i = 0;

    public void clickMenuItem() throws Throwable {

        try {

//            menuItem.click();
            Thread.sleep(2000);
            Actions action = new Actions(driver);
            WebElement mapSearchTextBox = driver.findElement(By.xpath("//div[@class='layout-actions']//input[@placeholder='Search Maps']"));
//            action.moveToElement(searchTextBox).perform();


        } catch (Exception e) {
            //  System.out.println(e);
            i = i + 1;
            System.out.println("Trying again - " + i);
            if (i < 20) {
                clickMenuItem();
            } else {
                System.out.println(e);
            }
        }
    }
}
