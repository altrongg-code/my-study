package model;

public class LargeChester extends Chester{
	public LargeChester() {
		super();
	}
	public LargeChester(int cabinetNum, String contents) {
		super.setCabinetNum(cabinetNum);
		super.setContents(contents);
		super.setBasicCharge(5000);
		super.setExtraCharge(3000);
		super.setModify_Num(0);
	}
	public int calculCharge(int day) {
		int charge = getBasicCharge()*(getModify_Num()+1)+getExtraCharge()*day;
		return charge;
	}
}
