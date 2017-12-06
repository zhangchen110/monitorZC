package com.flyusoft.apps.jointoil.action;


import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.flyusoft.apps.jointoil.entity.Compressor;
import com.flyusoft.apps.jointoil.entity.FiveBoosterCompressor;
import com.flyusoft.apps.jointoil.entity.FiveScrewMachine;
import com.flyusoft.apps.jointoil.entity.FourIntegratedMachine;
import com.flyusoft.apps.jointoil.entity.MachineRoom;
import com.flyusoft.apps.jointoil.entity.OneIntegratedMachine;
import com.flyusoft.apps.jointoil.entity.ThreeBoosterCompressor;
import com.flyusoft.apps.jointoil.entity.ThreeScrewMachine;
import com.flyusoft.apps.jointoil.entity.TwoBoosterCompressor;
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
import com.flyusoft.common.orm.Page;
import com.flyusoft.common.utils.web.struts2.Struts2Utils;
import com.google.common.collect.Lists;
import com.opensymphony.xwork2.ActionSupport;

@Controller
@Scope("prototype")
public class CompressorHistoryRecordAction extends ActionSupport{
	
	private static final long serialVersionUID = 6009144230690577468L;
	
	private Compressor compressor;
	
	private JointOilInitentity jointOilInitentity=JointOilInitentity.getInstance();
	
	private List<MachineRoom> machineRoomList=Lists.newArrayList();
	
	private String options;
	
	private String roomNumber;
	
	private String starttime = "";// 定义查询历史数据 开始时间

	private String endtime = "";// 定义查询历史数据 结束时间
	
	private String compressorNo="";
	
	private Page<OneIntegratedMachine> oneIntegratedList=new Page<OneIntegratedMachine>(25);
	private Page<TwoScrewMachine> twoScrewList=new Page<TwoScrewMachine>(25);
	private Page<TwoBoosterCompressor> twoBoosterList=new Page<TwoBoosterCompressor>(25);
	private Page<ThreeScrewMachine> threeScrewList=new Page<ThreeScrewMachine>(25);
	private Page<ThreeBoosterCompressor> threeBoosterList=new Page<ThreeBoosterCompressor>(25);
	private Page<FourIntegratedMachine> fourIntegratedList=new Page<FourIntegratedMachine>(25);
	private Page<FiveScrewMachine> fiveScrewList=new Page<FiveScrewMachine>(25);
	private Page<FiveBoosterCompressor> fiveBoosterList=new Page<FiveBoosterCompressor>(25);
	@Autowired
	private OneIntegratedMachineService oneIntegratedMachineService;
	@Autowired
	private TwoScrewMachineService twoScrewMachineService;
	@Autowired
	private TwoBoosterCompressorService twoBoosterCompressorService;
	@Autowired
	private ThreeScrewMachineService threeScrewMachineService;
	@Autowired
	private ThreeBoosterCompressorService threeBoosterCompressorService;
	@Autowired
	private FourIntegratedMachineService fourIntegratedMachineService;
	@Autowired
	private FiveScrewMachineService fiveScrewMachineService;
	@Autowired
	private FiveBoosterCompressorService fiveBoosterCompressorService;
	
	
	
	public String execute()throws Exception{
		machineRoomList=jointOilInitentity.getMachineRoomList();
		if(compressorNo!=null&&!"".equals(compressorNo)){
			// 为日期添加秒
			starttime = starttime.trim() + ":00";
			endtime = endtime.trim() + ":59";

			// 将日期转化为date类型
			DateFormat f = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");// 注意前台传递过来的日期,中间空格空位应相同
			Date start_date = null;
			Date end_date = null;
			try {
				start_date = f.parse(starttime);
				end_date = f.parse(endtime);
			} catch (ParseException e) {
				System.out.println("  StatisticsHistoryAction.java  ---- DATE格式转换错误  ");
			}
			compressor=jointOilInitentity.getCompressorByCompressorCode(compressorNo);
			if(compressor!=null&&start_date!=null&&end_date!=null){
				String compressorCode=compressor.getCompressorCode();
				if (compressorCode.startsWith("J1-Y")) {
					oneIntegratedList = oneIntegratedMachineService.getOneIntegratedMsg(oneIntegratedList, compressorCode, start_date, end_date);
				} else if (compressorCode.startsWith("J2-L")) {
					twoScrewList = twoScrewMachineService.getTwoScrewMsg(twoScrewList, compressorCode, start_date, end_date);
				} else if (compressorCode.startsWith("J2-Y")) {
					twoBoosterList = twoBoosterCompressorService.getTwoBoosterMsg(twoBoosterList, compressorCode, start_date, end_date);
				} else if (compressorCode.startsWith("J3-L")) {
					threeScrewList = threeScrewMachineService.getThreeScrewMsg(threeScrewList, compressorCode, start_date, end_date);
				} else if (compressorCode.startsWith("J3-Y")) {
					threeBoosterList = threeBoosterCompressorService.getThreeBoosterMsg(threeBoosterList, compressorCode, start_date, end_date);
				} else if (compressorCode.startsWith("J4-Y")) {
					fourIntegratedList = fourIntegratedMachineService.getFourIntegratedMsg(fourIntegratedList, compressorCode, start_date, end_date);
				} else if (compressorCode.startsWith("J5-L")) {
					fiveScrewList = fiveScrewMachineService.getFiveScrewMsg(fiveScrewList, compressorCode, start_date, end_date);
				} else if (compressorCode.startsWith("J5-Y")) {
					fiveBoosterList = fiveBoosterCompressorService.getFiveBoosterMsg(fiveBoosterList, compressorCode, start_date, end_date);
				}
			}
		}
		return SUCCESS;
	}
	/**
	 * ajax查询压缩机
	 * @return
	 */
	public String searchCompressor(){
		String roomId=Struts2Utils.getParameter("roomId");
		StringBuilder sb=new StringBuilder();
		MachineRoom machineRoom=jointOilInitentity.getMachineRoomByMachineRoomId(roomId);
		if(machineRoom!=null){
			List<Compressor> compressors=machineRoom.getCompressors();
			for (Compressor compressor : compressors) {
				String inputValue=compressor.getCompressorCode();
				String inputName=compressor.getCompressorName();
				
				sb.append("<option value='"+inputValue+"'>"+inputName+"</option>");
			}
		}
		Struts2Utils.renderText(sb.toString());
		return null;
	}
	
	public Compressor getCompressor() {
		return compressor;
	}
	
	public List<MachineRoom> getMachineRoomList() {
		return machineRoomList;
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
	public String getRoomNumber() {
		return roomNumber;
	}
	public void setRoomNumber(String roomNumber) {
		this.roomNumber = roomNumber;
	}
	public String getStarttime() {
		return starttime;
	}
	public void setStarttime(String starttime) {
		this.starttime = starttime;
	}
	public String getEndtime() {
		return endtime;
	}
	public void setEndtime(String endtime) {
		this.endtime = endtime;
	}
	public String getCompressorNo() {
		return compressorNo;
	}
	public void setCompressorNo(String compressorNo) {
		this.compressorNo = compressorNo;
	}
	public Page<OneIntegratedMachine> getOneIntegratedList() {
		return oneIntegratedList;
	}
	public void setOneIntegratedList(Page<OneIntegratedMachine> oneIntegratedList) {
		this.oneIntegratedList = oneIntegratedList;
	}
	public Page<TwoScrewMachine> getTwoScrewList() {
		return twoScrewList;
	}
	public void setTwoScrewList(Page<TwoScrewMachine> twoScrewList) {
		this.twoScrewList = twoScrewList;
	}
	public Page<TwoBoosterCompressor> getTwoBoosterList() {
		return twoBoosterList;
	}
	public void setTwoBoosterList(Page<TwoBoosterCompressor> twoBoosterList) {
		this.twoBoosterList = twoBoosterList;
	}
	public Page<ThreeScrewMachine> getThreeScrewList() {
		return threeScrewList;
	}
	public void setThreeScrewList(Page<ThreeScrewMachine> threeScrewList) {
		this.threeScrewList = threeScrewList;
	}
	public Page<ThreeBoosterCompressor> getThreeBoosterList() {
		return threeBoosterList;
	}
	public void setThreeBoosterList(Page<ThreeBoosterCompressor> threeBoosterList) {
		this.threeBoosterList = threeBoosterList;
	}
	public Page<FourIntegratedMachine> getFourIntegratedList() {
		return fourIntegratedList;
	}
	public void setFourIntegratedList(Page<FourIntegratedMachine> fourIntegratedList) {
		this.fourIntegratedList = fourIntegratedList;
	}
	public Page<FiveScrewMachine> getFiveScrewList() {
		return fiveScrewList;
	}
	public void setFiveScrewList(Page<FiveScrewMachine> fiveScrewList) {
		this.fiveScrewList = fiveScrewList;
	}
	public Page<FiveBoosterCompressor> getFiveBoosterList() {
		return fiveBoosterList;
	}
	public void setFiveBoosterList(Page<FiveBoosterCompressor> fiveBoosterList) {
		this.fiveBoosterList = fiveBoosterList;
	}
	public void setCompressor(Compressor compressor) {
		this.compressor = compressor;
	}
	
	
	
	
}
