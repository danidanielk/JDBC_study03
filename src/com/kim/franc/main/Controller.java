package com.kim.franc.main;

import java.util.Scanner;

public class Controller {

	public static void main(String[] args) {
		
		DAO d= new DAO();
		Scanner scan = new Scanner(System.in);
		
		while (true) {
			System.out.println("���Ͻô� ��ȣ�� �Է��ϼ���.");
			System.out.println("1 - �����ϱ�.");
			System.out.println("2 - ������.");
			System.out.println("3 - ��ü ���� Ȯ��.");
			System.out.println("4 - ��ü ���� ��ȸ.");
			System.out.println("5 - �¼��� ���� ���� ��ȸ.");
			System.out.println("6 - ������ ��ȸ.");
			System.out.println("7 - ����ó ����");
			System.out.println("8 - ���� ���");
			System.out.println("9 - ����.");
			
			int a = scan.nextInt();
			if(a==1) {
				d.insert_reservation();
			}
			else if (a==2) {
				d.insert_restaurant();
			}
			else if (a==3) {
				d.select_Allreservation();
			}
			else if (a==4) {
				d.select_Allrestaurant();
			}
			else if (a==5) {
				d.select_seatrestaurant();
			}
			else if (a==6) {
				d.info_of_reservation();
			}
			else if (a==7) {
				d.update_reservation();
			}
			else if (a==8) {
				d.delete_reservation();
			}
			else if (a==9) {
				break;
			}
			else {
				System.out.println("�߸� �Է��ϼ̽��ϴ�.");
				break;
			}
		}
		
		
	}
}
