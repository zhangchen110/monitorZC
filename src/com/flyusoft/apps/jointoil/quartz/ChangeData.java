package com.flyusoft.apps.jointoil.quartz;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.flyusoft.apps.jointoil.entity.Compressor;
import com.flyusoft.apps.jointoil.entity.CompressorData;
import com.flyusoft.apps.jointoil.entity.FiveBoosterCompressor;
import com.flyusoft.apps.jointoil.entity.FiveScrewMachine;
import com.flyusoft.apps.jointoil.entity.FourIntegratedMachine;
import com.flyusoft.apps.jointoil.entity.MachineRoom;
import com.flyusoft.apps.jointoil.entity.MachineRoomMonitorData;
import com.flyusoft.apps.jointoil.entity.OneIntegratedMachine;
import com.flyusoft.apps.jointoil.entity.ThreeBoosterCompressor;
import com.flyusoft.apps.jointoil.entity.ThreeScrewMachine;
import com.flyusoft.apps.jointoil.entity.TwoBoosterCompressor;
import com.flyusoft.apps.jointoil.entity.TwoScrewMachine;
import com.flyusoft.apps.jointoil.service.CompressorDataService;
import com.flyusoft.apps.jointoil.service.FiveBoosterCompressorService;
import com.flyusoft.apps.jointoil.service.FiveScrewMachineService;
import com.flyusoft.apps.jointoil.service.FourIntegratedMachineService;
import com.flyusoft.apps.jointoil.service.MachineRoomMonitorDataService;
import com.flyusoft.apps.jointoil.service.OneIntegratedMachineService;
import com.flyusoft.apps.jointoil.service.ThreeBoosterCompressorService;
import com.flyusoft.apps.jointoil.service.ThreeScrewMachineService;
import com.flyusoft.apps.jointoil.service.TwoBoosterCompressorService;
import com.flyusoft.apps.jointoil.service.TwoScrewMachineService;
import com.flyusoft.apps.jointoil.util.InsertFiveBoosterCompressorThread;
import com.flyusoft.apps.jointoil.util.InsertFiveScrewMachineThread;
import com.flyusoft.apps.jointoil.util.InsertFourIntegratedMachineThread;
import com.flyusoft.apps.jointoil.util.InsertMachineRoomMonitorDataThread;
import com.flyusoft.apps.jointoil.util.InsertOneIntegratedMachineThread;
import com.flyusoft.apps.jointoil.util.InsertThreeBoosterCompressorThread;
import com.flyusoft.apps.jointoil.util.InsertThreeScrewMachineThread;
import com.flyusoft.apps.jointoil.util.InsertTwoBoosterCompressorThread;
import com.flyusoft.apps.jointoil.util.InsertTwoScrewMachineThread;
import com.flyusoft.apps.jointoil.util.JointOilInitentity;
import com.google.common.collect.Lists;

public class ChangeData {
	public static int round = 0;

	@Autowired
	private CompressorDataService compressorDataService;
	@Autowired
	private OneIntegratedMachineService oneIntegratedMachineService;
	@Autowired
	private FourIntegratedMachineService fourIntegratedMachineService;
	@Autowired
	private MachineRoomMonitorDataService machineRoomMonitorDataService;
	@Autowired
	private TwoScrewMachineService twoScrewMachineService;
	@Autowired
	private TwoBoosterCompressorService twoBoosterCompressorService;
	@Autowired
	private ThreeBoosterCompressorService threeBoosterCompressorService;
	@Autowired
	private ThreeScrewMachineService threeScrewMachineService;
	@Autowired
	private FiveBoosterCompressorService fiveBoosterCompressorService;
	@Autowired
	private FiveScrewMachineService fiveScrewMachineService;

	public void change() {
		JointOilInitentity jointOilInitentity = JointOilInitentity
				.getInstance();
		List<Compressor> compressorList = Lists.newArrayList();
		List<MachineRoom> machineRoomList = jointOilInitentity
				.getMachineRoomList();
		for (MachineRoom machineRoom : machineRoomList) {
			if (machineRoom.getRoomNo().equals("MR1")
					|| machineRoom.getRoomNo().equals("MR4")) {
				compressorList.addAll(machineRoom.getCompressors());
			}
		}
		if (round == 0) {
			round = compressorDataService.getMaxRoundInteger().intValue();
		}
		List<CompressorData> cdList = compressorDataService
				.getCompressorDataByRound(round);

		// -----判断是否等于查完整22条 ,如何完整进行 插入数据 round +1
		List<OneIntegratedMachine> oneList = new ArrayList<OneIntegratedMachine>();// 一机房压缩机
		List<FourIntegratedMachine> fourList = new ArrayList<FourIntegratedMachine>();// 四机房压缩机
		List<MachineRoomMonitorData> roomMonitorDataList = new ArrayList<MachineRoomMonitorData>();// 机房list
		 List<TwoScrewMachine> twoScrewList=new ArrayList<TwoScrewMachine>();//二机房螺杆机
		List<TwoBoosterCompressor> twoBoosterList = new ArrayList<TwoBoosterCompressor>();// 二机房增压机
		List<ThreeScrewMachine> threeScrewList = new ArrayList<ThreeScrewMachine>();// 三机房螺杆机
		List<ThreeBoosterCompressor> threeBoosterList = new ArrayList<ThreeBoosterCompressor>();// 三机房增压机
		List<FiveScrewMachine> fiveScrewList = new ArrayList<FiveScrewMachine>();// 五机房螺杆机
		List<FiveBoosterCompressor> fiveBoosterList = new ArrayList<FiveBoosterCompressor>();// 五机房增压机
		if (cdList != null && cdList.size() == 32) {
			int tmp = 1;
			for (int i = 1; i <= 16; i++) {
				
				String adconverterNum1 = tmp + "";
				CompressorData cd1 = getCompressorDataByAdconverter(cdList,
						adconverterNum1);
				tmp++;
				String adconverterNum2 = tmp + "";
				CompressorData cd2 = getCompressorDataByAdconverter(cdList,
						adconverterNum2);
				tmp++;
				if (cd1 == null) {
					cd1 = new CompressorData();
				}
				if (cd2 == null) {
					cd2 = new CompressorData();
				}
				if (i <= 4) {// 一机房前4台压缩机
					if (cd1 != null && cd2 != null) {
						OneIntegratedMachine oneIntegratedMachine = new OneIntegratedMachine();
						oneIntegratedMachine.setOilPressure(cd1.getHole1());
						oneIntegratedMachine.setCoolingWaterPressure(cd1
								.getHole2());
						oneIntegratedMachine.setScrewPressure(cd1.getHole3());
						oneIntegratedMachine
								.setScrewTemperature(cd2.getHole1()==null?null: cd2.getHole1() - 4D );
						oneIntegratedMachine.setFirstPistonPressure(cd1
								.getHole4());
						oneIntegratedMachine.setFirstPistonTemperature(cd2.getHole2()==null?null: cd2
								.getHole2() - 4D );
						oneIntegratedMachine.setSecondPistonPressure(cd1
								.getHole5());
						oneIntegratedMachine.setSecondPistonTemperature(cd2.getHole3()==null?null: cd2
								.getHole3() - 4D );
						oneIntegratedMachine.setThirdPistonPressure(cd1
								.getHole6());
						oneIntegratedMachine.setThirdPistonTemperature(cd2.getHole4()==null?null: cd2
								.getHole4() - 4D );
						oneIntegratedMachine.setOilTemperature(cd2.getHole6()==null?null:cd2.getHole6() - 4D );
						oneIntegratedMachine.setCoolingWaterTemperature(cd2.getHole5()==null?null: cd2
								.getHole5() - 4D );
						oneIntegratedMachine.setTime(cd1.getMonitorTime());
						oneIntegratedMachine.setCompressorCode("J1-Y" + i);
						oneList.add(oneIntegratedMachine);
					}
				}
				if (i == 5) {// 一机房第5台压缩机
					if (cd1 != null && cd2 != null) {
						OneIntegratedMachine oneIntegratedMachine = new OneIntegratedMachine();
						MachineRoomMonitorData machineRoomMonitorData = new MachineRoomMonitorData();
						oneIntegratedMachine.setOilPressure(cd1.getHole1());
						oneIntegratedMachine.setCoolingWaterPressure(cd1
								.getHole2());
						oneIntegratedMachine.setScrewPressure(cd1.getHole3());
						oneIntegratedMachine
								.setScrewTemperature(cd2.getHole1()==null?null: cd2.getHole1() - 4D );
						oneIntegratedMachine.setFirstPistonPressure(cd1
								.getHole4());
						oneIntegratedMachine.setFirstPistonTemperature(cd2.getHole2()==null?null: cd2
								.getHole2() - 4D );
						oneIntegratedMachine.setSecondPistonPressure(cd1
								.getHole5());
						oneIntegratedMachine.setSecondPistonTemperature(cd2.getHole3()==null?null: cd2
								.getHole3() - 4D );
						oneIntegratedMachine.setThirdPistonPressure(cd1
								.getHole6());
						oneIntegratedMachine.setThirdPistonTemperature(cd2.getHole4()==null?null: cd2
								.getHole4() - 4D );
						oneIntegratedMachine.setOilTemperature(cd2.getHole6()==null?null: cd2.getHole6() - 4D );
						oneIntegratedMachine.setCoolingWaterTemperature(cd2.getHole5()==null?null: cd2
								.getHole5() - 4D );
						oneIntegratedMachine.setCompressorCode("J1-Y" + i);
						oneIntegratedMachine.setTime(cd1.getMonitorTime());

						machineRoomMonitorData.setConvergePipePressure(cd1
								.getHole7());
						machineRoomMonitorData
								.setConvergePipeCoolingWaterPressure(cd1
										.getHole8());
						machineRoomMonitorData.setConvergePipeTemperature(cd2.getHole7()==null?null: cd2
								.getHole7() - 4D );
						machineRoomMonitorData
								.setConvergePipeCoolingWaterTemperature(cd2.getHole8()==null?null: cd2
										.getHole8() - 4D );
						machineRoomMonitorData.setTime(cd1.getMonitorTime());
						machineRoomMonitorData.setRoomNo("MR1");

						oneList.add(oneIntegratedMachine);
						roomMonitorDataList.add(machineRoomMonitorData);
					}
				}
				if (i == 6) {// 四机房最后一台压缩机
					if (cd1 != null && cd2 != null) {
						FourIntegratedMachine fourIntegratedMachine = new FourIntegratedMachine();
						MachineRoomMonitorData machineRoomMonitorData = new MachineRoomMonitorData();

						fourIntegratedMachine.setOilPressure(cd1.getHole1());
						fourIntegratedMachine.setCoolingWaterPressure(cd1
								.getHole2());
						fourIntegratedMachine.setScrewPressure(cd1.getHole3());
						fourIntegratedMachine.setScrewTemperature(cd2.getHole1()==null?null: cd2
								.getHole1() - 4D );
						fourIntegratedMachine.setFirstPistonPressure(cd1
								.getHole4());
						fourIntegratedMachine.setFirstPistonTemperature(cd2.getHole2()==null?null: cd2
								.getHole2() - 4D );
						fourIntegratedMachine.setSecondPistonPressure(cd1
								.getHole5());
						fourIntegratedMachine.setSecondPistonTemperature(cd2.getHole3()==null?null: cd2
								.getHole3() - 4D );
						fourIntegratedMachine.setOilTemperature(cd2.getHole5()==null?null: cd2.getHole5() - 4D );
						fourIntegratedMachine.setCoolingWaterTemperature(cd2.getHole4()==null?null: cd2
								.getHole4() - 4D );
						fourIntegratedMachine.setCompressorCode("J4-Y6");
						fourIntegratedMachine.setTime(cd1.getMonitorTime());
						machineRoomMonitorData.setConvergePipeCoolingWaterPressure(cd1.getHole7());
						machineRoomMonitorData.setConvergePipeCoolingWaterTemperature(cd2.getHole7()==null?null: cd2.getHole7() - 4D );
						machineRoomMonitorData.setTime(cd1.getMonitorTime());
						machineRoomMonitorData.setRoomNo("MR4");
						fourList.add(fourIntegratedMachine);
						roomMonitorDataList.add(machineRoomMonitorData);
					}
				}
				if (i > 6 && i <= 11) {// 四机房后前5台压缩机
					if (cd1 != null && cd2 != null) {
						FourIntegratedMachine fourIntegratedMachine = new FourIntegratedMachine();

						fourIntegratedMachine.setOilPressure(cd1.getHole1());
						fourIntegratedMachine.setCoolingWaterPressure(cd1
								.getHole2());
						fourIntegratedMachine.setScrewPressure(cd1.getHole3());
						fourIntegratedMachine.setScrewTemperature(cd2.getHole1()==null?null: cd2
								.getHole1() - 4D );
						fourIntegratedMachine.setFirstPistonPressure(cd1
								.getHole4());
						fourIntegratedMachine.setFirstPistonTemperature(cd2.getHole2()==null?null: cd2
								.getHole2() - 4D );
						fourIntegratedMachine.setSecondPistonPressure(cd1
								.getHole5());
						fourIntegratedMachine.setSecondPistonTemperature(cd2.getHole3()==null?null: cd2
								.getHole3() - 4D );
						fourIntegratedMachine.setOilTemperature(cd2.getHole5()==null?null: cd2.getHole5() - 4D );
						fourIntegratedMachine.setCoolingWaterTemperature(cd2.getHole4()==null?null: cd2
								.getHole4() - 4D );
						int is_i=i;//因为机房弄反了。所以从新定义对应关系。
						if(is_i==7){
							fourIntegratedMachine.setCompressorCode("J4-Y5");
						}
						if(is_i==8){
							fourIntegratedMachine.setCompressorCode("J4-Y4");
						}
						if(is_i==9){
							fourIntegratedMachine.setCompressorCode("J4-Y3");
						}
						if(is_i==10){
							fourIntegratedMachine.setCompressorCode("J4-Y2");
						}
						if(is_i==11){
							fourIntegratedMachine.setFirstPistonTemperature(fourIntegratedMachine.getFirstPistonTemperature()==null?null:fourIntegratedMachine.getFirstPistonTemperature()-4D);
							fourIntegratedMachine.setSecondPistonTemperature(fourIntegratedMachine.getSecondPistonTemperature()==null?null:fourIntegratedMachine.getSecondPistonTemperature()+4D);
							fourIntegratedMachine.setScrewTemperature(fourIntegratedMachine.getScrewTemperature()==null?null:fourIntegratedMachine.getScrewTemperature()-4D);
							fourIntegratedMachine.setCompressorCode("J4-Y1");
						}
						
						fourIntegratedMachine.setTime(cd1.getMonitorTime());
						fourList.add(fourIntegratedMachine);
					}
				}
				if (i == 12) {// 二机房
					if (cd1 != null && cd2 != null) {
						TwoBoosterCompressor twoBoosterCompressor = new TwoBoosterCompressor();
						TwoScrewMachine  twoScrewMachine = new TwoScrewMachine();
						twoBoosterCompressor.setInletPressure(cd1.getHole1());
						twoBoosterCompressor.setFirstPistonPressure(cd1
								.getHole2());
						twoBoosterCompressor.setSecondPistonPressure(cd1
								.getHole3());
						twoBoosterCompressor.setThirdPistonPressure(cd1
								.getHole4());
						twoBoosterCompressor.setOilPressure(cd1.getHole5());
						twoBoosterCompressor.setFirstPistonTemperature(cd2.getHole1()==null?null: cd2
								.getHole1() - 8D );
						twoBoosterCompressor.setSecondPistonTemperature(cd2.getHole2()==null?null: cd2
								.getHole2() - 8D );
						twoBoosterCompressor.setThirdPistonTemperature(cd2.getHole3()==null?null: cd2
								.getHole3() - 8D );
						twoBoosterCompressor.setOilTemperature(cd2.getHole4()==null?null: cd2.getHole4() - 8D );
						twoBoosterCompressor.setCompressorCode("J2-Y1");
						twoBoosterCompressor.setTime(cd1.getMonitorTime());
						
						
						twoScrewMachine.setOutScrewTemperature1(cd2.getHole5()==null?null: cd2.getHole5() - 8D);//后加的
						twoScrewMachine.setOutScrewTemperature2(cd2.getHole6()==null?null: cd2.getHole6() - 8D);
						twoScrewMachine.setCompressorCode("J2-L1");
						twoScrewMachine.setTime(cd2.getMonitorTime());
						
						twoBoosterList.add(twoBoosterCompressor);
						twoScrewList.add(twoScrewMachine);
					}
				}
				if (i == 13 || i == 14) {// 三机房
					if (cd1 != null && cd2 != null) {
						ThreeBoosterCompressor threeBoosterCompressor = new ThreeBoosterCompressor();
						ThreeScrewMachine threeScrewMachine = new ThreeScrewMachine();
						threeScrewMachine.setOilPressure(cd1.getHole1());
						threeScrewMachine.setExhaustPressure(cd1.getHole2());
						threeScrewMachine.setOilTemperature(cd2.getHole1()==null?null: cd2.getHole1() - 8D );
						threeScrewMachine.setExhaustTemperature(cd2.getHole2()==null?null: cd2.getHole2() - 8D );
						threeScrewMachine.setCompressorCode("J3-L" + (i - 12));
						threeScrewMachine.setTime(cd1.getMonitorTime());

						threeBoosterCompressor.setOilPressure(cd1.getHole3());
						threeBoosterCompressor.setFirstPistonPressure(cd1
								.getHole4());
						threeBoosterCompressor.setSecondPistonPressure(cd1
								.getHole5());
						threeBoosterCompressor
								.setOilTemperature(cd2.getHole3()==null?null: cd2.getHole3() - 2D );
						threeBoosterCompressor.setFirstPistonTemperature(cd2.getHole4()==null?null: cd2
								.getHole4() - 8D );
						threeBoosterCompressor.setSecondPistonTemperature(cd2.getHole5()==null?null: cd2
								.getHole5() - 8D );
						threeBoosterCompressor.setCompressorCode("J3-Y"
								+ (i - 12));
						threeBoosterCompressor.setTime(cd1.getMonitorTime());

						threeBoosterList.add(threeBoosterCompressor);
						threeScrewList.add(threeScrewMachine);
					}
				}
				if (i == 15 || i == 16) {// 五机房
					if (cd1 != null && cd2 != null) {
						FiveBoosterCompressor fiveBoosterCompressor = new FiveBoosterCompressor();
						FiveScrewMachine fiveScrewMachine = new FiveScrewMachine();

						fiveBoosterCompressor.setOilPressure(cd1.getHole1());
						fiveBoosterCompressor.setFirstPistonPressure(cd1
								.getHole2());
						fiveBoosterCompressor.setSecondPistonPressure(cd1
								.getHole3());
						fiveBoosterCompressor.setFirstExhaustTemperature(cd2.getHole3()==null?null: cd2
								.getHole3() - (8D+25D) );
						fiveBoosterCompressor.setSecondInletTemperature(cd2.getHole4()==null?null: cd2
								.getHole4() - 8D );
						fiveBoosterCompressor.setSecondExhaustTemperature(cd2.getHole5()==null?null: cd2
								.getHole5() - (8D+8D) );
						fiveBoosterCompressor.setOilTemperature(cd2.getHole6()==null?null: cd2.getHole6() - 8D );
						
						fiveBoosterCompressor.setInletPressure(cd1.getHole4());
						fiveBoosterCompressor.setInletTemperature(cd2.getHole2()==null?null: cd2.getHole2() - 8D);
						
				
						fiveBoosterCompressor.setTime(cd1.getMonitorTime());

						fiveScrewMachine.setBearingTemperature(cd2.getHole1()==null?null: cd2.getHole1() - 8D );
						fiveScrewMachine.setOutScrewTemperature1(cd2.getHole7()==null?null: cd2.getHole7() - 0D );//不减了
						fiveScrewMachine.setOutScrewTemperature2(cd2.getHole8()==null?null: cd2.getHole8() - 0D );
						
						
						fiveScrewMachine.setTime(cd1.getMonitorTime());
						
						if(i==15){
							fiveBoosterCompressor.setCompressorCode("J5-Y2");
							fiveScrewMachine.setCompressorCode("J5-L2");
						}
						if(i==16){
							fiveBoosterCompressor.setCompressorCode("J5-Y1");
							fiveScrewMachine.setCompressorCode("J5-L1");
						}
						fiveBoosterList.add(fiveBoosterCompressor);
						fiveScrewList.add(fiveScrewMachine);
					}
				}

			}
			round++;
			if (oneList.size() > 0) {
				InsertOneIntegratedMachineThread oneThread = new InsertOneIntegratedMachineThread(
						oneIntegratedMachineService, oneList);
				InsertFourIntegratedMachineThread fourThread = new InsertFourIntegratedMachineThread(
						fourIntegratedMachineService, fourList);
				InsertMachineRoomMonitorDataThread roomThread = new InsertMachineRoomMonitorDataThread(
						machineRoomMonitorDataService, roomMonitorDataList);
				InsertTwoScrewMachineThread twoScrewThread = new InsertTwoScrewMachineThread(
						twoScrewMachineService, twoScrewList);// 后加d   new class 
				InsertTwoBoosterCompressorThread twoBoosterThread = new InsertTwoBoosterCompressorThread(
						twoBoosterCompressorService, twoBoosterList);
				InsertThreeBoosterCompressorThread threeBoosterThread = new InsertThreeBoosterCompressorThread(
						threeBoosterCompressorService, threeBoosterList);
				InsertThreeScrewMachineThread threeScrewThread = new InsertThreeScrewMachineThread(
						threeScrewMachineService, threeScrewList);
				InsertFiveBoosterCompressorThread fiveBoosterThread = new InsertFiveBoosterCompressorThread(
						fiveBoosterCompressorService, fiveBoosterList);
				InsertFiveScrewMachineThread fiveScrewThread = new InsertFiveScrewMachineThread(
						fiveScrewMachineService, fiveScrewList);

				Thread one = new Thread(oneThread);
				Thread four = new Thread(fourThread);
				Thread room = new Thread(roomThread);
				Thread twoBooster = new Thread(twoBoosterThread);
				Thread twoScrew = new Thread(twoScrewThread);// 后加d 
				Thread threeBooster = new Thread(threeBoosterThread);
				Thread threeScrew = new Thread(threeScrewThread);
				Thread fiveBooster = new Thread(fiveBoosterThread);
				Thread fiveScrew = new Thread(fiveScrewThread);

				one.start();
				four.start();
				room.start();
				twoBooster.start();
				twoScrew.start();// 后加d 
				threeBooster.start();
				threeScrew.start();
				fiveBooster.start();
				fiveScrew.start();
			}

		}

	}

	/**
	 * 通过adconvernum获取对象
	 * 
	 * @param _cdList
	 * @param _adconverterNum
	 * @return
	 */
	private CompressorData getCompressorDataByAdconverter(
			List<CompressorData> _cdList, String _adconverterNum) {
		for (CompressorData compressorData : _cdList) {
			if (compressorData.getAdconverterNum().trim()
					.equals(_adconverterNum)) {
				return compressorData;
			}
		}
		return null;
	}
}
