package view;

import java.util.Scanner;

import controller.CabinetController;
import model.Customer;



public class CabinetView {
	private CabinetController cc = new CabinetController();
	private Scanner sc = new Scanner(System.in);
	
	
	
	public void mainMenu() {
		while(true) {
			System.out.println("***** 물품 보관함 *****");
			System.out.println("1. 물품 넣기");
			System.out.println("2. 물품 바꾸기/추가하기");
			System.out.println("3. 정보 조회");// 물품이름, 현재요금, 사람이름
			System.out.println("4. 물품 빼고 정산하기");
			System.out.println("9. 끝내기");
			System.out.print("메뉴 번호 : ");
			int menuNum = readInt();
			
			switch(menuNum){
			case 1:
				createSmallOrLarge();
				break;
			case 2:
				modifySmallOrLarge();
				break;
			case 3:
				showinfoSmallorLarge();
				break;
			case 4:
				removeSmallOrLarge();
				break;
			case 9:
				System.out.println("프로그램을 종료합니다.");
				return;
			default:
				System.out.println("1~9까지의 범위 내의 숫자를 입력해 주세요");
				break;
			}
		}
	}
	private String readPassword() {
		String password = "";
		while(true) {
			password = sc.nextLine();
			if(!password.matches("^[0-9]+$")) {
				System.out.println("4자리 숫자로 입력해주세요");
				continue;
			}
			if(password.length()!=4) {
				System.out.println("4자리 숫자로 입력해주세요");
				continue;
			}
			return password;
		}
	}
	private int readInt() {
		
		int menu = -1;
		
		while(!sc.hasNextInt()) {
			System.out.println("숫자를 입력해 주세요 : ");
			sc.nextLine();
		}
		menu = sc.nextInt();
		sc.nextLine();
		/*
		// MismatchException 예외가 발생하지 않은 경우, 반복문 종료
		while(true) {
			try {
				menu = sc.nextInt();
				sc.nextLine();
			}
			catch(InputMismatchException e) {
				System.out.println("올바른 메뉴를 선택하세요");
				sc.nextLine();
//				e.printStackTrace();
				continue;
			}
			break;
		}
		*/
		return menu;
	}
	public void modifySmallOrLarge() {
		System.out.println("작은 보관함을 선택하려면 1, 큰 보관함을 선택하려면 2를 입력해주세요");
		int a = readInt();
		while (true) {
			if (a == 1) {
				modifySmall();//작은상자 선택 메소드
				break;
			}
			else if(a == 2) {
			//큰 상자 선택 메소드
				modifyLarge();
				break;
			}
			else {
				System.out.println("1 또는 2만 입력해 주세요");
				break;
				// 그외 고를시 메인 메뉴
			}
		}
	}
	public void modifySmall() {
		for(int i = 0; i<10 ; i++) {
			if(!cc.isEmpty(i)) {
				System.out.print("["+(i+1)+"] ");
			}
		}
		System.out.println();
		for(int i = 10; i<20 ; i++) {
			if(!cc.isEmpty(i)) {
				System.out.print("["+(i+1)+"] ");
			}
		}
		System.out.println();
		System.out.println("반납할 보관함 번호를 선택하여 주세요 \n메인 메뉴로 돌아가시려면 0번을 입력해주세요");
		while(true) {
			int a = readInt();
			if(a>= 1 && a <= 20) {
				if(!cc.isEmpty(a-1)) {
					modifyChester(a-1);
					break;
				}
				else {
					System.out.println("유효한 보관함 번호를 입력해 주세요");
				}
			}
			else if (a == 0) {
				break;
			}
			else
				System.out.println("유효한 보관함 번호를 입력해 주세요");
		
		}
	}
	public void modifyLarge() {
		for(int i = 20; i<30 ; i++) {
			if(!cc.isEmpty(i)) {
				System.out.print("["+(i-19)+"] ");
			}
		}
		System.out.println();
		
			System.out.println("물품을 넣을 보관함 번호를 선택하여 주세요 \n메인 메뉴로 돌아가시려면 0번을 입력해주세요");
			
			while(true) {
				int a = readInt();
				if(a>= 1 && a <= 10) {
					if(!cc.isEmpty(a+19)) {
						modifyChester(a+19);
						break;
					}
					else {
						System.out.println("유효한 보관함 번호를 입력해 주세요");
					}
				}
				else if (a == 0) {
					break;
				}
				else
					System.out.println("유효한 보관함 번호를 입력해 주세요");
			
		}
	}
	public void modifyChester(int index) {
		while(true) {
			System.out.println("비밀번호를 입력해 주세요 ");
			System.out.println("메인메뉴로 돌아가고싶으시면 -1을 입력해주세요");
			String password = readPassword();
			if(cc.getPassword(index).equals(password)) {
				break;
			}
			System.out.println("비밀번호가 올바르지 않습니다.");
		}
		System.out.print("내용물을 새롭게 바꾸시려면 1, 추가만 하실거면 2를 입력해 주세요");
		while(true) {
			int a = readInt();
			if(a == 1) {
				System.out.println("새롭게 넣을 내용물 이름을 입력해 주세요");
				String contents = sc.nextLine();
				cc.setContents(index, contents);
				break;
			}
			else if(a == 2) {
				System.out.println("추가할 내용물 이름을 입력해 주세요");
				String contents = sc.nextLine();
				cc.appendContents(index,contents);
				break;
			}
			else
				System.out.println("1 또는 2만 입력해 주십시오");
		}
		cc.plusModifyNum(index);

		System.out.println("수정 완료 !! ");
	}
	public void showinfoSmallorLarge() {
		System.out.println("작은 보관함을 선택하려면 1, 큰 보관함을 선택하려면 2를 입력해주세요");
		int a = readInt();
		while (true) {
			if (a == 1) {
				showInfoSmall();
				//작은상자 선택 메소드
				break;
			}
			else if(a == 2) {
			//큰 상자 선택 메소드
				showInfoLarge(); 
				break;
			}
			else {
				System.out.println("1 또는 2만 입력해 주세요");
				break;
			}
		}
	}
	public void showInfoSmall() {
		for(int i = 0; i<10 ; i++) {
			if(!cc.isEmpty(i)) {
				System.out.print("["+(i+1)+"] ");
			}
		}
		System.out.println();
		for(int i = 10; i<20 ; i++) {
			if(!cc.isEmpty(i)) {
				System.out.print("["+(i+1)+"] ");
			}
		}
		System.out.println();
		System.out.println("정보를 확인할 보관함 번호를 선택하여 주세요 \n메인 메뉴로 돌아가시려면 0번을 입력해주세요");
		while(true) {
			int a = readInt();
			if(a>= 1 && a <= 20) {
				if(!cc.isEmpty(a-1)) {
					showInfoChester(a-1);
					break;
				}
				else {
					System.out.println("유효한 보관함 번호를 입력해 주세요");
				}
			}
			else if (a == 0) {
				break;
			}
			else
				System.out.println("유효한 보관함 번호를 입력해 주세요");
		
		}
	}
	public void showInfoLarge() {
		for(int i = 20; i<30 ; i++) {
			if(!cc.isEmpty(i)) {
				System.out.print("["+(i-19)+"] ");
			}
		}
		System.out.println();
		System.out.println("정보를 확인할 보관함 번호를 선택하여 주세요 \n메인 메뉴로 돌아가시려면 0번을 입력해주세요");
		while(true) {
			int a = readInt();
			if(a>= 1 && a <= 10) {
				if(!cc.isEmpty(a+19)) {
					showInfoChester(a+19);
					break;
				}
				else {
					System.out.println("유효한 보관함 번호를 입력해 주세요");
				}
			}
			else if (a == 0) {
				break;
			}
			else
				System.out.println("유효한 보관함 번호를 입력해 주세요");
		
		}
	}
	public void showInfoChester(int index) {
		while(true) {
			System.out.println("비밀번호를 입력해 주세요 ");
			System.out.println("메인메뉴로 돌아가고싶으시면 -1을 입력해주세요");
			String password = readPassword();
			if(cc.getPassword(index).equals(password)) {
				break;
			}
			System.out.println("비밀번호가 올바르지 않습니다.");
		}
		System.out.print("현재 날짜를 입력해주세요 : ");
		String endDate = sc.nextLine();
		
		cc.setEndDate(index, endDate); 
		String name = cc.getName(index);
		String contents = cc.getContents(index);
		System.out.println(name+"님의 보관함에는 현재 "+contents+"이/가 들어있습니다.");
		System.out.println("현재까지의 요금은 "+cc.calculCharge(index)+"원 입니다.");
	}
	//큰 보관함고를건지 작은 보관함 고를건지 선택 메소드
	public void createSmallOrLarge() {
		System.out.println("작은 보관함을 선택하려면 1, 큰 보관함을 선택하려면 2를 입력해주세요");
		int a = readInt();
		while (true) {
			
			if (a == 1) {
				createSmall();//작은상자 선택 메소드
				break;
			}
			
			else if(a == 2) {
			//큰 상자 선택 메소드
				createLarge(); 
				break;
			}
			
			else {
				
				System.out.println("1 또는 2만 입력해 주세요");
				break;
				// 그외 고를시 메인 메뉴
			
			}
		}
	}
	public void createSmall() {
		for(int i = 0; i<10 ; i++) {
			if(cc.isEmpty(i)) {
				System.out.print("["+(i+1)+"] ");
			}
		}
		System.out.println();
		for(int i = 10; i<20 ; i++) {
			if(cc.isEmpty(i)) {
				System.out.print("["+(i+1)+"] ");
			}
		}
		System.out.println();
		
			System.out.println("물품을 넣을 보관함 번호를 선택하여 주세요 \n메인 메뉴로 돌아가시려면 0번을 입력해주세요");
			
			while(true) {
				int a = readInt();
				
				if(a>= 1 && a <= 20) {
					if(cc.isEmpty(a-1)) {
						createChester(a-1);
						break;
					}
					else {
						System.out.println("유효한 보관함 번호를 입력해 주세요");
					}
				}
				else if (a == 0) {
					break;
				}
				else
					System.out.println("유효한 보관함 번호를 입력해 주세요");
			
		}
	}
	public void createLarge() {
		for(int i = 20; i<30 ; i++) {
			if(cc.isEmpty(i)) {
				System.out.print("["+(i-19)+"] ");
			}
		}
		System.out.println();
		
			System.out.println("물품을 넣을 보관함 번호를 선택하여 주세요 \n메인 메뉴로 돌아가시려면 0번을 입력해주세요");
			
			while(true) {
				int a = readInt();
				
				if(a>= 1 && a <= 10) {
					if(cc.isEmpty(a+19)) {
						createChester(a+19);
						break;
					}
					else {
						System.out.println("유효한 보관함 번호를 입력해 주세요");
					}
				}
				else if (a == 0) {
					break;
				}
				else
					System.out.println("유효한 보관함 번호를 입력해 주세요");
			
		}
	}
	
	public void createChester(int index) {
		// 입력받은 파라미터를 index로 한다.
		cc.setEmpty(index, false);
		if(index >= 0 && index<20) {
			cc.setCabinetNum(index+1); // smallchester가 선택되었을 경우 1~20 입력
		}
		else
			cc.setCabinetNum(index-19);// largechester가 선택되었을 경우 1~10 입력
		
		System.out.print("사용자 이름을 입력해 주세요 : ");
		String name = sc.nextLine();
		
		System.out.print("사용할 비밀번호를 숫자 4자리로만 입력해주세요 입력해 주세요 : ");
		String password = readPassword();
		
		System.out.print("보관 시작 날짜를 8자리 숫자 [ex)20260628] 로 입력해 주세요 : ");
		String regiDate = sc.nextLine();
		
		cc.setRegiDate(index, regiDate);
		
		Customer c = new Customer(name,password);
		cc.insertCustomer(c, index);
		
		System.out.print("보관할 물품 이름을 입력해 주세요 : ");
		String contents = sc.nextLine();
		cc.setContents(index, contents);
		
		
		//System.out.println(cc.customer[index].getName()+"\n"+cc.chester[index].toString());
//		
		//System.out.println(cc.customer[index].getPassword()+" "+cc.chester[index].getRegiDate());
//		
		System.out.println("보관완료 !! ");
		// 사용자에 대한 이름과 패스워드를 받고 원래대로라면 넣는 날짜를 받아야하지만
		// 실제로 날짜를 받을 순 없으므로 임의로 날짜를 지정한다.
		// 캐비넷 넘버는 입력 파라미터인 index로 설정한다. 
		// 이 캐비넷 넘버는 보관물품파일의 이름이 될것이다.
		// 물품 이름 입력으로 받아 파일로 저장한다.
		// 보관 완료 출력하고 메인메뉴 돌아가기
		
	}
	public void removeSmallOrLarge() {
		System.out.println("작은 보관함을 선택하려면 1, 큰 보관함을 선택하려면 2를 입력해주세요");
		int a = readInt();
		while (true) {
			if (a == 1) {
				removeSmall();//작은상자 선택 메소드
				break;
			}
			else if(a == 2) {
			//큰 상자 선택 메소드
				removeLarge();
				break;
			}
			else {
				System.out.println("1 또는 2만 입력해 주세요");
				break;
				// 그외 고를시 메인 메뉴
			}
		}
	}
	public void removeSmall() {
		for(int i = 0; i<10 ; i++) {
			if(!cc.isEmpty(i)) {
				System.out.print("["+(i+1)+"] ");
			}
		}
		System.out.println();
		for(int i = 10; i<20 ; i++) {
			if(!cc.isEmpty(i)) {
				System.out.print("["+(i+1)+"] ");
			}
		}
		System.out.println();
		System.out.println("반납할 보관함 번호를 선택하여 주세요 \n메인 메뉴로 돌아가시려면 0번을 입력해주세요");
		while(true) {
			int a = readInt();
			if(a>= 1 && a <= 20) {
				if(!cc.isEmpty(a-1)) {
					removeChester(a-1);
					break;
				}
				else {
					System.out.println("유효한 보관함 번호를 입력해 주세요");
				}
			}
			else if (a == 0) {
				break;
			}
			else
				System.out.println("유효한 보관함 번호를 입력해 주세요");
		
		}
	}
	public void removeLarge() {
		for(int i = 20; i<30 ; i++) {
			if(!cc.isEmpty(i)) {
				System.out.print("["+(i-19)+"] ");
			}
		}
		System.out.println();
		
			System.out.println("물품을 넣을 보관함 번호를 선택하여 주세요 \n메인 메뉴로 돌아가시려면 0번을 입력해주세요");
			
			while(true) {
				int a = readInt();
				if(a>= 1 && a <= 10) {
					if(!cc.isEmpty(a+19)) {
						removeChester(a+19);
						break;
					}
					else {
						System.out.println("유효한 보관함 번호를 입력해 주세요");
					}
				}
				else if (a == 0) {
					break;
				}
				else
					System.out.println("유효한 보관함 번호를 입력해 주세요");
			
		}
	}
	public void removeChester(int index) {
		// 입력받은 파라미터를 index로 한다.
		
		while(true) {
			System.out.println("비밀번호를 입력해 주세요 ");
			System.out.println("메인메뉴로 돌아가고싶으시면 -1을 입력해주세요");
			String password = readPassword();
			if(cc.getPassword(index).equals(password)) {
				break;
			}
			System.out.println("비밀번호가 올바르지 않습니다.");
		}
		System.out.print("반납 날짜를 8자리 숫자 [ex)20260628] 로 입력해 주세요 : ");
		String endDate = sc.nextLine();
		
		cc.setEndDate(index, endDate); 
		
		System.out.println("사용 요금은 "+cc.calculCharge(index)+"원 입니다.");
		Customer c= new Customer();
		cc.insertCustomer(c, index);
		
		if(index>= 0 && index <20)
			cc.initializeSmall(index);
		else 
			cc.initializeLarge(index);
		
		System.out.println("반납완료 !! ");
		
		
	}
}
