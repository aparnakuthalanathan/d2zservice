package com.example.serviceImpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.SenderData;
import com.example.service.JasperReportsService;
import com.example.service.LabelService;

import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;



@Service
public class LabelServiceImpl implements LabelService{

	@Autowired
	JasperReportsService jasperService;
	
	@Override
	public byte[] generateLabel(List<SenderData> senderData) {
		// TODO Auto-generated method stub
		
		JRBeanCollectionDataSource beanColDataSource =
		         new JRBeanCollectionDataSource(senderData);
		 Map<String,Object> parameters = new HashMap<>();
		 
		 byte[] labelAsBytes = jasperService.generatePDFLabel(parameters, beanColDataSource);
		 
		return labelAsBytes;
	} 

	
}
