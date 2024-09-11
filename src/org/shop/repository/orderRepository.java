package org.shop.repository;

import java.util.ArrayList;

import org.shop.model.orderModel;

public class orderRepository {
	
	ArrayList orderlist=new ArrayList();
	
	public boolean isAddOrder(orderModel omodel) {
		
		boolean b=orderlist.add(omodel);
		
		if(b) 
			return true;
		return false;
	}
	
	public ArrayList getOrderList() {
		return orderlist;
	}

}
