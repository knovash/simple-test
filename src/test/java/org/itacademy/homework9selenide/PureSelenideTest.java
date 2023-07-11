package org.itacademy.homework9selenide;

import com.codeborne.selenide.ElementsCollection;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

@Log4j2
public class PureSelenideTest {

    @Test()
    public void pureSelenideTest() {
        log.info("BEFORE CLASS");
        System.setProperty("webdriver.chrome.driver", "/home/konstantin/Downloads/chromedriver_linux64_114/chromedriver");
        
        var chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--no-sandbox"); // with this it works; without, doesn't
//        var driver = new ChromeDriver(chromeOptions);

        WebDriver driver = new ChromeDriver(chromeOptions);

        driver.get("https://donerking.by/");



//        Configuration.browserSize = "1920x1080";
//        Configuration.browser = CHROME;
//        Configuration.browserCapabilities.setCapability("");
//        System.setProperty("webdriver.chrome.driver", "/home/konstantin/Downloads/chromedriver_linux64 114/chromedriver");
//        System.setProperty("selenide.browser", "Chrome");

//        Selenide.open("https://donerking.by/");











        String item = "бургер";
        log.info("TEST SEARCH");
        log.info("DATA " + item);
        log.info("CLICK SEARCH BUTTON");
        $(By.xpath("//a[@class='main-header__search-block']//*[name()='svg']")).click();
        log.info("ENTER TEXT IN SEARCH FIELD");
        $(By.xpath("//input[@class='search-header__input']")).setValue(item);
        log.info("SUBMIT SEARCH");
        $(By.xpath("//input[@class='search-header__input']")).submit();
        log.info("GET RESULT COLLECTION");
        ElementsCollection resultElements = $$(By.xpath("//div[@class='col-xxs-12 col-xs-6 col-sm-4 col-md-4 col-lg-4 menuItemWrapper']//div[@class='imageData']//div[@class='h4']"));
        resultElements.asFixedIterable().stream()
                .map(selenideElement -> selenideElement.getText().toLowerCase())
                .peek(text -> log.info("ITEM :" + text))
                .forEach(text -> Assert.assertTrue(text.contains(item), "not match"));
        log.info("TEST END");
    }
}
