package org.shop.service;

import java.util.ArrayList;

import org.shop.model.orderModel;
import org.shop.repository.orderRepository;
public class orderService {
	      orderRepository orderRepo=new orderRepository();
       public boolean isAddOrder(orderModel omodel) {
    	   return orderRepo.isAddOrder(omodel);
       }
       
       public ArrayList showOrderList() {
    	   return orderRepo.getOrderList();
       }

}
