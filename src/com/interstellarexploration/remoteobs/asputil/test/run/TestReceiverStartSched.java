package com.interstellarexploration.remoteobs.asputil.test.run;

import org.apache.commons.configuration2.ex.ConfigurationException;
import org.quartz.SchedulerException;

import com.interstellarexploration.remoteobs.asputil.amq.AmqReceiver;
import com.interstellarexploration.remoteobs.asputil.amq.AmqReceiverStartSched;

import javax.jms.*;

public class TestReceiverStartSched {
    public static void main(String[] args) throws SchedulerException {
		AmqReceiverStartSched ar = null;
		try {
			ar = new AmqReceiverStartSched();
		} catch (ConfigurationException e) {
			e.printStackTrace();
		} catch (JMSException e) {
			e.printStackTrace();
		}
			ar.runReceiver();
    }
}