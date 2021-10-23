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
    private final static String MARCA_INICIAL_RETORNO_NAO_UTIL = "<div id='concurso_resultado'>";
    private final static String MARCA_FINAL_RETORNO_NAO_UTIL = "</div>";
    private QuantidadeDezenas quantidadeDezenas;

    public Scrapper(String URL, QuantidadeDezenas quantidadeDezenas) {
        this.URL = URL;
        this.quantidadeDezenas = quantidadeDezenas;
    }

    public  List<String> pegarResultado() {
        WebDriverManager.getInstance(CHROME).setup();

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        WebDriver driver = new ChromeDriver(options);

        try {
            driver.get(URL);
            new WebDriverWait(driver, 5).until(
                    webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete")
            );

            List<String> resultado = obterResultado(driver);

            return resultado;
        } catch (Exception e) {
            throw new RuntimeException("Um erro inesperado ocorreu: ", e);
        } finally {
            driver.quit();
        }
    }


    private  List<String> obterResultado(WebDriver driver) {
            try {
                WebElement ulResultado = driver.findElement(By.id("ulDezenas"));

                List<WebElement> liResultado = ulResultado.findElements(By.tagName("li"));
                List<String> resultado = new ArrayList();

                for (WebElement liRes: liResultado) {
                    resultado.add(liRes.getAttribute("textContent"));
                }

                return resultado;

            } catch (Exception e) {
                List<WebElement> ulResultado = driver.findElements(By.className("lista-dezenas"));
                List<String> listOfUls = new ArrayList();

                for (WebElement ul: ulResultado){
                    List<WebElement> liResultado = ul.findElements(By.tagName("li"));
                    List<String> resultado = new ArrayList();

                    int i = 0;

                    for (WebElement liRes: liResultado) {
                        resultado.add(liRes.getAttribute("textContent"));
                        i++;

                        if(i == this.quantidadeDezenas.getValor()) {
                            listOfUls.add((Arrays.stream(listOfUls.toArray()).count() + 1) + " Resultado: " + resultado);
                            resultado.clear();
                            i = 0;
                        }
                    }
                }

                return listOfUls;
            }

    }



}
