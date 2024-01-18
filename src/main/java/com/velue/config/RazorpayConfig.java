package com.velue.config;

	import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;

import org.springframework.beans.factory.annotation.Value;
	import org.springframework.context.annotation.Bean;
	import org.springframework.context.annotation.Configuration;

	@Configuration
	public class RazorpayConfig {

	    @Value("${razorpay.api.key}")
	    private String apiKey;

	    @Value("${razorpay.api.secret}")
	    private String apiSecret;

	    @Bean
	    public RazorpayClient razorpayClient() {
	        try {
				return new RazorpayClient(apiKey, apiSecret);
			} catch (RazorpayException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
	    }
	}


