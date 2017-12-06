package com.flyusoft.apps.jointoil.action;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.flyusoft.apps.jointoil.entity.MachineRoomMonitorData;
import com.flyusoft.apps.jointoil.service.MachineRoomMonitorDataService;
import com.flyusoft.common.orm.Page;
import com.opensymphony.xwork2.ActionSupport;


@Controller
@Scope("prototype")
public class MachineRoomRecordAction extends ActionSupport{

	private static final long serialVersionUID = -8009658859192675609L;

	private Page<MachineRoomMonitorData> page = new Page<MachineRoomMonitorData>(25);
	
	private String roomNo;
	private String startime;
	private String endtime;
	@Autowired
	private MachineRoomMonitorDataService mrmdService;
	
	public String execute(){
		boolean isContain=roomNo!=null&&!roomNo.equals("")&&startime!=null&&!startime.equals("")
				&&endtime!=null&&!endtime.equals("");
		DateFormat df=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		if(isContain){
			try {
				startime = startime.trim() + ":00";
				endtime = endtime.trim() + ":59";
				Date startDate = df.parse(startime);
				Date endDate = df.parse(endtime);
				page=mrmdService.getMachineRoomMonitorDataMsg(page, roomNo, startDate, endDate);
			} catch (ParseException e) {
				System.out.println("  StatisticsHistoryAction.java  ---- DATE格式转换错误  ");
			}
		}else{
			page.setTotalCount(0);
			page.setPageNo(0);
		}
		
		return SUCCESS;
	}


	public Page<MachineRoomMonitorData> getPage() {
		return page;
	}


	public void setPage(Page<MachineRoomMonitorData> page) {
		this.page = page;
	}


	public String getRoomNo() {
		return roomNo;
	}


	public void setRoomNo(String roomNo) {
		this.roomNo = roomNo;
	}


	public String getStartime() {
		return startime;
	}


	public void setStartime(String startime) {
		this.startime = startime;
	}


	public String getEndtime() {
		return endtime;
	}
	public void setEndtime(String endtime) {
		this.endtime = endtime;
	}
	
	
}
