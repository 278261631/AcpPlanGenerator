package com.interstellarexploration.remoteobs.asputil.test;

import static org.junit.Assert.*;

import java.util.Random;

import org.junit.Before;
import org.junit.Test;

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
	public void testPlanGeneratePlanFile() {
		
			Random ra=new Random();
		
			PlanFileContent planFile=new PlanFileContent();
			planFile.getTargetList().add(new PlanDOMEOPEN());
			planFile.getTargetList().add(new PlanDARK());
			planFile.getTargetList().add(new PlanBIAS());
			planFile.getTargetList().add(new PlanDOMECLOSE());
			NormalPlan planA=new NormalPlan(TestUtil.random(10),ra.nextDouble()*10,ra.nextDouble()*10);
			planA.setNextTar_AUTOFOCUS("xx");
			NormalPlan planB=new NormalPlan(TestUtil.random(10),ra.nextDouble()*10,ra.nextDouble()*10);
			planB.setSubSequenTar_INTERVAL("2");
			planFile.getTargetList().add(planA);
			planFile.getTargetList().add(planB);
			
			planFile.setPlan_sets(3);
			
			System.out.println(planFile.toString());
		
		
	}

}
