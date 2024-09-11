package org.shop.model;

public class productModel {
	
	   public productModel() {
		   
	   }
	   
	   public productModel(int id,String name,int price) {
		   this.id=id;
		   this.name=name;
		   this.price=price;
		   
	   }
		
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public int getPrice() {
			return price;
		}
		public void setPrice(int price) {
			this.price = price;
		}
		
		private String name;
		private int id;
		private int price;
		
}
