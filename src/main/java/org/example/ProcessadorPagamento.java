package org.example;

public class ProcessadorPagamento {

    private float valorBase;

    public ProcessadorPagamento(float valorBase) {
        this.valorBase = valorBase;
    }

    public String executarPagamento(String tipoPagamento) {
        IPagamentoStrategy strategy = PagamentoFactory.obterPagamento(tipoPagamento);
        return strategy.processarPagamento(valorBase);
    }
}