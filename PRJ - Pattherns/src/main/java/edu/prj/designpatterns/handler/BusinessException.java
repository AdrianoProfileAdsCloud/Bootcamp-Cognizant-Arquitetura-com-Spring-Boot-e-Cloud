package edu.prj.designpatterns.handler;

/**
 * @author Adriano Aparecido da Silva
 *
 *  Algumas das nossas exceções estão relacionadas ao domínio ou negócio da nossa aplicação, sendo assim,
 * vamos criar uma classe de exceção que estende RunTimeException,
 * que servirá como base para todas as outras exceções de negócio.
 */


public class BusinessException extends RuntimeException {
    public BusinessException(String mensagem) {
        super(mensagem);
    }
    public BusinessException(String mensagem, Object ... params) {
        super(String.format(mensagem, params));
    }
}