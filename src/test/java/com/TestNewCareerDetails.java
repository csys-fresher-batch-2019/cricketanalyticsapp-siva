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
		  
		   
		   
	}

}
