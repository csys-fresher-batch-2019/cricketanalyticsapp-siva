package com;

import java.util.List;
import java.util.Scanner;

import com.csys.dao.imp.PlayerCareerDaoImp;
import com.csys.model.PlayerCareer;

public class TestDisplayTop5Batsman {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("odi\tt20\ttest");
        System.out.println("Enter the any one of the format ");
        Scanner sc = new Scanner(System.in);
        String format = sc.next();
        System.out.println("Enter number of players you need to list");
        int a =sc.nextInt();
        sc.close();
		PlayerCareerDaoImp vs =new PlayerCareerDaoImp();
		List<PlayerCareer> bs = vs.displayTopBatsman(format,a);
		for (PlayerCareer pc : bs) {
			System.out.println(pc.getPlayerName());
			System.out.println(pc.getNation());
			System.out.println(pc.getAverage());
			System.out.println(pc.getRanks());
			System.out.println("\n");
		}
	}

}
