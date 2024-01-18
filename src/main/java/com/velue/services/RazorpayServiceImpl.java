package com.velue.services;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.razorpay.Order;
import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;
import com.velue.dto.PaymentOrder;
import com.velue.dto.RazorpayOrder;

import java.util.HashMap;
import java.util.Map;

@Service
public class RazorpayServiceImpl implements RazorpayService {

    @Value("${razorpay.api.key}")
    private String apiKey;

    @Value("${razorpay.api.secret}")
    private String apiSecret;

    @Override
    public RazorpayOrder createPaymentOrder(RazorpayOrder order) throws RazorpayException {
        try {
            RazorpayClient razorpayClient = new RazorpayClient(apiKey, apiSecret);

            JSONObject orderRequest = new JSONObject();
            orderRequest.put("amount", order.getAmount() * 100); // Amount in paise
            orderRequest.put("amount", order.getAmount() ); // Amount in rupees

            orderRequest.put("currency", order.getCurrency());
            orderRequest.put("receipt", order.getOrderId());
            orderRequest.put("payment_capture", 1); // Auto-capture


            Order createdOrder = razorpayClient.orders.create(orderRequest);
            System.out.println("==jagan createdOrder=="+createdOrder);

            return convertToRazorpayOrder(createdOrder);
        } catch (RazorpayException e) {
            throw new RazorpayException("Error creating payment order", e);
        }
    }

    private RazorpayOrder convertToRazorpayOrder(Order razorpayOrder) {
        RazorpayOrder result = new RazorpayOrder();
        result.setOrderId(razorpayOrder.get("id"));
        result.setAmount(Long.valueOf(razorpayOrder.get("amount").toString()));
        result.setCurrency(razorpayOrder.get("currency").toString());
        // Set other attributes as needed
        return result;
    }
}