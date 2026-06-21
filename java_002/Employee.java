package Homework;

public class Employee {
	private String name;
	private int eno;
	private char gender;
	private String job;
	private String hiredate;
	
	public Employee() {}
	
	public Employee(String name, int eno, char gender, String job, String hiredate) {
		this.name = name;
		this.eno = eno;
		this.gender = gender;
		this.job = job;
		this.hiredate = hiredate;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getEno() {
		return eno;
	}

	public void setEno(int eno) {
		this.eno = eno;
	}

	public char getGender() {
		return gender;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public String getHiredate() {
		return hiredate;
	}

	public void setHiredate(String hiredate) {
		this.hiredate = hiredate;
	}
	
	public void infor() {
		System.out.printf("이 사원의 이름은 %s, 사원번호는 %d, 성별은 %c이며 %s에 입사하여 현재 %s업무중에 있습니다.\n"
				,name, eno, gender, hiredate, job);
	}
	
}
