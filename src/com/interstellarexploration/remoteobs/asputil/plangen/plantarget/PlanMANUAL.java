package com.interstellarexploration.remoteobs.asputil.plangen.plantarget;

public class PlanMANUAL extends PlanTarget {
	
	public PlanMANUAL() {
		setOutString("#MANUAL");
	}
	
	/**
	 * 会替换文件
	 * will replace your file if exist
	 * @param filePath
	 */
	public PlanMANUAL(String filePath) {
		setOutString("#MANUAL "+filePath);
	}
}
