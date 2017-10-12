package server.transporting;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import java.io.Serializable;

/**
 * Created by bakla410 on 08.10.17.
 */
@Component
public class MessagSenderImpl implements MessageSender {

    @Autowired
    private JmsTemplate jmsTemplate;

    public void send(Serializable message) {
        jmsTemplate.convertAndSend(message);
    }
}
