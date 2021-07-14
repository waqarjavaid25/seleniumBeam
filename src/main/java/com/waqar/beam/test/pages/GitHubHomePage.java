package com.waqar.beam.test.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GitHubHomePage {
    WebDriver driver;
    WebDriverWait webDriverWait;

    @FindBy(className = "header-search-input")
    private WebElement searchBar;

    public GitHubHomePage(WebDriver driver) {
        this.driver = driver;
        this.webDriverWait = new WebDriverWait(driver, 30);
        PageFactory.initElements(driver, this);
    }

    public void goTo() {
        driver.get("https://github.com/");
    }


    public void searchRepo(String data) {
        searchBar.sendKeys(data);
        searchBar.sendKeys(Keys.ENTER);
    }
}
