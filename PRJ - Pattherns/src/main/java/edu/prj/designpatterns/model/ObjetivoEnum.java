package edu.prj.designpatterns.model;

public enum ObjetivoEnum {

    EMAGRECER("Objetivo de treino de academia: Emagrecer"),
    DEFINICAO(" Principal meta: Definir músculos"),
    GANHAR_MASSA("Quero ganhar massa muscular");

    public String objetivos;
    ObjetivoEnum(String objetivos) {
        objetivos = objetivos;

    }
    public String getObejetivos() {
        return objetivos;
    }
}
