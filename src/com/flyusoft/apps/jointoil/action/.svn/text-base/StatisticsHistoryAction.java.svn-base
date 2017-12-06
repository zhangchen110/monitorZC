package com.flyusoft.apps.jointoil.action;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.flyusoft.apps.jointoil.entity.Index;
import com.flyusoft.apps.jointoil.entity.MonitorData;
import com.flyusoft.apps.jointoil.entity.ReportHtml;
import com.flyusoft.apps.jointoil.entity.Well;
import com.flyusoft.apps.jointoil.service.MonitorDataService;
import com.flyusoft.apps.jointoil.service.ReportHtmlService;
import com.flyusoft.apps.jointoil.service.WellService;
import com.flyusoft.common.orm.Page;
import com.opensymphony.xwork2.ActionSupport;

@Controller
@Scope("prototype")
public class StatisticsHistoryAction extends ActionSupport {

	private static final long serialVersionUID = -2620520863102563876L;

	private ReportHtml reportHtml = new ReportHtml();//定义一个班报实体类，并且new
	private boolean ishtml; //用于判断是显示false|$(htmls) 还是true|<html>

	private String wellno_h;//查询之后将当前查询的井号 和 日期赋值给隐藏域
	private String reporttime_h;

	@Autowired
	private ReportHtmlService reportHtmlService;//班报表service
	@Autowired
	private WellService wellService;//井表
	@Autowired
	private MonitorDataService monitordataService;//历史记录表
	// ---------下面为历史数据查询内容

	private String id = "";//班报表的id，如果空就插入一条井/日期记录，如果id存在，就执行update
	private String htmls = "";//保存临时html标签信息
	private Page<MonitorData> page = new Page<MonitorData>(25);

	private String wellid = "";// 定义将要查询的井no  实际为历史统计查询用的井no

	private String wellno = "";//定义班报查询的井no

	private String startime = "";// 定义查询历史数据 开始时间

	private String endtime = "";// 定义查询历史数据 结束时间

	private String reporttime = "";// 定义班报日期  '2011-09-22'

	private MonitorData mon3 = new MonitorData();
	private MonitorData mon7 = new MonitorData();
	private MonitorData mon11 = new MonitorData();
	private MonitorData mon15 = new MonitorData();
	private MonitorData mon19 = new MonitorData();
	private MonitorData mon23 = new MonitorData();
	private MonitorData beforemon23 = new MonitorData();//前一天23点信息
	private MonitorData fullaverage = new MonitorData();//全部平均值

	private String time_year = "";
	private String time_month = "";
	private String time_day = "";
	private String beforeday = "";//前一天的日期字符窜形式
	// ----- 报警日志信息查询

	private Map<String, String> wellallmap = new HashMap<String, String>();
	private Map<String, String> indexallmap = new HashMap<String, String>();
	private List<Well> wellAllList = new ArrayList<Well>();
	private List<Index> indexAllList = new ArrayList<Index>();

	@Override
	public String execute() throws Exception {
		// 调用
		wellAllList = wellService.getAllWell();// 获得井id,用于条件查询
		if (wellid == "" || startime == "" || endtime == "") {// 为空则返回
			page.setPageNo(0);
			page.setTotalCount(0);
			return "SUCCESS";
		}

		// 为日期添加秒
		startime = startime.trim() + ":00";
		endtime = endtime.trim() + ":59";

		// 将日期转化为date类型
		DateFormat f = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");// 注意前台传递过来的日期,中间空格空位应相同
		Date start_date = null;
		Date end_date = null;
		try {
			start_date = f.parse(startime);
			end_date = f.parse(endtime);
		} catch (ParseException e) {
			System.out.println("  StatisticsHistoryAction.java  ---- DATE格式转换错误  ");
		}
		if (!page.isOrderBySetted()) {
			page.setOrderBy("id");
			page.setOrder(Page.ASC);
		}
		if (start_date == null || end_date == null) {// 如果日期转换不成功则返回
			page.setPageNo(0);
			page.setTotalCount(0);
			return "SUCCESS";
		}
		page = monitordataService.getMonitorDataMsg(page, wellid, start_date, end_date);
		return "SUCCESS";
	}

	public String listclassreport() {

		wellAllList = wellService.getAllWell();// 获得井no,用于条件查询

		DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		if (wellno == "" || reporttime == "") {// 为空则进行当天信息查询
			if (!(wellAllList.size() > 0)) {//如果数据库没有井信息，就返回
				return "SUCCESS_CLASSREPORT";
			}
			Well well = (Well) wellAllList.get(0);
			wellno = well.getWellNo();

			Date date = new Date();
			reporttime = format.format(date);
		}

		wellno_h = wellno;//赋值给隐藏域
		reporttime_h = reporttime;//赋值给隐藏域

		reportHtml = reportHtmlService.getReportHtmlList(wellno, reporttime);//有信息则显示。 无信息则为空。
		String reportid = reportHtml.getId() + "";
		ishtml = false;//显示$符号
		if (reportid == null || "".equals(reportid) || "null".equals(reportid)) {//如果查询信息为空,显示<html>标签
			ishtml = true;//显示html标签

			//为了得到前一天日期
			String[] time_s = reporttime.split("-");
			time_year = time_s[0];//添加时间显示
			time_month = time_s[1];
			time_day = time_s[2];
			GregorianCalendar ger = new GregorianCalendar(Integer.parseInt(time_year),
					Integer.parseInt(time_month) - 1, Integer.parseInt(time_day));
			ger.add(Calendar.DAY_OF_MONTH, -1);
			Date today = ger.getTime();
			beforeday = format.format(today);//得到前天日期 字符串类型的

			//查询 井id  ,提交的日期   ,time
			mon3 = monitordataService.getMonitorDataClassReport(wellno, reporttime, "3");
			mon7 = monitordataService.getMonitorDataClassReport(wellno, reporttime, "7");
			mon11 = monitordataService.getMonitorDataClassReport(wellno, reporttime, "11");
			mon15 = monitordataService.getMonitorDataClassReport(wellno, reporttime, "15");
			mon19 = monitordataService.getMonitorDataClassReport(wellno, reporttime, "19");
			mon23 = monitordataService.getMonitorDataClassReport(wellno, reporttime, "23");
			int sumnumber = 0;
			if (mon3.getId() != null) {
				sumnumber = sumnumber + 1;
			}

			if (mon7.getId() != null) {
				sumnumber = sumnumber + 1;
			}

			if (mon11.getId() != null) {
				sumnumber = sumnumber + 1;
			}

			if (mon15.getId() != null) {
				sumnumber = sumnumber + 1;
			}

			if (mon19.getId() != null) {
				sumnumber = sumnumber + 1;
			}

			if (mon23.getId() != null) {
				sumnumber = sumnumber + 1;
			}
			if (sumnumber == 0) {//如果所有信息都是空， 则默认除1. 避免分母为零异常
				sumnumber = 1;
			}
			beforemon23 = monitordataService.getMonitorDataClassReport(wellno, beforeday, "23");//查询前一天23点信息

			//		  ----------------得到全日信息 
			DecimalFormat df = new DecimalFormat("0.00");
			fullaverage
					.setPressure(Double.valueOf(df.format(((mon3.getPressure() + mon7.getPressure()
							+ mon11.getPressure() + mon15.getPressure() + mon19.getPressure() + mon23.getPressure()) / sumnumber))));
			fullaverage
					.setTemperature(Double.valueOf(df.format(((mon3.getTemperature() + mon7.getTemperature()
							+ mon11.getTemperature() + mon15.getTemperature() + mon19.getTemperature() + mon23
							.getTemperature()) / sumnumber))));
			fullaverage.setInstantaneousFlow(Double.valueOf(df.format(((mon3.getInstantaneousFlow()
					+ mon7.getInstantaneousFlow() + mon11.getInstantaneousFlow() + mon15.getInstantaneousFlow()
					+ mon19.getInstantaneousFlow() + mon23.getInstantaneousFlow()) / sumnumber))));
			fullaverage.setAccumulativeFlow(mon23.getAccumulativeFlow() == 0.0 ? null : mon23.getAccumulativeFlow());//只写23点信息

			id = "";//如果是<html>，说明班报表中无此天，此井的html信息，也同样无id，id就要置空;

		} else {//查询历史记录结束
			id = reportHtml.getId();
			//如果显示${html}才给htmls赋值,如果查询不到，不进行赋值。
			htmls = reportHtml.getHtmls();
		}
		//		  ----------------
		return "SUCCESS_CLASSREPORT";
	}

	public String save() throws Exception {//存储班报信息
		ishtml = false;//显示${htmls}符号
		String[] time_s = null;
		wellAllList = wellService.getAllWell();// 获得井no,用于条件查询
		if (id == "" || id.equals("")) {//如果id为空，说明第一次进入。 日期：reporttime_h,井号：wellno_h，过来的htmls直接存储在对象中了。

			time_s = reporttime_h.split("-");
			reportHtml.setWellNo(wellno_h);
			reportHtml.setHtmls(htmls);
		} else {//修改的为${html}标签的时候
			ReportHtml report = reportHtmlService.getReportHtml(id);
			reportHtml.setId(report.getId());
			time_s = reporttime_h.split("-");
			reportHtml.setWellNo(wellno_h);
			reportHtml.setHtmls(htmls);
		}
		GregorianCalendar ger = new GregorianCalendar(Integer.parseInt(time_s[0]), Integer.parseInt(time_s[1]) - 1,
				Integer.parseInt(time_s[2]));
		Date today = ger.getTime();
		reportHtml.setDate(today);

		reportHtmlService.saveReportHtml(reportHtml);
		id = reportHtml.getId();
		htmls = reportHtml.getHtmls();
		//其中井号和日期的隐藏于，因为在保存的时候已经提交，不再赋值。
		return "SUCCESS_CLASSREPORT";
	}

	public String report() {

		return "SUCCESS_REPORTHTML";
	}

	// ---------------- 此处是报警日志方法

	public Page<MonitorData> getPage() {
		return page;
	}

	public List<Well> getWellAllList() {
		return wellAllList;
	}

	public List<Index> getIndexAllList() {
		return indexAllList;
	}

	public Map<String, String> getWellallmap() {
		return wellallmap;
	}

	public Map<String, String> getIndexallmap() {
		return indexallmap;
	}

	// ----------下面是历史数据查询的方法

	public String getEndtime() {
		return endtime;
	}

	

	public String getStartime() {
		return startime;
	}

	public void setStartime(String startime) {
		this.startime = startime;
	}

	public void setEndtime(String endtime) {
		this.endtime = endtime;
	}

	public String getWellid() {
		return wellid;
	}

	public void setWellid(String wellid) {
		this.wellid = wellid;
	}

	public String getReporttime() {
		return reporttime;
	}

	public void setReporttime(String reporttime) {
		this.reporttime = reporttime;
	}

	public String getWellno() {
		return wellno;
	}

	public void setWellno(String wellno) {
		this.wellno = wellno;
	}

	//MonitorData  存储

	public MonitorData getMon3() {
		return mon3;
	}

	public MonitorData getMon7() {
		return mon7;
	}

	public MonitorData getMon11() {
		return mon11;
	}

	public MonitorData getMon15() {
		return mon15;
	}

	public MonitorData getMon19() {
		return mon19;
	}

	public MonitorData getMon23() {//前一天的信息
		return mon23;
	}

	public String getBeforeday() {
		return beforeday;
	}

	public MonitorData getBeforemon23() {
		return beforemon23;
	}

	public String getTime_year() {
		return time_year;
	}

	public void setTime_year(String time_year) {
		this.time_year = time_year;
	}

	public String getTime_month() {
		return time_month;
	}

	public void setTime_month(String time_month) {
		this.time_month = time_month;
	}

	public String getTime_day() {
		return time_day;
	}

	public void setTime_day(String time_day) {
		this.time_day = time_day;
	}

	public MonitorData getFullaverage() {//全部平均值
		return fullaverage;
	}

	public ReportHtml getReportHtml() {
		return reportHtml;
	}

	public void setReportHtml(ReportHtml reportHtml) {
		this.reportHtml = reportHtml;
	}

	public boolean isIshtml() {
		return ishtml;
	}

	public void setIshtml(boolean ishtml) {
		this.ishtml = ishtml;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getHtmls() {
		return htmls;
	}

	public void setHtmls(String htmls) {
		this.htmls = htmls;
	}

	public String getReporttime_h() {
		return reporttime_h;
	}

	public void setReporttime_h(String reporttime_h) {
		this.reporttime_h = reporttime_h;
	}

	public String getWellno_h() {
		return wellno_h;
	}

	public void setWellno_h(String wellno_h) {
		this.wellno_h = wellno_h;
	}

}
