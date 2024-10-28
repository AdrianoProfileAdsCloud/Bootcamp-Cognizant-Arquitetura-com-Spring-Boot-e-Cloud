package edu.prj.designpatterns.handler;

import java.util.Date;

/**
 * @author Adriano Aparecido da Silva
 *     Primeiro de tudo, uma resposta HTTP mesmo sendo um erro,
 *     pode ser considerada um Objeto que será convertido em JSON,
 *     expondo informações relacionadas a exceção disparada.
 */

public class ResponseError {
    private Date timestamp = new Date();
    private String status = "error";
    private int statusCode = 400;
    private String error;

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}