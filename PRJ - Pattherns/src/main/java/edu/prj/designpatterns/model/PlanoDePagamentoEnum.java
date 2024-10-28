package edu.prj.designpatterns.model;

public enum PlanoDePagamentoEnum {

    PLANO_FAMILIAR_ANUAL("Plano Familiar Anual 30% de Desconto"),
    PLANO_FAMILIAR_Semestral("Plano Familiar Semestral 15% de Desconto"),
    PLANO_FAMILIAR_TRIMESTRAL("Plano Familiar Trimestral 5% de Desconto"),
    PLANO_FAMILIAR_MENSAL("Plano Familiar Mensal sem Desconto"),
    PLANO_INDIVIDUAL_ANUAL("Plano Indiviadual 30% de Desconto"),
    PLANO_INDIVIDUAL_Semestral("Plano Individual Semestral 15% de Desconto"),
    PLANO_INDIVIDUAL_TRIMESTRAL("Plano Individual Trimestral 5% de Desconto"),
    PLANO_INDIVIDUAL_MENSAL("Plano Individual Mensal sem Desconto");

    public String planoDePagamentoEscolhido;
    PlanoDePagamentoEnum(String plano) {
        planoDePagamentoEscolhido = plano;

    }
    public String getPlanoDePagamentoEscolhido() {
        return planoDePagamentoEscolhido;
    }
}
