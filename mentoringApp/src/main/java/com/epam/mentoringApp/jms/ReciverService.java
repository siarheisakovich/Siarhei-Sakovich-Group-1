package com.epam.mentoringApp.jms;

import javax.jms.JMSException;
import javax.jms.TextMessage;

import org.apache.log4j.Logger;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;

@Component
public class ReciverService {
    private static final Logger logger = Logger.getLogger(ReciverService.class);
    
    @JmsListener(containerFactory = "myJmsListenerContainerFactory", destination = "TEST.FOO")
    @SendTo("reply")
    public String doTestFooMessage(TextMessage message) throws JMSException{
        logger.debug("Listener " + Thread.currentThread().getName() + " : " + message.getText());
        return "doTestFooMessage";
    }
    
    @JmsListener(containerFactory = "myJmsListenerContainerFactory", destination = "TEST.BAR")
    @SendTo("reply")
    public String doTestBarMessage(TextMessage message) throws JMSException{
        logger.debug("Listener " + Thread.currentThread().getName() + " : " + message.getText());
        return "doTestBarMessage";
    }
    
    @JmsListener(containerFactory = "myJmsListenerContainerFactory", destination = "FOO.TEST")
    @SendTo("reply")
    public String doFooTestMessage(TextMessage message) throws JMSException{
        logger.debug("Listener " + Thread.currentThread().getName() + " : " + message.getText());
        return "doFooTestMessage";
    }
}
