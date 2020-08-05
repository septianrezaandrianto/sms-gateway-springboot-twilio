package com.rnd.twiliosms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

@SpringBootApplication
public class TwilioSmsApplication {

	public static void main(String[] args) {	
		
		String ACCOUNT_SID = "AC98d261a0ad459fd7a2328b870033cd83";
		String AUTH_TOKEN = "cde3612cac619779939f3998ae92f5a0";
		
		    Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
		
		    Message message = Message
		            .creator(new PhoneNumber("+62 858-1331-0276"), // to
		                    new PhoneNumber("+14242503284"), // from
		                    "Tes sms gateway")
		            .create();
		
		    System.out.println(message.getSid());		    
		
		SpringApplication.run(TwilioSmsApplication.class, args);
	}
}
