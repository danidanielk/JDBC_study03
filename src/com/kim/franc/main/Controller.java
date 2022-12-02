package com.kim.franc.main;

import java.util.Scanner;

public class Controller {

	public static void main(String[] args) {
		
		DAO d= new DAO();
		Scanner scan = new Scanner(System.in);
		
		while (true) {
			System.out.println("원하시는 번호를 입력하세요.");
			System.out.println("1 - 예약하기.");
			System.out.println("2 - 매장등록.");
			System.out.println("3 - 전체 예약 확인.");
			System.out.println("4 - 전체 매장 조회.");
			System.out.println("5 - 좌석수 가능 매장 조회.");
			System.out.println("6 - 예약자 조회.");
			System.out.println("7 - 연락처 변경");
			System.out.println("8 - 예약 취소");
			System.out.println("9 - 종료.");
			
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
				System.out.println("잘못 입력하셨습니다.");
				break;
			}
		}
		
		
	}
}
