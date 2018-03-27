package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.sql.*;

public class BasePage
{
    protected WebDriver driver;
    protected WebDriverWait wait;

    protected BasePage(WebDriver driver)
    {
        this.driver = driver;
        wait = new WebDriverWait(driver,60);
    }
    protected boolean isElementPresent(By by)
    {
        try
        {
            driver.findElement(by);
            return true;
        }
        catch (Exception ex)
        {
            return false;
        }
    }
    static Connection conn=null;
    static  Statement st = null;
    public static void connect() throws SQLException,ClassNotFoundException
    {
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/testautomationdb","admin","test1234");
    }
    public String URL_VALUE;
    public String OBJECT_VALUE;
    protected String GetUrl(String strapp,String strenvironment)
    {
        try
        {
            connect();
            st = conn.createStatement();
            String Query = "select appUrl from tbl_app where app="+"'"+strapp+"'"+" and environment="+"'"+strenvironment+"'"+"";
            ResultSet rs = st.executeQuery(Query);
            do
            {
                URL_VALUE = rs.getString("appUrl");
            }
            while (rs.next());
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return URL_VALUE;
    }
    protected String GetObject(String strObjectName)
    {
        try
        {
            connect();
            st = conn.createStatement();
            String Query = "select objectValue from tbl_objects where objectName="+"'"+strObjectName+"'"+"";
            ResultSet rs = st.executeQuery(Query);
            do
            {
                OBJECT_VALUE = rs.getString("objectValue");
            }
            while (rs.next());
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return OBJECT_VALUE;
    }
}
