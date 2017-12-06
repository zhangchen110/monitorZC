package com.flyusoft.apps.jointoil.quartz;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.flyusoft.apps.jointoil.entity.Compressor;
import com.flyusoft.apps.jointoil.entity.CompressorData;
import com.flyusoft.apps.jointoil.service.CompressorDataService;
import com.flyusoft.apps.jointoil.service.CompressorService;
import com.flyusoft.apps.jointoil.service.FiveBoosterCompressorService;
import com.flyusoft.apps.jointoil.service.FiveScrewMachineService;
import com.flyusoft.apps.jointoil.service.FourIntegratedMachineService;
import com.flyusoft.apps.jointoil.service.OneIntegratedMachineService;
import com.flyusoft.apps.jointoil.service.ThreeBoosterCompressorService;
import com.flyusoft.apps.jointoil.service.ThreeScrewMachineService;
import com.flyusoft.apps.jointoil.service.TwoBoosterCompressorService;
import com.flyusoft.apps.jointoil.service.TwoScrewMachineService;

/**
 * 被Spring的Quartz MethodInvokingJobDetailFactoryBean定时执行的普通Spring Bean.
 */

public class QuartzJobCompressor {
	public TimerTools timertools = new TimerTools();

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
	@Autowired
	private CompressorService compressorService;
	@Autowired
	private CompressorDataService compressorDataService;
	public static int insertRound = 0;

	/**
	 * 定时打印当前用户数到日志.
	 */

	public void execute() {
		// new QuartzJob().execute();//存在事物的情况下才能进行增加删除修改查询操作// S 螺杆 B 增压 J1 和
		// J4 一体机
		List<Compressor> compressorList = compressorService.getAllCompressors();

		for (int i = 0; i < compressorList.size(); i++) {
			Compressor comp = compressorList.get(i);
			String code = comp.getCompressorCode();

			if (code.startsWith("J1")) {
				oneIntegratedMachineSave(code);
			}
			if (code.startsWith("J2-Y")) {
				twoBoosterCompressorSave(code);
			}
			if (code.startsWith("J2-L")) {
				twoScrewMachineSave(code);
			}
			if (code.startsWith("J3-Y")) {
				threeBoosterCompressorSave(code);
			}
			if (code.startsWith("J3-L")) {
				threeScrewMachineSave(code);
			}
			if (code.startsWith("J4")) {
				fourIntegratedMachineSave(code);
			}
			if (code.startsWith("J5-Y")) {
				fiveBoosterCompressorSave(code);
			}
			if (code.startsWith("J5-L")) {
				fiveScrewMachineSave(code);
			}
		}

	}

	public void insertCompressorMonitor() {
		if (insertRound == 0) {
			insertRound = compressorDataService.getMaxRoundInteger().intValue();
		}
		Double numDouble = 9.99;
		for (int i = 1; i <= 32; i++) {
			CompressorData cd = new CompressorData();
			cd.setAdconverterNum(i + "");
			cd.setHole1(Math.random() * 40 + numDouble);
			cd.setHole2(Math.random() * 40 + numDouble);
			cd.setHole3(Math.random() * 40 + numDouble);

			if (i <= 10) {
				cd.setHole4(Math.random() * 40 + numDouble);
				cd.setHole5(Math.random() * 40 + numDouble);
				cd.setHole6(Math.random() * 40 + numDouble);
				if (i == 9 || i == 10) {
					cd.setHole7(Math.random() * 40 + numDouble);
					cd.setHole8(Math.random() * 40 + numDouble);
				}
			}
			if (i == 11 || i == 12) {
				cd.setHole4(Math.random() * 40 + numDouble);
				cd.setHole5(Math.random() * 40 + numDouble);
				cd.setHole6(Math.random() * 40 + numDouble);
				cd.setHole7(Math.random() * 40 + numDouble);
			}
			if (i > 12 && i <= 23) {
				cd.setHole4(Math.random() * 40 + numDouble);
				cd.setHole5(Math.random() * 40 + numDouble);
			}
			if (i == 24) {
				cd.setHole4(Math.random() * 40 + numDouble);
			}
			if (i > 24 && i <= 28) {
				cd.setHole4(Math.random() * 40 + numDouble);
				cd.setHole5(Math.random() * 40 + numDouble);
			}
			if (i == 30 || i == 32) {
				cd.setHole4(Math.random() * 40 + numDouble);
				cd.setHole5(Math.random() * 40 + numDouble);
				cd.setHole6(Math.random() * 40 + numDouble);
			}
			cd.setMonitorTime(new Date());
			cd.setRound((insertRound) + 1);
			compressorDataService.insert(cd);
		}
		insertRound++;
	}

	public void oneIntegratedMachineSave(String compressorNo) {
		oneIntegratedMachineService.save(timertools
				.oneIntegratedMachinePojo(compressorNo));// 存储
	}

	public void twoBoosterCompressorSave(String compressorNo) {
		twoBoosterCompressorService.save(timertools
				.twoBoosterCompressorPojo(compressorNo));
	}

	public void twoScrewMachineSave(String compressorNo) {
		twoScrewMachineService.save(timertools
				.twoScrewMachinePojo(compressorNo));
	}

	public void threeBoosterCompressorSave(String compressorNo) {
		ThreeBoosterCompressorService.save(timertools
				.threeBoosterCompressorPojo(compressorNo));
	}

	public void threeScrewMachineSave(String compressorNo) {
		threeScrewMachineService.save(timertools
				.threeScrewMachinePojo(compressorNo));
	}

	public void fourIntegratedMachineSave(String compressorNo) {
		fourIntegratedMachineService.save(timertools
				.fourIntegratedMachinePojo(compressorNo));
	}

	public void fiveBoosterCompressorSave(String compressorNo) {
		fiveBoosterCompressorService.save(timertools
				.fiveBoosterCompressorPojo(compressorNo));
	}

	public void fiveScrewMachineSave(String compressorNo) {
		fiveScrewMachineService.save(timertools
				.fiveScrewMachinePojo(compressorNo));
	}
}
