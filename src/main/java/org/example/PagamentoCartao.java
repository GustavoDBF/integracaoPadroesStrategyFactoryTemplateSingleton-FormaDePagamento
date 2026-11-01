package org.example;

public class PagamentoCartao extends PagamentoTemplate {

    @Override
    public float calcularTaxaEspecifica(float valorBase) {
        return valorBase * 0.05f;
    }

    @Override
    public String getTipo() {
        return "Cartao";
    }
}