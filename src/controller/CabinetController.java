package controller;

import model.*;
import model.Customer;

public class CabinetController {
	Chester[] chester = new Chester[30];
	Customer[] customer = new Customer[30];
	public CabinetController(){
		super();
		for(int i = 0; i<20; i++) {
			chester[i] = new SmallChester();
		}
		for(int i = 20; i<30; i++) {
			chester[i] = new LargeChester();
		}
	
		
	}
	public void insertCustomer(SmallChester sc,int index) {
		chester[index-1] = sc;
	}
	
	public void insertCustomer(LargeChester lc,int index) {
		chester[index-1+20] = lc;
	}
	
	public void insertCustomer(Customer c,int index) {
		customer[index-1] = c;
	}
	
	
	
	
}