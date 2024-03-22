package dto;

public class RDTO {
	// 채용등록-회사
	int num = 0;
	String name = null;// 회사명
	String r_type = null;// 고용형태
	String working_area = null;// 근무위치
	String working_date = null;// 근무일시
	String Q_require=null;

	String salary = null;// 급여조건
	String period = null;// 접수기간
	String field = null;// 모집분야
	String main_task = null;// 업무내용

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
		System.out.println(num + ":번째 기업" + "\n" + "회사명" + name + "\n고용형태" + r_type + "\n근무위치" + working_area + "\n근무일시"
				+ working_date + "\n급여조건" + salary + "\n접수기간" + period + "\n모집분야" + field + "\n업무내용" + main_task
				+ "\n");

	}

}
