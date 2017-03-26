package com.interstellarexploration.remoteobs.asputil.amq;

import java.io.File;
import java.nio.charset.Charset;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.commons.configuration2.Configuration;
import org.apache.commons.configuration2.builder.fluent.Configurations;
import org.apache.commons.configuration2.ex.ConfigurationException;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import com.interstellarexploration.remoteobs.asputil.planexec.AcpControl;

public class AmqReceiver {
	private String AMQUrl ;
	private String amqName ;
	private String amqLoginPass ;
	private String amqLoginUser  ;
	ConnectionFactory connectionFactory;
	Connection connection = null;
	Session session;
	Destination destination;
	MessageConsumer consumer;
	
	String acpUrl   ;
	String acpUser  ;
	String acpPass  ;
	
	public AmqReceiver() throws ConfigurationException, JMSException {
		Configurations configs = new Configurations();
    	Configuration config = null;
    
	    config = configs.properties(new File("acpconfig.properties"));
	    AMQUrl = config.getString("amqUrl","tcp://192.168.1.104:61616");
	    amqName = config.getString("amqName","loginTopic");
	    amqLoginPass = config.getString("amqLoginPass");
	    amqLoginUser = config.getString("amqLoginUser");
	    connectionFactory = new ActiveMQConnectionFactory(ActiveMQConnection.DEFAULT_USER, ActiveMQConnection.DEFAULT_PASSWORD, "failover://("+AMQUrl+")?randomize=false");
	    connection = connectionFactory.createConnection();
	    connection.start();
	    session = connection.createSession(Boolean.FALSE, Session.AUTO_ACKNOWLEDGE);
	    destination = session.createTopic(amqName);
	    consumer = session.createConsumer(destination);
	    
    	acpUrl = config.getString("acpUrl");
    	acpUser = config.getString("acpUser");
    	acpPass = config.getString("acpPass");
	}

	  public void runReceiver() {
	      
	        try {
	            while (true) {
//	                Message message =  consumer.receive(1000);
	                Message message =  consumer.receive();

	                if (null != message) {
	                	
	                	if (message instanceof TextMessage ) {
	                		Logger.getLogger("").debug("--------接收到消息-------"+ message);	
	                		String textMessage=((TextMessage) message).getText();
	                		LogManager.getLogger().debug(textMessage);
	                		String filePath="C:/planb.txt";
	                		if (!filePath.endsWith(".txt")) {
	                			filePath+=".txt";
	                		}
	                		File file = new File(filePath);
	                		FileUtils.writeStringToFile(file, textMessage, Charset.forName("UTF-8"), false);

	                		LogManager.getLogger().debug(file.getName()+"-"+file.getPath());
	                		Logger.getLogger("").debug("--------执行-------" + filePath );	
	                		AcpControl.runPlan(filePath,acpUrl,acpUser,acpPass);
						}
	                } else {
//	                    break;
//	                    System.out.println(".");
	                }
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        } finally {
	            try {
	                if (null != connection) connection.close();
	            } catch (Throwable ignore) {
	            }
	        }
	    }
}
