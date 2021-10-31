package br.upe.mavenBasico;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static io.github.bonigarcia.wdm.DriverManagerType.CHROME;

public class Scrapper {
    private static String URL = "";
    private QuantidadeDezenas quantidadeDezenas;

    public Scrapper(String URL, QuantidadeDezenas quantidadeDezenas) {
        this.URL = URL;
        this.quantidadeDezenas = quantidadeDezenas;
    }

    public  List<List<String>> pegarResultado() {
        // WebDriverManager.getInstance(CHROME).version("94").setup();
        WebDriverManager.chromedriver().version("95.0.4638.69").setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");

        WebDriver driver = new ChromeDriver(options);

        try {
            driver.get(URL);
            new WebDriverWait(driver, 5).until(
                    webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete")
            );

            List<List<String>> resultado = obterResultados(driver);

            return resultado;
        } catch (Exception e) {
            throw new RuntimeException("Um erro inesperado ocorreu: ", e);
        } finally {
            driver.quit();
        }
    }

    private  List<List<String>> obterResultados(WebDriver driver) {
        List<List<String>> resultado = new ArrayList();
        WebElement ulResultado;
        List<WebElement> liResultado;

        try {
            ulResultado = driver.findElement(By.id("ulDezenas"));
        } catch (Exception e) {
            ulResultado = driver.findElement(By.className("lista-dezenas"));
        }

        liResultado = ulResultado.findElements(By.tagName("li"));

        while ( liResultado.size() > 0 ) {
            List<String> dezenas = resultadoDaLi(liResultado.subList(0, this.quantidadeDezenas.getValor()));
            resultado.add(dezenas);
            liResultado = liResultado.subList(this.quantidadeDezenas.getValor(), liResultado.size());
        }

        return resultado;
    }

    private  List<String> resultadoDaLi(List<WebElement> liList) {
        List<String> resultado = new ArrayList();
        for (WebElement li: liList) {
            resultado.add(li.getAttribute("textContent").trim());
        }
        return resultado;
    }
}

