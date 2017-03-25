package com.interstellarexploration.remoteobs.asputil.amq;

import java.io.File;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.commons.configuration2.Configuration;
import org.apache.commons.configuration2.builder.fluent.Configurations;
import org.apache.commons.configuration2.ex.ConfigurationException;
import org.apache.logging.log4j.LogManager;


public class AmqSender {
	
  	private String AMQUrl ;
  	private String amqName ;
  	private String amqLoginPass ;
  	private String amqLoginUser  ;
    ConnectionFactory connectionFactory;
    Connection connection = null;
    Session session; 
    Destination destination;
    // MessageProducer锛氭秷鎭彂閫佽��
    MessageProducer producer; //
    TextMessage message = null;
	public AmqSender() throws ConfigurationException, JMSException {
		Configurations configs = new Configurations();
    	Configuration config = null;
    
	    config = configs.properties(new File("acpconfig.properties"));
	    AMQUrl = config.getString("amqUrl","tcp://127.0.0.1:61616");
	    amqName = config.getString("amqName","loginTopic");
	    amqLoginPass = config.getString("amqLoginPass");
	    amqLoginUser = config.getString("amqLoginUser");
	    connectionFactory = new ActiveMQConnectionFactory(ActiveMQConnection.DEFAULT_USER, ActiveMQConnection.DEFAULT_PASSWORD, AMQUrl);
        connection = connectionFactory.createConnection();
        
        connection.start();
        session = connection.createSession(Boolean.TRUE, Session.AUTO_ACKNOWLEDGE);

        destination = session.createTopic(amqName);
        producer = session.createProducer(destination);
	}



    public  void sender(String textMessage) {

        try { 
            message=session.createTextMessage(textMessage);
            producer.send(message);
            LogManager.getLogger().debug(textMessage);
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            LogManager.getLogger().error(e);
        } finally {
            try {
                if (null != connection){
//                	connection.close();
                }
            } catch (Throwable ignore) {
            }
        }
    }
}
