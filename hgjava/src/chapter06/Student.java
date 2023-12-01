package chapter06;

public class Student {
	// 속성(필드)
	String studentNo;
	String studentName;
	int engScore;
	int mathScore;
	
	// 생성자
	public Student(String studentNo, String studentName, int engScore, int mathScore) {
		this.studentNo = studentNo;
		this.studentName = studentName;
		this.engScore = engScore;
		this.mathScore = mathScore;
	}
	
	// 기능(메소드)
	void showInfo(){
		System.out.println( studentName + "의 영어 점수는 " + engScore + "점이고 수학 점수는 " + mathScore +"점입니다.");
	}

	public String getStudentNo() {
		return studentNo;
	}

	public void setStudentNo(String studentNo) {
		this.studentNo = studentNo;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public int getEngScore() {
		return engScore;
	}

	public void setEngScore(int engScore) {
		this.engScore = engScore;
	}

	public int getMathScore() {
		return mathScore;
	}

	public void setMathScore(int mathScore) {
		this.mathScore = mathScore;
	}
	
} //end of class