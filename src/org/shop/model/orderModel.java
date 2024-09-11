package org.shop.model;

public class orderModel {

		
		public productModel[] getPmodel() {
			return pmodel;
		}
		public void setPmodel(productModel[] pmodel) {
			this.pmodel = pmodel;
		}
		public customerModel getCustomermodel() {
			return cmodel;
		}
		public void setCustomermodel(customerModel cmodel) {
			this.cmodel = cmodel;
		}
		
		
		public int[] getQuantity() {
			return quantity;
		}
		public void setQuantity(int[] quantity) {
			this.quantity = quantity;
		}
		
		private productModel pmodel[];
		private	customerModel cmodel;
		private int quantity[];
		
}
