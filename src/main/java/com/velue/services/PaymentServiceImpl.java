package com.velue.services;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.json.JSONObject;
import org.springframework.stereotype.Service;

import com.razorpay.Payment;
import com.razorpay.PaymentClient;
import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;
import com.razorpay.Refund;

@Service
public class PaymentServiceImpl implements PaymentService {
	//razorpay


	public RazorpayClient razorpayClient;
	public PaymentClient Payments;

	@Override
	@SuppressWarnings("serial")
	public Payment createPayment(BigDecimal amount, String orderId, String redirectUrl) throws RazorpayException {
		Map<String, Object> options = new HashMap<>();
		options.put("amount", amount.multiply(new BigDecimal(100)).intValue());
		options.put("currency", "INR");
		options.put("receipt", orderId);
		options.put("payment_capture", 1);
		options.put("notes", new HashMap<String, String>() {{
			put("redirect_url", redirectUrl);
		}});
		//return razorpayClient.Payments.create(options);
		return razorpayClient.payments.createJsonPayment((JSONObject) options);

	}

	@SuppressWarnings("serial")
	public Payment generatePayment(BigDecimal amount, String orderId, String redirectUrl) throws RazorpayException {
		Map<String, Object> options = new HashMap<>();
		options.put("amount", amount.multiply(new BigDecimal(100)).intValue());
		options.put("currency", "INR");
		options.put("receipt", orderId);
		options.put("payment_capture", 1);
		options.put("notes", new HashMap<String, String>() {{
			put("redirect_url", redirectUrl);
		}});
		//return razorpayClient.Payments.create(options);
		return razorpayClient.payments.createJsonPayment((JSONObject) options);

	}

	@Override
	public Payment getPaymentById(String paymentId) throws RazorpayException {
		return razorpayClient.payments.fetch(paymentId);
	}

	@Override
	public Refund refundPayment(String paymentId, BigDecimal amount) throws RazorpayException {
		Map<String, Object> options = new HashMap<>();
		options.put("amount", amount.multiply(new BigDecimal(100)).intValue());
		return razorpayClient.payments.refund(paymentId, (JSONObject) options);
	}
	@Override
	public void capturePayment(String orderId, String paymentId) {
		// TODO Auto-generated method stub

	}
	@Override
	public String generateOrder(BigDecimal amount, String orderId, String redirectUrl) {
		// TODO Auto-generated method stub
		return null;
	}
}
