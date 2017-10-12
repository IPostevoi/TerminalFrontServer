package server.interfaces;
import server.Operation;
import server.api.Request;
import server.api.Response;

/**
 * Created by bakla410 on 08.10.17.
 */


/**
 * Интерфейс взаимодействия пользователя с Терминалом - проведение операций, выписка со счета
 *
 */
public interface Terminal {

    void processRequest(Request request);

    void processResponse(Response response);

    boolean validatePin(String pin);

    Double accountState();

    Double withdrawCash(String currencyName, Double amount);

    boolean putCash(String currencyName, Double amount);

    boolean isAuthorized();

}
