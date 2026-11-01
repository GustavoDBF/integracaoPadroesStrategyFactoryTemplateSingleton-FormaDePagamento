package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProcessadorPagamentoTest {

    @BeforeEach
    void setUp() {
        PagamentoConfig.getInstance().setNomeEmpresa("Loja Virtual SA");
        PagamentoConfig.getInstance().setTaxaAdquirente(1.00f);
    }

    @Test
    void deveProcessarPagamentoPix() {
        ProcessadorPagamento processador = new ProcessadorPagamento(100.0f);
        String resultado = processador.executarPagamento("Pix");
        assertEquals("Empresa: Loja Virtual SA | Tipo: Pix | Valor Final: R$101,00", resultado);
    }

    @Test
    void deveProcessarPagamentoCartao() {
        ProcessadorPagamento processador = new ProcessadorPagamento(100.0f);
        String resultado = processador.executarPagamento("Cartao");
        assertEquals("Empresa: Loja Virtual SA | Tipo: Cartao | Valor Final: R$106,00", resultado);
    }

    @Test
    void deveProcessarPagamentoBoleto() {
        ProcessadorPagamento processador = new ProcessadorPagamento(100.0f);
        String resultado = processador.executarPagamento("Boleto");
        assertEquals("Empresa: Loja Virtual SA | Tipo: Boleto | Valor Final: R$103,50", resultado);
    }

    @Test
    void deveRetornarExcecaoParaPagamentoInexistente() {
        try {
            ProcessadorPagamento processador = new ProcessadorPagamento(100.0f);
            processador.executarPagamento("Cripto");
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("Tipo de pagamento inexistente", e.getMessage());
        }
    }

    @Test
    void deveRetornarExcecaoParaPagamentoInvalido() {
        try {
            ProcessadorPagamento processador = new ProcessadorPagamento(100.0f);
            processador.executarPagamento("Invalido");
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("Estratégia de pagamento inválida", e.getMessage());
        }
    }

    @Test
    void deveRetornarExcecaoParaValorInvalido() {
        try {
            ProcessadorPagamento processador = new ProcessadorPagamento(0.0f);
            processador.executarPagamento("Pix");
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("Valor de pagamento inválido", e.getMessage());
        }
    }
}