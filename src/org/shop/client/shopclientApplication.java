package org.shop.client;

import org.shop.service.orderService;
import org.shop.service.productService;

import java.util.ArrayList;
import java.util.Scanner;

import org.shop.model.customerModel;
import org.shop.model.orderModel;
import org.shop.model.productModel;

public class shopclientApplication {

	public static void main(String[] args) {
	  productService pServ=new productService();
	  orderService oServ=new orderService();
	 
	  
	  Scanner sc=new Scanner(System.in);
	  int choice;
	  
	  
	  do {
		  System.out.println("\n\n1 : For Add New Product");
		  System.out.println("2 : For See All Products");
		  System.out.println("3 : For Search Product by id");
		  System.out.println("4 : For order new product");
		  System.out.println("5 : For see all client");
		  System.out.println("6 : For see perticular client details");
		  System.out.println("7 : For all collection(money)");
		  
		  System.out.println("Enter Your Choice");
		  choice =sc.nextInt();
		  
		  switch(choice) {
		  case 1:
			  System.out.println("Enter product id name and price");
			  int id=sc.nextInt();
			  sc.nextLine();
			  String name=sc.nextLine();
			  int price=sc.nextInt();
			  productModel pMod=new productModel();
			  pMod.setId(id);
			  pMod.setName(name);
			  pMod.setPrice(price);
			 int b= pServ.isAddProduct(pMod);
			 
			 if(b==2) {
				 System.out.println("list is empty");
			 }else if(b==-1) {
				 System.out.println("product is already present");
			 }else {
				 if(b==1) {
				 System.out.println("product successfully added");
				 }else {
					 System.out.println("something wrong !!!!");
				 }
			 }
			 
			  break;
		  case 2:
			  pServ.ShowAllProducts();
			  
			  break;
			  
		  case 3:
			  System.out.println("Enter a id");
			  id=sc.nextInt();
			  productModel mo=pServ.searchProduct(id);
			  if(mo!=null) {
				  System.out.println(mo.getId()+"\t"+mo.getName()+"\t"+mo.getPrice());
			  }else {
				  System.out.println("Product Not Found");
			  }
			  
			  break;
			  
		  case 4:
			  System.out.println("Enter client id name contact");
			  id=sc.nextInt();
			  sc.nextLine();
			  name=sc.nextLine();
			  String contact=sc.nextLine();
			  customerModel cmodel=new customerModel(id,name,contact);
			  
			  System.out.println("How many product do you wants");
			  int size=sc.nextInt();
			  productModel pmodel[]=new productModel[size];
			  int quantity[]=new int[size];
			  
			  for(int i=0;i<size;i++) {
				 
				  pmodel[i]=new productModel();
				  System.out.println("Enter product id name price and quantity");
				  id=sc.nextInt();
				  sc.nextLine();
				  name=sc.nextLine();
				  price =sc.nextInt();
				  quantity[i]=sc.nextInt();
				  pmodel[i].setId(id);
				  pmodel[i].setName(name);
				  pmodel[i].setPrice(price);
				 
			  }
			  orderModel ordermodel=new orderModel();
			  ordermodel.setPmodel(pmodel);
			  ordermodel.setQuantity(quantity);
			  ordermodel.setCustomermodel(cmodel);
			boolean c= oServ.isAddOrder(ordermodel);
			if(c) {
				System.out.println("order got place");
			}else {
			System.out.println("order not got place");
			  
			}  
			 
			  break;
			  
		  case 5:
			    ArrayList clientList=oServ.showOrderList();
			    System.out.println("details of all clients and their bill");
			    for(Object o:clientList) {
			    	orderModel ordermod=(orderModel)o;
			    	customerModel cutomermodel=(customerModel)ordermod.getCustomermodel();
			    	 quantity=ordermod.getQuantity();
			    	 
			    	 
			    	 productModel pmod[]=ordermod.getPmodel();

			    	 int totbill=0;
			    	 for(int i=0;i<pmod.length;i++) {
			    		  totbill+=pmod[i].getPrice()*quantity[i];
			    	 }
			    	 cutomermodel.setTotal(totbill);
			    	 
 System.out.println(cutomermodel.getName()+"\t"+cutomermodel.getId()+"\t"+cutomermodel.getContact()+"\t"+totbill);
 System.out.println("\n");
			    			 
			    			 
			    	 
			    	 
			    	
			    }
			  
			  break;
		  case 6:
			  ArrayList orderlist=oServ.showOrderList();
			  System.out.println("Enter client id and name for bill ");
			  id=sc.nextInt();
			  sc.nextLine();
			  name=sc.nextLine();
			  int flag=0;
			  int grandTotal=0;
  	        for(Object o:orderlist) {
  	          orderModel omodel=(orderModel)o;
  	          customerModel custmodel=omodel.getCustomermodel();
  	          
  	          if(custmodel.getName().equals(name) && custmodel.getId()==id) {
  	        	  flag=1;
  	           	     productModel pmod[]=omodel.getPmodel();
  	   	          int q[]=omodel.getQuantity();

  	          System.out.println("--------------------------------------------------------------------------------------------------------------------------");

  	          System.out.println("  "+custmodel.getId()+"   | "+custmodel.getName()+"   |"+custmodel.getContact());
  	          System.out.println("---------------------------------------------------------------------------------------------------------------------------\n");
  	          for(int i=0;i<pmod.length;i++) {
  	        	  grandTotal+=q[i]*pmod[i].getPrice();
  	        	  
  	        	  System.out.println("  "+pmod[i].getId()+"   |\t"+pmod[i].getName()+"   |\t"+pmod[i].getPrice());
  	          }
  	          System.out.println("---------------------------------------------------------------------------------------------------------------------------\n");
  	          
  	          
  	          System.out.println("\t\t ________________________________");
  	          System.out.println("\t\t|    Total bill is =  "+grandTotal+" \t |");
  	          System.out.println("\t\t|________________________________|");
  	          }
  	        
  	        }
  	        
  	        if(flag==0) {
  	        	System.out.println("Client not found ");
  	        }
  	        break;
  	        
		  case 7:
			ArrayList al=oServ.showOrderList();
			int Grandtotal=0;
			for(Object o:al) {
				orderModel om=(orderModel)o;
				customerModel cmd=om.getCustomermodel();
				 Grandtotal+=cmd.getTotal();
			}
			   	System.out.println("total income of the day  "+Grandtotal);
			
			  break;
			  default:
				  System.out.println("Wrong choice");
		  }
		  
		  
	  }while(true);
		
		

	}

}
