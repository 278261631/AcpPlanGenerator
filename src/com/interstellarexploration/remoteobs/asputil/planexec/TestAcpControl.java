package com.interstellarexploration.remoteobs.asputil.planexec;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Map;

import org.apache.commons.configuration2.Configuration;
import org.apache.commons.configuration2.builder.fluent.Configurations;
import org.apache.commons.configuration2.ex.ConfigurationException;
import org.apache.logging.log4j.LogManager;



public class TestAcpControl {
	public static void main(String[] args) {
		TestAcpControl tac=new TestAcpControl();
		tac.runPlan();
//		 runPlan();
		
//		 stopRunPlan();
	    }

	@org.junit.Test
	public   void runPlan() {
		Configurations configs = new Configurations();
    	Configuration config = null;
    	try
    	{
    	    config = configs.properties(new File("acpconfig.properties"));
    	}
    	catch (ConfigurationException cex)
    	{
    	    // Something went wrong
    		LogManager.getLogger().error(cex.getMessage());
    		cex.printStackTrace();
    	}

    	String acpUrl = config.getString("acpUrl");
    	String acpUser = config.getString("acpUser");
    	String acpPass = config.getString("acpPass");
		String filePath="C:/Users/Public/Documents/ACP Web Data/Doc Root/plans/mayong/test2.txt";
		System.out.println( AcpControl.runPlan(filePath,acpUrl,acpUser,acpPass));
	        
	}    
	
	@org.junit.Test
	public  void stopRunPlan() {
		Configurations configs = new Configurations();
    	Configuration config = null;
    	try
    	{
    	    config = configs.properties(new File("usergui.properties"));
    	}
    	catch (ConfigurationException cex)
    	{
    	    // Something went wrong
    		LogManager.getLogger().error(cex.getMessage());
    		cex.printStackTrace();
    	}
    	String acpPlanPath = config.getString("acpPlanPath");
    	String python27Path = config.getString("python27Path");
    	String acpUrl = config.getString("acpUrl");
    	String acpUser = config.getString("acpUser");
    	String acpPass = config.getString("acpPass");
    	String filter = config.getString("filter","");
		 System.out.println( AcpControl.stopRunPlan(acpUrl,acpUser,acpPass));
	}    
	
	
	// ----[lba info]You are already running the AcquireImages.js script now. When it finishes you can start your run.----
  	// ----Received. Script will be interrupted as soon as possible.----
	// ----Received, but there is no script running.----
	// ----Run started successfully. See [[System Status]] for ongoing info. @@You can close this item@@ now.----
	
	@org.junit.Test
	public  void updateSystemStatus() {
//		String resultString = AcpStatusUpdater.updateSystemStatus();
//		 System.out.println( resultString);
//		Map<String, String> resultMap = AcpStatusUpdater.acpResultToMap(resultString);
		Configurations configs = new Configurations();
    	Configuration config = null;
    	try
    	{
    	    config = configs.properties(new File("usergui.properties"));
    	}
    	catch (ConfigurationException cex)
    	{
    	    // Something went wrong
    		LogManager.getLogger().error(cex.getMessage());
    		cex.printStackTrace();
    	}
    	String acpPlanPath = config.getString("acpPlanPath");
    	String python27Path = config.getString("python27Path");
    	String acpUrl = config.getString("acpUrl");
    	String acpUser = config.getString("acpUser");
    	String acpPass = config.getString("acpPass");
    	String filter = config.getString("filter","");
		Map<String, String> resultMap = AcpStatusUpdater.getSystemStatus(acpUrl,acpUser,acpPass);
		System.out.println(resultMap.get("sm_obsStat"));
		System.out.println(resultMap.get("sm_obsStat"));
		System.out.println(resultMap.get("sm_plnTitle"));
		System.out.println(resultMap.get("sm_az"));
		System.out.println(resultMap.get("sm_alt"));
		try {
			System.out.println(URLDecoder.decode(resultMap.get("sm_utc"),"UTF-8"));
//			System.out.println(URLDecoder.decode(resultString,"UTF-8"));
			
			//当前指向  高度 方向
			
		} catch (UnsupportedEncodingException e) {
			//解码错误
			e.printStackTrace();
		}
	}    
//	_s('sm_obsStat','@anIn%20use');_s('sm_plnTitle','Plan%20%22test2%22');
//	_s('sm_obsStat','@anReady'); _s('sm_plnTitle','Plan');
	

}
