package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class MayaLoginPage extends BasePage
{

    private String URL = GetUrl("MAYA","PRP");
    private String LOGIN_PAGE_ID = GetObject("LOGIN_PAGE_ID");
    private String TXT_USERNAME_ID = GetObject("TXT_USERNAME_ID");
    private String TXT_PASSWWORD_ID = GetObject("TXT_PASSWWORD_ID");
    private String SELECT_MAINORG_XPATH = GetObject("SELECT_MAINORG_XPATH");
    private String LBL_AFTER_USERPASS_ID = GetObject("LBL_AFTER_USERPASS_ID");
    private String SELECT_MAINORGTEXT_XPATH = GetObject("SELECT_MAINORGTEXT_XPATH");
    private String BTN_SUBORG_ID = GetObject("BTN_SUBORG_ID");
    private String SELECT_SUBORG_XPATH = GetObject("SELECT_SUBORG_XPATH");
    private String BTN_LOGIN_ID = GetObject("BTN_LOGIN_ID");



    protected MayaLoginPage(WebDriver driver) {super(driver);}
    {
        driver.navigate().to(URL);
    }
    public static MayaLoginPage load(WebDriver driver)
    {
        return new MayaLoginPage(driver);
    }
    public boolean isValidLoginPage()
    {
        if (driver.findElement(By.id(LOGIN_PAGE_ID)).isDisplayed())
        {
            return true;
        }
        return false;
    }
    public void isValidAfterUserPass()
    {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(LBL_AFTER_USERPASS_ID)));
    }
    public void sendUserName(String text)
    {
        driver.findElement(By.id(TXT_USERNAME_ID)).sendKeys(text);
    }

    public void sendPassword(String text)
    {
        driver.findElement(By.id(TXT_PASSWWORD_ID)).sendKeys(text);
    }
    public void clickMainOrgButton()
    {
        driver.findElement(By.xpath(SELECT_MAINORG_XPATH)).click();
    }
    public void selectMainOrg()
    {
        driver.findElement(By.xpath(SELECT_MAINORGTEXT_XPATH)).click();
    }
    public void clickSubOrg()
    {
        wait.until(ExpectedConditions.elementToBeClickable(By.id(BTN_SUBORG_ID)));
        driver.findElement(By.id(BTN_SUBORG_ID)).click();
    }
    public void isValidSubOrgList()
    {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(SELECT_SUBORG_XPATH)));
    }
    public void selectSubOrg()
    {
        driver.findElement(By.xpath(SELECT_SUBORG_XPATH)).click();
    }
    public void clickBtnLogin()
    {
        wait.until(ExpectedConditions.elementToBeClickable(By.id(BTN_LOGIN_ID)));
        driver.findElement(By.id(BTN_LOGIN_ID)).click();
    }
}
