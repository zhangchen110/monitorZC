package com.flyusoft.apps.jointoil.action;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.flyusoft.apps.jointoil.entity.Compressor;
import com.flyusoft.apps.jointoil.entity.CompressorMD;
import com.flyusoft.apps.jointoil.entity.FiveBoosterCompressor;
import com.flyusoft.apps.jointoil.entity.FiveCompressorAllElements;
import com.flyusoft.apps.jointoil.entity.FiveScrewMachine;
import com.flyusoft.apps.jointoil.entity.MachineRoom;
import com.flyusoft.apps.jointoil.entity.ThreeBoosterCompressor;
import com.flyusoft.apps.jointoil.entity.ThreeCompressorAllElements;
import com.flyusoft.apps.jointoil.entity.ThreeScrewMachine;
import com.flyusoft.apps.jointoil.entity.TwoBoosterCompressor;
import com.flyusoft.apps.jointoil.entity.TwoCompressorAllElements;
import com.flyusoft.apps.jointoil.entity.TwoScrewMachine;
import com.flyusoft.apps.jointoil.service.FiveBoosterCompressorService;
import com.flyusoft.apps.jointoil.service.FiveScrewMachineService;
import com.flyusoft.apps.jointoil.service.FourIntegratedMachineService;
import com.flyusoft.apps.jointoil.service.OneIntegratedMachineService;
import com.flyusoft.apps.jointoil.service.ThreeBoosterCompressorService;
import com.flyusoft.apps.jointoil.service.ThreeScrewMachineService;
import com.flyusoft.apps.jointoil.service.TwoBoosterCompressorService;
import com.flyusoft.apps.jointoil.service.TwoScrewMachineService;
import com.flyusoft.apps.jointoil.util.JointOilInitentity;
import com.flyusoft.common.utils.web.struts2.Struts2Utils;
import com.opensymphony.xwork2.ActionSupport;

/**
 * 压缩机组运行记录
 * 
 * @author Administrator
 * 
 */
@Controller
@Scope("prototype")
public class CompressorRecordAction extends ActionSupport {

	private static final long serialVersionUID = -4093746197362425031L;
	private String roomNumber   = "";// 机房id MR1
	private String compressorNo = "";// 压缩机编号，准备传J1-Y1:J1-L1
	private String reporttime   = "";// 查询信息日期
	
	private List<MachineRoom> machineRoomList = new ArrayList();// 存放机房编号

	private Map<String,String>      compressorIndex = new HashMap();// 存放压缩机指标

	private List<? extends CompressorMD> messageOne = new ArrayList();// 
	private List<? extends CompressorMD> messageTwo = new ArrayList();// 
	private List<? extends CompressorMD> messageThree = new ArrayList();// 

	
	private String htmls="";//  存储html代码
	private String options="";//  存储ajax产生的<option>代码
	private String titleNO="";//  存储ajax产生的<option>代码
	
	private DateFormat fd = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	@Autowired
	private OneIntegratedMachineService oneIntegratedMachineService;
	@Autowired
	private TwoBoosterCompressorService twoBoosterCompressorService;
	@Autowired
	private TwoScrewMachineService twoScrewMachineService;
	@Autowired
	private ThreeBoosterCompressorService ThreeBoosterCompressorService;
	@Autowired
	private ThreeScrewMachineService threeScrewMachineService;
	@Autowired
	private FourIntegratedMachineService fourIntegratedMachineService;
	@Autowired
	private FiveBoosterCompressorService fiveBoosterCompressorService;
	@Autowired
	private FiveScrewMachineService fiveScrewMachineService;

	/**
	 * 
	 * 查询显示机房 通过ajax 显示机器号 提交 机房 机号 日期
	 * 
	 * 
	 * 进入的时候穿 参数
	 * 
	 * 注意SET方法
	 */
	public String execute() {
		// 如果第一次进来 roomNumber为空 查询第一个机房的信息
		JointOilInitentity jointOilInitentity = JointOilInitentity
				.getInstance();
		machineRoomList = jointOilInitentity.getMachineRoomList();// 机房list
		for (MachineRoom machineRoom : machineRoomList) {
			compressorIndex.put(machineRoom.getRoomNo(),machineRoom.getRoomName());
			List<Compressor> compressorList = machineRoom.getCompressors();
			for (Compressor compressor : compressorList) {
				compressorIndex.put(compressor.getCompressorCode(),compressor.getCompressorName());
				}
		}
		if ("".equals(roomNumber)) {
			return "SUCCESS";
		}
	
		
		String searchDate = reporttime.trim() + " 08:01:00";//具体日期
		Date dtime = null;
		try {
			dtime = fd.parse(searchDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		String[] com = compressorNo.split(":");
		String com0=com[0];
		if(com.length==1){
			titleNO=compressorIndex.get(com[0]);
		}else if(com.length==2){
			titleNO = compressorIndex.get(com[1])  +"    "+ compressorIndex.get(com[0]);
		}
		for (int i = 0; i < machineRoomList.size(); i++) {
			if (machineRoomList.get(i).getRoomNo().equals(roomNumber)) {// 如果找到机房 MR5
				
					if (com0.substring(0, 2).equals("J1")) {// 1机房
						messageOne = oneIntegratedMachineService
								.getDataByCompressor(com0, dtime);
					}
					if (com0.substring(0, 2).equals("J2")) {// 2机房
						messageOne = twoBoosterCompressorService
								.getDataByCompressor(com0, dtime);
						messageTwo = twoScrewMachineService
								.getDataByCompressor(com[1], dtime);
						messageThree=allElements("J2",messageOne,messageTwo);
					}
					if (com0.substring(0, 2).equals("J3")) {// 3机房
						messageOne = ThreeBoosterCompressorService
								.getDataByCompressor(com0, dtime);
						messageTwo = threeScrewMachineService
								.getDataByCompressor(com[1], dtime);
						messageThree=allElements("J3",messageOne,messageTwo);
					}
					if (com0.substring(0, 2).equals("J4")) {// 4机房
						messageOne = fourIntegratedMachineService
								.getDataByCompressor(com0, dtime);
					}
					if (com0.substring(0, 2).equals("J5")) {// 5机房
						messageOne = fiveBoosterCompressorService
								.getDataByCompressor(com0, dtime);
						messageTwo = fiveScrewMachineService
								.getDataByCompressor(com[1], dtime);
						messageThree=allElements("J5",messageOne,messageTwo);
					}
				 
			}
		}
		return "SUCCESS";
	}
	public List<? extends CompressorMD> allElements(String string, List<? extends CompressorMD> messageOne, List<? extends CompressorMD> messageTwo ){
		List  elements=new ArrayList();
		if(string.equals("J2")){
			for (int i = 0; i <=23; i++) {
				TwoCompressorAllElements twoCom = new TwoCompressorAllElements();
				TwoScrewMachine       twoScr=(TwoScrewMachine) messageTwo.get(i);
				twoCom.setCompressorCode(twoScr.getCompressorCode());
				twoCom.setExhaustPressure(twoScr.getExhaustPressure());
				twoCom.setOilPressure(twoScr.getOilPressure());
				twoCom.setTime(twoScr.getTime());
				
				TwoBoosterCompressor  twoBoo= (TwoBoosterCompressor) messageOne.get(i);
				twoCom.setCompressorCode_ya(twoBoo.getCompressorCode());
				twoCom.setFirstPistonPressure_ya(twoBoo.getFirstPistonPressure());
				twoCom.setFirstPistonTemperature_ya(twoBoo.getFirstPistonTemperature());
				twoCom.setInletPressure_ya(twoBoo.getInletPressure());
				twoCom.setOilPressure_ya(twoBoo.getOilPressure());
				twoCom.setOilTemperature_ya(twoBoo.getOilTemperature());
				twoCom.setSecondPistonPressure_ya(twoBoo.getSecondPistonPressure());
				twoCom.setSecondPistonTemperature_ya(twoBoo.getSecondPistonTemperature());
				twoCom.setThirdPistonPressure_ya(twoBoo.getThirdPistonPressure());
				twoCom.setThirdPistonTemperature_ya(twoBoo.getThirdPistonTemperature());
				twoCom.setTime_ya(twoBoo.getTime());
				elements.add(twoCom);
			}
		}
		if(string.equals("J3")){
			
			for (int i = 0; i <=23; i++) {
			ThreeCompressorAllElements threeCom = new ThreeCompressorAllElements();
			ThreeScrewMachine       threeScr=(ThreeScrewMachine) messageTwo.get(i);
			ThreeBoosterCompressor  threeBoo= (ThreeBoosterCompressor) messageOne.get(i);
			
			threeCom.setCompressorCode(threeScr.getCompressorCode());
			threeCom.setExhaustPressure(threeScr.getExhaustPressure());
			threeCom.setExhaustTemperature(threeScr.getExhaustTemperature());
			threeCom.setOilPressure(threeScr.getOilPressure());
			threeCom.setOilTemperature(threeScr.getOilTemperature());
			threeCom.setTime(threeScr.getTime());
			
			
			threeCom.setCompressorCode_ya(threeBoo.getCompressorCode());
			threeCom.setFirstPistonPressure_ya(threeBoo.getFirstPistonPressure());
			threeCom.setFirstPistonTemperature_ya(threeBoo.getFirstPistonTemperature());
			threeCom.setOilPressure_ya(threeBoo.getOilPressure());
			threeCom.setOilTemperature_ya(threeBoo.getOilTemperature());
			threeCom.setSecondPistonPressure_ya(threeBoo.getSecondPistonPressure());
			threeCom.setSecondPistonTemperature_ya(threeBoo.getSecondPistonTemperature());
			threeCom.setTime_ya(threeBoo.getTime());
			elements.add(threeCom);
			}
		}
		if(string.equals("J5")){
			for (int i = 0; i <=23; i++) {
				FiveCompressorAllElements fiveCom = new FiveCompressorAllElements();
				FiveScrewMachine       fiveScr=(FiveScrewMachine) messageTwo.get(i);
				FiveBoosterCompressor  fiveBoo= (FiveBoosterCompressor) messageOne.get(i);
			
				fiveCom.setBearingTemperature(fiveScr.getBearingTemperature());
				fiveCom.setCompressorCode(fiveScr.getCompressorCode());
				
				fiveCom.setTime(fiveScr.getTime());
				
				//如果增加字段就要在这地方增加值
				fiveCom.setCompressorCode_ya(fiveBoo.getCompressorCode());
				fiveCom.setFirstExhaustTemperature_ya(fiveBoo.getFirstExhaustTemperature());
				fiveCom.setFirstPistonPressure_ya(fiveBoo.getFirstPistonPressure());
				fiveCom.setOilPressure_ya(fiveBoo.getOilPressure());
				fiveCom.setOilTemperature_ya(fiveBoo.getOilTemperature());
				fiveCom.setSecondExhaustTemperature_ya(fiveBoo.getSecondExhaustTemperature());
				fiveCom.setSecondInletTemperature_ya(fiveBoo.getSecondInletTemperature());
				fiveCom.setSecondPistonPressure_ya(fiveBoo.getSecondPistonPressure());
				fiveCom.setTime_ya(fiveBoo.getTime());
				fiveCom.setInletPressure(fiveBoo.getInletPressure());
				fiveCom.setInletTemperature(fiveBoo.getInletTemperature());
				fiveCom.setOutScrewTemperature1(fiveScr.getOutScrewTemperature1());
				fiveCom.setOutScrewTemperature2(fiveScr.getOutScrewTemperature2());
				elements.add(fiveCom);
			}
 		}
		 return elements;
	}
	
	public String ajaxSearch() {
		String str="";
		// 从ajax进来 ，如果一个为空，则所有为空
		
		JointOilInitentity jointOilInitentity = JointOilInitentity
				.getInstance();
		for (MachineRoom machineRoom : jointOilInitentity.getMachineRoomList()) {
			if (machineRoom.getRoomNo().equals(roomNumber)) {// 如果机房相同 ，在此机房中选择一个压缩机
				if (roomNumber.equals("MR2")
						|| roomNumber.equals("MR3")
						|| roomNumber.equals("MR5")) {// 如果235 为
																// 螺杆机 和 增压机
					List<Compressor> compressorList = machineRoom
							.getCompressors();// 得到压缩机集合
					for (Compressor compressor : compressorList) {// 取出
																	// 压缩机实体
						String comSize = compressor.getCompressorCode();
						// comSize=comSize.substring(comSize.length()-1);
						for (Compressor compressor_1 : compressorList) {// 再进行一次截取
							String comSize_1 = compressor_1.getCompressorCode();
							// comSize_1=comSize_1.substring(comSize_1.length()-1);
							if ((!comSize_1.equals(comSize))
									&& comSize_1.substring(
											comSize_1.length() - 1)
											.equals(comSize.substring(comSize
													.length() - 1))) {// 如果他们最后一个值相同
																		// ,（但不能是自己）则进行存储
								String inputName = compressor.getCompressorName()
										+" 和 "+ compressor_1.getCompressorName();// 显示压缩机
								String inputValue = compressor
										.getCompressorCode()
										+ ":"
										+ compressor_1.getCompressorCode();// 压缩机CODE
								compressor.getCompressorName();
								if(compressor.getCompressorCode().substring(3, 4).equals("Y")){//证明是压缩机
									str=str+"<option value="+inputValue+">"+inputName+"</option>";
								}
							}
						}
					}// 里层for
				} else {// 一体机
					if (machineRoom.getRoomNo().equals(roomNumber)) {// 如果机房相同
																// ，在此机房中选择一个压缩机
						List<Compressor> compressorList = machineRoom
								.getCompressors();// 得到压缩机集合
						for (Compressor compressor : compressorList) {// 取出
																		// 压缩机实体
							String inputName = compressor.getCompressorName();// 显示压缩机
							String inputValue = compressor.getCompressorCode()
									+ ":";// 压缩机CODE
							str=str+"<option value="+inputValue+">"+inputName+"</option>";

						}// 里层for
					}// 都是自己机房中的信息
				}
			}// 进来的都是同一个机房的
		}// 外层for over
		Struts2Utils.renderText(str);
		return null;
	}
	
	public String getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(String roomNumber) {
		this.roomNumber = roomNumber;
	}

	public String getCompressorNo() {
		return compressorNo;
	}

	public void setCompressorNo(String compressorNo) {
		this.compressorNo = compressorNo;
	}

	public String getReporttime() {
		return reporttime;
	}

	public void setReporttime(String reporttime) {
		this.reporttime = reporttime;
	}

	public List<MachineRoom> getMachineRoomList() {
		return machineRoomList;
	}

	public void setMachineRoomList(List<MachineRoom> machineRoomList) {
		this.machineRoomList = machineRoomList;
	}


	public List<? extends CompressorMD> getMessageOne() {
		return messageOne;
	}

	public void setMessageOne(List<? extends CompressorMD> messageOne) {
		this.messageOne = messageOne;
	}

	public List<? extends CompressorMD> getMessageTwo() {
		return messageTwo;
	}

	public void setMessageTwo(List<? extends CompressorMD> messageTwo) {
		this.messageTwo = messageTwo;
	}
 
	public String getHtmls() {
		return htmls;
	}

	public void setHtmls(String htmls) {
		this.htmls = htmls;
	}
	public String getOptions() {
		return options;
	}
	public void setOptions(String options) {
		if(compressorNo!=""||"".equals(compressorNo)){
			options=options.replaceAll("selected=\"selected\"", "");
			options = options.replaceFirst("value=\""+compressorNo+"\"", "value=\""+compressorNo+"\"  selected");
		}
		this.options = options;
	}
	public List<? extends CompressorMD> getMessageThree() {
		return messageThree;
	}
	public void setMessageThree(List<? extends CompressorMD> messageThree) {
		this.messageThree = messageThree;
	}
	public Map<String, String> getCompressorIndex() {
		return compressorIndex;
	}
	public void setCompressorIndex(Map<String, String> compressorIndex) {
		this.compressorIndex = compressorIndex;
	}
	public DateFormat getFd() {
		return fd;
	}
	public void setFd(DateFormat fd) {
		this.fd = fd;
	}
	public OneIntegratedMachineService getOneIntegratedMachineService() {
		return oneIntegratedMachineService;
	}
	public void setOneIntegratedMachineService(
			OneIntegratedMachineService oneIntegratedMachineService) {
		this.oneIntegratedMachineService = oneIntegratedMachineService;
	}
	public TwoBoosterCompressorService getTwoBoosterCompressorService() {
		return twoBoosterCompressorService;
	}
	public void setTwoBoosterCompressorService(
			TwoBoosterCompressorService twoBoosterCompressorService) {
		this.twoBoosterCompressorService = twoBoosterCompressorService; 
	}
	public TwoScrewMachineService getTwoScrewMachineService() {
		return twoScrewMachineService;
	}
	public void setTwoScrewMachineService(
			TwoScrewMachineService twoScrewMachineService) {
		this.twoScrewMachineService = twoScrewMachineService;
	}
	public ThreeBoosterCompressorService getThreeBoosterCompressorService() {
		return ThreeBoosterCompressorService;
	}
	public void setThreeBoosterCompressorService(
			ThreeBoosterCompressorService threeBoosterCompressorService) {
		ThreeBoosterCompressorService = threeBoosterCompressorService;
	}
	public ThreeScrewMachineService getThreeScrewMachineService() {
		return threeScrewMachineService;
	}
	public void setThreeScrewMachineService(
			ThreeScrewMachineService threeScrewMachineService) {
		this.threeScrewMachineService = threeScrewMachineService;
	}
	public FourIntegratedMachineService getFourIntegratedMachineService() {
		return fourIntegratedMachineService;
	}
	public void setFourIntegratedMachineService(
			FourIntegratedMachineService fourIntegratedMachineService) {
		this.fourIntegratedMachineService = fourIntegratedMachineService;
	}
	public FiveBoosterCompressorService getFiveBoosterCompressorService() {
		return fiveBoosterCompressorService;
	}
	public void setFiveBoosterCompressorService(
			FiveBoosterCompressorService fiveBoosterCompressorService) {
		this.fiveBoosterCompressorService = fiveBoosterCompressorService;
	}
	public FiveScrewMachineService getFiveScrewMachineService() {
		return fiveScrewMachineService;
	}
	public void setFiveScrewMachineService(
			FiveScrewMachineService fiveScrewMachineService) {
		this.fiveScrewMachineService = fiveScrewMachineService;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public String getTitleNO() {
		return titleNO;
	}
	public void setTitleNO(String titleNO) {
		this.titleNO = titleNO;
	}
	
}
