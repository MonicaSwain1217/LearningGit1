package com.project.utilities;

import org.apache.commons.lang.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class BasePage {

    public static ChromeOptions options = new ChromeOptions();
    public static WebDriver driver;
    public static Properties properties;

    public static String _environment;
    public static String _username;
    public static String _password;

    public static final String defaultEnv = "DEV";

    public BasePage() {

        try {
            properties = new Properties();
            FileInputStream fis = new FileInputStream(
                    "src/main/java/com/revegy/config/config.properties");
            properties.load(fis);
        } catch (IOException e) {
            e.getMessage();
        }

    }

    public static void initialization(String env) {

        _environment = env; //dev/qa/demo
        String browserName = properties.getProperty("browser");

        if (browserName.equals("chrome")) {

            options.addArguments("enable-automation");
            //	options.addArguments("--headless");
            options.addArguments("--window-size=1920,1080");
            options.addArguments("--no-sandbox");
            options.addArguments("--disable-extensions");
            options.addArguments("--dns-prefetch-disable");
            options.addArguments("--disable-gpu");
            //    options.setPageLoadStrategy(PageLoadStrategy.NONE);


            System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver2");
            driver = new ChromeDriver(options);
            Reporter.log("-----Browser Session Started-----", true);

        } else if (browserName.equals("firefox")) {

            System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/firefox");
            driver = new FirefoxDriver(); // Edge and Safari

        }

//        e_driver = new EventFiringWebDriver(driver);
//        //Now create object of EventListenerHandler to register it with EventFiringWebDriver
//        eventListener = new WebDriverEventListener();
//        e_driver.register(eventListener);
//        driver = e_driver;

        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(TestUtils.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(TestUtils.IMPLICIT_WAIT, TimeUnit.SECONDS);

        if (_environment.equals("DEV")) {

            baseURL = properties.getProperty("devURL");
            _username = properties.getProperty("DEVUsername");
            _password = properties.getProperty("DEVPassword");
        } else if (_environment.equals("QA")) {

            baseURL = properties.getProperty("qaURL");
            _username = properties.getProperty("QAUsername");
            _password = properties.getProperty("QAPassword");
        } else if (_environment.equals("DEMO")) {

            baseURL = properties.getProperty("demoURL");
            _username = properties.getProperty("DEMOUsername");
            _password = properties.getProperty("DEMOPassword");
        } else {
            _environment = defaultEnv;
        }

        accountPageURL = baseURL + "/accounts";
        opportunitiesPageURL = baseURL + "/opportunities";
        reportingPageURL = baseURL + "/reporting";
        setUpPageURL = baseURL + "/setup";
        profileManagementURL = baseURL + "/setup/profiles";
        toolProfilesPageURL = baseURL + "/setup/profiles/tool";

    }

    public static String randomString() {

        String generatedString = RandomStringUtils.randomAlphabetic(5);

        return generatedString;

    }
}
