package com.sii.tests;

import configuration.AppProperties;
import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

@Slf4j
public class TestBase {
    protected WebDriver driver;

    @BeforeAll
    static void setup() {
        AppProperties singletonInstance = AppProperties.getInstance();

    }

    @BeforeEach
    void setupDriver() {
        getDriver();
        driver.get(System.getProperty("appUrl"));
        log.debug("WebDriver is up and running");
    }

    @AfterEach
    void teardown() {
        driver.quit();
        log.debug("WebDriver is closed");
    }

    public void getDriver() {
        String browserName = System.getProperty("browser");
        switch (browserName) {
            case "chrome" -> {
                ChromeOptions optionsChrome = new ChromeOptions();
                WebDriverManager.chromedriver().setup();
                optionsChrome.addArguments("start-maximized");
                driver = new ChromeDriver(optionsChrome);
            }
            case "edge" -> {
                EdgeOptions optionsEdge = new EdgeOptions();
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver(optionsEdge);
            }
        }
    }

}
