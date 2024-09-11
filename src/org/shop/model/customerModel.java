package org.shop.model;

public class customerModel {
		
	
		public customerModel(int id,String name,String contact) {
			this.id=id;
			this.name=name;
			this.contact=contact;
			
		}
		public customerModel() {
			
		}
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getContact() {
			return contact;
		}
		public void setContact(String contact) {
			this.contact = contact;
		}
		public void setTotal(int total) {
			this.total=total;
		}
		public int getTotal() {
			return total;
		}
		
		public int getTotalbill() {
			return totalbill;
		}
		public void setTotalbill(int totalbill) {
			this.totalbill = totalbill;
		}
		
		private int total;
		private int id;
		private String name;
		private String contact;
		private int totalbill;
		
		
}
