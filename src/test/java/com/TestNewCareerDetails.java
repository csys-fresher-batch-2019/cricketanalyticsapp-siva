package com;

import java.util.Scanner;

import com.csys.PlayerCareerDaoImp;

public class TestNewCareerDetails {

	public static void main(String[] args) throws Exception {
		
		PlayerCareerDaoImp obj = new  PlayerCareerDaoImp();
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String capNo = sc.nextLine();
		obj.createNewCareer(capNo);
		  // obj.newCareerDetails("i100", "odi", 1, 80, 1, 0, 80);
		   //obj.newCareerDetails("e227", "test", 1, 110, 0, 1, 110);
		   
	}

}
