package org.itacademy.homework9selenide;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import io.qameta.allure.selenide.LogType;
import lombok.extern.log4j.Log4j2;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.util.logging.Level;

//import static com.codeborne.selenide.Browsers.CHROME;

@Log4j2
public class BaseTest {

    @BeforeClass
    public static void startLocal() {
        log.info("START TYPE LOCAL");
//        System.setProperty("webdriver.chrome.driver", "/home/konstantin/Downloads/chromedriver_linux64 114/chromedriver");
//        System.setProperty("selenide.browser", "Chrome");
//        SelenideLogger.addListener("allure", new AllureSelenide()
//                .screenshots(true)
//                .savePageSource(true)
//                .enableLogs(LogType.BROWSER, Level.ALL));
//        Configuration.browserSize = "1920x1080";
//        Configuration.browser = CHROME;
//        Configuration.browserCapabilities.
    }

    @BeforeMethod
    public void beforeMethod() {
        log.info("BEFORE METHOD open home page: ");
        Selenide.open("https://donerking.by/");
    }

}