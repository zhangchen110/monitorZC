package com.flyusoft.apps.jointoil.action;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.flyusoft.apps.jointoil.entity.Compressor;
import com.flyusoft.apps.jointoil.entity.CompressorMD;
import com.flyusoft.apps.jointoil.entity.Index;
import com.flyusoft.apps.jointoil.entity.MachineRoom;
import com.flyusoft.apps.jointoil.entity.MachineRoomMonitorData;
import com.flyusoft.apps.jointoil.service.FiveBoosterCompressorService;
import com.flyusoft.apps.jointoil.service.FiveScrewMachineService;
import com.flyusoft.apps.jointoil.service.FourIntegratedMachineService;
import com.flyusoft.apps.jointoil.service.MachineRoomMonitorDataService;
import com.flyusoft.apps.jointoil.service.OneIntegratedMachineService;
import com.flyusoft.apps.jointoil.service.ThreeBoosterCompressorService;
import com.flyusoft.apps.jointoil.service.ThreeScrewMachineService;
import com.flyusoft.apps.jointoil.service.TwoBoosterCompressorService;
import com.flyusoft.apps.jointoil.service.TwoScrewMachineService;
import com.flyusoft.apps.jointoil.util.AlarmUtil;
import com.flyusoft.apps.jointoil.util.JointOilInitentity;
import com.flyusoft.common.utils.XMLConfigReader;
import com.flyusoft.common.utils.reflection.ReflectionUtils;
import com.flyusoft.common.utils.web.struts2.Struts2Utils;
import com.google.common.collect.Lists;
import com.opensymphony.xwork2.ActionSupport;

@Controller
@Scope("prototype")
public class IndexcomAction extends ActionSupport {
	private static final long serialVersionUID = -8885369849994789957L;

	private List<Compressor> compressorsList;
	private List<Index> indexListL = new ArrayList<Index>();
	private List<Index> indexListY = new ArrayList<Index>();
	@Autowired
	private OneIntegratedMachineService oneIntegratedMachineService;
	@Autowired
	private TwoBoosterCompressorService twoBoosterCompressorService;
	@Autowired
	private TwoScrewMachineService twoScrewMachineService;
	@Autowired
	private ThreeBoosterCompressorService threeBoosterCompressorService;
	@Autowired
	private ThreeScrewMachineService threeScrewMachineService;
	@Autowired
	private FourIntegratedMachineService fourIntegratedMachineService;
	@Autowired
	private FiveBoosterCompressorService fiveBoosterCompressorService;
	@Autowired
	private FiveScrewMachineService fiveScrewMachineService;
	@Autowired
	private MachineRoomMonitorDataService roomMonitorDataService;

	private List<Index> indexListMr = new ArrayList<Index>();// 存放机房指标名字

	private List<String> mrList = new ArrayList<String>();// 存放机房指标对应的值
	
	private String roomId;
	private String roomNo;

	private JointOilInitentity jointOilInitentity = JointOilInitentity
			.getInstance();

	private AlarmUtil alarmUtil = new AlarmUtil();

	private String alarmString = "";

	public String execute() throws Exception {
		roomId = Struts2Utils.getParameter("roomId");
		MachineRoom machineRoom = jointOilInitentity
				.getMachineRoomByMachineRoomId(roomId);
		compressorsList = machineRoom.getCompressors();
		// 查询对应指标
		XMLConfigReader reader = XMLConfigReader
				.getInstance("compressorMethod.xml");
		// 遍历 判断是哪一种，并将其添加到相应list

		// 下面是机房指标情况
		roomNo=machineRoom.getRoomNo();
		if (machineRoom.getRoomNo().equals("MR1")
				|| machineRoom.getRoomNo().equals("MR4")) {
			MachineRoomMonitorData mrmd = roomMonitorDataService
					.getLastTimeDataByRoomNO(machineRoom.getRoomNo());
			indexListMr = machineRoom.getIndexs();
			if (mrmd != null) {
				for (Index index : indexListMr) {
					String fieldName = reader.getTextFromPath("//method",
							"name", index.getIndexCode());
					Object value = ReflectionUtils.getFieldValue(mrmd,
							fieldName);
					if (value != null) {
						mrList.add(value.toString());
					}
					if (value != null && index.getStatus() == 0) {
						boolean isalarm = alarmUtil.isAlarming((Double) value,
								index);
						if (isalarm) {
							alarmString += index.getIndexCode() + ",";
						}
					}
				}
			}
		}
		// 下面是机房下压缩机情况
		for (Compressor compressor : compressorsList) {

			// 获取指标对象
			CompressorMD md = getCompressorMD(compressor.getCompressorCode());

			// 获取所有指标 并将指标封装到对象
			List<Index> comIndexs = compressor.getComIndexs();
			List<String> Llist = Lists.newArrayList();
			List<String> Ylist = Lists.newArrayList();
			if (md != null) {
				String str = "";
				for (int i = 0; i < comIndexs.size(); i++) {
					Index comIndex = comIndexs.get(i);
					str += comIndex.getIndexName() + "__";
					String fieldName = reader.getTextFromPath("//method",
							"name", comIndex.getIndexCode());
					//System.out.println(i+": "+  comIndex.getIndexCode() +" -  "+md+"  -  "+fieldName);
					Object value = ReflectionUtils.getFieldValue(md, fieldName);
					if (value == null)
						value = 0.0;
					if (comIndex.getStatus() == 0) {// 判断是否报警
						boolean isalarm = alarmUtil.isAlarming((Double) value,
								comIndex);
						if (isalarm) {
							alarmString += compressor.getCompressorCode() + i
									+ ",";
						}
					}
					// 判断是压缩机或螺杆机
					String compressorCode = compressor.getCompressorCode();
					String compresstype = compressorCode.substring(3, 4);
					if (compresstype.equals("Y")) {
						if (comIndex.getIndexCode().equals("YXZT")) {
							if (value.toString().equals("0")) {
								Ylist.add("停止");
								alarmString += compressor.getCompressorCode()
										+ i + ",";
							} else if (value.toString().equals("1")) {
								Ylist.add("运行");
							} else if (value.toString().equals("2")) {
								Ylist.add("报警");
								alarmString += compressor.getCompressorCode()
										+ i + ",";
							}

						} else {
							Ylist.add(value.toString());
						}
						indexListY = compressor.getComIndexs();
						compressor.setIdentify(0);
					} else {
						if (comIndex.getIndexCode().equals("YXZT")) {
							if (value.toString().equals("0")) {
								Llist.add("停止");
								alarmString += compressor.getCompressorCode()
										+ i + ",";
							} else if (value.toString().equals("1")) {
								Llist.add("运行");
							} else if (value.toString().equals("2")) {
								Llist.add("报警");
								alarmString += compressor.getCompressorCode()
										+ i + ",";
							}

						} else {
							Llist.add(value.toString());
						}
						indexListL = compressor.getComIndexs();
						compressor.setIdentify(1);
					}
				}
				compressor.setIndexYValueList(Ylist);
				compressor.setIndexLValueList(Llist);
			} else {
				addActionMessage(compressor.getCompressorName() + "无数据显示");
			}
		}

		return SUCCESS;
	}

	public String realTime() throws Exception {
		MachineRoom machineRoom = jointOilInitentity
				.getMachineRoomByMachineRoomId(roomId);
		compressorsList = machineRoom.getCompressors();
		String str = "";
		// 查询对应指标
		XMLConfigReader reader = XMLConfigReader
				.getInstance("compressorMethod.xml");

		if (machineRoom.getRoomNo().equals("MR1")
				|| machineRoom.getRoomNo().equals("MR4")) {
			MachineRoomMonitorData mrmd = roomMonitorDataService
					.getLastTimeDataByRoomNO(machineRoom.getRoomNo());
			indexListMr = machineRoom.getIndexs();
			if (mrmd != null) {
				for (Index index : indexListMr) {
					int isAlarmTmp = 0;
					String fieldName = reader.getTextFromPath("//method",
							"name", index.getIndexCode());
					Object value = ReflectionUtils.getFieldValue(mrmd,
							fieldName);
					if (value != null) {
						mrList.add(value.toString());
					}
					if (value != null && index.getStatus() == 0) {
						boolean isalarm = alarmUtil.isAlarming((Double) value,
								index);
						if (isalarm) {
							isAlarmTmp = 1;
						}
					}
					if(value==null){
						value=0.0;
					}
					if (!str.equals("") && str != null) {
						str += "," + index.getIndexCode() + "_"
								+ value.toString() + "_" + isAlarmTmp;
					} else {
						str += index.getIndexCode() + "_" + value.toString()
								+ "_" + isAlarmTmp;
					}
				}
				str += "#";
			}
		}

		// 遍历 判断是哪一种，并将其添加到相应list
		for (Compressor compressor : compressorsList) {
			// 获取指标对象
			CompressorMD md = getCompressorMD(compressor.getCompressorCode());
			if (md != null) {
				// 判断是压缩机或螺杆机
				String compressorCode = compressor.getCompressorCode();
				// String compresstype = compressorCode.substring(3,4);
				// if(compresstype.equals("Y")){
				// str += compressorCode+"Y"+":";
				// }else{
				str += compressorCode + ":";
				if(compressor.getState()==null){
					compressor.setState(0+"");
				}
				str+=compressor.getState()+":";
				// }
				// 获取所有指标 并将指标封装到对象
				List<Index> comIndexs = compressor.getComIndexs();
				for (int i = 0; i < comIndexs.size(); i++) {
					int isAlarm = 0;// 0为不报警,1为报警
					Index comIndex = comIndexs.get(i);
					String fieldName = reader.getTextFromPath("//method",
							"name", comIndex.getIndexCode());
					Object value = ReflectionUtils.getFieldValue(md, fieldName);
					String valueTmp = "";
					if (comIndex.getStatus() == 0) {// 判断是否报警
						if(value!=null){
							boolean alarmTmp = alarmUtil.isAlarming((Double) value,
									comIndex);
							if (alarmTmp) {
								isAlarm = 1;
							}
						}
					}
					if(value==null){
						value=0.0;
					}
					if (comIndex.getIndexCode().equals("YXZT")) {
						if (value.toString().equals("0")) {
							valueTmp = "停止";
							isAlarm = 1;
						} else if (value.toString().equals("1")) {
							valueTmp = "运行";
						} else if (value.toString().equals("2")) {
							valueTmp = "报警";
							isAlarm = 1;
						}

					} else {
						valueTmp = value.toString();
					}
					
					if (i > 0) {
						str += "," + i + "_" + valueTmp + "_" + isAlarm;
					} else {
						str += i + "_" + valueTmp + "_" + isAlarm;
					}
				}
				str += ";";
			}
		}
		Struts2Utils.renderText(str);
		return null;
	}

	private CompressorMD getCompressorMD(String compressorCode) {
		CompressorMD md = null;
		if (compressorCode.startsWith("J1-Y")) {
			md = oneIntegratedMachineService
					.searchMonitorDataByLastTime(compressorCode);

		} else if (compressorCode.startsWith("J2-L")) {
			md = twoScrewMachineService
					.searchMonitorDataByLastTime(compressorCode);
		} else if (compressorCode.startsWith("J2-Y")) {
			md = twoBoosterCompressorService
					.searchMonitorDataByLastTime(compressorCode);

		} else if (compressorCode.startsWith("J3-L")) {
			md = threeScrewMachineService
					.searchMonitorDataByLastTime(compressorCode);

		} else if (compressorCode.startsWith("J3-Y")) {
			md = threeBoosterCompressorService
					.searchMonitorDataByLastTime(compressorCode);

		} else if (compressorCode.startsWith("J4-Y")) {
			md = fourIntegratedMachineService
					.searchMonitorDataByLastTime(compressorCode);

		} else if (compressorCode.startsWith("J5-L")) {
			md = fiveScrewMachineService
					.searchMonitorDataByLastTime(compressorCode);

		} else if (compressorCode.startsWith("J5-Y")) {
			md = fiveBoosterCompressorService
					.searchMonitorDataByLastTime(compressorCode);
		}
		return md;
	}

	public List<Index> getIndexListL() {
		return indexListL;
	}

	public List<Index> getIndexListY() {
		return indexListY;
	}

	public List<Compressor> getCompressorsList() {
		return compressorsList;
	}

	public String getRoomId() {
		return roomId;
	}

	public void setRoomId(String roomId) {
		this.roomId = roomId;
	}

	public String getAlarmString() {
		return alarmString;
	}

	public List<Index> getIndexListMr() {
		return indexListMr;
	}

	public List<String> getMrList() {
		return mrList;
	}

	public String getRoomNo() {
		return roomNo;
	}

	public void setRoomNo(String roomNo) {
		this.roomNo = roomNo;
	}
	
}
