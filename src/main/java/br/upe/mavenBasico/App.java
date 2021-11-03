package br.upe.mavenBasico;

import org.openqa.selenium.WebDriver;

import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) {
        // Criando driver
        WebDriver driver = new Driver("95").getDriver();

        try {
            // Pegando resultados
            pegarResultado(UrlResultado.MEGASENA.getValor(), QuantidadeDezenas.MEGASENA.getValor(), driver, "MegaSena");
            pegarResultado(UrlResultado.QUINA.getValor(),  QuantidadeDezenas.QUINA.getValor(), driver, "Quina");
            pegarResultado(UrlResultado.LOTOMANIA.getValor(), QuantidadeDezenas.LOTOMANIA.getValor(), driver, "Lotomania");
        } finally {
            driver.quit();
        }
    }

    private static void pegarResultado(String URL, int quantidadeDezenas, WebDriver driver, String name) {
        // Mega Sena
        Scraper scrapperResultado  = new Scraper(URL, quantidadeDezenas, driver);
        List<List<String>> resultado = scrapperResultado.pegarResultado();
        mostrarResultados(resultado, name);
    }

    private static void mostrarResultados(List<List<String>> resultados, String nomeLoteria) {
        System.out.print("Resultado " + nomeLoteria + ": \n");
        for(List<String> dezenas: resultados) {
            System.out.print(dezenas + "\n");
        }
    }
}
