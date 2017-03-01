package com.interstellarexploration.remoteobs.asputil.plangen;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.Charset;

import org.apache.commons.io.FileUtils;

public class PlanGenerator {

	public static final String NewLine = "\r\n";

	
	public String doGenerate() {

		StringBuffer sb = new StringBuffer();
		sb.append("#INTERVAL 120");
		sb.append(NewLine);
		sb.append("#FILTER Luminance");
		sb.append(NewLine);
		sb.append("M 15");
		sb.append(NewLine);
		return sb.toString();
	}

	public String doGenerate(String ra, String dec) {

		StringBuffer sb = new StringBuffer();
		sb.append("#dir GRB");
		sb.append(NewLine);
		sb.append("#binning 2");
		sb.append(NewLine);
		sb.append("#interval 40");
		sb.append(NewLine);
		sb.append("GRB-40S-1	" + ra + "	" + dec);
		sb.append(NewLine);
		sb.append("#interval 40");
		sb.append(NewLine);
		sb.append("GRB-40S-2	" + ra + "	" + dec);
		sb.append(NewLine);
		sb.append("#interval 40");
		sb.append(NewLine);
		sb.append("GRB-40S-3	" + ra + "	" + dec);
		sb.append(NewLine);
		sb.append("#interval 60");
		sb.append(NewLine);
		sb.append("GRB-60S-1	" + ra + "	" + dec);
		sb.append(NewLine);
		sb.append("#interval 60");
		sb.append(NewLine);
		sb.append("GRB-60S-2	" + ra + "	" + dec);
		sb.append(NewLine);
		sb.append("#interval 60");
		sb.append(NewLine);
		sb.append("GRB-60S-3	" + ra + "	" + dec);
		sb.append(NewLine);
		sb.append("#interval 90");
		sb.append(NewLine);
		sb.append("GRB-90S-1	" + ra + "	" + dec);
		sb.append(NewLine);
		sb.append("#interval 90");
		sb.append(NewLine);
		sb.append("GRB-90S-2	" + ra + "	" + dec);
		sb.append(NewLine);
		sb.append("#interval 90");
		sb.append(NewLine);
		sb.append("GRB-90S-3	" + ra + "	" + dec);
		sb.append(NewLine);
		sb.append("#interval 90");
		sb.append(NewLine);
		sb.append("GRB-90S-4	" + ra + "	" + dec);
		sb.append(NewLine);
		sb.append("#interval 90");
		sb.append(NewLine);
		sb.append("GRB-90S-5	" + ra + "	" + dec);
		sb.append(NewLine);
		sb.append("#interval 90");
		sb.append(NewLine);
		sb.append("GRB-90S-6	" + ra + "	" + dec);
		sb.append(NewLine);
		sb.append("#interval 90");
		sb.append(NewLine);
		sb.append("GRB-90S-7	" + ra + "	" + dec);
		sb.append(NewLine);
		sb.append("#interval 90");
		sb.append(NewLine);
		sb.append("GRB-90S-8	" + ra + "	" + dec);
		sb.append(NewLine);
		sb.append("#interval 90");
		sb.append(NewLine);
		sb.append("GRB-90S-9	" + ra + "	" + dec);
		sb.append(NewLine);
		sb.append("#interval 90");
		sb.append(NewLine);
		sb.append("GRB-90S-10	" + ra + "	" + dec);
		sb.append(NewLine);
		sb.append("#interval 90");
		sb.append(NewLine);
		sb.append("GRB-90S-11	" + ra + "	" + dec);
		sb.append(NewLine);
		sb.append("#interval 90");
		sb.append(NewLine);
		sb.append("GRB-90S-12	" + ra + "	" + dec);
		sb.append(NewLine);
		return sb.toString();
	}

	@Deprecated
	public void writeToPlan(String str, String filePath) {
		try {
			File file = new File(filePath);
			if (!file.exists())
				file.createNewFile();
			FileOutputStream out = new FileOutputStream(file, false); 
			out.write(str.getBytes("utf-8"));
			out.close();
		} catch (IOException ex) {
			System.out.println(ex.getStackTrace());
		}
	}
	
	public void writeToPlanFile(String str, String filePath) throws IOException {
		File file = new File(filePath);
		FileUtils.writeStringToFile(file, str, Charset.forName("UTF-8"), false);
	}
	
	
	
//	public static String p_tab_delimited_format="{0}\t{1}\t";
	public static String p_tab_delimited_format="{0}\t{1}\t{2}";
	public static String p_filter="";
	public static String p_binning="";
	public static String p_count="";
	public static String p_interval="";
	public static String p_repeat="";
	
	

	public String PlanStringGenerate(String targetName,Double Ra,Double Dec,
			String[] filterName, int[]Binning,int[]count,int[]interval,int repeat ,int sets ){
		String result="";
		
		
		result+=java.text.MessageFormat.format(p_tab_delimited_format, targetName,Ra,Dec);
		return result;
	}
	
	public String generateBasePlan(String targetName,Double Ra,Double Dec ){
		String result="";
		result+=java.text.MessageFormat.format(p_tab_delimited_format, targetName,Ra,Dec);
		return result;
	}
	
	public String targetName=null;
	/**
	 * 增加Plan 的Target Name  
	 * @param targetName
	 * @param Ra
	 * @param Dec
	 * @return
	 * @throws PlanCheckExeption 
	 */
	public void generateTargetName(String targetName,Double Ra,Double Dec ) throws PlanCheckExeption{
		if (targetName==null||targetName.length()==0) {
			targetName = java.text.MessageFormat.format(p_tab_delimited_format, targetName,Ra,Dec);
		}else{
			throw new PlanCheckExeption("已经有"+targetName);
		}
	}
	
	/**
	 * These affect only the next target _NT_
	 */
	
	/**
	 * See Sets, Repeats, and Filter Groups . Tells script to take the given number 
	 * of filter groups of the next target or dark/bias frame (#DARK) in a row. 
	 * #REPEAT may be combined with #SETS. 
	 * For example: #REPEAT 5
	 * @param planString
	 * @param repeat
	 * @return
	 */
	public String add_NT_Repeat(String planString ,int repeat){
		String result="";
//		result+=java.text.MessageFormat.format(p_tab_delimited_format, targetName);
		return result;
	}
	
	
	
	
	/**
	 * Forces calibration of the images for this target, even if ACP's auto-calibration 
	 * preference is turned off (it is redundant if ACP's auto-calibration is turned on).
	 *  This will not cause calibration of pointing exposures, only the final images.	
	 *  For example: #CALIBRATE
	 * @param planString		
	 * @return
	 */
	public String add_NT_CALIBRATE(String planString ){
		String result="";
		return result;
	}

	/**
	 * Combines repeated images within one filter group without aligning into a single image. 
	 * Individual images used in the stack are preserved. File names will have -STACK in place 
	 * of the repeat number. This is most useful when doing orbital tracking.
	 * For example: #STACK
	 * @param planString
	 * @return
	 */
	public String add_NT_STACK(String planString ){
		String result="";
		return result;
	}
	
	/**
	 * Combines repeated images within one filter group and aligns images into a single image. 
	 * Individual images used in the stack are preserved. File names will have STACK in place 
	 * of the repeat number. Use this for all stare-mode image sets. 
	 * The stacked image is saved in IEEE floating-point FITS format to preserve the dynamic range. 
	 * For example: #STACKALIGN
	 * @param planString
	 * @return
	 */
	public String add_NT_STACKALIGN(String planString ){
		String result="";
		return result;
	}
	
	/**
	 * See Sets, Repeats, and Filter Groups. Automatically refocus the optical system before each 
	 * filter group in the filter group for this target. In order to preserve compatibility with 
	 * the old target-per-filter plan format, this is modified if there is only one filter group. 
	 * In this case, the autofocus is done once for the target, even if #repeat is greater than one. 
	 * This requires that FocusMax 3.3.6 or later be installed and autofocus be enabled in ACP's preferences.
	 *  For example:#AUTOFOCUS
	 * @param planString
	 * @return
	 */
	public String add_NT_AUTOFOCUS(String planString ){
		String result="";
		return result;
	}

	/**
	 * Schedule a pointing update prior to the target. This will work even if auto-center is 
	 * disabled in Preferences. Thus, you can use #POINTING as a means to manually control when 
	 * pointing updates occur in a plan. For example: #POINTING
	 * @param planString
	 * @return
	 */
	public String add_NT_POINTING(String planString ){
		String result="";
		return result;
	}
	
	/**
	 * Pause for the given number of seconds before processing the next target. 
	 * For example:#WAITFOR 30
	 * @param planString
	 * @return
	 */
	public String add_NT_WAITFOR(String planString ){
		String result="";
		return result;
	}
	
	/**
	 * Pause during a specific set (see #SETS) until the given UTC date/time or (only) time. 
	 * The first parameter is the set number for the pause, the second is the date/time at 
	 * which to resume. The set number may range from 1 through the number of sets given by 
	 * the #SETS directive. If there is no #SETS directive on the plan, the set number must be 1. 
	 * If a complete date/time is given, and has passed, the directive is ignored. If only a 
	 * time is given, it will always wait until the given time even if the time (on the current date) 
	 * was just passed. See the note below. 
	 * For example:#WAITUNTIL 1, 21-Apr-2006 08:02:00 
	 * #WAITUNTIL 2, 08:32:00 
	 * The above would wait till the given date/times in sets 1 and 2. This could be used to 
	 * force a minimum interval between sets when acquiring images for asteroid hunting. The date/time 
	 * format is flexible. We use US English here, so acceptable formats for us include: 
	 * 7/3/06 08:22           07/03/2006 18:34:24        03-July-2006 06:34 PM  
	 * You can use any acceptable date/time format for your version (language) of Windows.
	 * @param planString
	 * @return
	 */
	public String add_NT_WAITUNTIL(String planString ){
		String result="";
		return result;
	}
	
	/**
	 * Pause until the target is within the observatory limits: minimum elevation, horizon, 
	 * and any tilt-up limit. If target will never meet the criteria, it Is immediately skipped.
	 *  A maximum time to wait (minutes) must be included. 
	 *  For Example: #WAITINLIMITS 60 
	 *  This will wait for the target to rise above the observatory limits for up to 60 minutes.
	 * @param planString
	 * @return
	 */
	public String add_NT_WAITINLIMITS(String planString ){
		String result="";
		return result;
	}
	
	/**
	 * Pause until the target is at or below the given air mass. If the target will never get 
	 * within the given air mass, or won't Get there within the time limit, it is skipped. 
	 * A maximum time to wait (minutes) must be included. 
	 * For example: #WAITAIRMASS 2.5, 30  
	 * This will wait until the target is at or below 2.5 air masses for up to 30 minutes.
	 * @param planString
	 * @return
	 */
	public String add_NT_WAITAIRMASS(String planString ){
		String result="";
		return result;
	}

	/**
	 * Adds a named tag to the target. This directive does not affect the image acquisition process; 
	 * it simply attaches the tag name and value to the target. You can specify as many of these as 
	 * you want (each with different names) for any target. The tag name(s) and value(s) will be 
	 * echoed to the run log, but this is most useful when you have custom actions defined for 
	 * TargetStart and TargetEnd. These custom actions are passed a Target object as a parameter. 
	 * Within the custom action, you can refer to tags by their name (as you defined them) with the 
	 * syntax Target.Tags.name. Thus, you can use tags to alter the action of TargetStart and TargetEnd 
	 * based on the tags' value(s). This is an expert feature and allows powerful custom logic to be 
	 * implemented. The syntax is #TAG name=value. There must be an '=' in the #TAG directive. 
	 * For example: #TAG type=reference star 
	 * This will attach a tag "type" with the value "reference star" to the target.
	 * @param planString
	 * @return
	 */
	public String add_NT_Tag(String planString ){
		String result="";
		return result;
	}
	
	
	/**
	 * These affect the current and all subsequent targets  _ST_
	 */
	
	/**
	 * See Sets, Repeats, and Filter Groups. Used only when specifying a filter group. 
	 * For example: #Count 5,10,5,15
	 * @param planString
	 * @return
	 */
	public String add_ST_Count(String planString ){
		String result="";
		return result;
	}
	
	/**
	 * See Sets, Repeats, and Filter Groups. Set the final target exposure interval(s) 
	 * for subsequent targets (sec.). 
	 * For example:  #INTERVAL 31.5             #INTERVAL 180,240,180,180
	 * @param planString
	 * @return
	 */
	public String add_ST_INTERVAL(String planString ){
		String result="";
		return result;
	}
	
	/**
	 * See Sets, Repeats, and Filter Groups. Required if the system has filters. Set the 
	 * filter(s) for subsequent targets. If the filter name is not recognized, an error is
	 *  logged at plan start, and the plan will not run. 
	 *  For example: #FILTER Blue        #FILTER Red,Clear,Green,Blue
	 * @param planString
	 * @return
	 */
	public String add_ST_FILTER(String planString ){
		String result="";
		return result;
	}
	
	/**
	 * See Sets, Repeats, and Filter Groups. Sets the binning factor(s) for subsequent 
	 * targets. Note that some detectors don't support arbitrary binning values. Consult 
	 * the documentation for your detector for specifics. Note: for auto-calibration, of
	 *  the binned size must be available in MaxIm's calibration groups. 
	 *  For example: #BINNING 4               #BINNING 2,1,2,2
	 * @param planString
	 * @return
	 */
	public String add_ST_BINNING(String planString ){
		String result="";
		return result;
	}
	
	/**
	 * Sets the fraction of the chip to be used for subsequent images. Legal values are 0.1 
	 * to 1.0 (full frame). For example, if the chip is 1K by 1K (1024 by 1024), a SUBFRAME 
	 * of 0.5 will result in using the center 512 by 512 pixels of the chip. Note: for 
	 * auto-calibration, images of the subframe size must be available in MaxIm's calibration groups. 
	 * For example: #SUBFRAME 0.5
	 * @param planString
	 * @return
	 */
	public String add_ST_SUBFRAME(String planString ){
		String result="";
		return result;
	}
	
	
	/**
	 * Required if the system has a rotator. If a rotator is installed and configured in ACP, 
	 * sets the position angle for subsequent images. The value of the position angle ranges 
	 * from 0 up to but not including 360 degrees. 0 Degrees is pole-up, and the angle increases 
	 * counterclockwise, that is, north toward east. The rotator will be positioned correctly 
	 * regardless of GEM meridian flip, and the guider will be adjusted accordingly as well. 
	 * For example: #POSANG 240.5
	 * @param planString
	 * @return
	 */
	public String add_ST_POSANG(String planString ){
		String result="";
		return result;
	}
	
	/**
	 * Offset each image in a repeat-set by some "small" amount. Works for both guided and unguided images. 
	 * If no parameter is given, ACP chooses a value automatically. Normally, this value will be appropriate 
	 * for achieving the noise reduction effect of dithering.
	 * If given, the parameter specifies the maximum amount in each axis of this offset in fractional pixels. 
	 * A parameter value of 0 disables dithering. Note: If guiding, the value is in guider pixels, not pixels
	 *  on the main chip! You have to make the conversion if you want to know how far on the main chip the 
	 *  dither will be. For unguided images, the distance is in main imager chip pixels. In either case, 
	 *  the random offsets are applied independently in X and Y and are always relative to the initial position.
	 *   For example: 
	 *   #DITHER        ; Automatic dithering 
	 *   #DITHER 1.5 
	 *   #DITHER 0     ; Disable dithering
	 * @param planString
	 * @return
	 */
	public String add_ST_DITHER(String planString ){
		String result="";
		return result;
	}
	
	/**
	 * Change the directory into which all subsequent images are to be stored. This can be a relative or full (with a drive letter) 
	 * directory path, with multiple levels. If relative, the folder is relative to the default image folder as configured in the 
	 * Local User tab of ACP Preferences (or for web users, their images folder). The folder, including all intermediate levels, 
	 * is created if needed. 
	 * For example: #DIR C:\Special\Comet Search\28-Sep-2003  (absolute) 
	 * #DIR Photometric Standards\Landolt  (relative) 
	 * If no folder name is given, this will switch back to the default image folder as configured in the Local User tab of ACP 
	 * Preferences (or for web users, their images folder) plus the usual date-based subfolder. 
	 * For example: #DIR          ; Restore default image folder  
	 * The file path/name customization feature may be used to change image file names and folders. This directive will override 
	 * the custom folder, and if #DIR is given without a folder name, the custom folder will be restored.
	 * @param planString
	 * @return
	 */
	public String add_ST_DIR(String planString ){
		String result="";
		return result;
	}
	
	/**
	 * Initiates orbital tracking of solar system bodies. This remains in effect until 
	 * cancelled by #TRACKOFF. Orbital tracking will not be done except for solar system
	 *  bodies, so non-solar-system targets may be intermixed without harm. Autoguiding 
	 *  will not be done if orbital tracking is active. Note that orbital tracking requires
	 *   orbital elements as the target specification (major planet targets will also be tracked). 
	 *   For example: #TRACKON
	 * @param planString
	 * @return
	 */
	public String add_ST_TRACKON(String planString ){
		String result="";
		return result;
	}
	
	/**
	 * Cancels orbital tracking. This remains in effect until re-enabled with #TRACKON. 
	 * For example:  #TRACKOFF
	 * @param planString
	 * @return
	 */
	public String add_ST_TRACKOFF(String planString ){
		String result="";
		return result;
	}
	
	
	
	/**
	 * These affect the plan as a whole      _P_
	 */
	
	/**
	 * See Sets, Repeats, and Filter Groups. Repeat the entire plan a given number of times. 
	 * The images are acquired in round-robin order. This directive may appear anywhere in the
	 *  plan. If it appears more than once, the last value is used for the plan. The default 
	 *  is a single set. 
	 *  For example: #SETS 3
	 * @param planString
	 * @return
	 */
	public String add_P_SETS(String planString ){
		String result="";
		return result;
	}
	
	/**
	 * Turns on periodic autofocus. The interval is given in minutes. If an #AUTOFOCUS directive 
	 * is seen, it overrides a scheduled autofocus, and the time to the next autofocus is reset 
	 * to the interval. This directive may appear anywhere in the plan, and the value given in the
	 *  last appearance will be used for the entire plan. If you want an initial autofocus at plan
	 *   start, include a separate #AUTOFOCUS for the first target. 
	 *   For example, to do an autofocus every 30 minutes: 
	 *   #AFINTERVAL 30
	 * @param planString
	 * @return
	 */
	public String add_P_AFINTERVAL(String planString ){
		String result="";
		return result;
	}
	
	
	/**
	 * The plan starts by acquiring a series of automatic sky flats at dusk via the AutoFlat.vbs 
	 * script (which is run under control of AcquireImages.js). See #DAWNFLATS below, and Using 
	 * Automatic Sky Flats.
	 * If no argument is supplied, there must be a default flat plan named defaultduskflat.txt or just
	 * defaultflat.txt in the Local User's default plans folder or AcquireImages will not try to start 
	 * AutoFlat. This avoids AutoFlat stalling waiting for flat plan input. If an argument is supplied 
	 * it can be either a full path to a flat plan, or just a flat plan file name. If just the flat plan 
	 * file name is given, it is assumed to be in your default Plans folder. 
	 * For example: 
	 *  #DUSKFLATS        ;Need standard flat plan defaultflat.txt in user's default plans folder
	 *  #DUSKFLATS 20060122-dusk-flats.txt     ; In user's default plans folder
	 *  #DUSKFLATS C:\MasterCalibration\LRGB-Standard-Flats.txt
	 * @param planString
	 * @return
	 */
	public String add_P_DUSKFLATS(String planString ){
		String result="";
		return result;
	}
	
	
	/**
	 * The minimum amount of time that a set is allowed to take. This can be used to limit the number
	 *  of sets per unit time. 
	 *  For example: #MINSETTIME 00:05 
	 *  will tell ACP to wait until at least 5 minutes has elapsed before starting the next set.
	 * @param planString
	 * @return
	 */
	public String add_P_MINSETTIME(String planString ){
		String result="";
		return result;
	}
	
	
	/**
	 * Set a "quitting time" at which the plan will stop acquiring images. The quitting date/time is
	 *  in UTC, and is interpreted the same as for #WAITUNTIL. If you specify #DAWNFLATS, #CHAIN, 
	 *  or #CHAINSCRIPT, these actions will still occur after the plan ends. 
	 *  For example: #QUITAT 7/1/01 08:22 
	 *  If the plan completes before the quit date/time is reached, it ends as usual. If only 
	 *  a time is given, it will always wait until the given time, even if it was just passed 
	 *  (it will wait till it is that time again).
	 * @param planString
	 * @return
	 */
	public String add_P_QUITAT(String planString ){
		String result="";
		return result;
	}
	
	
	/**
	 * Same as #QUITAT, except the scope is parked and the camera is shut down at the quitting time,
	 *  or at normal exit. The shutdown time is in UTC, and is interpreted the same as for #WAITUNTIL.
	 *   For example: 
	 *   #SHUTDOWNAT 7/1/06 08:22 
	 *  If the plan completes before the shutdown date/time is reached, it acts as though a #SHUTDOWN
	 *  directive was given instead. If only a time is given, it will always wait until the given time,
	 *  even if it was just passed.
	 * @param planString
	 * @return
	 */
	public String add_P_SHUTDOWNAT(String planString ){
		String result="";
		return result;
	}
	
	
	/**
	 *At the end of the run, parks the scope and shuts down the camera and cooler. If dome control 
	 *is active, and if the "Automatically park or home and close AFTER the scope is parked" option
	 * is set, then the dome will be parked or homed and the shutter or roll-off roof will be closed.
	 *  This may be used with #DAWNFLATS, and shutdown will occur after dawn flats have been taken.
	 *   For example: #SHUTDOWN 
	 * @param planString
	 * @return
	 */
	public String add_P_SHUTDOWN(String planString ){
		String result="";
		return result;
	}
	
	/**
	 * The starting set number used in naming image files. Do not include this in your plans, it is
	 *  automatically inserted in all plans by AcquireImages.js. Each time the plan runs to completion,
	 *   this number is incremented by the number of sets specified in #SETS or by 1. Its main use is 
	 *   to prevent overwriting of images when the same plan is run multiple times. 
	 *   For example: #STARTSETNUM 6
	 * @param planString
	 * @return
	 */
	public String add_P_STARTSETNUM(String planString ){
		String result="";
		return result;
	}
	
	/**
	 * The number of sets, targets in the current set, repeats in the current target, filter groups in 
	 * the current repeat, and images in the current filter group, that have been completed. Do not 
	 * include this in your plans, it is automatically inserted in all plans by AcquireImages.js each 
	 * time a target is completed, then removed if and when the plan runs to completion (at which 
	 * time #STARTSETNUM is adjusted as described above). Its main use is to allow an interrupted plan 
	 * to resume at the point where the interruption occurred. 
	 * For example: #COMPLETIONSTATE 2,4,1,3,1
	 * @param planString
	 * @return
	 */
	public String add_P_COMPLETIONSTATE(String planString ){
		String result="";
		return result;
	}
	
	
	
	/**
	 * These act like targets   _LT_
	 */
	
	/**
	 * Acquire a dark or bias frame using the current target exposure interval. If you set #INTERVAL to 0 
	 * before using #DARK, ACP will acquire a bias frame, and the file naming will be adjusted. It is 
	 * recommended, however, to use the #BIAS directive described below. You can use the #REPEAT directive 
	 * to acquire multiple darks or biases. Multiple darks/biases will be sequence numbered as well as 
	 * carrying the current #SET number, similar to file naming for light images (except no filter name 
	 * is included of course). 
	 * For example: #DARK 
	 * results in one or more files of the form Dark-Snnn-Rnnn.fts, or if the preceding #INTERVAL was 0, Bias-Snnn-Rnnn.fts. 
	 * An optional complete file path and name may be given, in which case the dark or bias will be created in the given 
	 * folder with the exact given name. Dark vs bias name changing and sequencing are not done. Any existing file with 
	 * that name will be replaced. 
	 * For example: #DARK D:\MyCalibration\2006012\Dark-Bin2.fts
	 * @param planString
	 * @return
	 */
	public String add_LT_DARK(String planString ){
		String result="";
		return result;
	}
	
	/**
	 * Acquire a bias frame using the current target exposure interval. You can use the #REPEAT directive to acquire 
	 * multiple biases. Multiple biases will be sequence numbered as well as carrying the current #SET number, similar 
	 * to file naming for light images (except no filter name is included of course). 
	 * For example: #BIAS 
	 * results in one or more files of the form BIAS-Snnn-Rnnn.fts.An optional complete file path and name may be given, 
	 * in which case the bias will be created in the given folder with the exact given name. Any existing file with that 
	 * name will be replaced. 
	 * For example: #BIAS D:\MyCalibration\2006012\Bias-Bin2.fts
	 * @param planString
	 * @return
	 */
	public String add_LT_BIAS(String planString ){
		String result="";
		return result;
	}
	
	/**
	 * Acquire an image at the current telescope location. No pointing updates or slews will be done. This is actually 
	 * a type of target, so don't include a target line. Include an object name. 
	 * For example: #MANUAL MyImage 
	 * If you don't include an object name, the current date/Time will be used. 
	 * For example: #MANUAL 
	 * results in an image file name of Manual-dd-mm-yyyy@hhmmss-Snnn-Rnnn-filter.fts
	 * @param planString
	 * @return
	 */
	public String add_LT_MANUAL(String planString ){
		String result="";
		return result;
	}
	
	/**
	 * If needed, turns on the imager's cooler and waits for 5 seconds. In any case, the imager's temperature setpoint 
	 * is changed to the given temperature (deg. C). After the change, #chill waits for up to 10 minutes for the cooler 
	 * to reach a temperature within 5 degrees of the setpoint. This is actually a type of target, so you can wait before 
	 * it, have the imager cooled, then wait again so that imaging starts later. 
	 * For example: #CHILL -35.0
	 * @param planString
	 * @return
	 */
	public String add_LT_CHILL(String planString ){
		String result="";
		return result;
	}
	
	/**
	 * Opens the shutter or roll-off roof, and waits until the shutter or roof is actually open. Effective only 
	 * during the first or only set-loop of the plan. This is actually a type of target, so you can wait before 
	 * it, have the shutter or roof opened, then wait again so that imaging starts later. 
	 * For example: #DOMEOPEN
	 * @param planString
	 * @return
	 */
	public String add_LT_DOMEOPEN(String planString ){
		String result="";
		return result;
	}
	
	/**
	 * Closes the shutter or roll-off roof, and waits until the shutter or roof is actually closed. Effective 
	 * only during the last or only set-loop of the plan. 
	 * For example: #DOMECLOSE
	 * @param planString
	 * @return
	 */
	public String add_LT_DOMECLOSE(String planString ){
		String result="";
		return result;
	}
	
	/**
	 * These terminate the plan (last or only set) _TerP_
	 */
	
	
	/**
	 * When encountered during the last (or only) set, immediately stops reading image acquisition lines from 
	 * the current plan file, queues a new run of AcquireImages.js with the new plan, then exits. A chained-to 
	 * plan is thus run in a separate invocation of AcquireImages.js, and starts with conditions identical to 
	 * those when the same plan is run directly. Use this to chain together plans, each of which might take 
	 * several sets of images, then wait for a while, then run the new plan which would also take several sets 
	 * of images. 
	 * For example: #CHAIN C:\Program Files\ACP\Plans\LateNight.txt 
	 * or if you just specify a file name, the plan is assumed to be in the same folder as the plan being chained-from. 
	 * For example: #CHAIN LateNight.txt    ; In current plan's folder
	 * @param planString
	 * @return
	 */
	public String add_TerP_CHAIN(String planString ){
		String result="";
		return result;
	}
	
	/**
	 * When encountered during the last (or only) set, immediately stops reading image acquisition lines from 
	 * the current observing plan file, terminates AcquireImages.js, and starts ACP's automatic sky-flat script 
	 * AutoFlat.vbs. If AcquireImages fails or is aborted, the auto-flats will not occur. See #DUSKFLATS above, 
	 * and Using Automatic Sky Flats. 
	 * If no argument is supplied, there must be a default flat plan named defaultdawnflat.txt or just defaultflat.txt 
	 * in the Local User's default plans folder or AcquireImages will not try to start AutoFlat. This avoids AutoFlat 
	 * stalling waiting for flat plan input. If an argument is supplied it can be either a full path to a flat plan, 
	 * or just a flat plan file name. If just the flat plan file name is given, it is assumed to be in your default 
	 * Plans folder. For example: 
	 * #DAWNFLATS        ;Need standard flat plan defaultflat.txt in user's default plans folder 
	 * #DAWNFLATS 20060122-dawn-flats.txt     ; In user's default plans folder  
	 * #DAWNFLATS C:\MasterCalibration\LRGB-Standard-Flats.txt
	 * @param planString
	 * @return
	 */
	public String add_TerP_DAWNFLATS(String planString ){
		String result="";
		return result;
	}
	
	/**
	 * When encountered during the last (or only) set, immediately stops reading image acquisition lines from the 
	 * current plan file, terminates AcquireImages.js, and starts the given ACP script. If AcquireImages fails or 
	 * is aborted, the chain will not occur. 
	 * The argument is either the full path/name or just the file name only of the script to be chained-to. If only the 
	 * script file name is given, it is assumed to be in the ACP scripts folder. 
	 * For example: 
	 * #CHAINSCRIPT C:\Program Files\ACP Obs Control\Scripts\Cleanup.vbs 
	 * #CHAINSCRIPT Cleanup.vbs    ; In ACP script folder
	 * @param planString
	 * @return
	 */
	public String add_TerP_CHAINSCRIPT(String planString ){
		String result="";
		return result;
	}
	
}
