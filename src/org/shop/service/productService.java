package org.shop.service;

import java.util.ArrayList;

import org.shop.model.productModel;
import org.shop.repository.productRepository;

public class productService {
	
	productRepository pRepo=new productRepository();
	
	public int isAddProduct(productModel pmod) {
		
		 boolean b=false;
		 ArrayList al=new ArrayList();
		 al=pRepo.getProductList();
		 
		 if(al==null) {
			 return 2;
		 }else {
			 for(Object o:al) {
				 productModel pmodel=(productModel)o;
				 if(pmodel.getName().equals(pmod.getName())) {
					  b=true;
					  break;
				 }
			 }
			 return b?-1:pRepo.isAddProduct(pmod);
		 }
		
	}
	
	public void ShowAllProducts() {
		System.out.println("id\tname\tprice");
		ArrayList al;
		al=pRepo.getProductList();
		
		for(Object o:al) {
			
			productModel pmod=(productModel)o;
			
			System.out.println(pmod.getId()+"\t"+pmod.getName()+"\t"+pmod.getPrice());
		}
		
	}
	
	public productModel searchProduct(int id) {
		       ArrayList al=new ArrayList();
		       
		       al=pRepo.getProductList();
		       productModel mo=null;
		       for(Object o:al) {
		    	   productModel model=(productModel)o;
		    	   if(model.getId()==id) {
		    		   mo= model;
		    		   break;
		    	   }
		       }
		      return mo;
		       
		       
		       
	}
	
}
