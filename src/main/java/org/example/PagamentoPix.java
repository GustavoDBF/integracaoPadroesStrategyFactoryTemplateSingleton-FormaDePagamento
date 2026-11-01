package org.example;

public class PagamentoPix extends PagamentoTemplate {

    @Override
    public float calcularTaxaEspecifica(float valorBase) {
        return 0.0f;
    }

    @Override
    public String getTipo() {
        return "Pix";
    }
}