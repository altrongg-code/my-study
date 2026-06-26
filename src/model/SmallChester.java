package model;

public class SmallChester extends Chester{
	public SmallChester() {
		super();
	}
	public SmallChester(int cabinetNum, String contents) {
		super.setCabinetNum(cabinetNum);
		super.setContents(contents);
		super.setBasicCharge(3000);
		super.setExtraCharge(2000);
		super.setModify_Num(0);
	}
	public int calculCharge(int day) {
		int charge = getBasicCharge()*(getModify_Num()+1)+getExtraCharge()*day;
		return charge;
	}


}
