package com.epam.mentoringApp;

import javax.jms.ConnectionFactory;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;

@Configuration
@EnableJms
@ComponentScan("com.epam.mentoringApp.jms")
public class JMSConfig {
    
    @Bean
    public ConnectionFactory connectionFactory(){
        ActiveMQConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory("tcp://EPBYGROW0184:61616");
        return activeMQConnectionFactory;
    }
    
    @Bean
    public DefaultJmsListenerContainerFactory myJmsListenerContainerFactory() {
      DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
      factory.setConnectionFactory(connectionFactory());
      factory.setConcurrency("5");
      return factory;
    }
}
