package com.flyusoft.apps.jointoil.service;

import com.flyusoft.apps.jointoil.entity.ReportHtml;

public interface ReportHtmlService {

	public  ReportHtml getReportHtml(String id);

	public void saveReportHtml(ReportHtml reportHtml);

	public void deleteReportHtml(String id);

	public ReportHtml getReportHtmlList(String wellno, String reporttime);


}
