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
//        List<String> resultado = ResultadoMegasena.obtemUltimoResultado();
//        for (String dezena: resultado) {
//            System.out.print( dezena + " " );
//        }
//
//        List<String> resultadoQuina = ResultadoQuina.pegarResultado();
//        for(String quina: resultadoQuina) {
//            System.out.print(quina + " ");
//        }

        // Modo generico

//        Scrapper resultadoMegaSena  = new Scrapper("http://loterias.caixa.gov.br/wps/portal/loterias/landing/megasena/");
//        Scrapper resultadoCaixaQuina = new Scrapper("http://loterias.caixa.gov.br/wps/portal/loterias/landing/quina/");
//
//        List<String> resultadoMega = resultadoMegaSena.pegarResultado();
//        List<String> resultadoQuin  = resultadoCaixaQuina.pegarResultado();
        Scrapper resultadoLotomania = new Scrapper("http://loterias.caixa.gov.br/wps/portal/loterias/landing/lotomania/", QuantidadeDezenas.LOTOMANIA);

        List<String> resultadoLoto =  resultadoLotomania.pegarResultado();

        for(String loto: resultadoLoto) {
           System.out.println(loto);
       }
    }
}
