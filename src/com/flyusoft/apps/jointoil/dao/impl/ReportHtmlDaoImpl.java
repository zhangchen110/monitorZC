package com.flyusoft.apps.jointoil.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.flyusoft.apps.jointoil.dao.ReportHtmlDao;
import com.flyusoft.apps.jointoil.entity.MonitorData;
import com.flyusoft.apps.jointoil.entity.ReportHtml;
import com.flyusoft.common.dao.impl.BaseHibernateDaoImpl;

@Repository
public class ReportHtmlDaoImpl extends BaseHibernateDaoImpl<ReportHtml, String> implements ReportHtmlDao{
	private final static String QUERY_MONITORDATA_CLASS_REPORT_TIME = "  select r.* from fly_reporthtml r  where DATE_FORMAT(r.date, '%Y-%m-%d') = ? and   well_no = ?";

	@Override
	public List getReportHtmlList(String wellNo, String reporttime) {
		List<MonitorData> list = createSQLQuery(
				QUERY_MONITORDATA_CLASS_REPORT_TIME, reporttime,  wellNo)
				.addEntity(ReportHtml.class).list();
		return list;
	}

}
