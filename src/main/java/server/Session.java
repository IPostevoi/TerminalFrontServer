package server;

import org.springframework.stereotype.Component;
import server.api.Request;
import server.api.Response;

/**
 * Created by bakla410 on 08.10.17.
 */

/**
 * Класс, инкапсулирующий в себя текущий запрос и текущий ответ от бэка
 *
 */
@Component
public class Session {

    private Response response;
    private Request request;
    private boolean authorized;

    public Response getResponse() {
        return response;
    }

    public void setResponse(Response response) {
        this.response = response;
    }

    public Request getRequest() {
        return request;
    }

    public void setRequest(Request request) {
        this.request = request;
    }

    public boolean isAuthorized() {
        return authorized;
    }

    public void setAuthorized(boolean authorized) {
        this.authorized = authorized;
    }
}
