package br.upe.mavenBasico;

import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        List<String> resultado = ResultadoMegasena.obtemUltimoResultado();
        for (String dezena: resultado) {
            System.out.print( dezena + " " );
        }

        List<String> resultadoQuina = ResultadoQuina.pegarResultado();

        for(String quina: resultadoQuina) {
            System.out.print(quina + " ");
        }
    }
}
