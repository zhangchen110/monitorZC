package com.flyusoft.apps.jointoil.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.flyusoft.apps.jointoil.dao.ReportHtmlDao;
import com.flyusoft.apps.jointoil.entity.ReportHtml;
import com.flyusoft.apps.jointoil.service.ReportHtmlService;

@Service
@Transactional
public class ReportHtmlServiceImpl  implements ReportHtmlService{	
	
	@Autowired
	public ReportHtmlDao reportHtmlDao;

		
	@Override
	@Transactional(readOnly = true)
	public ReportHtml getReportHtml(String id) {
		return reportHtmlDao.get(id);
	}


	@Override
	public void saveReportHtml(ReportHtml reportHtml) {
		reportHtmlDao.save(reportHtml);
	}


	@Override
	public void deleteReportHtml(String id) {
		reportHtmlDao.delete(id);
	}


	@Override
	@Transactional(readOnly=true)
	public ReportHtml getReportHtmlList(String wellNo, String reporttime) {
		List<ReportHtml> list=reportHtmlDao.getReportHtmlList(wellNo, reporttime );
		ReportHtml report =new ReportHtml() ;
		if(list.size()>0){
			report=list.get(0);
		}
		return report;
	}

 
	

}
