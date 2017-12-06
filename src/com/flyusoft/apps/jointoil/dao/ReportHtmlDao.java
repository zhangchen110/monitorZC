package com.flyusoft.apps.jointoil.dao;

import java.util.List;

import com.flyusoft.apps.jointoil.entity.ReportHtml;
import com.flyusoft.common.dao.BaseDao;

public interface ReportHtmlDao  extends BaseDao<ReportHtml, String>{

	public List getReportHtmlList(String wellNo, String reporttime);

}
