package com.epam.mentoringApp.jms;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.Connection;
import javax.jms.DeliveryMode;
import javax.jms.Destination;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;

public class JMSRunner {

    public static String[] topics = {"TEST.FOO", "TEST.BAR", "FOO.TEST"};
    
    public static void main(String[] args) throws InterruptedException {
        while (true) {
            thread(new HelloWorldProducer(), false);
            Thread.sleep(1000);
        }
        
        //thread(new HelloWorldProducer(), false);
        
    }
    
    public static void thread(Runnable runnable, boolean daemon) {
        Thread brokerThread = new Thread(runnable);
        brokerThread.setDaemon(daemon);
        brokerThread.start();
    }
    
    public static class HelloWorldProducer implements Runnable {
        public void run() {
            try {
                ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://EPBYGROW0184:61616");
 
                Connection connection = connectionFactory.createConnection();
                connection.start();
 
                Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
                
                String topic = topics[(int)Math.round(Math.random()*2)];
                Destination destination = session.createQueue(topic);
 
                MessageProducer producer = session.createProducer(destination);
                producer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);
 
                String text = "Hello jms! From: " + Thread.currentThread().getName() + " : " + this.hashCode();
                TextMessage message = session.createTextMessage(text);
                // Tell the producer to send the message
                System.out.println("Sent message: "+ message.hashCode() + " : " + Thread.currentThread().getName() + " : " + "Topic - " + topic );
                producer.send(message);
 
                // Clean up
                session.close();
                connection.close();
            }
            catch (Exception e) {
                System.out.println("Caught: " + e);
                e.printStackTrace();
            }
        }
    }
}
