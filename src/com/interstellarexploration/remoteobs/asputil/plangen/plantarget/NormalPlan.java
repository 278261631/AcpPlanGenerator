package com.interstellarexploration.remoteobs.asputil.plangen.plantarget;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.interstellarexploration.remoteobs.asputil.plangen.PlanCheckExeption;
import com.interstellarexploration.remoteobs.asputil.plangen.PlanFileContent;


public class NormalPlan extends PlanTarget {
	
	public NormalPlan(String targetName, int repeat,int[]count,int [] interval,int [] binning) {
		this.targetName=targetName;
		setNextTar_REPEAT(repeat);
		setSubSequenTar_COUNT(count);
		setSubSequenTar_INTERVAL(interval);
		setSubSequenTar_BINNING(binning);

	}
	
	public NormalPlan(String targetName,double ra,double dec) {
		this.targetName=targetName+"\t"+String.valueOf(ra)+"\t"+ String.valueOf(dec);
	}
	
	private String targetName="";

	public String getSubSequenTar_COUNT() {
		return subSequenTar_COUNT;
	}



	private int [] countArray;
	private int [] countInterval;
	private String[] countFilter;
	private int [] countBinning;
	public boolean isPlanCheckPass() throws  PlanCheckExeption{
		if (countArray==null || countInterval == null 
			 || countBinning ==null){
			throw new PlanCheckExeption("需要设置 Count Interval  Binning 并且数量应该一致");
		}
		
		if (countArray.length==countInterval.length &&countInterval.length==countBinning.length ) {
			if (countFilter==null) {
			  return true;	
			}else {
				if (countArray.length==countFilter.length) {
					return true;
				}else {
					throw new PlanCheckExeption("需要设置 Count Interval  Binning Filter 并且数量应该一致");
				}
			}
			
		}else {
			throw new PlanCheckExeption("需要设置 Count Interval  Binning 并且数量应该一致");
		}
	}
	
	public void setSubSequenTar_COUNT(int [] count_array) {
		String format= "#Count ";
		for (int i=0;i<count_array.length;i++) {
			if (i!=0) {
				format+=",";
			}
			format+= count_array[i];
		}
		this.countArray=count_array;
		this.subSequenTar_COUNT = format;
	}




	public String getSubSequenTar_INTERVAL() {
		return subSequenTar_INTERVAL;
	}




	public void setSubSequenTar_INTERVAL(int[] countInterval) {
		String format= "#Interval ";
		for (int i=0;i<countInterval.length;i++) {
			if (i!=0) {
				format+=",";
			}
			format+= countInterval[i];
		}
		this.countInterval=countInterval;
		this.subSequenTar_INTERVAL = format;
	}




	public String getSubSequenTar_FILTER() {
		return subSequenTar_FILTER;
	}




	public void setSubSequenTar_FILTER(String []filterNames) {
		String format= "#Filter ";
		for (int i=0;i<filterNames.length;i++) {
			if (i!=0) {
				format+=",";
			}
			format+= filterNames[i];
		}
		this.countFilter = filterNames;
		this.subSequenTar_FILTER = format;
	}




	public String getSubSequenTar_BINNING() {
		return subSequenTar_BINNING;
	}




	public void setSubSequenTar_BINNING(int[] countBinning) {
		String format= "#Binning ";
		for (int i=0;i<countBinning.length;i++) {
			if (i!=0) {
				format+=",";
			}
			format+= countBinning[i];
		}
		this.countBinning = countBinning;
		this.subSequenTar_BINNING = format;
	}




	public String getSubSequenTar_SUBFRAME() {
		return subSequenTar_SUBFRAME;
	}




	public void setSubSequenTar_SUBFRAME(double subframe) {
		this.subSequenTar_SUBFRAME = "#SUBFRAME " + subframe;
	}




	public String getSubSequenTar_POSANG() {
		return subSequenTar_POSANG;
	}




	public void setSubSequenTar_POSANG(double posAngle) {
		this.subSequenTar_POSANG = "#POSANG " + posAngle;
	}




	public String getSubSequenTar_DITHER() {
		return subSequenTar_DITHER;
	}




	public void setSubSequenTar_DITHER(double dither , boolean isAuto) {
		if (isAuto ) {
			this.subSequenTar_DITHER = "#DITHER    " ;
		}else {
			this.subSequenTar_DITHER = "#DITHER " + dither;
		}
	}




	public String getSubSequenTar_DIR() {
		return subSequenTar_DIR;
	}




	public void setSubSequenTar_DIR(String subSequenTar_DIR) {
		this.subSequenTar_DIR = "#DIR " + subSequenTar_DIR;
	}




	public String getSubSequenTar_TRACKON() {
		return subSequenTar_TRACKON;
	}




	public void setSubSequenTar_TRACKON() {
		this.subSequenTar_TRACKON = "#TRACKON ";
	}




	public String getSubSequenTar_TRACKOFF() {
		return subSequenTar_TRACKOFF;
	}




	public void setSubSequenTar_TRACKOFF() {
		this.subSequenTar_TRACKOFF = "#TRACKOFF";
	}




	public String getNextTar_REPEAT() {
		return nextTar_REPEAT;
	}




	public void setNextTar_REPEAT(int nextTar_REPEAT) {
		this.nextTar_REPEAT ="#REPEAT " + nextTar_REPEAT;
	}




	public String getNextTar_CALIBRATE() {
		return nextTar_CALIBRATE;
	}




	public void setNextTar_CALIBRATE() {
		this.nextTar_CALIBRATE = "#CALIBRATE";
	}




	public String getNextTar_STACK() {
		return nextTar_STACK;
	}




	public void setNextTar_STACK() {
		this.nextTar_STACK = "#STACK";
	}




	public String getNextTar_STACKALIGN() {
		return nextTar_STACKALIGN;
	}




	public void setNextTar_STACKALIGN() {
		this.nextTar_STACKALIGN = "#STACKALIGN";
	}




	public String getNextTar_AUTOFOCUS() {
		return nextTar_AUTOFOCUS;
	}




	public void setNextTar_AUTOFOCUS() {
		this.nextTar_AUTOFOCUS = "#AUTOFOCUS";
	}




	public String getNextTar_POINTING() {
		return nextTar_POINTING;
	}




	public void setNextTar_POINTING() {
		this.nextTar_POINTING = "#POINTING";
	}




	public String getNextTar_WAITFOR() {
		return nextTar_WAITFOR;
	}




	public void setNextTar_WAITFOR(int nextTar_WAITFOR) {
		this.nextTar_WAITFOR = "#WAITFOR " + nextTar_WAITFOR;
	}




	public List<Date> getNextTar_WAITUNTIL() {
		return nextTar_WAITUNTIL;
	}




	public void setNextTar_WAITUNTIL(List<Date> nextTar_WAITUNTIL) {
		this.nextTar_WAITUNTIL = nextTar_WAITUNTIL;
	}




	public String getNextTar_WAITINLIMITS() {
		return nextTar_WAITINLIMITS;
	}




	public void setNextTar_WAITINLIMITS(int nextTar_WAITINLIMITS) {
		this.nextTar_WAITINLIMITS = "#WAITINLIMITS " + nextTar_WAITINLIMITS;
	}




	public String getNextTar_WAITZENDIST() {
		return nextTar_WAITZENDIST;
	}




	public void setNextTar_WAITZENDIST(double deg,int waitMinutes) {
				
		this.nextTar_WAITZENDIST = "#WAITZENDIST " +deg + "," + waitMinutes ;
	}




	public String getNextTar_WAITAIRMASS() {
		return nextTar_WAITAIRMASS;
	}




	public void setNextTar_WAITAIRMASS(double airMass,int waitMinutes) {
		this.nextTar_WAITAIRMASS = "#WAITAIRMASS " + airMass + "," + waitMinutes;
	}




	public String getNextTar_TAG() {
		return nextTar_TAG;
	}



	/**
	 * #TAG type=reference star
	 * #TAG typeName=XXXX
	 * @param nextTar_TAG
	 */
	public void setNextTar_TAG(String tagName,String tagValue) {
		
		this.nextTar_TAG = "#TAG" + tagName + "=" + tagValue;
	}




	private String subSequenTar_COUNT     = "";
	private String subSequenTar_INTERVAL  = "";
	private String subSequenTar_FILTER    = "";
	private String subSequenTar_BINNING   = "";
	private String subSequenTar_SUBFRAME  = "";
	private String subSequenTar_POSANG    = "";
	private String subSequenTar_DITHER    = "";
	private String subSequenTar_DIR       = "";
	private String subSequenTar_TRACKON   = "";
	private String subSequenTar_TRACKOFF  = "";
	
	
	
	private String nextTar_REPEAT        ="";               
	private String nextTar_CALIBRATE     ="";                   
	private String nextTar_STACK         ="";               
	private String nextTar_STACKALIGN    ="";                   
	private String nextTar_AUTOFOCUS     ="";                   
	private String nextTar_POINTING      ="";                 
	private String nextTar_WAITFOR       ="";                 
	private List<Date> nextTar_WAITUNTIL     =new ArrayList<Date>();                   
	private String nextTar_WAITINLIMITS  ="";                     
	private String nextTar_WAITZENDIST   ="";                     
	private String nextTar_WAITAIRMASS   ="";                     
	private String nextTar_TAG           ="";       
	
	
	
	
	@Override
	public String toOutString() throws PlanCheckExeption{

		isPlanCheckPass();
		
		StringBuilder tarSB=new StringBuilder();
		if( subSequenTar_COUNT    .length()>0){tarSB.append(getSubSequenTar_COUNT   ()).append(PlanFileContent.NewLine);}
		if( subSequenTar_INTERVAL .length()>0){tarSB.append(getSubSequenTar_INTERVAL()).append(PlanFileContent.NewLine);}
		if( subSequenTar_FILTER   .length()>0){tarSB.append(getSubSequenTar_FILTER  ()).append(PlanFileContent.NewLine);}
		if( subSequenTar_BINNING  .length()>0){tarSB.append(getSubSequenTar_BINNING ()).append(PlanFileContent.NewLine);}
		if( subSequenTar_SUBFRAME .length()>0){tarSB.append(getSubSequenTar_SUBFRAME()).append(PlanFileContent.NewLine);}
		if( subSequenTar_POSANG   .length()>0){tarSB.append(getSubSequenTar_POSANG  ()).append(PlanFileContent.NewLine);}
		if( subSequenTar_DITHER   .length()>0){tarSB.append(getSubSequenTar_DITHER  ()).append(PlanFileContent.NewLine);}
		if( subSequenTar_DIR      .length()>0){tarSB.append(getSubSequenTar_DIR     ()).append(PlanFileContent.NewLine);}
		if( subSequenTar_TRACKON  .length()>0){tarSB.append(getSubSequenTar_TRACKON ()).append(PlanFileContent.NewLine);}
		if( subSequenTar_TRACKOFF .length()>0){tarSB.append(getSubSequenTar_TRACKOFF()).append(PlanFileContent.NewLine);}
		if( nextTar_REPEAT        .length()>0){tarSB.append(getNextTar_REPEAT       ()).append(PlanFileContent.NewLine);}
		if( nextTar_CALIBRATE     .length()>0){tarSB.append(getNextTar_CALIBRATE    ()).append(PlanFileContent.NewLine);}
		if( nextTar_STACK         .length()>0){tarSB.append(getNextTar_STACK        ()).append(PlanFileContent.NewLine);}
		if( nextTar_STACKALIGN    .length()>0){tarSB.append(getNextTar_STACKALIGN   ()).append(PlanFileContent.NewLine);}
		if( nextTar_AUTOFOCUS     .length()>0){tarSB.append(getNextTar_AUTOFOCUS    ()).append(PlanFileContent.NewLine);}
		if( nextTar_POINTING      .length()>0){tarSB.append(getNextTar_POINTING     ()).append(PlanFileContent.NewLine);}
		if( nextTar_WAITFOR       .length()>0){tarSB.append(getNextTar_WAITFOR      ()).append(PlanFileContent.NewLine);}
		
		if (nextTar_WAITUNTIL!=null && nextTar_WAITUNTIL.size()>0) { //这里时间只采用这一种格式 事实上ACP支持很多种
			java.text.SimpleDateFormat sf= new SimpleDateFormat("yyyy-mm-dd HH:MM:ss");
			for (int i = 0; i < nextTar_WAITUNTIL.size(); i++) {
				tarSB.append("#WAITUNTIL "+i+", "+ sf.format(nextTar_WAITUNTIL.get(i))).append(PlanFileContent.NewLine);;
			}
		}
		
		
		if( nextTar_WAITINLIMITS  .length()>0){tarSB.append(getNextTar_WAITINLIMITS ()).append(PlanFileContent.NewLine);}
		if( nextTar_WAITZENDIST   .length()>0){tarSB.append(getNextTar_WAITZENDIST  ()).append(PlanFileContent.NewLine);}
		if( nextTar_WAITAIRMASS   .length()>0){tarSB.append(getNextTar_WAITAIRMASS  ()).append(PlanFileContent.NewLine);}
		if( nextTar_TAG           .length()>0){tarSB.append(getNextTar_TAG          ()).append(PlanFileContent.NewLine);}

		tarSB.append(targetName).append(PlanFileContent.NewLine);
		
		return tarSB.toString();
	}
}
