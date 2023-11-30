package chapter7;

// 자식: UnivFriend -> Friend(부모)
public class UnivFriend extends Friend {
	// 필드
	private String univ; // 학과
	private String major; // 전공

	// 기본 생성자
	public UnivFriend() {
		
	}
	
	public UnivFriend(String name, String phone, String univ, String major) {
		super(name, phone);
		this.univ = univ;
		this.major = major;
	}

	// 메소드
	@Override
	public String showInfo() {
		return "이름은 " + getName() + " 연락처는 " + getPhone() //
				+ " 학교는 " + univ + " 전공은 " + major;
	}

	public String getUniv() {
		return univ;
	}

	public void setUniv(String univ) {
		this.univ = univ;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

}