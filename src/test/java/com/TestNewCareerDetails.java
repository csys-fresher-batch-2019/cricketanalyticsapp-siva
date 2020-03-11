package com;

import java.util.Scanner;

import com.csys.dao.imp.PlayerCareerDaoImp;

public class TestNewCareerDetails {

	public static void main(String[] args) throws Exception {

		PlayerCareerDaoImp obj = new PlayerCareerDaoImp();

		Scanner sc = new Scanner(System.in);
		String capNo = sc.nextLine();
		String format1 = sc.next();
		String format2 = sc.next();
		String format3 = sc.next();
		sc.close();
		obj.createNewCareer(capNo, format1, format2, format3);
	}

}
