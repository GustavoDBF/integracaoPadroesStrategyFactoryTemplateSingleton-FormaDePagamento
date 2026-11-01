package org.example;

public class PagamentoConfig {

    private PagamentoConfig() {}

    private static PagamentoConfig instance = new PagamentoConfig();

    public static PagamentoConfig getInstance() {
        return instance;
    }

    private String nomeEmpresa;
    private float taxaAdquirente;

    public String getNomeEmpresa() {
        return nomeEmpresa;
    }

    public void setNomeEmpresa(String nomeEmpresa) {
        this.nomeEmpresa = nomeEmpresa;
    }

    public float getTaxaAdquirente() {
        return taxaAdquirente;
    }

    public void setTaxaAdquirente(float taxaAdquirente) {
        this.taxaAdquirente = taxaAdquirente;
    }
}