package br.upe.mavenBasico;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Driver {
    private WebDriver driver;
    private String version;

    public Driver(String version) {
        this.version = version;
        this.createDriver();
    }

    private void createDriver() {
        WebDriverManager.chromedriver().version(this.version).setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        this.driver = new ChromeDriver(options);
    }

    public WebDriver getDriver() {
        return this.driver;
    }

    public String getVersion() {
        return this.version;
    }
}
