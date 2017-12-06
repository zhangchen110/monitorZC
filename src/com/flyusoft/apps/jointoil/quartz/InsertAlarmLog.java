package com.flyusoft.apps.jointoil.quartz;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.flyusoft.apps.jointoil.entity.AlarmLog;
import com.flyusoft.apps.jointoil.entity.Compressor;
import com.flyusoft.apps.jointoil.entity.CompressorMonitorData;
import com.flyusoft.apps.jointoil.entity.Index;
import com.flyusoft.apps.jointoil.entity.MachineRoom;
import com.flyusoft.apps.jointoil.entity.MachineRoomMonitorData;
import com.flyusoft.apps.jointoil.entity.MonitorData;
import com.flyusoft.apps.jointoil.entity.Well;
import com.flyusoft.apps.jointoil.service.AlarmLogService;
import com.flyusoft.apps.jointoil.service.CompressorMonitorDataService;
import com.flyusoft.apps.jointoil.service.MachineRoomMonitorDataService;
import com.flyusoft.apps.jointoil.service.MonitorDataService;
import com.flyusoft.apps.jointoil.util.AlarmUtil;
import com.flyusoft.apps.jointoil.util.GainCompressorData;
import com.flyusoft.apps.jointoil.util.InsertAlarmThread;
import com.flyusoft.apps.jointoil.util.JointOilInitentity;
import com.flyusoft.common.utils.XMLConfigReader;
import com.flyusoft.common.utils.reflection.ReflectionUtils;
import com.google.common.collect.Maps;

/**
 * 执行插入报警日志
 * 
 * @author yanglongquan
 * 
 */

public class InsertAlarmLog {
	public static Map<String, Date> timeMap = Maps.newHashMap();

	@Autowired
	private MonitorDataService monitorDataService;
	@Autowired
	private AlarmLogService alarmLogService;
	@Autowired
	private CompressorMonitorDataService compressorMonitorDataService;
	@Autowired
	private MachineRoomMonitorDataService machineRoomMonitorDataService;

	private AlarmUtil alarmUtil = new AlarmUtil();
	@Autowired
	private GainCompressorData gainCompressorData;

	public void execute() throws Exception {
		List<AlarmLog> alarmList = new ArrayList<AlarmLog>();// 井与压缩机需要报警的对象
		XMLConfigReader reader = XMLConfigReader
				.getInstance("compressorMethod.xml");
		// 油井
		JointOilInitentity jointOilInitentity = JointOilInitentity
				.getInstance();
		List<Well> wellList = jointOilInitentity.getWellList();
		List<MonitorData> allLastMonitorDatas = monitorDataService
				.searchAllWellLastTimeMonitorData(wellList.size());// 获取所有井的最后一条数据
		for (Well well : wellList) {
			MonitorData monitorData = monitorDataService
					.getLastTimeMonitorData(well.getWellNo(),
							allLastMonitorDatas);// 先从集合中读取
			if (monitorData == null) {
				monitorData = monitorDataService
						.searchMonitorDataByLastMonitorTime(well.getWellNo());
			}
			if (monitorData != null) {
				// 下面为判断是判断过了的指标
				boolean tmp = true;
				if (timeMap.size() != 0) {
					if (timeMap.get(monitorData.getWellNo()) != null) {
						if ((timeMap.get(monitorData.getWellNo()).toString())
								.equals(monitorData.getMonitorTime().toString())) {
							tmp = false;
						}
					}
				}

				if (tmp) {
					String isAlramNum = "1";
					List<Index> wellIndexList = well.getIndexList();
					for (Index index : wellIndexList) {
						boolean isTmp = index.getStatus() == 0 ? true : false;// 判断是否是报警指标
						if (isTmp) {
							String fieldName = reader.getTextFromPath(
									"//method", "name", index.getIndexCode());
							Double value = (Double) ReflectionUtils
									.getFieldValue(monitorData, fieldName);
							// 报警
							boolean isAlarming = alarmUtil.isAlarming(value,
									index);
							if (isAlarming) {
								AlarmLog alarmLog = new AlarmLog();
								alarmLog.setTime(monitorData.getMonitorTime());
								alarmLog.setMsg("井：" + well.getWellNo() + "，"
										+ index.getIndexName() + "：" + value
										+ "，最小下限：" + index.getMinLimit()
										+ "，最大上限：" + index.getMaxLimit());
								alarmLog.setStatus(0);
								alarmList.add(alarmLog);
								isAlramNum = "2";
							}
						}
					}
					timeMap.put(monitorData.getWellNo(),
							monitorData.getMonitorTime());
					well.setStatus(isAlramNum);
				}
			}
		}

		// 压缩机
		List<Compressor> compressorList = jointOilInitentity.getAllCompressor();
		List<CompressorMonitorData> dataList = compressorMonitorDataService
				.getAllCompressorLastMonitorDatas();
		
		for (Compressor compressor : compressorList) {
			
			// str += compressor.getCompressorCode() + "_";
			CompressorMonitorData compressorMonitorData = gainCompressorData
					.getCompressorMonitorDataByCompressorCode(
							compressor.getCompressorCode(), dataList);
			if ( 
					(compressorMonitorData != null)&&((compressorMonitorData.getFirstPistonPressure()!=null&&compressorMonitorData.getFirstPistonPressure()>1)
					||(compressorMonitorData.getThirdPistonPressure()!=null&&compressorMonitorData.getThirdPistonPressure()>5)
					||(compressorMonitorData.getSecondPistonPressure()!=null&&compressorMonitorData.getSecondPistonPressure()>2)
					||(compressorMonitorData.getExhaustPressure()!=null&&compressorMonitorData.getExhaustPressure()>0.4)
					||(compressorMonitorData.getOutletTemperature()!=null&&compressorMonitorData.getOutletTemperature()>60)
					||(compressorMonitorData.getOutScrewTemperature1()!=null&&compressorMonitorData.getOutScrewTemperature1()>60)//2 5 机房 螺杆机
					||(compressorMonitorData.getOutScrewTemperature2()!=null&&compressorMonitorData.getOutScrewTemperature2()>60)
					)
					
			) {// 判断是否正在运行
					boolean flag = false;// 判断压缩机某指标是否报警
					boolean tmp = true;// 判断是否执行过true为没执行过该对象
					if (timeMap.size() != 0) {
						if (timeMap.get(compressor.getCompressorCode()) != null) {
							if ((timeMap.get(compressor.getCompressorCode())
									.toString()).equals(compressorMonitorData
									.getTime().toString())) {
								tmp = false;
							}
						}
					}
					if (tmp) {
						String isAlarmString = "1";
						List<Index> comIndexs = compressor.getComIndexs();
						for (Index comIndex : comIndexs) {
							// 只有指标表status为0的指标才报警
							if (comIndex.getStatus().intValue() == 0) {
								String fieldName = reader.getTextFromPath(
										"//method", "name",
										comIndex.getIndexCode());
								Object value = ReflectionUtils.getFieldValue(
										compressorMonitorData, fieldName);
								if (value instanceof Double) {
									flag = alarmUtil.isAlarming((Double) value,
											comIndex);
									if (flag) {
										AlarmLog alarmLog = new AlarmLog();
										alarmLog.setTime(compressorMonitorData
												.getTime());
										alarmLog.setMsg(compressor
												.getMachineRoom().getRoomName()
												+ "："
												+compressor.getCompressorCode()
												+"：，"
												+ comIndex.getIndexName()
												+ "："
												+ value.toString()
												+ "，最小下限："
												+ comIndex.getMinLimit()
												+ "，最大上限："
												+ comIndex.getMaxLimit());
										alarmLog.setStatus(0);
										alarmList.add(alarmLog);
										isAlarmString = "2";
									}
								}
							}
						}
						timeMap.put(compressor.getCompressorCode(),
								compressorMonitorData.getTime());
							compressor.setState(isAlarmString);
					}
				} else{
					compressor.setState("0");
				}
			
//				if((compressor.getCompressorCode().substring(3, 4)=="L")){//如果是螺杆机器  根据压缩机运行状态判断    上面根据温度判断了
//					String comCode=compressor.getCompressorCode().substring(0, 3)+"Y"+compressor.getCompressorCode().substring(4,5);
//						for (Compressor compressor_L :  compressorList) {
//								if(compressor_L.getCompressorCode()==comCode){
//									compressor.setState(compressor_L.getState());
//									break;
//								}
//						}
//				}
			
				if("0".equals(compressor.getState()) ){
					compressor.setRunningStartTime(new Date());//存储当前时间
					compressor.setRunningTime("0");
				}else{
					if(compressor.getRunningStartTime()==null){//如果为空 将现在时间赋值
						compressor.setRunningStartTime(new Date());
					}
					Date sta=compressor.getRunningStartTime();
					Date end=new Date();
					   long l=end.getTime()-sta.getTime();
					   long day=l/(24*60*60*1000);
					   long hour=(l/(60*60*1000)-day*24);
					   long min=((l/(60*1000))-day*24*60-hour*60);
					compressor.setRunningTime(""+day+"天"+hour+"小时"+min+"分");
				}
				
		}
		
		
		//机房
		List<MachineRoom> machineRoomList=jointOilInitentity.getMachineRoomList();
		List<MachineRoomMonitorData> mrmdList=machineRoomMonitorDataService.getMachineRoomMonitorDatasByNum(machineRoomList.size());
		for (MachineRoom machineRoom : machineRoomList) {
			if(machineRoom.getRoomNo().equals("MR1")||machineRoom.getRoomNo().equals("MR4")){
				List<Index> mrIndexs=machineRoom.getIndexs();
				MachineRoomMonitorData mrmd=machineRoomMonitorDataService.getDataByRoomNo(machineRoom.getRoomNo(),mrmdList);
				if(mrmd!=null){
					boolean tmp = true;
					if (timeMap.size() != 0) {
						if (timeMap.get(mrmd.getRoomNo()) != null) {
							if ((timeMap.get(mrmd.getRoomNo()).toString())
									.equals(mrmd.getTime().toString())) {
								tmp = false;
							}
						}
					}
					if(tmp){
						for (Index index : mrIndexs) {
							if(index.getStatus()==0){
								String fieldName = reader.getTextFromPath(
										"//method", "name",
										index.getIndexCode());
								Object value = ReflectionUtils.getFieldValue(
										mrmd, fieldName);
								boolean flag=false;
								if (value instanceof Double) {
									flag = alarmUtil.isAlarming((Double) value,
											index);
									if (flag) {
										AlarmLog alarmLog = new AlarmLog();
										alarmLog.setTime(mrmd.getTime());
										alarmLog.setMsg(
												machineRoom.getRoomName()
												+ "："
												+ index.getIndexName()
												+ "："
												+ value.toString()
												+ "，最小下限："
												+ index.getMinLimit()
												+ "，最大上限："
												+ index.getMaxLimit());
										alarmLog.setStatus(0);
										alarmList.add(alarmLog);
									}
								}
							}
							timeMap.put(mrmd.getRoomNo(),
									mrmd.getTime());
						}
					}
				}
			}
		}
		
		if (alarmList.size() > 0) {
			InsertAlarmThread alarmThread = new InsertAlarmThread(
					alarmLogService, alarmList);
			Thread t = new Thread(alarmThread);
			t.start();
		}
	}
}
