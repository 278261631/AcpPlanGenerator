package com.interstellarexploration.remoteobs.asputil.plangen.plantarget;

public class PlanDARK extends PlanTarget {
	
	public PlanDARK() {
		setOutString("#DARK");
	}
	
	/**
	 * 会替换文件
	 * will replace your file if exist
	 * @param filePath
	 */
	public PlanDARK(String filePath) {
		setOutString("#DARK "+filePath);
	}
}
