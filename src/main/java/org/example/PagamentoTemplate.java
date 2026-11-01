package org.example;

public abstract class PagamentoTemplate implements IPagamentoStrategy {

    @Override
    public String processarPagamento(float valorBase) {
        if (valorBase <= 0) {
            throw new IllegalArgumentException("Valor de pagamento inválido");
        }
        float taxaEspecifica = calcularTaxaEspecifica(valorBase);
        float taxaGlobal = PagamentoConfig.getInstance().getTaxaAdquirente();
        float valorFinal = valorBase + taxaEspecifica + taxaGlobal;

        return "Empresa: " + PagamentoConfig.getInstance().getNomeEmpresa() +
                " | Tipo: " + getTipo() +
                " | Valor Final: R$" + String.format("%.2f", valorFinal);
    }

    public abstract float calcularTaxaEspecifica(float valorBase);

    public String getTipo() {
        return "PagamentoGenerico";
    }
}