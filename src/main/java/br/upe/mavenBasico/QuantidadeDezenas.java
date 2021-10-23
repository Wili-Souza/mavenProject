package br.upe.mavenBasico;

public enum QuantidadeDezenas {
    MEGASENA(6), LOTOFACIL(5), QUINA(5),
    LOTOMANIA(5), TIMEMANIA(7),DUPLASENA(6),
    DIADESORTE(7);

    private final int valor;

    QuantidadeDezenas(int valor) {
        this.valor = valor;
    }

    public int getValor() {
        return valor;
    }
}
