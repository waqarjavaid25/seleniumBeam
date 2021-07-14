package com.waqar.beam.test;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class Test {

    protected WebDriver driver;


    protected void maximizeWindow() {
        driver.manage().window().maximize();

    }

    @BeforeTest
    protected void start() {
        maximizeWindow();
    }

    @AfterTest
    protected void end() {
        driver.quit();
    }

}
