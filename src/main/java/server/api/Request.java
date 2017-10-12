package server.api;

import server.Operation;
import server.OperationType;

import java.io.Serializable;
import java.util.List;

/**
 * Created by bakla410 on 08.10.17.
 */

/**
 * Запрос, формирующийся на терминале и отправляющийся на бэк-сервер
 *
 */
public class Request implements Serializable {

    private OperationType type;
    private String body;
    private Operation operation;

    public OperationType getType() {
        return type;
    }

    public void setType(OperationType type) {
        this.type = type;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Operation getOperation() {
        return operation;
    }

    public void setOperation(Operation operation) {
        this.operation = operation;
    }
}
