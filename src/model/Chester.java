package model;

public class Chester {
	private int cabinetNum; // 물품 이름을 저장하는 파일의 이름이 될 예정 인덱스
	private String contents;
	private int basicCharge;
	private int extraCharge;
	private int modify_Num;
	
	public Chester() {}
	
	
	public Chester(int cabinetNum, String contents) {
		this.cabinetNum = cabinetNum;
		this.contents = contents;
	}
	
	
	public int getModify_Num() {
		return modify_Num;
	}

	public void setModify_Num(int modify_Num) {
		this.modify_Num = modify_Num;
	}

	public int getCabinetNum() {
		return cabinetNum;
	}
	public void setCabinetNum(int cabinetNum) {
		this.cabinetNum = cabinetNum;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	public int getBasicCharge() {
		return basicCharge;
	}
	public void setBasicCharge(int basicCharge) {
		this.basicCharge = basicCharge;
	}
	public int getExtraCharge() {
		return extraCharge;
	}
	public void setExtraCharge(int extraCharge) {
		this.extraCharge = extraCharge;
	}
	
	public int calculCharge(int day) {
		int charge = getBasicCharge()*(getModify_Num()+1)+getExtraCharge()*day;
		return charge;
	}
	
	
}
