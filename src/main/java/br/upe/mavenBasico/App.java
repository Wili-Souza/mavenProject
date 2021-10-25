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
        // Mega Sena
        Scrapper resultadoMegaSena  = new Scrapper(
                "http://loterias.caixa.gov.br/wps/portal/loterias/landing/megasena/",
                QuantidadeDezenas.MEGASENA
        );
        List<List<String>> resultadoMega = resultadoMegaSena.pegarResultado();
        mostrarResultados(resultadoMega, "MegaSena");

        // Quina
        Scrapper resultadoCaixaQuina = new Scrapper(
                "http://loterias.caixa.gov.br/wps/portal/loterias/landing/quina/",
                QuantidadeDezenas.QUINA
        );
        List<List<String>> resultadoQuina  = resultadoCaixaQuina.pegarResultado();
        mostrarResultados(resultadoQuina, "Quina");


        // Lotomania
        Scrapper resultadoLotomania = new Scrapper(
                "http://loterias.caixa.gov.br/wps/portal/loterias/landing/lotomania/",
                QuantidadeDezenas.LOTOMANIA
        );
        List<List<String>> resultadoLoto =  resultadoLotomania.pegarResultado();
        mostrarResultados(resultadoLoto, "Lotomania");
    }

    private static void mostrarResultados(List<List<String>> resultados, String nomeLoteria) {
        System.out.print("Resultado " + nomeLoteria + ": \n");
        for(List<String> dezenas: resultados) {
            System.out.print(dezenas + "\n");
        }
    }
}
