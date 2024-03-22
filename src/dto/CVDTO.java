package dto;

public class CVDTO {
	//이력서관리
	int num=0;
	String id=null;//아이디;
	String name =null;//이름
	String w_type=null;//근무이력
	String edu =null;//최종학력
	String pay =null;//희망연봉
	String work_e =null;//경력
	String self_intro =null;//자기소개
	
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getW_type() {
		return w_type;
	}
	public void setW_type(String w_type) {
		this.w_type = w_type;
	}
	public String getEdu() {
		return edu;
	}
	public void setEdu(String edu) {
		this.edu = edu;
	}
	public String getPay() {
		return pay;
	}
	public void setPay(String pay) {
		this.pay = pay;
	}
	public String getWork_e() {
		return work_e;
	}
	public void setWork_e(String work_e) {
		this.work_e = work_e;
	}
	public String getSelf_intro() {
		return self_intro;
	}
	public void setSelf_intro(String self_intro) {
		this.self_intro = self_intro;
	}
	public void prt() {
		System.out.println(num + ":번째 지원자"+ "\n"+ "이름"+name+ "\n최종학력"+edu+ "\n희망급여"+pay
				+ "\n경력"+work_e+ "\n자기소개서"+self_intro);
		
	}

}
