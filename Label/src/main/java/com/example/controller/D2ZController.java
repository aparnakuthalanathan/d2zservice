package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.SenderData;
import com.example.service.LabelService;


@RestController
@RequestMapping("/v1")
public class D2ZController {

	@Autowired
    private LabelService labelService;
	 
	
	@RequestMapping( method = RequestMethod.POST, path = "/generateLabel")
	public ResponseEntity<byte[]> generateLabel(@RequestBody List<SenderData> senderData) {
		
		byte[] bytes = labelService.generateLabel(senderData);
	    return ResponseEntity
	      .ok()
	      // Specify content type as PDF
	      .header("Content-Type", "application/pdf; charset=UTF-8")
	      // Tell browser to display PDF if it can
	      .header("Content-Disposition", "inline; filename=\"Label.pdf\"")
	      .body(bytes);
    }
}
