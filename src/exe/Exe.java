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
		System.out.println("�α׾ƿ��Ǿ����ϴ�.");
		Muser = null;
		Mlog = false;
	}

	private void CLogout() {
		System.out.println("�α׾ƿ��Ǿ����ϴ�.");
		CDuser = null;
		Clog = false;
	}

	private void View() {
		RDTO rdto = new RDTO();
		rdto.prt();

	}

	private void C_login() {// ����α���
		CDTO cdto = new CDTO();
		System.out.println("����ڵ�Ϲ�ȣ �Է��ϼ���");
		cdto.setCo_regi_num(in.nextLine());
		cdto = cdao.clog(cdto);
		if (cdto != null) {
			System.out.println("����");
			Clog = true;
			CDuser = cdto;
		} else {
			System.out.println("�α��ν���");
		}
	}

	public void CV() {
		CVDTO cvdto = new CVDTO();
		System.out.println("���̵� �Է��ϼ���");
		cvdto.setId(in.nextLine());
		System.out.println("�̸��� �Է��ϼ���");
		cvdto.setName(in.nextLine());
		System.out.println("���");
		cvdto.setW_type(in.nextLine());
		System.out.println("�����з�");
		cvdto.setEdu(in.nextLine());
		System.out.println("�������");
		cvdto.setPay(in.nextLine());
		System.out.println("�������");
		cvdto.setWork_e(in.nextLine());
		System.out.println("�ڱ�Ұ���");
		cvdto.setSelf_intro(in.nextLine());
		cvdao.CV(cvdto);
		cvdto = null;
	}

	private void M_login() {// ȸ���α���
		MDTO mdto = new MDTO();
		System.out.println("���̵� �Է��ϼ���");
		mdto.setId(in.nextLine());
		System.out.println("��й�ȣ�� �Է�");
		mdto.setPw(in.nextLine());
		mdto = mdao.log(mdto);
		if (mdto != null) {
			System.out.println("�α��μ���");
			Mlog = true;
			Muser = mdto;
		} else {
			System.out.println("�α��ν���");
		}
	}

	private void menu() {
		System.out.println();
		int selnum = 0;
		if (Mlog) {
			while (true) {
				System.out.println("1.����Ȱ��\t2.�̷¼� ���\t3.�ڷΰ���");
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
				System.out.println("1.ä����\t2.�̷¼� �˻�\t3.�ڷΰ���");
				in.nextInt();
				if (selnum == 1) {
					
				} else if (selnum == 2) {

				} else {

				}
			}
		}
	}

	private void menu2() {
		System.out.println("1.ȸ������\t2.���ȸ������\t3.���ηα���\t4.����α���\t5.���ڸ���ü����");
	}

	private void C_join() {// ���ȸ������
		CDTO cdto = new CDTO();
		System.out.println("����� ��Ϲ�ȣ�� �Է��ϼ���");
		cdto.setCo_regi_num(in.nextLine());
		System.out.println("��ǥ�� �̸��� �����ϼ���");
		cdto.setCEO_name(in.nextLine());
		System.out.println("��ǥ ��ȭ��ȣ�� �Է��ϼ���");
		cdto.setCo_num(in.nextLine());
		cdao.Cjoin(cdto);
		cdto = null;

	}

	private void join() {// ȸ������
		MDTO mdto = new MDTO();
		System.out.println("���̵� �Է��ϼ���");
		mdto.setId(in.nextLine());
		System.out.println("�̸��� �Է��ϼ���");
		mdto.setName(in.nextLine());
		System.out.println("��й�ȣ�� �Է��ϼ���");
		mdto.setPw(in.nextLine());
		System.out.println("��ȭ��ȣ�� �Է��ϼ���");
		mdto.setPnum(in.nextLine());
		mdao.Mjoin(mdto);
		mdto = null;
	}
}
