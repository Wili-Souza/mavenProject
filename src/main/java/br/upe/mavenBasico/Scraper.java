package br.upe.mavenBasico;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class Scraper {
    private static String URL;
    private int quantidadeDezenas;
    private WebDriver driver;

    public Scraper(String URL, int quantidadeDezenas, WebDriver driver) {
        this.URL = URL;
        this.quantidadeDezenas = quantidadeDezenas;
        this.driver = driver;
    }

    public  List<List<String>> pegarResultado() {
        try {
            this.driver.get(URL);
            new WebDriverWait(this.driver, 5).until(
                    webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete")
            );

            List<List<String>> resultado = formatarResultados();

            return resultado;
        } catch (Exception e) {
            throw new RuntimeException("Um erro inesperado ocorreu: ", e);
        }
    }

    private  List<List<String>> formatarResultados() {
        List<List<String>> resultado = new ArrayList();
        WebElement ulResultado;
        List<WebElement> liResultado;

        try {
            ulResultado = this.driver.findElement(By.id("ulDezenas"));
        } catch (Exception e) {
            ulResultado = this.driver.findElement(By.className("lista-dezenas"));
        }

        liResultado = ulResultado.findElements(By.tagName("li"));

        while ( liResultado.size() > 0 ) {
            List<String> dezenas = resultadoDaLi(liResultado.subList(0, this.quantidadeDezenas));
            resultado.add(dezenas);
            liResultado = liResultado.subList(this.quantidadeDezenas, liResultado.size());
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

