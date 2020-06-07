package com.ibm.activity.ordersservice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ibm.activity.ordersservice.client.ProductFeignClient;
import com.ibm.activity.ordersservice.client.UsersFeignClient;
import com.ibm.activity.ordersservice.domain.Orders;
import com.ibm.activity.ordersservice.dto.MyUserDetailsDTO;
import com.ibm.activity.ordersservice.dto.OrdersDTO;
import com.ibm.activity.ordersservice.dto.OrdersMapper;
import com.ibm.activity.ordersservice.dto.ProductDTO;
import com.ibm.activity.ordersservice.repository.OrdersRepository;

@Service
public class OrdersService implements IOrderService {

	@Autowired
	OrdersRepository ordersRepository;

	@Autowired
	ProductFeignClient productFeignClient;

	@Autowired
	UsersFeignClient usersFeignClient;

	public OrdersDTO createOrder(OrdersDTO orderDto,Long userId) {
		OrdersMapper mapper = new OrdersMapper();

		ResponseEntity<ProductDTO> productDetailsById=productFeignClient.getProduct(orderDto.getProductId());
	     if(productDetailsById.getBody().getId()!=null) {
	    	 Orders order = ordersRepository.save(mapper.convertOrderDtoToOrder(orderDto));
	 		return mapper.convertOrderToOrderDto(order);
	     }else{
	    	 return null;
	     }
	}

	@SuppressWarnings("rawtypes")
	public List findAll() {
		return ordersRepository.findAll();
	}

	@Override
	public OrdersDTO getDetailsByUserIdAndOrderId(Long userId, Long orderId, String authHeader) {
		ResponseEntity<MyUserDetailsDTO> details = usersFeignClient.getUserDetails(userId, authHeader);
		Optional<Orders> orderEntity = ordersRepository.findById(orderId);
		OrdersDTO orderDto = new OrdersDTO();

		orderEntity.ifPresent(oe -> {
			orderDto.setOrderId(oe.getOrderId());
			orderDto.setProductId(oe.getProductId());
		});
		orderDto.setUserName(details.getBody().getUsername());
		return orderDto;
	}

}
