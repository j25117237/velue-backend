package com.velue.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.razorpay.Order;
import com.razorpay.RazorpayException;
import com.velue.dto.RazorpayOrder;
import com.velue.services.RazorpayService;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/razorpay")
//@CrossOrigin(origins = "http://localhost:3000") // Add your React frontend URL

public class RazorpayController {

    @Autowired
    private RazorpayService razorpayService;

    @PostMapping("/create-order")
    public ResponseEntity<Map<String, Object>> createOrder(@RequestBody RazorpayOrder order) {
        try {
            RazorpayOrder createdOrder = razorpayService.createPaymentOrder(order);

            Map<String, Object> response = new HashMap<>();
            response.put("orderId", createdOrder.getOrderId());
            response.put("amount", createdOrder.getAmount());
            response.put("currency", createdOrder.getCurrency());

            return ResponseEntity.ok(response);
        } catch (RazorpayException e) {
            // Handle RazorpayException
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
