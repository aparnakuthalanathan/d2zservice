package com.example.service;

import java.util.List;

import com.example.model.SenderData;

public interface LabelService {

	public byte[] generateLabel (List<SenderData> senderData);

}
