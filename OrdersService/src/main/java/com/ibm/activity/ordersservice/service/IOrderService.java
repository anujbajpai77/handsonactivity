package com.ibm.activity.ordersservice.service;

import com.ibm.activity.ordersservice.dto.OrdersDTO;

public interface IOrderService {
 
	public  OrdersDTO getDetailsByUserIdAndOrderId(Long userId, Long orderId, String authHeader) ;
}
