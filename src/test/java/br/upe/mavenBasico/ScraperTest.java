package br.upe.mavenBasico;

import junit.framework.TestCase;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import java.util.List;

public class ScraperTest extends TestCase {
    
    // Criando driver
    WebDriver driver = new Driver("95").getDriver();

    /**  Teste para resultado da MegaSena */
    @Test
    public void testResultadoMegaSena() {
        List<List<String>> resultadoMegaSena = new Scraper(
                "http://loterias.caixa.gov.br/wps/portal/loterias/landing/megasena/",
                QuantidadeDezenas.MEGASENA.getValor(),
                driver
        ).pegarResultado();
        assertNotNull(resultadoMegaSena);
        for(List<String> dezenas: resultadoMegaSena) {
            assertTrue( dezenas.toArray().length == QuantidadeDezenas.MEGASENA.getValor() );
        }
    }

    /**  Teste para resultado da Quina */
    @Test
    public void testResultadoQuina() {
        List<List<String>> resultadoMegaSena = new Scraper(
                "http://loterias.caixa.gov.br/wps/portal/loterias/landing/quina/",
                QuantidadeDezenas.QUINA.getValor(),
                driver
        ).pegarResultado();
        assertNotNull(resultadoMegaSena);
        for(List<String> dezenas: resultadoMegaSena) {
            assertTrue( dezenas.toArray().length ==QuantidadeDezenas.QUINA.getValor() );
        }
    }

    /**  Teste para resultado da Lotomania */
    @Test
    public void testResultadoLotomania() {
        List<List<String>> resultadoMegaSena = new Scraper(
                "http://loterias.caixa.gov.br/wps/portal/loterias/landing/lotomania/",
                QuantidadeDezenas.LOTOMANIA.getValor(),
                driver
        ).pegarResultado();
        assertNotNull(resultadoMegaSena);
        for(List<String> dezenas: resultadoMegaSena) {
            assertTrue( dezenas.toArray().length == QuantidadeDezenas.LOTOMANIA.getValor() );
        }
    }
}