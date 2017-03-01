package com.interstellarexploration.remoteobs.asputil.plangen.plantarget;

import com.interstellarexploration.remoteobs.asputil.plangen.PlanFileContent;

public class NormalPlan extends PlanTarget {
	
	public NormalPlan(String targetName) {
		this.targetName=targetName;
		
	}
	
	public NormalPlan(String targetName,double ra,double dec) {
		this.targetName=targetName+"\t"+String.valueOf(ra)+"\t"+ String.valueOf(dec);
	}
	
	private String targetName="";

	public String getSubSequenTar_COUNT() {
		return subSequenTar_COUNT;
	}




	public void setSubSequenTar_COUNT(String subSequenTar_COUNT) {
		this.subSequenTar_COUNT = subSequenTar_COUNT;
	}




	public String getSubSequenTar_INTERVAL() {
		return subSequenTar_INTERVAL;
	}




	public void setSubSequenTar_INTERVAL(String subSequenTar_INTERVAL) {
		this.subSequenTar_INTERVAL = subSequenTar_INTERVAL;
	}




	public String getSubSequenTar_FILTER() {
		return subSequenTar_FILTER;
	}




	public void setSubSequenTar_FILTER(String subSequenTar_FILTER) {
		this.subSequenTar_FILTER = subSequenTar_FILTER;
	}




	public String getSubSequenTar_BINNING() {
		return subSequenTar_BINNING;
	}




	public void setSubSequenTar_BINNING(String subSequenTar_BINNING) {
		this.subSequenTar_BINNING = subSequenTar_BINNING;
	}




	public String getSubSequenTar_SUBFRAME() {
		return subSequenTar_SUBFRAME;
	}




	public void setSubSequenTar_SUBFRAME(String subSequenTar_SUBFRAME) {
		this.subSequenTar_SUBFRAME = subSequenTar_SUBFRAME;
	}




	public String getSubSequenTar_POSANG() {
		return subSequenTar_POSANG;
	}




	public void setSubSequenTar_POSANG(String subSequenTar_POSANG) {
		this.subSequenTar_POSANG = subSequenTar_POSANG;
	}




	public String getSubSequenTar_DITHER() {
		return subSequenTar_DITHER;
	}




	public void setSubSequenTar_DITHER(String subSequenTar_DITHER) {
		this.subSequenTar_DITHER = subSequenTar_DITHER;
	}




	public String getSubSequenTar_DIR() {
		return subSequenTar_DIR;
	}




	public void setSubSequenTar_DIR(String subSequenTar_DIR) {
		this.subSequenTar_DIR = subSequenTar_DIR;
	}




	public String getSubSequenTar_TRACKON() {
		return subSequenTar_TRACKON;
	}




	public void setSubSequenTar_TRACKON(String subSequenTar_TRACKON) {
		this.subSequenTar_TRACKON = subSequenTar_TRACKON;
	}




	public String getSubSequenTar_TRACKOFF() {
		return subSequenTar_TRACKOFF;
	}




	public void setSubSequenTar_TRACKOFF(String subSequenTar_TRACKOFF) {
		this.subSequenTar_TRACKOFF = subSequenTar_TRACKOFF;
	}




	public String getNextTar_REPEAT() {
		return nextTar_REPEAT;
	}




	public void setNextTar_REPEAT(String nextTar_REPEAT) {
		this.nextTar_REPEAT = nextTar_REPEAT;
	}




	public String getNextTar_CALIBRATE() {
		return nextTar_CALIBRATE;
	}




	public void setNextTar_CALIBRATE(String nextTar_CALIBRATE) {
		this.nextTar_CALIBRATE = nextTar_CALIBRATE;
	}




	public String getNextTar_STACK() {
		return nextTar_STACK;
	}




	public void setNextTar_STACK(String nextTar_STACK) {
		this.nextTar_STACK = nextTar_STACK;
	}




	public String getNextTar_STACKALIGN() {
		return nextTar_STACKALIGN;
	}




	public void setNextTar_STACKALIGN(String nextTar_STACKALIGN) {
		this.nextTar_STACKALIGN = nextTar_STACKALIGN;
	}




	public String getNextTar_AUTOFOCUS() {
		return nextTar_AUTOFOCUS;
	}




	public void setNextTar_AUTOFOCUS(String nextTar_AUTOFOCUS) {
		this.nextTar_AUTOFOCUS = nextTar_AUTOFOCUS;
	}




	public String getNextTar_POINTING() {
		return nextTar_POINTING;
	}




	public void setNextTar_POINTING(String nextTar_POINTING) {
		this.nextTar_POINTING = nextTar_POINTING;
	}




	public String getNextTar_WAITFOR() {
		return nextTar_WAITFOR;
	}




	public void setNextTar_WAITFOR(String nextTar_WAITFOR) {
		this.nextTar_WAITFOR = nextTar_WAITFOR;
	}




	public String getNextTar_WAITUNTIL() {
		return nextTar_WAITUNTIL;
	}




	public void setNextTar_WAITUNTIL(String nextTar_WAITUNTIL) {
		this.nextTar_WAITUNTIL = nextTar_WAITUNTIL;
	}




	public String getNextTar_WAITINLIMITS() {
		return nextTar_WAITINLIMITS;
	}




	public void setNextTar_WAITINLIMITS(String nextTar_WAITINLIMITS) {
		this.nextTar_WAITINLIMITS = nextTar_WAITINLIMITS;
	}




	public String getNextTar_WAITZENDIST() {
		return nextTar_WAITZENDIST;
	}




	public void setNextTar_WAITZENDIST(String nextTar_WAITZENDIST) {
		this.nextTar_WAITZENDIST = nextTar_WAITZENDIST;
	}




	public String getNextTar_WAITAIRMASS() {
		return nextTar_WAITAIRMASS;
	}




	public void setNextTar_WAITAIRMASS(String nextTar_WAITAIRMASS) {
		this.nextTar_WAITAIRMASS = nextTar_WAITAIRMASS;
	}




	public String getNextTar_TAG() {
		return nextTar_TAG;
	}




	public void setNextTar_TAG(String nextTar_TAG) {
		this.nextTar_TAG = nextTar_TAG;
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
	private String nextTar_WAITUNTIL     ="";                   
	private String nextTar_WAITINLIMITS  ="";                     
	private String nextTar_WAITZENDIST   ="";                     
	private String nextTar_WAITAIRMASS   ="";                     
	private String nextTar_TAG           ="";       
	
	
	
	
	@Override
	public String toString(){
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
		if( nextTar_WAITUNTIL     .length()>0){tarSB.append(getNextTar_WAITUNTIL    ()).append(PlanFileContent.NewLine);}
		if( nextTar_WAITINLIMITS  .length()>0){tarSB.append(getNextTar_WAITINLIMITS ()).append(PlanFileContent.NewLine);}
		if( nextTar_WAITZENDIST   .length()>0){tarSB.append(getNextTar_WAITZENDIST  ()).append(PlanFileContent.NewLine);}
		if( nextTar_WAITAIRMASS   .length()>0){tarSB.append(getNextTar_WAITAIRMASS  ()).append(PlanFileContent.NewLine);}
		if( nextTar_TAG           .length()>0){tarSB.append(getNextTar_TAG          ()).append(PlanFileContent.NewLine);}

		tarSB.append(targetName).append(PlanFileContent.NewLine);
		
		return tarSB.toString();
	}
}
