package org.itacademy.homework9selenide;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import io.qameta.allure.selenide.LogType;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.*;

import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.logging.Level;

import static com.codeborne.selenide.Browsers.CHROME;

@Log4j2
public class BaseTest {

    private final ResourceBundle bundle = ResourceBundle.getBundle("config");
    private final String URL = bundle.getString("homePage");
    private final String DATAFILE = bundle.getString("dataFile");



    @BeforeClass
    public static void startLocal() {
        log.info("START TYPE LOCAL");
        SelenideLogger.addListener("allure", new AllureSelenide()
                .screenshots(true)
                .savePageSource(true)
                .enableLogs(LogType.BROWSER, Level.ALL));
        Configuration.browserSize = "1920x1080";
        Configuration.browser = CHROME;
    }

    @BeforeMethod
    public void beforeMethod() {
        log.info("BEFORE METHOD open home page: ");
        Selenide.open(URL);
    }

    @AfterMethod
    public void tearDown() {
        Selenide.clearBrowserCookies();
    }
}