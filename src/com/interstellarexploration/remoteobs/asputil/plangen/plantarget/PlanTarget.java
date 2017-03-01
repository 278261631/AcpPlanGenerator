package com.interstellarexploration.remoteobs.asputil.plangen.plantarget;

import com.interstellarexploration.remoteobs.asputil.plangen.PlanFileContent;

public abstract class PlanTarget {
	

	private String outString;

	public String getOutString() {
		return outString;
	}

	public void setOutString(String outString) {
		this.outString = outString;
	}
	
	public String toString(){
		return outString+PlanFileContent.NewLine;
	}
	
}
