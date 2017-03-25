package com.interstellarexploration.remoteobs.asputil.amq;

import static org.quartz.JobBuilder.newJob;
import static org.quartz.TriggerBuilder.newTrigger;

import java.io.File;
import java.nio.charset.Charset;
import java.util.Date;

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
import org.apache.logging.log4j.LogManager;
import org.quartz.DateBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.Trigger;
import org.quartz.DateBuilder.IntervalUnit;
import org.quartz.impl.StdSchedulerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.interstellarexploration.remoteobs.asputil.planexec.AcpControl;

import quartz.HelloJob;
import quartz.SimpleExample;

public class AmqReceiverStartSched {
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
	
	public AmqReceiverStartSched() throws ConfigurationException, JMSException {
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

	  public void runReceiver() throws SchedulerException {
	      
		  Logger log = LoggerFactory.getLogger(SimpleExample.class);
	        try {
	            while (true) {
//	                Message message =  consumer.receive(1000);
	                Message message =  consumer.receive();

	                if (null != message) {
	                	if (message instanceof TextMessage ) {
	                		SchedulerFactory sf = new StdSchedulerFactory();
	                		Scheduler sched = sf.getScheduler();
	                		JobDetail job = newJob(HelloJob.class).withIdentity("job1", "group1").build();

	                        
	                        log.info("------- Run Spring Task ----------------------"+new Date());
//	                        Date runTime =   DateBuilder.nextGivenSecondDate(null, 15);;
	                        Date runTime =   DateBuilder.futureDate(15, IntervalUnit.SECOND);


	                        Trigger trigger = newTrigger().withIdentity("trigger1", "group1").startAt(runTime).build();

	                        // Tell quartz to schedule the job using our trigger
	                        sched.scheduleJob(job, trigger);
	                        log.info(job.getKey() + " will run at: " + runTime);

	                        // Start up the scheduler (nothing can actually run until the
	                        // scheduler has been started)
	                        sched.start();
	                        // shut down the scheduler

//	                		String textMessage=((TextMessage) message).getText();
//	                		LogManager.getLogger().debug(textMessage);
//	                		String filePath="C:/planb.txt";
//	                		if (!filePath.endsWith(".txt")) {
//	                			filePath+=".txt";
//	                		}
//	                		File file = new File(filePath);
//	                		FileUtils.writeStringToFile(file, textMessage, Charset.forName("UTF-8"), false);
//	                		
//	                		LogManager.getLogger().debug(file.getName()+"-"+file.getPath());
//	                		AcpControl.runPlan(filePath,acpUrl,acpUser,acpPass);
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
//	        sched.shutdown(true);
	    }
}
