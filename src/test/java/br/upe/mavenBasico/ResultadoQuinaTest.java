package br.upe.mavenBasico;

import junit.framework.TestCase;
import org.junit.Test;

import java.util.List;

public class ResultadoQuinaTest extends TestCase {
    private final static int NUMERO_DE_DEZENAS = 5;

    @Test
    public void testPegarResultado() {
        List<String> resultado = ResultadoQuina.pegarResultado();

        assertNotNull(resultado);
        assertTrue(resultado.toArray().length == NUMERO_DE_DEZENAS);
    }

}
