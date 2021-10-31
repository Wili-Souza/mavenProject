package br.upe.mavenBasico;

import junit.framework.TestCase;
import org.junit.Test;

import java.util.List;

public class ResultadoMegasenaTest extends TestCase {
    /** Número de dezenas esperadas no resultado da mega-sena. */
    private final static int NUMERO_DE_DEZENAS = 6;

    /**  Teste para resultado da MegaSena */
    @Test
    public void testResultadoMegaSena() {
        List<List<String>> resultadoMegaSena = new Scrapper(
                "http://loterias.caixa.gov.br/wps/portal/loterias/landing/megasena/",
                QuantidadeDezenas.MEGASENA
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
                QuantidadeDezenas.QUINA
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
                QuantidadeDezenas.LOTOMANIA
        ).pegarResultado();
        assertNotNull(resultadoMegaSena);
        for(List<String> dezenas: resultadoMegaSena) {
            assertTrue( dezenas.toArray().length == QuantidadeDezenas.LOTOMANIA.getValor() );
        }
    }
}