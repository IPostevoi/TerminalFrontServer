package server;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import server.api.Request;
import server.api.Response;
import server.interfaces.Terminal;
import server.transporting.MessageSender;


/**
 * Created by bakla410 on 08.10.17.
 */

/**
 * Класс, собирающий в себя всю логику по обработке входящих данных,
 * пересылке их на бэк-сервер Терминала
 *
 */
@Component
public class Orchestration implements Terminal {

    // TODO - подсчитывать количество неправильных попыток
    private int wrongTries;

    private boolean terminalLocked;

    @Autowired
    private MessageSender sender;

    @Autowired
    private Session session;

    //Грязный хак для синхронизации отправки и получения сообщения с бэка
    private Object obj;

    public Orchestration() {
        obj = new Object();
    }

    @Override
    public void processRequest(Request request) {


        switch (request.getType()) {
            case ACCOUNTSTATE:
                break;
            case VALIDATEPIN:
                break;
            case WITHDRAW:
                break;
            case PUT:
                break;

        }
    }

    @Override
    public boolean validatePin(String pin) {
        synchronized (obj) {
            try {
                Request request = new Request();
                request.setType(OperationType.VALIDATEPIN);
                request.setBody(pin);
                sender.send(request);
                obj.wait();
            } catch (InterruptedException e) {}
        }

        boolean success = session.getResponse().isSuccess();

        System.out.println("Ответ валидации pin. Success - " + success);

        if (success) {
            session.setAuthorized(true);
        }

        return success;
    }

    @Override
    public void processResponse(Response response) {
        synchronized (obj) {
            session.setResponse(response);
            obj.notify();
        }

//        switch (response.getType()) {
//            case ACCOUNTSTATE:
//                response.setBody(accountState());
//                break;
//            case VALIDATEPIN:
//                System.out.println("Ответ валидации pin. Success - " + response.isSuccess());
//                break;
//            case WITHDRAW:
//                System.out.println("Снятие со счета. Success - " + response.isSuccess());
//                break;
//            case PUT:
//                System.out.println("Пополнение счета. Success - " + response.isSuccess());
//                break;
//        }
    }

    @Override
    public Double accountState() {
        return null;
    }

    @Override
    public Double withdrawCash(String currencyName, Double amount) {
        return null;
    }

    @Override
    public boolean putCash(String currencyName, Double amount) {
        synchronized (obj) {
            try {
                Request request = new Request();
                Operation operation = new Operation(CurrencyType.valueOf(currencyName), amount);
                request.setType(OperationType.PUT);
                request.setOperation(operation);
                sender.send(request);
                obj.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        boolean success = session.getResponse().isSuccess();

        System.out.println("Ответ пополнения счета. Success - " + success);

        return success;
    }

    @Override
    public boolean isAuthorized() {
        return session.isAuthorized();
    }

}
