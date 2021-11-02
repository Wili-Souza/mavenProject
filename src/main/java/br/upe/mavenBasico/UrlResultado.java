package br.upe.mavenBasico;

public enum UrlResultado {
    MEGASENA("http://loterias.caixa.gov.br/wps/portal/loterias/landing/megasena/"),
    LOTOFACIL(""),
    QUINA("http://loterias.caixa.gov.br/wps/portal/loterias/landing/quina/"),
    LOTOMANIA("http://loterias.caixa.gov.br/wps/portal/loterias/landing/lotomania/"),
    TIMEMANIA(""),
    DUPLASENA(""),
    DIADESORTE("");

    private final String url;

    UrlResultado(String url) {
        this.url = url;
    }

    public String getValor() {
        return url;
    }
}
