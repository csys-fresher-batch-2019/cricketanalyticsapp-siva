package com;

import java.util.ArrayList;
import java.util.Scanner;

import com.csys.PlayerCareer;
import com.csys.PlayerCareerDaoImp;

public class TestGetDetails {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Scanner sc =new Scanner(System.in);
		System.out.println("Enter the Player name");
		String name = sc.nextLine();
        PlayerCareerDaoImp p = new PlayerCareerDaoImp();
		ArrayList<PlayerCareer> task1 = new ArrayList<PlayerCareer>();
		task1 = (p.getdetails(name));
       for (PlayerCareer res : task1) {
    	   System.out.println(res);
	}
		
		

	}

}
