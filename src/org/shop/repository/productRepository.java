package org.shop.repository;

import java.util.ArrayList;

import org.shop.model.productModel;

public class productRepository {

	 ArrayList al= new ArrayList();
	 ArrayList order=new ArrayList();
	
	public int isAddProduct(productModel pmod) {
		
		boolean b=al.add(pmod);
		if(b) {
			return 1;
		}else {
			return 0;
		}
	}
	
	public ArrayList getProductList() {
		return al.size()>=0?al:null;
	}
	
	
	public ArrayList getOrderList() {
		return order.size()>=0?order:null;
	}
	
}
