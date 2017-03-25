package com.interstellarexploration.remoteobs.asputil.plangen;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;


import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;

import com.interstellarexploration.remoteobs.asputil.plangen.plantarget.PlanTarget;

public class PlanFileContent {

	public List<PlanTarget> getTargetList() {
		return targetList;
	}
	public void setTargetList(List<PlanTarget> targetList) {
		this.targetList = targetList;
	}
	public String getPlan_sets() {
		return plan_sets;
	}
	public void setPlan_sets(int plan_sets) {
		this.plan_sets = "#SETS "+ plan_sets;
	}
	public String getPlan_afinterval() {
		return plan_afinterval;
	}
	public void setPlan_afinterval(String plan_afinterval) {
		this.plan_afinterval = plan_afinterval;
	}
	public String getPlan_duskflats() {
		return plan_duskflats;
	}
	public void setPlan_duskflats(String plan_duskflats) {
		this.plan_duskflats = plan_duskflats;
	}
	public String getPlan_minsettime() {
		return plan_minsettime;
	}
	public void setPlan_minsettime(String plan_minsettime) {
		this.plan_minsettime = plan_minsettime;
	}
	public String getPlan_quitat() {
		return plan_quitat;
	}
	public void setPlan_quitat(String plan_quitat) {
		this.plan_quitat = plan_quitat;
	}
	public String getPlan_SHUTDOWNAT() {
		return plan_SHUTDOWNAT;
	}
	public void setPlan_SHUTDOWNAT(String plan_SHUTDOWNAT) {
		this.plan_SHUTDOWNAT = plan_SHUTDOWNAT;
	}
	public String getPlan_SHUTDOWN() {
		return plan_SHUTDOWN;
	}
	public void setPlan_SHUTDOWN(String plan_SHUTDOWN) {
		this.plan_SHUTDOWN = plan_SHUTDOWN;
	}
	public String getPlan_STARTSETNUM() {
		return plan_STARTSETNUM;
	}
	public void setPlan_STARTSETNUM(String plan_STARTSETNUM) {
		this.plan_STARTSETNUM = plan_STARTSETNUM;
	}
	public String getPlan_COMPLETIONSTATE() {
		return plan_COMPLETIONSTATE;
	}
	public void setPlan_COMPLETIONSTATE(String plan_COMPLETIONSTATE) {
		this.plan_COMPLETIONSTATE = plan_COMPLETIONSTATE;
	}
	private List<PlanTarget> targetList=new ArrayList<>();
	private String plan_sets="";
	private String plan_afinterval="";
	private String plan_duskflats="";
	private String plan_minsettime="";
	private String plan_quitat="";
	private String plan_SHUTDOWNAT="";
	private String plan_SHUTDOWN="";
	private String plan_STARTSETNUM="";
	private String plan_COMPLETIONSTATE="";
	
	public String getPaln_Chian() {
		return paln_Chian;
	}
	public void setPaln_Chian(String paln_Chian) {
		this.paln_Chian = paln_Chian;
	}
	public List<String> getPaln_DawnFlats() {
		return paln_DawnFlats;
	}
	public void setPaln_DawnFlats(List<String> paln_DawnFlats) {
		this.paln_DawnFlats = paln_DawnFlats;
	}
	public List<String> getPaln_ChainSript() {
		return paln_ChainSript;
	}
	public void setPaln_ChainSript(List<String> paln_ChainSript) {
		this.paln_ChainSript = paln_ChainSript;
	}

	public void setPlan_sets(String plan_sets) {
		this.plan_sets = plan_sets;
	}

	private String paln_Chian="";
	private List<String> paln_DawnFlats=new ArrayList<>();
	private List<String> paln_ChainSript=new ArrayList<>();

	public static final String NewLine = "\r\n";
	public String toOutString() throws PlanCheckExeption{
		StringBuilder resultSB=new StringBuilder();
		if(getPlan_sets()!=null && getPlan_sets().length()>0)resultSB.append(getPlan_sets()).append(NewLine);
		if(getPlan_afinterval()!=null && getPlan_afinterval().length()>0)resultSB.append(getPlan_afinterval()).append(NewLine);
		if(getPlan_duskflats()!=null && getPlan_duskflats().length()>0)resultSB.append(getPlan_duskflats()).append(NewLine);
		if(getPlan_quitat()!=null && getPlan_quitat().length()>0)resultSB.append(getPlan_quitat()).append(NewLine);
		if(getPlan_SHUTDOWNAT()!=null && getPlan_SHUTDOWNAT().length()>0)resultSB.append(getPlan_SHUTDOWNAT()).append(NewLine);
		if(getPlan_SHUTDOWN()!=null && getPlan_SHUTDOWN().length()>0)resultSB.append(getPlan_SHUTDOWN()).append(NewLine);
		if(getPlan_STARTSETNUM()!=null && getPlan_STARTSETNUM().length()>0)resultSB.append(getPlan_STARTSETNUM()).append(NewLine);
		if(getPlan_COMPLETIONSTATE()!=null && getPlan_COMPLETIONSTATE().length()>0)resultSB.append(getPlan_COMPLETIONSTATE()).append(NewLine);
		
		if (getTargetList().size()>0) {
			for (PlanTarget planTargetItem : getTargetList()) {
				resultSB.append(planTargetItem.toOutString());
			}
		}
		
		
		if (getPaln_Chian().length()>0) resultSB.append(getPaln_Chian()).append(NewLine);
		if(getPaln_DawnFlats().size()>0){
			for (String string : getPaln_DawnFlats()) {
				resultSB.append(string).append(NewLine);
			}
		}
		if(getPaln_ChainSript().size()>0){
			for (String string : getPaln_ChainSript()) {
				resultSB.append(string).append(NewLine);
			}
		}
		
		return resultSB.toString();
	}
	
	
	public void toFile(String filePath) throws IOException, PlanCheckExeption{
		if (!filePath.endsWith(".txt")) {
			filePath+=".txt";
		}
		File file = new File(filePath);
		FileUtils.writeStringToFile(file, toOutString(), Charset.forName("UTF-8"), false);
//		FileUtils.writeLines(file, lines, lineEnding);;
		
		LogManager.getLogger().debug(file.getName()+"-"+file.getPath());
//		File file = new File(filePath);
//		FileUtils.writeStringToFile(file, str, Charset.forName("UTF-8"), false);
//		return "";
	}
	
}
