package server;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.listener.DefaultMessageListenerContainer;
import server.transporting.MessageListenerImpl;

/**
 * Created by bakla410 on 08.10.17.
 */

/**
 * Конфигурация очередей, два канала - один для Request, второй для Response
 *
 */
@Configuration
@ComponentScan
public class QueueConfig {

    @Bean
    public ActiveMQConnectionFactory connectionFactory(){
        ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://localhost:61616");
        connectionFactory.setTrustAllPackages(true);
        return connectionFactory;
    }

    @Bean
    @Autowired
    public DefaultMessageListenerContainer listenerContainer(MessageListenerImpl messageListener){
        DefaultMessageListenerContainer container = new DefaultMessageListenerContainer();
        container.setConnectionFactory(connectionFactory());
        container.setDestinationName("terminalResponseQueue");
        container.setMessageListener(messageListener);
        return container;
    }

    @Bean
    public JmsTemplate jmsTemplate(){
        JmsTemplate jmsTemplate = new JmsTemplate(connectionFactory());
        jmsTemplate.setDefaultDestinationName("terminalRequestQueue");
        return jmsTemplate;
    }
}