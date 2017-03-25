package com.interstellarexploration.remoteobs.asputil.test.run;

import org.apache.commons.configuration2.ex.ConfigurationException;
import com.interstellarexploration.remoteobs.asputil.amq.AmqReceiver;

import javax.jms.*;

public class TestReceiver {
    public static void main(String[] args) {
		AmqReceiver ar = null;
		try {
			ar = new AmqReceiver();
		} catch (ConfigurationException e) {
			e.printStackTrace();
		} catch (JMSException e) {
			e.printStackTrace();
		}
			ar.runReceiver();
    }
}