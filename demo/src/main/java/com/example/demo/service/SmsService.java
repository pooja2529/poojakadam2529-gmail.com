package com.example.demo.service;



import java.net.URI;


import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;





@Service
public class SmsService {

	
	 public  final String REST_SERVICE_URI = "http://localhost:8087/SpringBootRestApi/api";
	  
	  public  final String source="9136578317";
	  public final String username="Admin";
	  public  final String password="admin@123";
	  public  void sendSMS(String mob,String message,int eventid)  {
	      
	        RestTemplate restTemplate = new RestTemplate();
	       // SmsTracker sms=new SmsTracker(1 , "9136578317", "hiiii", "send", "img.jpf", 1, 1, "", 2, "", "", "");
	    
	    	  

	        URI uri = restTemplate.postForLocation(REST_SERVICE_URI+"/sendSms/",username,password,source,mob,message);
	        System.out.println("Location : "+uri.toASCIIString());
	      
	      
	    }

}
