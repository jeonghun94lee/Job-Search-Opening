package codr;

public class CallDriver {
public CallDriver() {
		
	}
	public void DriverLoad() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("����̹� �ε� ����");
		} catch (Exception e) {
			System.out.println("����̹� �ε� ����");
		}
	}

}
