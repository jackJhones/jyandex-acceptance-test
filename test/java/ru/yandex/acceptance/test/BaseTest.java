package ru.yandex.acceptance.test;

import com.codeborne.selenide.Configuration;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import ru.yandex.acceptance.test.exceptions.InvalidTestPropertiesException;
import ru.yandex.acceptance.test.pages.HomePage;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import static com.codeborne.selenide.Selenide.open;

public abstract class BaseTest {
    private String propertyFilePath = "src/resources/config/conf.properties";
    private String browser;
    private long timeout;
    private String url;

    /* Pages */
    protected HomePage homePage;

    @BeforeClass
    protected void loadProperties() {
        try {
            Properties prop = new Properties();
            prop.load(new FileInputStream(propertyFilePath));
            this.url = prop.getProperty("ru.yandex.home.url");
            this.browser = prop.getProperty("driver.browser.name");
            this.timeout = Long.parseLong(prop.getProperty("driver.wait.timeout"));
        } catch (IOException e) {
            throw new InvalidTestPropertiesException(String.format("%s properties file could not be found.",
                    propertyFilePath));
        }
    }

    @BeforeMethod
    protected void init() {
        Configuration.browser = browser;
        Configuration.timeout = timeout;
        open(url);
        this.homePage = new HomePage();
    }
}
