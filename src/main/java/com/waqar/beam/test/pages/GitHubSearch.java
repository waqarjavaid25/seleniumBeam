package com.waqar.beam.test.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class GitHubSearch {
    WebDriver driver;
    WebDriverWait webDriverWait;

    @FindBy(css = "ul.repo-list  li div.text-normal")
    private List<WebElement> reposTextList;

    public GitHubSearch(WebDriver driver) {
        this.driver = driver;
        this.webDriverWait = new WebDriverWait(driver, 30);
        PageFactory.initElements(driver, this);
    }


    public Boolean findRepo(String repoName) {

        return reposTextList.stream().filter(x -> x.getText().equalsIgnoreCase(repoName)).count() >= 1;

    }
}
