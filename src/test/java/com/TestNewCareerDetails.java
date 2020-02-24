package com;

import java.util.Scanner;

import com.csys.PlayerCareerDaoImp;

public class TestNewCareerDetails {

	public static void main(String[] args) throws Exception {
		
		PlayerCareerDaoImp obj = new  PlayerCareerDaoImp();
		
		Scanner sc = new Scanner(System.in);
		String capNo = sc.nextLine();
		sc.close();
		obj.createNewCareer(capNo);
	}

}
