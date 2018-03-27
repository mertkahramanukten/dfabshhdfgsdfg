package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MayaMainPage extends BasePage
{
    private String LBL_ISLOGIN_XPATH = GetObject("LBL_ISLOGIN_XPATH");
    protected MayaMainPage(WebDriver driver) {super(driver);}
    public static MayaMainPage load(WebDriver driver)
    {
        return new MayaMainPage(driver);
    }
    public boolean isValidLogin()
    {
        if (driver.findElement(By.xpath(LBL_ISLOGIN_XPATH)).isDisplayed())
        {
            return true;
        }
        return false;
    }
}
