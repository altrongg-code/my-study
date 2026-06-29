package model;
/*
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
*/
public class LargeChester extends Chester{
	/*
	private int cabinetNum; // 물품 이름을 저장하는 파일의 이름이 될 예정 인덱스
	private String contents;
	private int basicCharge;
	private int extraCharge;
	private int modify_Num;
	private boolean empty;
	private String regiDate;
	private String EndDate;
	*/
	public LargeChester() {
		super();
		basicCharge=5000;
		extraCharge=3000;
	}
	
	/*
	public int calculDate(String regiDate, String endDate) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
		
		try{
			Date startDate = formatter.parse(regiDate);
			Date lastDate = formatter.parse(endDate);
			int dif = (int) ((lastDate.getTime()-startDate.getTime()) / (24*60*60*1000));
			return dif;
		}
		catch(ParseException e) {
			e.printStackTrace();
			System.out.println("오류발생 Large");
		}
		
		return 0;
	}
	public int calculCharge() {
		int charge = getBasicCharge()*(getModify_Num()+1)+getExtraCharge()*calculDate(regiDate, endDate);
		return charge;
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
	public int getModify_Num() {
		return modify_Num;
	}
	public void setModify_Num(int modify_Num) {
		this.modify_Num = modify_Num;
	}
	public boolean isEmpty() {
		return empty;
	}
	public void setEmpty(boolean empty) {
		this.empty = empty;
	}
	
	public String getRegiDate() {
		return regiDate;
	}
	public void setRegiDate(String regiDate) {
		this.regiDate = regiDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	public String toString() {
		return "Chester [보관함 번호=" + cabinetNum + ", 내용물=" + contents + "]large";
	}
	*/
}
