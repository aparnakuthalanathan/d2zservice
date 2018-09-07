package com.example.serviceImpl;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.example.service.JasperReportsService;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRSaver;

@Service
public class JasperReportsServiceImpl implements JasperReportsService {

	@Override
	public byte[] generatePDFLabel(Map<String, Object> params, JRDataSource dataSource) {
		// TODO Auto-generated method stub
		byte[] bytes = null;
	    JasperReport jasperReport = null;
	    try (ByteArrayOutputStream byteArray = new ByteArrayOutputStream()) {
	    	
	  
	        String jrxml = "src/main/resources/eparcelLabel.jrxml";
	        jasperReport = JasperCompileManager.compileReport(jrxml);
	        // Save compiled report. Compiled report is loaded next time
	        JRSaver.saveObject(jasperReport, "label.jasper");
	      
	      JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, params, dataSource);
	      // return the PDF in bytes
	      bytes = JasperExportManager.exportReportToPdf(jasperPrint);
	    }
	    catch (JRException | IOException e) {
	      e.printStackTrace();
	    }
	    return bytes;
	  }


}
