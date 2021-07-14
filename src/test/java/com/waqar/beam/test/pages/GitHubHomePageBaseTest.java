package com.waqar.beam.test.pages;

import com.waqar.beam.test.BaseTest;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class GitHubHomePageBaseTest extends BaseTest {


    @Test(dataProvider = "SearchRepoData")
    protected void gitHubHomePageSearchTest(String repoName, Boolean result) {

        System.out.println("repoName=" + repoName);
        System.out.println("result=" + result);


        GitHubHomePage gitHubHomePage = new GitHubHomePage(driver);
        GitHubSearch gitHubSearch = new GitHubSearch(driver);

        gitHubHomePage.goTo();
        gitHubHomePage.searchRepo(repoName);

        Assert.assertEquals(gitHubSearch.findRepo(repoName), result);

    }

    @DataProvider
    public Object[][] SearchRepoData() {
        Object[][] data = new Object[2][2];

        data[0][0] = "scala/scala";
        data[0][1] = true;
        data[1][0] = "waqarbeam";
        data[1][1] = false;

        return data;
    }
}


