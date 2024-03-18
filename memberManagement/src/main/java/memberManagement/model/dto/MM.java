package memberManagement.model.dto;

public class MM {

	private String memberNo;     // 회원번호
	private String memberName;  // 회원명
	private String gradeName; // 등급명
	
	@Override
	public String toString() {
		return "MM [memberNo=" + memberNo + ", memberName=" + memberName + ", gradeName=" + gradeName + "]";
	}

	public MM() {
	}

	public String getMemberNo() {
		return memberNo;
	}

	public void setMemberNo(String memberNo) {
		this.memberNo = memberNo;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public String getGradeName() {
		return gradeName;
	}

	public void setGradeName(String gradeName) {
		this.gradeName = gradeName;
	}

	// 매개 변수 생성자
	public MM(String memberNo, String memberName, String gradeName) {
		super();
		this.memberNo = memberNo;
		this.memberName = memberName;
		this.gradeName = gradeName;
	}
	
	
	
}
