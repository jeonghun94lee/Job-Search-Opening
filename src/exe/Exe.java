package exe;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import dao.CDAO;
import dao.CVDAO;
import dao.MDAO;
import dao.RDAO;
import dto.CDTO;
import dto.CVDTO;
import dto.MDTO;
import dto.RDTO;

public class Exe {
	PreparedStatement psmt = null;
	Scanner in = new Scanner(System.in);
	MDAO mdao = MDAO.getInstance();
	CDAO cdao = CDAO.getInstance();
	RDAO rdao = RDAO.getInstance();
	CVDAO cvdao = CVDAO.getInstance();
	String tmp = null;
	MDTO Muser = null;
	CDTO CDuser = null;
	boolean Clog = false;
	boolean Mlog = false;
	ArrayList<CVDTO> cvlist = new ArrayList<>();

	boolean f = true;

	public Exe() {
		Label: while (true) {
			while (f) {
				menu2();
				int sel_num = in.nextInt();
				in.nextLine();
				if (sel_num == 1) {
					join();
				} else if (sel_num == 2) {
					C_join();

				} else if (sel_num == 3) {
					M_login();
					if (Mlog) {
						menu();
					}
				} else if (sel_num == 4) {
					C_login();
					if (Clog) {
						menu();
					}
				} else if (sel_num == 5) {
					View();
				} else {
					if (Clog) {
						menu();
						if (sel_num == 6) {
							CLogout();
							break;
						} else if (Mlog) {
							menu();
							if (sel_num == 6) {
								MLogout();
								break;
							} else {
								break Label;
							}

						}
					}
				}
			}
		}
	}

	public void CV_all() {
		ArrayList<CVDTO> cvlist = new ArrayList<CVDTO>();
		try {
			cvdao.CV_all(cvlist);
			for (CVDTO c : cvlist) {
				c.prt();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void MLogout() {
		System.out.println("로그아웃되었습니다.");
		Muser = null;
		Mlog = false;
	}

	private void CLogout() {
		System.out.println("로그아웃되었습니다.");
		CDuser = null;
		Clog = false;
	}

	private void View() {
		RDTO rdto = new RDTO();
		rdto.prt();

	}

	private void C_login() {// 기업로그인
		CDTO cdto = new CDTO();
		System.out.println("사업자등록번호 입력하세요");
		cdto.setCo_regi_num(in.nextLine());
		cdto = cdao.clog(cdto);
		if (cdto != null) {
			System.out.println("성공");
			Clog = true;
			CDuser = cdto;
		} else {
			System.out.println("로그인실패");
		}
	}

	public void CV() {
		CVDTO cvdto = new CVDTO();
		System.out.println("아이디를 입력하세요");
		cvdto.setId(in.nextLine());
		System.out.println("이름을 입력하세요");
		cvdto.setName(in.nextLine());
		System.out.println("경력");
		cvdto.setW_type(in.nextLine());
		System.out.println("최종학력");
		cvdto.setEdu(in.nextLine());
		System.out.println("희망연봉");
		cvdto.setPay(in.nextLine());
		System.out.println("직무경력");
		cvdto.setWork_e(in.nextLine());
		System.out.println("자기소개서");
		cvdto.setSelf_intro(in.nextLine());
		cvdao.CV(cvdto);
		cvdto = null;
	}

	private void M_login() {// 회원로그인
		MDTO mdto = new MDTO();
		System.out.println("아이디를 입력하세요");
		mdto.setId(in.nextLine());
		System.out.println("비밀번호를 입력");
		mdto.setPw(in.nextLine());
		mdto = mdao.log(mdto);
		if (mdto != null) {
			System.out.println("로그인성공");
			Mlog = true;
			Muser = mdto;
		} else {
			System.out.println("로그인실패");
		}
	}

	private void menu() {
		System.out.println();
		int selnum = 0;
		if (Mlog) {
			while (true) {
				System.out.println("1.구직활동\t2.이력서 등록\t3.뒤로가기");
				selnum = in.nextInt();
				in.nextLine();
				if (selnum == 1) {

				} else if (selnum == 2) {
					CV();
				} else {
					MLogout();
					break;
				}
			}

		} else if (Clog) {
			while (true) {
				System.out.println("1.채용등록\t2.이력서 검색\t3.뒤로가기");
				in.nextInt();
				if (selnum == 1) {
					
				} else if (selnum == 2) {

				} else {

				}
			}
		}
	}

	private void menu2() {
		System.out.println("1.회원가입\t2.기업회원가입\t3.개인로그인\t4.기업로그인\t5.일자리전체보기");
	}

	private void C_join() {// 기업회원가입
		CDTO cdto = new CDTO();
		System.out.println("사업자 등록번호를 입력하세요");
		cdto.setCo_regi_num(in.nextLine());
		System.out.println("대표자 이름을 설정하세요");
		cdto.setCEO_name(in.nextLine());
		System.out.println("대표 전화번호를 입력하세요");
		cdto.setCo_num(in.nextLine());
		cdao.Cjoin(cdto);
		cdto = null;

	}

	private void join() {// 회원가입
		MDTO mdto = new MDTO();
		System.out.println("아이디를 입력하세요");
		mdto.setId(in.nextLine());
		System.out.println("이름을 입력하세요");
		mdto.setName(in.nextLine());
		System.out.println("비밀번호를 입력하세요");
		mdto.setPw(in.nextLine());
		System.out.println("전화번호를 입력하세요");
		mdto.setPnum(in.nextLine());
		mdao.Mjoin(mdto);
		mdto = null;
	}
}
