package dto;

public class RDTO {
	// ä����-ȸ��
	int num = 0;
	String name = null;// ȸ���
	String r_type = null;// �������
	String working_area = null;// �ٹ���ġ
	String working_date = null;// �ٹ��Ͻ�
	String Q_require=null;

	String salary = null;// �޿�����
	String period = null;// �����Ⱓ
	String field = null;// �����о�
	String main_task = null;// ��������

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getR_type() {
		return r_type;
	}

	public void setR_type(String r_type) {
		this.r_type = r_type;
	}

	public String getWorking_area() {
		return working_area;
	}
	public String getQ_require() {
		return Q_require;
	}
	
	public void setQ_require(String q_require) {
		Q_require = q_require;
	}

	public void setWorking_area(String working_area) {
		this.working_area = working_area;
	}

	public String getWorking_date() {
		return working_date;
	}

	public void setWorking_date(String working_date) {
		this.working_date = working_date;
	}

	public String getSalary() {
		return salary;
	}

	public void setSalary(String salary) {
		this.salary = salary;
	}

	public String getPeriod() {
		return period;
	}

	public void setPeriod(String period) {
		this.period = period;
	}

	public String getField() {
		return field;
	}

	public void setField(String field) {
		this.field = field;
	}

	public String getMain_task() {
		return main_task;
	}

	public void setMain_task(String main_task) {
		this.main_task = main_task;
	}

	public void prt() {
		System.out.println(num + ":��° ���" + "\n" + "ȸ���" + name + "\n�������" + r_type + "\n�ٹ���ġ" + working_area + "\n�ٹ��Ͻ�"
				+ working_date + "\n�޿�����" + salary + "\n�����Ⱓ" + period + "\n�����о�" + field + "\n��������" + main_task
				+ "\n");

	}

}
