package tests;

import pages.MayaLoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MayaLoginPageTest extends BaseTest
{
    @Test
    public void LoginPageTest()
    {
        MayaLoginPage loginPage = MayaLoginPage.load(driver);
        Assert.assertTrue(loginPage.isValidLoginPage());
    }
}
