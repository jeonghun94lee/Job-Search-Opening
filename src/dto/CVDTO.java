package dto;

public class CVDTO {
	//�̷¼�����
	int num=0;
	String id=null;//���̵�;
	String name =null;//�̸�
	String w_type=null;//�ٹ��̷�
	String edu =null;//�����з�
	String pay =null;//�������
	String work_e =null;//���
	String self_intro =null;//�ڱ�Ұ�
	
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
		System.out.println(num + ":��° ������"+ "\n"+ "�̸�"+name+ "\n�����з�"+edu+ "\n����޿�"+pay
				+ "\n���"+work_e+ "\n�ڱ�Ұ���"+self_intro);
		
	}

}
