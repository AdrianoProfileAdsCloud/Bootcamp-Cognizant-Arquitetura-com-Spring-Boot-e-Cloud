package edu.prj.designpatterns.model;

public enum StatusDePagamentoEnum {

    PAGAMETO_VENCIDO("Pagamento atrasado!"),
    PAGAMETO_A_VENCER("Pagamento em dia"),
    PAGAMENTO_REALIZADO("Pagamento realizado"),
    PAGAMENTO_PENDENTE("Pagamento Pendente");

    public String statusDePagamento;
    StatusDePagamentoEnum(String pagamento) {
        statusDePagamento = pagamento;

    }
    public String getStatusDePagamento() {
        return statusDePagamento;
    }
}
