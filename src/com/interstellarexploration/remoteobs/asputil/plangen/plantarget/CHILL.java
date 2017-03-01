package com.interstellarexploration.remoteobs.asputil.plangen.plantarget;

public class CHILL extends PlanTarget {
	
	
	
	/**
	 * 
	 * @param temperature (deg. C).
	 */
	public CHILL(double temperature ) {
		setOutString("#CHILL "+temperature );
	}
}
