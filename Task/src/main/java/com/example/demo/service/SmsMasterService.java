package com.example.demo.service;


import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.SmsMaster;
import com.example.demo.repository.SmsRepository;


@Service
public class SmsMasterService {
	
	@Autowired
	SmsRepository smsRepo;

	public SmsMaster getSmsTemplate(int sms_event_id) {
		return smsRepo.findById(sms_event_id).orElse(null);
	}

	public Map<Integer,SmsMaster> getAvailableNotification(int sms_event_id)
	{
		Map<Integer,SmsMaster> result=new HashMap<Integer, SmsMaster>();
		
		SmsMaster validNotification=getSmsTemplate(sms_event_id);
		
		result.put(validNotification.getSms_event_id(), validNotification);
		
		return result;
		
	}
	
	
	
}

