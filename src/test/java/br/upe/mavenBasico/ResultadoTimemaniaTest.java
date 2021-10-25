package br.upe.mavenBasico;

import junit.framework.TestCase;
import org.junit.Test;

import java.util.List;

public class ResultadoTimemaniaTest extends TestCase {
    private final static int NUMERO_DE_DEZENAS = 7;

    @Test
    public void testPegarResultadoTimemania(){
        List<String> resultado = ResultadoTimemania.pegarResultadoTimemania();

        assertNotNull(resultado);
        assertTrue(resultado.toArray().length = NUMERO_DE_DEZENAS);
    }
}

