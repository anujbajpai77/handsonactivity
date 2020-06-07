package com.ibm.activity.ordersservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.activity.ordersservice.dto.OrdersDTO;
import com.ibm.activity.ordersservice.service.OrdersService;

@RestController
@RequestMapping("/orderservice")
public class OrdersController {
	@Autowired
	OrdersService ordersService;
	
	@GetMapping("/check")
	public String orderServiceStatus() {
		return "orderservice";
	}

	@PostMapping("/users/{userid}/orders")
	public  ResponseEntity<OrdersDTO> createOrder(@RequestBody OrdersDTO orderDto, @PathVariable(value = "userid") Long userId){
	         OrdersDTO createdOrder=ordersService.createOrder(orderDto,userId);
	             return ResponseEntity.ok().body(createdOrder);
	}

	//To do get all orders based on user id
	//To do get all existing orders
	
	@GetMapping
	public <T> ResponseEntity<T>  getAllOrders(){
		return new ResponseEntity<>(ordersService.findAll(), HttpStatus.OK) ;
	}
	
	@GetMapping("/users/{userid}/orders")
	public <T> ResponseEntity<T>  getUserAllOrder(@PathVariable(value="userid") Long id){
		return new ResponseEntity<>(ordersService.findAll(), HttpStatus.OK) ;
	}
	
	@GetMapping("/users/{userid}/orders/{orderid}")
	public ResponseEntity<OrdersDTO> getUserOrder(@PathVariable(value = "userid") Long userId,
			@PathVariable(value = "orderid") Long orderId, @RequestHeader("Authorization") String authHeader) {
		return new ResponseEntity<>(ordersService.getDetailsByUserIdAndOrderId(userId, orderId, authHeader), HttpStatus.OK);
	}
	
}
