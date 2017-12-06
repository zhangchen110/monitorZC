package com.flyusoft.apps.jointoil.action;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.flyusoft.apps.jointoil.entity.AlarmLog;
import com.flyusoft.apps.jointoil.service.AlarmLogService;
import com.flyusoft.common.orm.Page;
import com.flyusoft.common.utils.web.struts2.Struts2Utils;
import com.opensymphony.xwork2.ActionSupport;

@Controller
@Scope("prototype")
public class AlarmLogAction extends ActionSupport {
	private static final long serialVersionUID = -2620520863102563876L;
	@Autowired
	private AlarmLogService alarmLogService;

	// ----- 报警日志信息查询
	private AlarmLog alarmLog;

	private Page<AlarmLog> page = new Page<AlarmLog>(50);// 每页10条记录

	private String todays = "";// 开始日期
	private String todaye = "";// 结束日期

	@Override
	public String execute() throws Exception {
		// 如果时间为空 查找今天数据
		// 将日期转化为date类型
		DateFormat f = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");// 注意前台传递过来的日期,中间空格空位应相同
		DateFormat f_newtoday = new SimpleDateFormat("yyyy-MM-dd");// 注意前台传递过来的日期,中间空格空位应相同
		String s_day = "";
		String e_day = "";
		if (todays == null || "".equals(todays)) {// 默认查询当天信息
			Date newtoday = new Date();
			String newday = f_newtoday.format(newtoday);
			todays = newday.trim();
			todaye = newday.trim();
			s_day = newday.trim() + " 00:00:00";
			e_day = newday.trim() + " 23:59:59"; // 注意空格
		} else {
			s_day = todays.trim() + " 00:00:00";
			e_day = todaye.trim() + " 23:59:59";
		}

		if (!page.isOrderBySetted()) {
			page.setOrderBy("id");
			page.setOrder(Page.ASC);
		}
		page = alarmLogService.getAlarmLogTime(page, f.parse(s_day),
				f.parse(e_day));

		return "SUCCESS";
	}

	/**
	 * 查找所有需要报警的信息
	 * 
	 * @return
	 */
	public String queryAlarmMessage() {
		StringBuilder sb = new StringBuilder();
		List<AlarmLog> alarmLogMessageList = alarmLogService
				.searchAllAlarmLogs();
		for (AlarmLog alarmLog : alarmLogMessageList) {
			sb.append(alarmLog.getMsg() + ";");
			alarmLog.setStatus(1);
			alarmLogService.saveAlarmLog(alarmLog);
		}
		Struts2Utils.renderText(sb.toString());
		return null;
	}

	// ---------------- 此处是报警日志方法

	public Page<AlarmLog> getPage() {
		return page;
	}

	public AlarmLog getAlarmLog() {
		return alarmLog;
	}

	public void setAlarmLog(AlarmLog alarmLog) {
		this.alarmLog = alarmLog;
	}

	public String getTodays() {
		return todays;
	}

	public void setTodays(String todays) {
		this.todays = todays;
	}

	public void setPage(Page<AlarmLog> page) {
		this.page = page;
	}

	public String getTodaye() {
		return todaye;
	}

	public void setTodaye(String todaye) {
		this.todaye = todaye;
	}

}
