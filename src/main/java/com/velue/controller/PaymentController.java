package com.velue.controller;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.razorpay.Payment;
import com.razorpay.RazorpayException;
import com.razorpay.Refund;
import com.velue.RequestBody.PaymentRequest;
import com.velue.RequestBody.RefundRequest;
import com.velue.services.PaymentService;

@RestController
@RequestMapping("/orders")
@CrossOrigin(origins = "http://localhost:3000") // Add your React frontend URL

public class PaymentController {

	PaymentService paymentService;

	@Autowired
	public PaymentController(PaymentService paymentService) {
		this.paymentService = paymentService;
	}

	@PostMapping("/{orderId}/pay")
	public ResponseEntity<?> createPayment(@PathVariable("orderId") String orderId,
			@RequestBody PaymentRequest paymentRequest) {
		try {
			Payment payment = paymentService.createPayment(paymentRequest.getAmount(), orderId,
					paymentRequest.getRedirectUrl());
			return ResponseEntity.ok().body(payment);
		} catch (RazorpayException e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
	}

	@PostMapping("/capture")
	public ResponseEntity<Void> capturePayment(@RequestParam("orderId") String orderId,
			@RequestParam("paymentId") String paymentId) throws RazorpayException {
		paymentService.capturePayment(orderId, paymentId);
		return ResponseEntity.ok().build();
	}

	@PostMapping("/create")
	public ResponseEntity<String> generatePayment(@RequestParam("orderId") String orderId,
			@RequestParam("amount") BigDecimal amount, @RequestParam("redirectUrl") String redirectUrl)
			throws RazorpayException {
		String paymentId = paymentService.generateOrder(amount, orderId, redirectUrl);
		return ResponseEntity.ok(paymentId);
	}

	@GetMapping("/{orderId}/verify-payment")
	public ResponseEntity<?> verifyPayment(@PathVariable("orderId") String orderId,
			@RequestParam("payment_id") String paymentId, @RequestParam("payment_signature") String paymentSignature) {
		try {
			Payment payment = paymentService.getPaymentById(paymentId);
			boolean isSignatureValid = true;
			// = SignatureValidator.verifyPaymentSignature(payment.toMap(),
			// paymentSignature, "<your_razorpay_webhook_secret>");
			if (isSignatureValid) {
				// update order status as paid
				return ResponseEntity.ok().build();
			} else {
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid payment signature");
			}
		} catch (RazorpayException e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());

		}

	}

	@PostMapping("/{orderId}/refund")
	public ResponseEntity<?> refundPayment(@PathVariable("orderId") String orderId,
			@RequestParam("payment_id") String paymentId, @RequestBody RefundRequest refundRequest) {
		try {
			Refund refund = paymentService.refundPayment(paymentId, refundRequest.getAmount());
			// update order status as refunded
			return ResponseEntity.ok().body(refund);
		} catch (RazorpayException e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
	}
}
