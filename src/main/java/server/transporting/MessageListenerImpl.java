package server.transporting;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import server.Orchestration;
import server.api.Request;
import server.api.Response;
import server.interfaces.Terminal;

import javax.jms.*;

/**
 * Created by bakla410 on 08.10.17.
 */

@Service
public class MessageListenerImpl implements MessageListener {

    @Autowired
    private Terminal orchestration;

    public void onMessage(Message message) {
        ObjectMessage msg = (ObjectMessage) message;
        try {
            Response response = (Response) (msg.getObject());
            orchestration.processResponse(response);
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
}
