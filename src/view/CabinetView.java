package view;

import java.util.Scanner;
import java.io.*;
import controller.CabinetController;
import model.Customer;

public class CabinetView {
	private CabinetController cc = new CabinetController();
	private Customer c = new Customer();
	private Scanner sc = new Scanner(System.in);
	
	public void mainMenu() {
		while(true) {
			System.out.println("***** 물품 보관함 *****");
			System.out.println("1. 물품 넣기");
			System.out.println("2. 물품 바꾸기/추가하기");
			System.out.println("3. 물품 검색하기");
			System.out.println("4. 물품 빼고 정산하기");
			System.out.println("5. 정보 조회"); // 물품이름, 현재요금, 사람이름
			System.out.println("9. 끝내기");
			System.out.print("메뉴 번호 : ");
			int menuNum = sc.nextInt();
			sc.nextLine();
			switch(menuNum){
			case 1:
				
				break;
			case 2:
				
				break;
			case 3:
				
				break;
			case 4:
				
				break;
			case 9:
				System.out.println("프로그램을 종료합니다.");
				return;
			default:
				System.out.println("잘못 입력하였습니다.");
				return;
			}
		}
	}
	public void selectSmallOrLarge(int a) {
		if (a == 1) {
			//작은상자 선택 메소드
		}
			
		else if(a == 2) {
			//큰 상자 선택 메소드
			
		}
			
		else return;
		// 그외 고를시 메인 메뉴
	}
	public void small() {
		//상자 번호 1~20 받아서 번호-1를 인덱스로 하는 스몰 체스터 생성 메소드 호출
		createChester(-1);
	}
	public void large() {
		
		//상자 번호 1~10 받아서 번호-1+20를 인덱스로 하는 라지 체스터 생성 메소드 호출
		createChester(-1+20);
	}
	public void createChester(int num) {
		// num값을 index로 한다.
		// 사용자에 대한 이름과 패스워드를 받고 원래대로라면 넣는 날짜를 받아야하지만
		// 실제로 날짜를 받을 순 없으므로 임의로 날짜를 지정한다.
		// 캐비넷 넘버는 입력 파라미터인 num으로 설정한다. 
		// 이 캐비넷 넘버는 보관물품파일의 이름이 될것이다.
		// 물품 이름 입력으로 받아 파일로 저장한다.
		// 보관 완료 출력하고 메인메뉴 돌아가기
		
	}
}
