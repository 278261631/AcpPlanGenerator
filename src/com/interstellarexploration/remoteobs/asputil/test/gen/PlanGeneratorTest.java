package com.interstellarexploration.remoteobs.asputil.test.gen;

import static org.junit.Assert.*;

import java.io.IOException;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import org.apache.logging.log4j.LogManager;
import org.junit.Before;
import org.junit.Test;

import com.interstellarexploration.remoteobs.asputil.plangen.PlanCheckExeption;
import com.interstellarexploration.remoteobs.asputil.plangen.PlanFileContent;
import com.interstellarexploration.remoteobs.asputil.plangen.PlanGenerator;
import com.interstellarexploration.remoteobs.asputil.plangen.plantarget.NormalPlan;
import com.interstellarexploration.remoteobs.asputil.plangen.plantarget.PlanBIAS;
import com.interstellarexploration.remoteobs.asputil.plangen.plantarget.PlanDARK;
import com.interstellarexploration.remoteobs.asputil.plangen.plantarget.PlanDOMECLOSE;
import com.interstellarexploration.remoteobs.asputil.plangen.plantarget.PlanDOMEOPEN;

public class PlanGeneratorTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testDoGenerate() {
		fail("Not yet implemented");
	}

	@Test
	public void testDoGenerateStringString() {
		fail("Not yet implemented");
	}

	@Test
	public void testWriteToPlan() {
		fail("Not yet implemented");
	}

	@Test
	public void testPlanGenerate() {
		for (int i = 0; i < 20; i++) {
			Random ra=new Random();
			PlanGenerator pg=new PlanGenerator();
			String result = pg.generateBasePlan(TestUtil.random(50),ra.nextDouble(),ra.nextDouble()*20);
			
			System.out.println(result);
		}
//		assertEquals(true, true);
		
	}
	
	@Test
	public void testPlanGeneratePlanFile()  {
		
			Random ra=new Random();
		
			PlanFileContent planFile=new PlanFileContent();
			planFile.getTargetList().add(new PlanDOMEOPEN());
			planFile.getTargetList().add(new PlanDARK());
			planFile.getTargetList().add(new PlanBIAS());
			planFile.getTargetList().add(new PlanDOMECLOSE());
			NormalPlan planA=new NormalPlan(TestUtil.random(10),ra.nextDouble()*10,ra.nextDouble()*10);
			planA.setNextTar_AUTOFOCUS();
			String[] filterNames={"red","blue","green",};
			int[] count_array={1,2,3};
			int[] count_Binning={1,2,3};
			int[] countInterval={1,2,3};
			planA.setSubSequenTar_FILTER(filterNames);
			planA.setSubSequenTar_COUNT(count_array);
			planA.setSubSequenTar_BINNING(count_Binning);
			planA.setSubSequenTar_INTERVAL(countInterval);
			NormalPlan planB=new NormalPlan(TestUtil.random(10),ra.nextDouble()*10,ra.nextDouble()*10);
			planB.setSubSequenTar_FILTER(new String[]{"RED","CLEAR"});
			planB.setSubSequenTar_INTERVAL(new int []{1,2});
			planB.setSubSequenTar_COUNT(new int[]{2,3});
			planB.setSubSequenTar_BINNING(new int []{3,4});
			planFile.getTargetList().add(planA);
			planFile.getTargetList().add(planB);
			
			planFile.setPlan_sets(3);
			
			try {
				System.out.println(planFile.toOutString());
			} catch (PlanCheckExeption e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		
	}
	
	
	@Test
	public void testPlanGeneratePlanToFile()  {
		
			int loopcount=5;
			String FilePath="d:/hello/planTest_";
			
			for (int i = 0; i < loopcount; i++) {
				Random ra = new Random();
				PlanFileContent planFile = new PlanFileContent();
				planFile.getTargetList().add(new PlanDOMEOPEN());
				planFile.getTargetList().add(new PlanDARK());
				planFile.getTargetList().add(new PlanBIAS());
				planFile.getTargetList().add(new PlanDOMECLOSE());
				NormalPlan planA = new NormalPlan(TestUtil.random(10), ra.nextDouble() * 10, ra.nextDouble() * 10);
				planA.setNextTar_AUTOFOCUS();
				String[] filterNames = { "red", "blue", "green", };
				int[] count_array = { 1, 2, 3 };
				int[] count_Binning = { 1, 2, 3 };
				int[] countInterval = { 1, 2, 3 };
				planA.setSubSequenTar_FILTER(filterNames);
				planA.setSubSequenTar_COUNT(count_array);
				planA.setSubSequenTar_BINNING(count_Binning);
				planA.setSubSequenTar_INTERVAL(countInterval);
				NormalPlan planB = new NormalPlan(TestUtil.random(10), ra.nextDouble() * 10, ra.nextDouble() * 10);
				planB.setSubSequenTar_FILTER(new String[] { "RED", "CLEAR" });
				planB.setSubSequenTar_INTERVAL(new int[] { 1, 2 });
				planB.setSubSequenTar_COUNT(new int[] { 2, 3 });
				planB.setSubSequenTar_BINNING(new int[] { 3, 4 });
				planFile.getTargetList().add(planA);
				planFile.getTargetList().add(planB);
				planFile.setPlan_sets(3);
				try {
					planFile.toFile(FilePath+i);
//					System.out.println(planFile.toOutString());

				} catch (PlanCheckExeption e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
			}
		
		
	}
	
	
	@Test
	public void testPlanGeneratePlanToFile_M42()  {
		
		int loopcount=5;
		String FilePath="d:/hello/planTest_";
		
		for (int i = 0; i < loopcount; i++) {
			Random ra = new Random();
			PlanFileContent planFile = new PlanFileContent();
			NormalPlan planA = new NormalPlan("M 42", 1,new int[]{1,2},new int[]{1,2},new int[]{1,2});
			planFile.getTargetList().add(planA);
			try {
				planFile.toFile(FilePath+i);
//					System.out.println(planFile.toOutString());
				
			} catch (PlanCheckExeption e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		}
		
		
	}
	
	@Test
	public void test() {
//		Object [] count={1,2,3,4};
//		String format= "#Count {0},{1},{2},{3}";
//		List<Integer> countList=new ArrayList();
//		countList.add(1);
//		countList.add(1);
//		countList.add(1);
//		countList.add(1);
//		System.out.println( java.text.MessageFormat.format(format, countList));
//		System.out.println( java.text.MessageFormat.format(format, count));
//		
//		
//        String message = "Once upon a time ({1,date}, around about {1,time,short}), there "  
//                + "was a humble developer named Geppetto who slaved for "  
//                + "{0,number,integer} days with {2,number,percent} complete user " + "requirements.{3}{4}{5}{6} ";  
//        Object[] variables = new Object[] { new Integer(4), new Date(), new Double(0.21) };  
//        String output = MessageFormat.format(message, variables);  
//        System.out.println(output);
		
		boolean isX;
//		testBoolean(isX);
//		PropertyConfigurator.configure("log4j.property");
		LogManager.getLogger(this.getClass()).error("__");
		LogManager.getLogger(this.getClass()).debug("__");
	}
	
	public void testBoolean(boolean isX){
		if (isX) {
			System.out.println("xxx");
		}
		System.out.println("yyy");
		
		
	}
}
