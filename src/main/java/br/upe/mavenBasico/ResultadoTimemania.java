package br.upe.mavenBasico;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;
import static io.github.bonigarcia.wdm.DriverManagerType.CHROME;

public class ResultadoTimemania {
    private final static String URL = "http://loterias.caixa.gov.br/wps/portal/loterias/landing/timemania/";
    private final static String MARCA_INICIAL_RETORNO_NAO_UTIL = "<div id='concurso_resultado'>";
    private final static String MARCA_FINAL_RETORNO_NAO_UTIL = "</div>";

    public static List<String> pegarResultadoTimemania() {
        WebDriverManager.getInstance(CHROME).setup();

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        WebDriver driver = new ChromeDriver(options);

        try {
            driver.get(URL);
            new WebDriverWait(driver, 5).until(
                webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete")
            );

            List<String> resultado = obterResultadoTimemania(driver);

            return resultado;
        } catch (Exception e) {
            throw new RuntimeException("Um erro inesperado ocorreu: ", e);
        } finally {
            driver.quit();
        }
        
    }

    private static List<String> obterResultadoTimemania(WebDriver driver){
        WebElement ulResultado = driver.findElement(By.id("ulDezenas"));
        List<WebElement> liResultado = ulResultado.findElements(By.tagName("li"));
        List<String> resultado = new ArrayList();
        
        for (WebElement liRes: liResultado) {
            resultado.add(liRes.getAttribute("textContent"));
        }

        return resultado;
        
    }

}