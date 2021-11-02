package br.upe.mavenBasico;

import junit.framework.TestCase;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import java.util.List;

public class ResultadoMegasenaTest extends TestCase {
    /** Número de dezenas esperadas no resultado da mega-sena. */
    private final static int NUMERO_DE_DEZENAS = 6;
    // Criando driver
    WebDriver driver = new Driver("95").getDriver();

    /**  Teste para resultado da MegaSena */
    @Test
    public void testResultadoMegaSena() {
        List<List<String>> resultadoMegaSena = new Scrapper(
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
        List<List<String>> resultadoMegaSena = new Scrapper(
                "http://loterias.caixa.gov.br/wps/portal/loterias/landing/quina/",
                QuantidadeDezenas.QUINA.getValor(),
                driver
        ).pegarResultado();
        assertNotNull(resultadoMegaSena);
        for(List<String> dezenas: resultadoMegaSena) {
            assertTrue( dezenas.toArray().length ==QuantidadeDezenas.QUINA.getValor() );
        }
    }

    /**  Teste para resultado da  */
    @Test
    public void testResultadoLotomania() {
        List<List<String>> resultadoMegaSena = new Scrapper(
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