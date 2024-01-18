package com.velue.services;

import java.math.BigDecimal;

import com.razorpay.Payment;
import com.razorpay.RazorpayException;
import com.razorpay.Refund;

public interface PaymentService {
	// razorpay
	public Payment createPayment(BigDecimal amount, String orderId, String redirectUrl) throws RazorpayException;

	// public Payment generatePayment (BigDecimal amount, String orderId , String
	// redirectUrl) throws RazorpayException;
	public Payment getPaymentById(String paymentId) throws RazorpayException;

	public Refund refundPayment(String paymentId, BigDecimal amount) throws RazorpayException;

	public void capturePayment(String orderId, String paymentId);

	public String generateOrder(BigDecimal amount, String orderId, String redirectUrl);

}
