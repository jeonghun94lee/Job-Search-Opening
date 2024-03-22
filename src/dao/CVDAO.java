package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import codr.CallConn;
import codr.CallDriver;
import dto.CVDTO;

public class CVDAO {// 이력서관리

	public static CVDAO self = null;
	private PreparedStatement psmt = null;
	private CallDriver dr = new CallDriver();
	private CallConn co = new CallConn();

	public static CVDAO getInstance() {
		if (self == null) {
			self = new CVDAO();
		}
		return self;
	}

	public CVDAO() {
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

	public void CV(CVDTO cvdto) {
		if (co.checkConn()) {
			String sql = "insert into CV values(CV_seq.nextval,?,?,?,?,?,?,?)";
			try {
				Call_psmt(sql);
				psmt.setString(1, cvdto.getId()); // 자소서아이디
				psmt.setString(2, cvdto.getName()); // 자소서이름
				psmt.setString(3, cvdto.getW_type()); // 지원종류
				psmt.setString(4, cvdto.getEdu()); // 최종학력
				psmt.setString(5, cvdto.getPay()); // 급여
				psmt.setString(6, cvdto.getWork_e()); // 경력
				psmt.setString(7, cvdto.getSelf_intro()); // 자기소개
				Call_exeQ();
			} catch (Exception e) {
			} finally {
				Call_Close();
			}

		}
	}

	public void CV_all(ArrayList<CVDTO> cvlist) throws SQLException {// 이력서 전체보기
		ResultSet rs = null;
		String sql = "select *from CV";
		Call_psmt(sql);
		rs = psmt.executeQuery();
		while (rs.next()) {
			CVDTO cvdto = new CVDTO();
			cvdto.setId(rs.getString("id"));
			cvdto.setName(rs.getString("name"));
			cvdto.setW_type(rs.getString("w_type"));
			cvdto.setEdu(rs.getString("edu"));
			cvdto.setPay(rs.getString("pay"));
			cvdto.setWork_e(rs.getString("work_e"));
			cvdto.setSelf_intro(rs.getString("self_intro"));
			cvlist.add(cvdto);
		}

	}

}
