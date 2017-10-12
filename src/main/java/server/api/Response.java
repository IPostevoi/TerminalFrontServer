package server.api;

/**
 * Created by bakla410 on 08.10.17.
 */

import server.OperationType;

import java.io.Serializable;

/**
 * Ответ, сформированный бэк-сервером в ответ на полученный Response, и отправленный на Terminal
 *
 */
public class Response implements Serializable {

    private OperationType type;
    private String text;
    private boolean success;
    private Object body;

    public OperationType getType() {
        return type;
    }

    public void setType(OperationType type) {
        this.type = type;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public Object getBody() {
        return body;
    }

    public void setBody(Object body) {
        this.body = body;
    }
}
