package com.interstellarexploration.remoteobs.asputil.plangen.plantarget;

public class PlanBIAS extends PlanTarget {
	
	public PlanBIAS() {
		setOutString("#BIAS");
	}
	
	/**
	 * 会替换文件
	 * will replace your file if exist
	 * @param filePath
	 */
	public PlanBIAS(String filePath) {
		setOutString("#BIAS "+filePath);
	}
}
