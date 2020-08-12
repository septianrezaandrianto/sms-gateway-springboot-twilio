package com.rnd.twiliosms.models;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import com.twilio.type.PhoneNumber;

@Configuration
@ConfigurationProperties("twilio")
public class SmsSender {

	private PhoneNumber toPhoneNumbers;	
	private String body;
	
	public PhoneNumber getToPhoneNumbers() {
		return toPhoneNumbers;
	}
	public void setToPhoneNumbers(PhoneNumber toPhoneNumbers) {
		this.toPhoneNumbers = toPhoneNumbers;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	
		
}
