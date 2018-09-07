package com.example.service;

import java.util.Map;

import net.sf.jasperreports.engine.JRDataSource;

public interface JasperReportsService {
	
	public byte[] generatePDFLabel( Map<String, Object> params,
		    JRDataSource dataSource);

}
