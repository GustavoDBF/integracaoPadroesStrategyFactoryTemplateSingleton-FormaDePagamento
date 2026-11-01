package org.example;

public class PagamentoBoleto extends PagamentoTemplate {

    @Override
    public float calcularTaxaEspecifica(float valorBase) {
        return 2.50f;
    }

    @Override
    public String getTipo() {
        return "Boleto";
    }
}