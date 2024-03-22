package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import codr.CallConn;
import codr.CallDriver;
import dto.MDTO;


public class MDAO {// 개인회원관리
	public static MDAO self = null;
	private PreparedStatement psmt = null;
	private CallDriver dr = new CallDriver();
	private CallConn co = new CallConn();

	public static MDAO getInstance() {
		if (self == null) {
			self = new MDAO();
		}
		return self;
	}

	public MDAO() {
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

	public MDTO log(MDTO mdto) {
	    ResultSet rs = null;
	    MDTO ret = null;
	    if (co.checkConn()) {
	    	System.out.println(mdto.getId());
	    	System.out.println(mdto.getPw());
	        String sql = "select * from member where id=? AND pw=?";
	        try {
	            Call_psmt(sql);
	            System.out.println(sql);
	            psmt.setString(1, mdto.getId());
	            psmt.setString(2, mdto.getPw());
	            rs = psmt.executeQuery();
	            if (rs.next()) {
	                mdto.setNum(rs.getInt("num"));
	                mdto.setId(rs.getString("id"));
	                mdto.setName(rs.getString("name"));
	                mdto.setPw(rs.getString("pw"));
	                mdto.setPnum(rs.getString("pnum"));                
	                ret = mdto;
	            }
	        } catch (SQLException e) {	        	
	        	e.printStackTrace();
	        } finally {
	            Call_Close();
	        }
	    }
	    return ret;
	}
	
	
	
	public void Mjoin(MDTO mdto) {
		if (co.checkConn()) {
			String sql = "insert into Member values(Member_seq.nextval,?,?,?,?)";
			try {
				Call_psmt(sql);
				psmt.setString(1, mdto.getId());
				psmt.setString(2, mdto.getName());
				psmt.setString(3, mdto.getPw());
				psmt.setString(4, mdto.getPnum());
				Call_exeQ();
			} catch (Exception e) {
			} finally {
				Call_Close();
			}

		}
	}
}
