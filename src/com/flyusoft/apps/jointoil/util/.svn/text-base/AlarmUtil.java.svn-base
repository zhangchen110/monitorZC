package com.flyusoft.apps.jointoil.util;

import com.flyusoft.apps.jointoil.entity.Index;
/**
 * 报警工具类
 * @author Administrator
 *
 */
public class AlarmUtil {
	/**
	 * 判断是否为报警
	 * @param value
	 * @param index
	 * @return
	 */
	public boolean isAlarming(Double value, Index index) {
		if (index.getStatus().intValue() == 0) {
			return (value < index.getMinLimit() || value > index
					.getMaxLimit()) ? true : false;
		} else {
			return false;
		}
	}
}
