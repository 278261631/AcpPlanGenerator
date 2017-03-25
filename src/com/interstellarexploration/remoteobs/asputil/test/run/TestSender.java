package com.interstellarexploration.remoteobs.asputil.test.run;

import javax.jms.JMSException;

import org.apache.commons.configuration2.ex.ConfigurationException;
import org.junit.Test;

import com.interstellarexploration.remoteobs.asputil.amq.AmqSender;
import com.interstellarexploration.remoteobs.asputil.plangen.PlanCheckExeption;
import com.interstellarexploration.remoteobs.asputil.plangen.PlanFileContent;
import com.interstellarexploration.remoteobs.asputil.plangen.plantarget.NormalPlan;

public class TestSender {

  
    public static void main(String[] args) {
    	
    }
    
    @Test
    public void testSend(){
    	AmqSender as =null;
    	try {
			as = new AmqSender();
		} catch (ConfigurationException | JMSException e) {
			e.printStackTrace();
		}
		
		PlanFileContent planFile = new PlanFileContent();
		NormalPlan planA = new NormalPlan("M 42", 1,new int[]{1,2},new int[]{1,2},new int[]{1,2});
		planFile.getTargetList().add(planA);
		
    	 try {
			as.sender(planFile.toOutString());
		} catch (PlanCheckExeption e) {
		
			e.printStackTrace();
		}
    }

  


}
