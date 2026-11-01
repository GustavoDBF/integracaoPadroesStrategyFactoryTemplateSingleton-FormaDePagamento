package org.example;

public class PagamentoFactory {

    public static IPagamentoStrategy obterPagamento(String tipoPagamento) {
        Class classe = null;
        Object objeto = null;
        try {
            classe = Class.forName("org.example.Pagamento" + tipoPagamento);
            objeto = classe.newInstance();
        } catch (Exception ex) {
            throw new IllegalArgumentException("Tipo de pagamento inexistente");
        }
        if (!(objeto instanceof IPagamentoStrategy)) {
            throw new IllegalArgumentException("Estratégia de pagamento inválida");
        }
        return (IPagamentoStrategy) objeto;
    }
}