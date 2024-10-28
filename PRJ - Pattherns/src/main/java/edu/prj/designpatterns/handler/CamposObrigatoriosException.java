package edu.prj.designpatterns.handler;

public class CamposObrigatoriosException extends BusinessException {
    public CamposObrigatoriosException(String campo) {
        super("O Campo %s é obrigatório", campo);
    }
}
