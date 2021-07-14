package com.waqar.beam.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class BaseTest extends Test {

    private final String targetwebdriver;
    private final String host;
    private final String browser;
    private final String driverPath;
    private final String enviorment;
    private DesiredCapabilities dc;

    public BaseTest() {


        browser = getValueOrDefault(System.getProperty("BROWSER"), "chrome");
        targetwebdriver = getValueOrDefault(System.getProperty("TARGET_WEBDRIVER"), "local");
        host = getValueOrDefault(System.getProperty("SELENIUM_HUB"), "localhost");
        driverPath = getValueOrDefault(System.getProperty("DRIVER_PATH"), "C:\\Driver\\WebDriver\\chromedriver.exe");
        enviorment = getValueOrDefault(System.getProperty("ENVIRONMENT"), "local");

        System.out.println("############################################");
        System.out.println(browser);
        System.out.println(targetwebdriver);
        System.out.println(host);
        System.out.println(driverPath);
        System.out.println(enviorment);
        System.out.println("############################################");


        if (targetwebdriver.equalsIgnoreCase("remote")) {
            driver=initializeRemoteDriver();
        } else {
            driver = initializeLocalDriver();
        }


    }

    public <T> T getValueOrDefault(T value, T defaultValue) {
        return value == null ? defaultValue : value;
    }

    private void setDesiredCapabilities() {
        if (browser.equalsIgnoreCase("firefox")) {
            dc = DesiredCapabilities.firefox();
        } else {
            dc = DesiredCapabilities.chrome();
        }
    }

    private WebDriver initializeRemoteDriver() {
        try {
            setDesiredCapabilities();
            System.out.println("http://" + host + ":4444/wd/hub");
            return new RemoteWebDriver(new URL("http://" + host + ":4444/wd/hub"), dc);
        } catch (MalformedURLException e) {
            e.printStackTrace();
            return null;
        }

    }

    private WebDriver initializeLocalDriver() {
        return DriverFactory.getDriver(browser, driverPath);

    }


}
