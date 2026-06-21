package Homework;

public class Run {

	public static void main(String[] args) {
		Employee e1 = new Employee("이순신",1592, 'M', "삼도수군통제사", "2000/12/25");
		Employee e2 = new Employee("신사임당",50000, 'F', "화가", "1979/06/06");
		
		e2.setJob("화가, 서예");
		e1.infor();
		e2.infor();
	}

}
