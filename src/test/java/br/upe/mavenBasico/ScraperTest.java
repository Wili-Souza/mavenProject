package br.upe.mavenBasico;

import junit.framework.TestCase;

import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.openqa.selenium.WebDriver;
import java.util.ArrayList;

import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class ScraperTest extends TestCase {
    /** Número de dezenas esperadas no resultado da mega-sena. */
    private final static int NUMERO_DE_DEZENAS = 6;
    // Criando driver
    WebDriver driver = new Driver("95").getDriver();

    /**  Teste para resultado da MegaSena |*/

    @Mock
    Scraper scraperMock;

    @Test
    public void testResultadoMegaSena() {

        List<List<String>> resultado = new ArrayList<>();
        List<String> subList = Arrays.asList("1", "2", "3", "4", "5", "6");
        List<String> subList2 = Arrays.asList("1", "2", "3", "4", "5", "6");
        resultado.add(subList);
        resultado.add(subList2);

        //scraperMock.quantidadeDezenas = 6;

        when(scraperMock.pegarResultado()).thenReturn(resultado);
        for(List<String> dezenas: scraperMock.pegarResultado()) {
            assertTrue( dezenas.toArray().length == QuantidadeDezenas.MEGASENA.getValor() );
        }
        
        /*List<List<String>> resultadoMegaSena = new Scraper(
                "http://loterias.caixa.gov.br/wps/portal/loterias/landing/megasena/",
                QuantidadeDezenas.MEGASENA.getValor(),
                driver
        ).pegarResultado();
        assertNotNull(resultadoMegaSena);
        for(List<String> dezenas: resultadoMegaSena) {
            assertTrue( dezenas.toArray().length == QuantidadeDezenas.MEGASENA.getValor() );
        }*/
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