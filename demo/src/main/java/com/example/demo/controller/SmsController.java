package com.example.demo.controller;




import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Sms;
import com.example.demo.model.SmsMaster;

import com.example.demo.service.CustomErrorType;
import com.example.demo.service.SmsMasterService;
import com.example.demo.service.SmsService;



@RequestMapping("/Sms")
@RestController
public class SmsController {

	@Autowired
	SmsService smsService;
	
	@Autowired
	SmsMasterService smsMasterService;
	
	
	

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@PostMapping(value = "/verifyTeplate/")
	public ResponseEntity<?> verifyNotification(@RequestBody Sms track ) 
	{
		try {
			
		
		int id=track.getTokenid();
		String mob=track.getMob();
		String template=track.getTemplatemsg();
		Map<Integer,SmsMaster> result=smsMasterService.getAvailableNotification(track.getTokenid());
		
		if ( mob.equalsIgnoreCase(result.get(id).getMob()) && template.equalsIgnoreCase(result.get(id).getSms_template()))
		{
			smsService.sendSMS(result.get(id).getMob() ,result.get(id).getSms_template(),result.get(id).getSms_event_id());
			return new ResponseEntity(new CustomErrorType("Success","SMS Notification is sent !!!!!!"),HttpStatus.OK);
		}
		
		return new ResponseEntity(new CustomErrorType("Success","SMS Notification is Verified but not sent due to wrong Api !!!!!!"),HttpStatus.OK);
		}
		catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity(new CustomErrorType("Fail","Error....please check your code.."+e),HttpStatus.OK);
		}
	}
	

}