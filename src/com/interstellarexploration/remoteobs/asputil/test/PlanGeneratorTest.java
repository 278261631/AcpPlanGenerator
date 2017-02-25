package com.interstellarexploration.remoteobs.asputil.test;

import static org.junit.Assert.*;

import java.util.Random;

import org.junit.Before;
import org.junit.Test;

import com.interstellarexploration.remoteobs.asputil.plangen.PlanGenerator;

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

}
