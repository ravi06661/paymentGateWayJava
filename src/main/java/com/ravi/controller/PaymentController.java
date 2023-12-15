package com.ravi.controller;

import java.util.Map;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ravi.model.TransactionDetailes;
import com.ravi.service.impl.OrderServiceImpl;
import com.razorpay.*;

@RestController
@RequestMapping("/user")
@CrossOrigin("*")
public class PaymentController {
	@Autowired
	private OrderServiceImpl impl;
	
	@PostMapping("/create_order")
	public ResponseEntity<?> createPayement(@RequestBody Map<String, Object> data) throws Exception{
		
		int amt=Integer.parseInt(data.get("amount").toString()) ;
		 RazorpayClient razorpayClient = new  RazorpayClient("rzp_test_MSiqoTHVW7H10i", "Npa6AGzHit0qB6MV3YFefyd4");
		JSONObject ob=new JSONObject();
		ob.put("amount", amt*100);
		ob.put("ecurrency", "INR");
		ob.put("recipt", "txn_123455");
		Order order=razorpayClient.orders.create(ob);
		 return ResponseEntity.ok(order.toString());
	}
	
	
	@GetMapping("/createTransaction/{amount}")
	public TransactionDetailes createTransaction(@PathVariable("amount") Double amount) throws RazorpayException {
		TransactionDetailes createTransaction = impl.createTransaction(amount);
		return createTransaction;
	}

}
