package org.itacademy.homework9selenide;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.util.HashMap;

import static com.codeborne.selenide.Browsers.CHROME;
import static com.codeborne.selenide.Browsers.FIREFOX;

@Log4j2
public class BaseTest {

        public static WebDriver driver;

    @BeforeClass
    public static void beforeClass() {
        log.info("BEFORE CLASS");

//        System.setProperty("webdriver.chrome.driver", "/home/konstantin/Downloads/chromedriver_linux64_114/chromedriver");
//        WebDriver driver = new ChromeDriver();

//        Configuration.browserSize = "1920x1080";
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