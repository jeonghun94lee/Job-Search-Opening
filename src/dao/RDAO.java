package dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import codr.CallConn;
import codr.CallDriver;
import dto.RDTO;

public class RDAO {// 채용관리
	public static RDAO self = null;
	private PreparedStatement psmt = null;
	private CallDriver dr = new CallDriver();
	private CallConn co = new CallConn();

	public static RDAO getInstance() {
		if (self == null) {
			self = new RDAO();
		}
		return self;
	}

	public RDAO() {
		dr.DriverLoad();
	}

	public void Call_psmt(String str) throws SQLException {
		psmt = co.getConn().prepareStatement(str);
	}

	public void Call_exeQ() throws SQLException {
		psmt.executeQuery();
	}

	public void Call_Close() {
		try {
			if (co.getConn() != null) {
				co.getConn().close();
			}
		} catch (Exception e) {
		}
	}

	public void Recru(RDTO rdto) {
		if (co.checkConn()) {
			String sql = "insert into Recruit values (recruit_seq.nextval,?,?,?,?,?,?,?,?,?)";
			try {
				Call_psmt(sql);
				psmt.setString(1, rdto.getName());
				psmt.setString(2, rdto.getR_type());
				psmt.setString(3, rdto.getWorking_area());
				psmt.setString(4, rdto.getWorking_date());
				psmt.setString(5, rdto.getQ_require());
				psmt.setString(6, rdto.getSalary());
				psmt.setString(7, rdto.getPeriod());
				psmt.setString(8, rdto.getField());
				psmt.setString(9, rdto.getMain_task());
				Call_exeQ();
			} catch (Exception e) {
			}finally {
				Call_Close();
			}

		}
	}

}
