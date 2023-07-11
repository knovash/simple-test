package org.itacademy.homework9selenide;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import lombok.extern.log4j.Log4j2;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import static com.codeborne.selenide.Browsers.CHROME;

@Log4j2
public class BaseTest {

    @BeforeClass
    public static void beforeClass() {
        log.info("BEFORE CLASS");
        Configuration.browserSize = "1920x1080";
        Configuration.browser = CHROME;
//        System.setProperty("webdriver.chrome.driver", "/home/konstantin/Downloads/chromedriver_linux64 114/chromedriver");
//        System.setProperty("selenide.browser", "Chrome");
    }

    @BeforeMethod
    public void beforeMethod() {
        log.info("BEFORE METHOD open home page: ");
        Selenide.open("https://donerking.by/");
    }

}