package com;

import java.util.Scanner;

import com.csys.PlayerCareerDaoImp;

public class TestUpdateRanking {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		PlayerCareerDaoImp ns = new PlayerCareerDaoImp();
		System.out.println("odi\tt20\ttest");
		System.out.println("Enter any one of the above mentioned format");
		Scanner sc = new Scanner(System.in);
		String format = sc.next();
		ns.updaterank(format);
}

}
