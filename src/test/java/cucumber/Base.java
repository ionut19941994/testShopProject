package cucumber;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Base {
    public static WebDriver driver;
    public static Properties prop;

    public static WebDriver getDriver() throws IOException
    {
        BasicConfigurator.configure();
        Logger.getRootLogger().setLevel(Level.OFF);
        prop=new Properties();
        FileInputStream fis=new FileInputStream("src/test/resources/environments/environment.properties");
        prop.load(fis);

        System.setProperty("webdriver.chrome.driver", "/Users/alexandru.badescu/Downloads/Automation/Drivers/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(prop.getProperty("baseurl"));
        return driver;
    }
}
