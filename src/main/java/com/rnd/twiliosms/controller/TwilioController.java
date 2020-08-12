package com.rnd.twiliosms.controller;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rnd.twiliosms.models.SmsSender;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

@RestController
@RequestMapping("/api")
public class TwilioController {

	@Value("${twilio.trial-number}")
	private PhoneNumber twilioNumber;	
	@Value("${twilio.account-sid}")
	private String accountSid;
	@Value("${twilio.auth-token}")
	private String authToken;
		
//	Code for sending message to a person
	@PostMapping("/sendMessage")
	public HashMap<String, Object> sendMessage(@RequestBody SmsSender smsSender) {
		HashMap<String, Object> mapResult = new HashMap<String, Object>();
		
		Twilio.init(accountSid, authToken);
		
		Message message = Message
	            .creator(smsSender.getToPhoneNumbers(), twilioNumber, smsSender.getBody())
	            .create();
	    
	    mapResult.put("message", "Sms has been send");
	    mapResult.put("data", message.getSid());
	return mapResult;
	}
	
//	Code for sending message to more person
	@PostMapping("/sendMessage/more")
	public HashMap<String, Object> sendMessageToMore(@RequestBody SmsSender ...smsSenders) {
		HashMap<String, Object> mapResult = new HashMap<String, Object>();
		ArrayList<SmsSender> listMessage = new ArrayList<SmsSender>();
		Twilio.init(accountSid, authToken);
		
		for (SmsSender sms : smsSenders) {
			
			Message message = Message
		            .creator(sms.getToPhoneNumbers(), twilioNumber, sms.getBody())
		            .create();
			listMessage.add(sms);
			
		mapResult.put("data", message.getSid());
		}
		
		 mapResult.put("message", "Sms has been send");		 
		 mapResult.put("total", listMessage.size());
	return mapResult;
	}
}
