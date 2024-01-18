package com.velue.services;

import org.springframework.stereotype.Service;

import com.razorpay.Order;
import com.razorpay.RazorpayException;
import com.velue.dto.PaymentOrder;
import com.velue.dto.RazorpayOrder;

@Service
public interface RazorpayService {
    RazorpayOrder createPaymentOrder(RazorpayOrder order) throws RazorpayException;



    


}
