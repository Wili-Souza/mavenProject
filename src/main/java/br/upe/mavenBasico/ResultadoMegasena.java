package br.upe.mavenBasico;

import io.github.bonigarcia.wdm.WebDriverManager;
import static io.github.bonigarcia.wdm.DriverManagerType.CHROME;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.*;

/**

 * Classe que obtém os números do último sorteio da mega-sena.

 */

public class ResultadoMegasena {
    /**
     * URL que possui as dezenas sorteadas
     */
    private final static String URL = "http://loterias.caixa.gov.br/wps/portal/loterias/landing/megasena/";

    /**
     * Marcação inicial para extrair as dezenas do retorno HTML.
     */
    private final static String MARCA_INICIAL_RETORNO_NAO_UTIL = "<div id='concurso_resultado'>";

    /**
     * Marcação final para extrair as dezenas do retorno HTML.
     */
    private final static String MARCA_FINAL_RETORNO_NAO_UTIL = "</div>";

    /**
     * Método que se conecta ao site da CEF para obter as dezenas
     * do último sorteio.
     *
     * @return array de Strings, onde cada elemento é uma dezena
     * sorteada.
     */

    public static List<String>  obtemUltimoResultado() {
        // setting driver
        WebDriverManager.getInstance(CHROME).version("95").setup();

        // setting options
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");

        // creating driver
        WebDriver driver = new ChromeDriver(options);

        try {
            // connecting to url and waiting page to load
            driver.get(URL);
            new WebDriverWait(driver, 5).until(
                    webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete")
            );

            // getting dezenas from page content
            List<String> dezenas = obterDezenas(driver);

            return dezenas;
        } catch (Exception e) {
            // Caso haja erro, dispara exceção.
            throw new RuntimeException("Um erro inesperado ocorreu: ", e);
        } finally {
            //Destruição do driver para liberação dos recursos do sistema.
            driver.quit();
        }
    }

    /**
     * Tratamento doconteúdo do driver obtida pelo método
     * obtemUltimoResultado().
     *
     * @param driver WebDriver obtida
     * @return List de Strings, onde cada elemento é uma dezena
     * sorteada.
     */

    private static List<String> obterDezenas(WebDriver driver) {
        // getting ul tag of dezenas
        WebElement ulDezenas = driver.findElement(By.id("ulDezenas"));

        // getting list of li elements
        List<WebElement> liDezenas = ulDezenas.findElements(By.tagName("li"));

        // creating a new array of Strings with the text content of li elements
        List<String> dezenas = new ArrayList();
        for (WebElement liDezena: liDezenas) {
            dezenas.add(liDezena.getAttribute("textContent"));
        }

        return dezenas;
    }
}
