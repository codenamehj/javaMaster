package chapter6;
// 저장공간: 배열
// 추가/수정/삭제/목록/단건조회

public class StudentExe {
	// 배열:
	private Student[] students;
	
	// 생성자: 반환타입이 없음
	StudentExe(){
		students = new Student[100];
		students[0] = new Student("23-001", "홍길동", 77, 88);
		students[1] = new Student("23-002", "김철수", 82, 85);
	}
	
	//추가 기능
	boolean addStudent(Student std) {
		for(int i = 0; i < students.length; i++) {
			if(students[i] == null) {
				students[i] =std;
//				break;
				return true; // 메소드에서 return문은 메소드의 끝.
			}
		}
		return false;
	}
	
	// 목록 기능
	Student[] getStudentList() {
		return students;
	}
	
	// 단건조회
	Student getStudent(String no) {
		for(int i = 0;i < students.length; i++) {
			if(students[i] != null && students[i].getStudentNo().equals(no)) {
				return students[i];
			}
		}
		return null;
	}
	
	// 수정
	boolean modifyStudent(String no, int eng, int math) {
		for(int i = 0; i < students.length; i++) {
			if(students[i] != null && students[i].getStudentNo().equals(no)) {
				students[i].setEngScore(eng);
				students[i].setMathScore(math);
				return true;
			}
		}
		return false;
	}
	
	// 삭제
	boolean removeStudent(String name) {
		for(int i = 0; i < students.length; i++) {
			if(students[i] != null && students[i].getStudentName().equals(name)) {
				students[i] = null;
				return true;
			}
		}
		return false;
	}
	
}
