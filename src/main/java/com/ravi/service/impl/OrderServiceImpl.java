package com.ravi.service.impl;

import org.json.JSONObject;
import org.springframework.stereotype.Service;

import com.ravi.model.TransactionDetailes;
import com.ravi.service.IOrderService;
import com.ravi.util.AppContants;
import com.razorpay.Order;
import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;
@Service

public class OrderServiceImpl implements IOrderService {

	
	public TransactionDetailes createTransaction(Double amount) throws RazorpayException {
	
		JSONObject ob=new JSONObject();
		ob.put("amount", (amount*100));
		ob.put("currency", "INR");
	
		RazorpayClient razorpayClient = new  RazorpayClient("rzp_test_MSiqoTHVW7H10i", "Npa6AGzHit0qB6MV3YFefyd4");
		Order order=razorpayClient.orders.create(ob);
		 
		TransactionDetailes prepareTransactionDetails = prepareTransactionDetails(order);
		return prepareTransactionDetails;
	}

	public TransactionDetailes prepareTransactionDetails(Order order) {
		String orderId = order.get("id");
		String currency=order.get("currency");
		Integer amount=order.get("amount");
		TransactionDetailes detailes=new TransactionDetailes(orderId, currency, amount,AppContants.KEY);
		
		return detailes;
	}
	
}
