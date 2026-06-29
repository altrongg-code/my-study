package controller;

import model.*;
import model.Customer;

public class CabinetController {
	private Chester[] chester = new Chester[30];
	private Customer[] customer = new Customer[30];
	
	public CabinetController(){
		super();
		for(int i = 0; i<20; i++) {
			chester[i] = new SmallChester();
		}
		for(int i = 20; i<30; i++) {
			chester[i] = new LargeChester();
		}
	}
	public void appendContents(int index, String contents) {
		String modifiedContents = chester[index].getContents()+", "+contents; 
		chester[index].setContents(modifiedContents);
	}
	
	public void plusModifyNum(int index) {
		chester[index].setModify_Num(chester[index].getModify_Num()+1);
	}
	public void insertCustomer(Customer c,int index) {
		customer[index] = c;
	}
	public void initializeSmall(int index) {
		chester[index] = new SmallChester();
	}
	public void initializeLarge(int index) {
		chester[index] = new LargeChester();
	}
	public int calculCharge(int index) {
		return chester[index].calculCharge();
	}
	public void setContents(int index, String contents) {
		chester[index].setContents(contents);
	}
	public String getContents(int index) {
		return chester[index].getContents();
	}
	public void setRegiDate(int index, String regiDate) {
		chester[index].setRegiDate(regiDate);
	}
	public void setEndDate (int index, String endDate) {
		chester[index].setEndDate(endDate);
	}
	public boolean isEmpty(int index) {
		return chester[index].isEmpty();
	}
	public void setEmpty(int index, boolean tf) {
		chester[index].setEmpty(tf);
	}
	public void setCabinetNum(int index) {
		chester[index].setCabinetNum(index+1);
	}
	public void setPassword(int index, String password) {
		customer[index].setPassword(password);
	}
	public String getPassword(int index) {
		return customer[index].getPassword();
	}
	public String getName(int index) {
		return customer[index].getName();
	}
	
}