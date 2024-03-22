package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import codr.CallConn;
import codr.CallDriver;
import dto.CDTO;

public class CDAO {// ������� �α���
	public static CDAO self = null;
	private PreparedStatement psmt = null;
	private CallDriver dr = new CallDriver();
	private CallConn co = new CallConn();

	public static CDAO getInstance() {
		if (self == null) {
			self = new CDAO();
		}
		return self;
	}

	private CDAO() {
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

	public CDTO clog(CDTO cdto) {
		ResultSet rs = null;
		CDTO ret = null;
		if (co.checkConn()) {
			String sql = "select * from company where co_regi_num=?";
			try {
				Call_psmt(sql);
				psmt.setString(1, cdto.getCo_regi_num());
				rs = psmt.executeQuery();
				if (rs.next()) {
					cdto.setNum(rs.getInt("num"));
					cdto.setCo_regi_num(rs.getString("co_regi_num"));
					cdto.setCEO_name(rs.getString("CEO_name"));
					cdto.setCo_num(rs.getString("co_num"));
					ret = cdto;
				}
			} catch (Exception e) {
			} finally {
				Call_Close();
			}

		}
		return ret;

	}

	public void Cjoin(CDTO cdto) {
		if (co.checkConn()) {
			String sql = "insert into Company values(Company_seq.nextval,?,?,?)";
			try {
				Call_psmt(sql);
				psmt.setString(1, cdto.getCo_regi_num());// ����ڵ�Ϲ�ȣ
				psmt.setString(2, cdto.getCEO_name());// ��ǥ�̸�
				psmt.setString(3, cdto.getCo_num());// ȸ���ȣ
				Call_exeQ();
			} catch (Exception e) {
			} finally {
				Call_Close();
			}
		}

	}

}
