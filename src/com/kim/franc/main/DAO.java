package com.kim.franc.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;
import java.util.Scanner;

//DAO /DTO 패턴 : 스프링에서 사용할 MVC 패턴

//DAO ( Data Access Object) MVC 패턴중 M 중에서DB관련한 작업을 전담하는 클래스
//DTO (Data Transfer Object) DAO 의 작업결과를 표현하는 클래스.

//java.util.date - > java.sql.date : new Date(클래스명.get날짜멤버변수명().getTime())
//java.sql.date - > java.util.date : 알아서 바꿔줌.
public class DAO {

	PreparedStatement pstmt = null;
	Connection con = null;
	Scanner scan = new Scanner(System.in);

	public void insert_reservation() {
		try {
			con = DriverManager.getConnection("jdbc:oracle:thin:@192.168.123.100:1521:xe", "danidani", "1");
			// reservation_seq.nextval,'soyeon',to_date('20220906','YYYYMMDD'),01012345678,'moran'

			System.out.println("이름 :");
			String a = scan.next();
			System.out.println("예약 시간(ex:2022xxxx) :");
			String b = scan.next();
			System.out.println("전화 번호(-제외) :");
			int c = scan.nextInt();
			System.out.println("지역 :");
			String d = scan.next();

			String aa = "insert into reservation values(reservation_seq.nextval,?,to_date('" + b + "','YYYYMMDD'),?,?";

			pstmt = con.prepareStatement(aa);
			pstmt.setString(1, a);
			// pstmt.setString(2, new Date(b.));
			pstmt.setInt(2, c);
			pstmt.setString(3, d);

			if (pstmt.executeUpdate() == 1) {
				System.out.println("success");
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		try {
			pstmt.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
		try {
			con.close();
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	public void insert_restaurant() {
		try {
			con = DriverManager.getConnection("jdbc:oracle:thin:@192.168.123.100:1521:xe", "danidani", "1");
			// reservation_seq.nextval,'soyeon',to_date('20220906','YYYYMMDD'),01012345678,'moran'
			// insert into restaurant values(default,'moran','dani',500)

			System.out.println("지점 :");
			String a = scan.next();
			System.out.println("예약자명 :");
			String b = scan.next();
			System.out.println("좌석수 :");
			int c = scan.nextInt();

			String aa = "insert into restaurant values(default,?,?,?)";

			pstmt = con.prepareStatement(aa);
			pstmt.setString(1, a);
			pstmt.setString(2, b);
			pstmt.setInt(3, c);

			if (pstmt.executeUpdate() == 1) {
				System.out.println("success");
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		try {
			pstmt.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
		try {
			con.close();
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	public void select_Allreservation() {
		ResultSet rs = null;

		try {

			con = DriverManager.getConnection("jdbc:oracle:thin:@192.168.123.100:1521:xe", "danidani", "1");

			String aa = "select * from reservation";

			pstmt = con.prepareStatement(aa);

			rs = pstmt.executeQuery();
			while (rs.next()) {
				System.out.println(rs.getString("rr_name"));
				System.out.println(rs.getString("rr_date"));
				System.out.println(rs.getInt("rr_phone"));
				System.out.println(rs.getString("rr_location"));
			}
			// reservation_seq.nextval,'soyeon',to_date('20220906','YYYYMMDD'),01012345678,'moran'
		} catch (Exception e) {
			// TODO: handle exception
		}
		try {
			rs.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
		try {
			pstmt.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
		try {
			con.close();
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	public void select_Allrestaurant() {

		ResultSet rs = null;

		try {
			con = DriverManager.getConnection("jdbc:oracle:thin:@192.168.123.100:1521:xe", "danidani", "1");

			String aa = "select * from restaurant";

			pstmt = con.prepareStatement(aa);

			rs = pstmt.executeQuery();
			while (rs.next()) {
				System.out.println(rs.getString("r_name"));
				System.out.println(rs.getString("r_location"));
				System.out.println(rs.getString("r_oner"));
				System.out.println(rs.getInt("r_seat"));
			}

		} catch (Exception e) {
			// TODO: handle exception
		}
		try {
			rs.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
		try {
			pstmt.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
		try {
			con.close();
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	public void select_seatrestaurant() {
		ResultSet rs = null;

		try {

			con = DriverManager.getConnection("jdbc:oracle:thin:@192.168.123.100:1521:xe", "danidani", "1");

			System.out.println("최소 필요 좌석: ");
			int scanSeat = scan.nextInt();
			String aa = "select * from restaurant where r_seat >= " + scanSeat;

			pstmt = con.prepareStatement(aa);

			rs = pstmt.executeQuery();
			while (rs.next()) {
				System.out.println(rs.getString("r_location"));
				System.out.println(rs.getString("r_oner"));
				System.out.println(rs.getInt("r_seat"));
			}
			// reservation_seq.nextval,'soyeon',to_date('20220906','YYYYMMDD'),01012345678,'moran'
		} catch (Exception e) {
			// TODO: handle exception
		}
		try {
			rs.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
		try {
			pstmt.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
		try {
			con.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public void info_of_reservation() {

		ResultSet rs = null;

		try {
			con = DriverManager.getConnection("jdbc:oracle:thin:@192.168.123.100:1521:xe", "danidani", "1");
			System.out.println("예약자 이름을 입력하세요 :");
			String name = scan.next();
			String aa = "select * from reservation where rr_name = '" + name + "'";
			pstmt = con.prepareStatement(aa);
			rs = pstmt.executeQuery();
			while (rs.next()) {

				System.out.println(rs.getInt("rr_no"));
				System.out.println(rs.getString("rr_name"));
				System.out.println(rs.getString("rr_date"));
				System.out.println(rs.getInt("rr_phone"));
				System.out.println(rs.getString("rr_location"));
			}

		} catch (Exception e) {
			// TODO: handle exception
		}
		try {
			rs.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
		try {
			pstmt.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
		try {
			con.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public void update_reservation() {

		try {
			con = DriverManager.getConnection("jdbc:oracle:thin:@192.168.123.100:1521:xe", "danidani", "1");
			System.out.println("예약번호를 입력하세요 :");
			int a = scan.nextInt();
			System.out.println("변경할 휴대폰번호를 입력하세요 :");
			int b = scan.nextInt();

			String aa = "update reservation set rr_phone=" + b + " where rr_no=" + a;

			pstmt = con.prepareStatement(aa);

			if (pstmt.executeUpdate() == 1) {
				System.out.println("success");
			}

		} catch (Exception e) {
			// TODO: handle exception
		}
		try {
			pstmt.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
		try {
			con.close();
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	public void delete_reservation() {
		try {

			con = DriverManager.getConnection("jdbc:oracle:thin:@192.168.123.100:1521:xe", "danidani", "1");

			System.out.println("취소하실 예약 번호를 입력해주세요 :");
			int a = scan.nextInt();

			String aa = "delete from reservation where rr_no=" + a;

			pstmt = con.prepareStatement(aa);

			if (pstmt.executeUpdate() >= 1) {
				System.out.println("success");
			}

		} catch (Exception e) {
			// TODO: handle exception
		}
		try {
			pstmt.close();

		} catch (Exception e) {
			// TODO: handle exception
		}
		try {
			con.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
