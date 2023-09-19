package com.Base;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class BasePage {
    public WebDriver driver;

    public WebDriverWait wait;

    public BasePage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofMillis(2000L));
    }

    public void setup() {
        System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromedriver/chromedriver.exe");
        this.driver.manage().window().maximize();
    }

    public void url(String url) throws InterruptedException {
        this.driver.get(url);
        Thread.sleep(1000L);
    }

    public void close() {
        this.driver.quit();
    }

    public WebElement findElement(By locator) {
        this.wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        return this.driver.findElement(locator);
    }

    public void sendText(String imputText, By locator) {
        this.wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        this.findElement(locator).clear();
        this.findElement(locator).sendKeys(new CharSequence[]{imputText});
    }

    public void sendKey(CharSequence pressKeys, By locator) {
        this.wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        this.findElement(locator).sendKeys(new CharSequence[]{pressKeys});
    }

    public void clickear(By locator) {
        this.wait.until(ExpectedConditions.elementToBeClickable(locator));
        this.findElement(locator).click();
    }

    public String getText(By locator) {
        this.wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        return this.findElement(locator).getText();
    }
}
