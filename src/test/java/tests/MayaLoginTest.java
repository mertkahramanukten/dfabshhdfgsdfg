package tests;

import pages.MayaLoginPage;
import pages.MayaMainPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MayaLoginTest extends BaseTest
{
    @Test
    public void LoginTest()
    {
        MayaLoginPage loginPage = MayaLoginPage.load(driver);
        Assert.assertTrue(loginPage.isValidLoginPage());
        loginPage.sendUserName("TEOASLIM");
        loginPage.sendPassword("Test1234");
        loginPage.clickMainOrgButton();
        loginPage.isValidAfterUserPass();
        loginPage.clickMainOrgButton();
        loginPage.selectMainOrg();
        loginPage.clickSubOrg();
        loginPage.isValidSubOrgList();
        loginPage.selectSubOrg();
        loginPage.clickBtnLogin();
        MayaMainPage mainPage = MayaMainPage.load(driver);
        Assert.assertTrue(mainPage.isValidLogin());
    }
}
